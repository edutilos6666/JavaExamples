package com.edutilos.designpattern.mediator;

/**
 * Created by edutilos on 15.06.17.
 */
public interface ChatMediator {
   void sendMessage(String message, User user);
   void addUser(User user);
}
