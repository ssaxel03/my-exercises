package io.codeforall.bootcamp;

public class HttpHelper {

    public static String badRequest() {
        return "HTTP/1.0 400 Bad Request\r\n";
    }

    public static String notFound() {
        return "HTTP/1.0 404 Not Found\r\n";
    }

    public static String notAllowed() {
        return "HTTP/1.0 405 Method Not Allowed\r\n" +
                "Allow: GET\r\n";
    }

    public static String ok() {
        return "HTTP/1.0 200 Document Follows\r\n";
    }

    public static String contentLength(long lenght) {

        //an extra line is needed before content
        return "Content-Length: " + lenght + "\r\n\r\n";
    }

    public static String unsupportedMedia() {
        return "HTTP/1.0 415 Unsupported Media Type\r\n";
    }

    public static String contentType(String file) {

        if (HttpMedia.isImage(file)) {
            return "Content-Type: image/" + HttpMedia.getExtension(file) + "\r\n";
        }

        return "Content-Type: text/html; charset=UTF-8\r\n";

    }
}
