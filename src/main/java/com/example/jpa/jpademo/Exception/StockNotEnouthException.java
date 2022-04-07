package com.example.jpa.jpademo.Exception;
/*
Created on 2022/04/04 9:00 PM In Intelli J IDEA 
by jeon-wangi
*/

public class StockNotEnouthException extends RuntimeException {

    public StockNotEnouthException() {
        super();
    }

    public StockNotEnouthException(String message) {
        super(message);
    }

    public StockNotEnouthException(String message, Throwable cause) {
        super(message, cause);
    }

    public StockNotEnouthException(Throwable cause) {
        super(cause);
    }
}
