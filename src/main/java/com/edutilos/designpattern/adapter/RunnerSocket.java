package com.edutilos.designpattern.adapter;

/**
 * Created by edutilos on 15.06.17.
 */
public class RunnerSocket {
    public static void main(String[] args) {
        Volt v1 , v2, v3 , v4 ;
         Socket socket = new Socket();
         MultiSocket multiSocket = new MultiSocketAdapter(socket);
         v1 = socket.getVolt();
         v2 = multiSocket.getVolt120();
         v3 = multiSocket.getVolt12();
         v4 = multiSocket.getVolt3();
        System.out.println(v1);
        System.out.println(v2);
        System.out.println(v3);
        System.out.println(v4);
    }
}
