package com.edutilos.designpattern.mvc;

import com.edutilos.designpattern.Person;

/**
 * Created by edutilos on 16.06.17.
 */
public class PersonController {
     private Person model;
     private PersonView view ;
     public PersonController(Person model, PersonView view) {
         this.model = model;
         this.view = view ;
     }
    public void setModelId(long id) {
      model.setId(id);
   }
    public void setModelName(String name) {
         model.setName(name);
    }

    public void setModelAge(int age) {
         model.setAge(age);
    }

    public void setModelWage(double wage) {
         model.setWage(wage);
    }

    public void setModelActive(boolean active) {
         model.setActive(active);
    }

    public long getModelId() {
         return model.getId();
    }

    public String getModelName() {
         return model.getName();
    }

    public int getModelAge() {
         return model.getAge();
    }
    public double getModelWage() {
         return model.getWage();
    }
    public boolean isModelActive() {
         return model.isActive();
    }

    public void updateView() {
         view.printPersonDetails(model);
    }
}
