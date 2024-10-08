package io.codeforall.fanSTATICs_;

public class FileManager {

    public final int MAX_FILES = 10;
    private boolean loggedIn;
    private int filesCreated;
    private File[] files;

    public FileManager() {
        this.loggedIn = false;
        this.filesCreated = 0;
        this.files = new File[MAX_FILES];
    }

    public void login() {
        System.out.println("Login successful");
        this.loggedIn = true;
    }

    public void logout() {
        System.out.println("Logout successful");
        this.loggedIn = false;
    }

    public File getFile(String string) throws Exception {

        if (!loggedIn) {
            throw new NotEnoughPermissionsException();
        }

        System.out.println("Looking for file '" + string + "'...");

        if(filesCreated < 1) {
            throw new FileNotFoundException();
        }

        for (int i = 0; i < filesCreated; i++) {
            if (files[i].getMessage().equals(string)) {
                System.out.println("Target file found and returned");
                return files[i];
            }
        }

        throw new FileNotFoundException();
    }

    public void createFile(String string) throws Exception {

        if (!loggedIn) {
            throw new NotEnoughPermissionsException();
        }

        if (filesCreated == files.length) {
            throw new NotEnoughSpaceException();
        }

        System.out.println("File " + string + " created with success");
        files[filesCreated] = new File(string);
        filesCreated++;
    }

}
