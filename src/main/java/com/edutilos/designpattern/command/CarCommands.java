package com.edutilos.designpattern.command;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by edutilos on 15.06.17.
 */
public class CarCommands {
   private List<Command> commands;
   public CarCommands() {
       commands = new ArrayList<>();
   }

   public void registerCommand(Command cmd) {
       commands.add(cmd);
   }
   public void registerCommands(List<Command> cmds) {
       for(Command cmd: cmds)
           commands.add(cmd);
   }

   public void batchExecuteCommands() {
       for(Command cmd: commands) {
           cmd.execute();
       }

       commands.clear();
   }
}
