package com.scaler.lld.bookmyshow.exception;

public class ServiceException extends Exception {

    public ServiceException(String msg, Throwable e){
         new Exception(msg, e);
    }
}
