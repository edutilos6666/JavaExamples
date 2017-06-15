package com.edutilos.designpattern.mediator;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by edutilos on 15.06.17.
 */
public class ChatMediatorImpl implements ChatMediator {
    private List<User> userList ;

    public ChatMediatorImpl() {
        if(userList == null)
        userList = new LinkedList<>();
    }
    @Override
    public void sendMessage(String message, User user) {
        for(User receiver: userList) {
            if(receiver!= user) {
                receiver.receiveMessage(message);
            }
        }
    }

    @Override
    public void addUser(User user) {
        if(!userList.contains(user))
         userList.add(user);
    }
}
