package br.com.walmart.exception;

/**
 * Created by amandalacanna on 1/10/17.
 */

public class PathNotFoundException extends Exception {

    public PathNotFoundException() {
        super("Path from source to destination vertex was not found");
    }

    public PathNotFoundException(String msg) {
        super(msg);
    }

}
