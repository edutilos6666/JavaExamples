package com.edutilos.designpattern.proxy;

/**
 * Created by edutilos on 15.06.17.
 */
public class Runner {
    public static void main(String[] args) {
        HttpServer mainServer = new RealSlowHttpServer();
        ProxyHttpServer proxyServer = new ProxyHttpServer(mainServer);
        System.out.println(proxyServer.serveFile("www.google.com/index.html"));
        System.out.println(proxyServer.serveFile("www.google.com/index.html"));
    }
}
