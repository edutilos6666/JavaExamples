package com.edutilos.designpattern.mediator;

/**
 * Created by edutilos on 15.06.17.
 */
public class Runner {
    public static void main(String[] args) {
        ChatMediator chatMediator = new ChatMediatorImpl();
        User u1 , u2 , u3 ;
        u1 = new UserImpl("foo", chatMediator);
        u2 = new UserImpl("bar", chatMediator);
        u3 = new UserImpl("bim", chatMediator);
        chatMediator.addUser(u1);
        chatMediator.addUser(u2);
        chatMediator.addUser(u3);
        u1.sendMessage("Hello World");
        u3.sendMessage("Can you help me?");
    }
}
