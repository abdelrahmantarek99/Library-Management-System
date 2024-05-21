package com.maids.cc.Library.Management.System.Exception;

public class NotFound extends RuntimeException {
    public NotFound(){

    }
    public NotFound(String msg){
        super(msg);
    }
}
