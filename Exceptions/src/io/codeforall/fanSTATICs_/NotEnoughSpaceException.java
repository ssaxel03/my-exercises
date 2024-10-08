package io.codeforall.fanSTATICs_;

public class NotEnoughSpaceException extends FileException{

    public NotEnoughSpaceException() {
        super("NotEnoughSpaceException was thrown");
    }

    public String getMessage() {
        return this.message;
    }

}
