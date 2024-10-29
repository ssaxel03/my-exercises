package io.codeforall.bootcamp;

public class HttpMedia {

    public static boolean isImage(String file) {

        switch (getExtension(file)) {
            case "jpg":
            case "png":
            case "ico":
                return true;
            default:
                return false;
        }

    }

    public static boolean isHtml(String file) {
        return getExtension(file).equals("html");
    }

    public static boolean isSupported(String file) {
        return isHtml(file) || isImage(file);
    }

    public static String getExtension(String file) {
        return file.substring(file.lastIndexOf(".") + 1);
    }
}
