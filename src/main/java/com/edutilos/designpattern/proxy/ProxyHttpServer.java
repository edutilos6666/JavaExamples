package com.edutilos.designpattern.proxy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by edutilos on 15.06.17.
 */
public class ProxyHttpServer implements  HttpServer {
    private HttpServer server ;
    private List<String> cache = new ArrayList<>();
    public ProxyHttpServer(HttpServer server) {
        if(this.server == null)
        this.server = server;
    }

    @Override
    public String serveFile(String url) {
        String [] splitted = url.split("/");
        String ret = splitted[splitted.length -1];
        if(!cache.contains(ret)) {
            cache.add(ret);
            return server.serveFile(url);
        }
        //meaningless , but for showing functionality of proxy pattern it is ok!
        return cache.get(cache.indexOf(ret));
    }
}
