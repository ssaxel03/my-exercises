package io.codeforall.fanSTATICs_;

public class NotEnoughPermissionsException extends FileException{

    public NotEnoughPermissionsException() {
        super("NotEnoughPermissionsException was thrown");
    }

    public String getMessage() {
        return this.message;
    }

}
