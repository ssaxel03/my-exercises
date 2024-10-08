package io.codeforall.fanSTATICs_;

public class Program {

    public static void main(String[] args) {

        FileManager fileManager = new FileManager();

        createFile(fileManager, "Mamas");

        getFile(fileManager, "Mamas");

        login(fileManager);

        createFile(fileManager, "Mamas");

        getFile(fileManager, "Mama");

        for(int i = 0; i < 10; i++) {
            createFile(fileManager, "test " + (i + 1));
        }

        logout(fileManager);

    }

    public static void createFile(FileManager fileManager, String file) {

        try {
            fileManager.createFile(file);
        } catch (NotEnoughPermissionsException e) {
            System.out.println(e.getMessage());
        } catch (NotEnoughSpaceException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public static void getFile(FileManager fileManager, String file) {

        File fileRes = null;
        try {
            fileRes = fileManager.getFile(file);
        } catch (NotEnoughPermissionsException e) {
            System.out.println(e.getMessage());
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if(fileRes == null) {
                System.out.println("File: null");
            } else {
                System.out.println("File: " + fileRes.getMessage());
            }
        }
    }

    public static void login(FileManager fileManager) {
        fileManager.login();
    }

    public static void logout(FileManager fileManager) {
        fileManager.logout();
    }

}
