package io.codeforall.fanSTATICs_;

public class FileNotFoundException extends FileException{

    public FileNotFoundException() {
        super("FileNotFoundException was thrown");
    }

    public String getMessage() {
        return this.message;
    }

}
