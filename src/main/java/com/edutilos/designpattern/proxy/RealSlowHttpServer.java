package com.edutilos.designpattern.proxy;

/**
 * Created by edutilos on 15.06.17.
 */
public class RealSlowHttpServer implements  HttpServer {
    @Override
    public String serveFile(String url) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String ret = null;
        String [] splitted = url.split("/");
        ret = splitted[splitted.length - 1];
        return ret ;
    }
}
