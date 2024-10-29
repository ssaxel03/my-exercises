package io.codeforall.bootcamp;

import java.io.*;
import java.net.Socket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Web server client dispatcher
 */
public class ClientDispatcher implements Runnable {

    private static final Logger logger = Logger.getLogger(ClientDispatcher.class.getName());

    private Socket clientSocket;
    private DataOutputStream out;
    private BufferedReader in;

    public ClientDispatcher(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    public String getAddress() {
        return clientSocket.getInetAddress().getHostAddress() + ":" + clientSocket.getLocalPort();
    }

    @Override
    public void run() {

        try {

            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out = new DataOutputStream(clientSocket.getOutputStream());

            String requestHeaders = fetchRequestHeaders();
            if (requestHeaders.isEmpty()) {
                close();
                return;
            }

            String request = requestHeaders.split("\n")[0]; // request is first line of header
            String httpVerb = request.split(" ")[0]; // verb is the first word of request
            String resource = request.split(" ").length > 1 ? request.split(" ")[1] : null; // second word of request

            logger.log(Level.INFO, "Request received: " + request);
            logger.log(Level.FINE, "Headers : \n" + requestHeaders);

            if (!httpVerb.equals("GET")) {
                logger.log(Level.WARNING, "request not supported from " + getAddress());
                reply(HttpHelper.notAllowed());
                close();
                return;

            }

            if (resource == null) {
                logger.log(Level.WARNING, "resource not specified from " + getAddress());
                reply(HttpHelper.badRequest());
                close();
                return;
            }

            String filePath = getPathForResource(resource);
            if (!HttpMedia.isSupported(filePath)) {
                logger.log(Level.WARNING, "request for content type not supported from " + getAddress());
                reply(HttpHelper.unsupportedMedia());
                close();
                return;
            }

            File file = new File(filePath);
            if (file.exists() && !file.isDirectory()) {

                reply(HttpHelper.ok());

            } else {

                logger.log(Level.WARNING, file.getPath() + " not found");
                reply(HttpHelper.notFound());

                filePath = WebServer.DOCUMENT_ROOT + "404.html";
                file = new File(filePath);

            }

            reply(HttpHelper.contentType(filePath));
            reply(HttpHelper.contentLength(file.length()));

            streamFile(file);
            close();

        } catch (SocketException ex) {

            logger.log(Level.INFO, "client disconnected " + getAddress());

        } catch (IOException ex) {

            logger.log(Level.WARNING, ex.getMessage());
            close();
        }

    }

    private String fetchRequestHeaders() throws IOException {

        String line = null;
        StringBuilder builder = new StringBuilder();

        // read the full http request
        while ((line = in.readLine()) != null && !line.isEmpty()) {
            builder.append(line + "\n");
        }

        return builder.toString();

    }

    private String getPathForResource(String resource) {

        String filePath = resource;

        Pattern pattern = Pattern.compile("(\\.[^.]+)$"); // regex for file extension
        Matcher matcher = pattern.matcher(filePath);

        if (!matcher.find()) {
            filePath += "/index.html";
        }

        filePath = WebServer.DOCUMENT_ROOT + filePath;

        return filePath;
    }

    private void reply(String response) throws IOException {
        out.writeBytes(response);
    }

    private void streamFile(File file) throws IOException {

        byte[] buffer = new byte[1024];
        FileInputStream in = new FileInputStream(file);

        int numChars;
        while ((numChars = in.read(buffer)) != -1) {
            out.write(buffer, 0, numChars);
        }

        in.close();

    }

    private void close() {

        try {

            logger.log(Level.INFO, "closing client socket for " + getAddress());
            clientSocket.close();

        } catch (IOException e) {

            logger.log(Level.INFO, e.getMessage());
        }

    }

}
