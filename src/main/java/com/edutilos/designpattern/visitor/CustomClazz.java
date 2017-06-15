package com.edutilos.designpattern.visitor;

/**
 * Created by edutilos on 16.06.17.
 */
public class CustomClazz {
   private String name;

   public CustomClazz(String name) {
       this.name = name;
   }

   public String getName() {
       return name;
   }

   public void setName(String name) {
       this.name = name;
   }

   public void accept(Visitor visitor) {
       visitor.visit(this);
   }
}
