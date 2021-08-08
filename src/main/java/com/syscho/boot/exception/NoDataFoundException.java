package com.syscho.boot.exception;

public class NoDataFoundException extends RuntimeException {

    public NoDataFoundException(String msg) {
        super(String.format("No Data found for id %s ", msg));
    }


}
