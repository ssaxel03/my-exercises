package io.codeforall.fanSTATICs_;

public abstract class FileException extends Exception{

    protected String message;
    public FileException(String message) {
        this.message = message;
    }
    public abstract String getMessage();
}
