package com.edutilos.designpattern.mediator;

/**
 * Created by edutilos on 15.06.17.
 */
public class UserImpl implements User {
    private String name;
    private ChatMediator chatMediator;
    public UserImpl(String name, ChatMediator chatMediator) {
        this.name = name ;
        this.chatMediator = chatMediator;
    }

    @Override
    public void sendMessage(String msg) {
        System.out.println(String.format("%s sends %s", name, msg));
        chatMediator.sendMessage(msg, this);
    }

    @Override
    public void receiveMessage(String msg) {
        System.out.println(String.format("%s receives %s", name, msg));
    }
}
