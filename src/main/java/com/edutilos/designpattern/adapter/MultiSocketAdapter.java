package com.edutilos.designpattern.adapter;

/**
 * Created by edutilos on 15.06.17.
 */
public class MultiSocketAdapter implements MultiSocket {

    private Socket socket;

    public MultiSocketAdapter(Socket socket) {
        this.socket = socket;
    }

    @Override
    public Volt getVolt120() {
        return socket.getVolt();
    }

    @Override
    public Volt getVolt12() {
        return new Volt(socket.getVolt().getVolts()/10);
    }

    @Override
    public Volt getVolt3() {
        return new Volt(socket.getVolt().getVolts()/40);
    }
}
