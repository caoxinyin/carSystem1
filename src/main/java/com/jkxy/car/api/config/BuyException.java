package com.jkxy.car.api.config;/**
    *@ClassNameBuyException
    *@Description TODO
    *@Author sifsrt
    *@Date 2022/9/4 21:04
    *@Version 1.0
**/
public class BuyException extends RuntimeException {

    public BuyException() {
        super();
    }

    public BuyException(String message) {
        super(message);
    }

    public BuyException(String message, Throwable cause) {
        super(message, cause);
    }

    public BuyException(Throwable cause) {
        super(cause);
    }

    public BuyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}