package com.edutilos.jaxb;


import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class State {
   private String stateName;
   private long statePopulation;

    public State(String stateName, long statePopulation) {
        this.stateName = stateName;
        this.statePopulation = statePopulation;
    }

    public State() {
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public long getStatePopulation() {
        return statePopulation;
    }

    public void setStatePopulation(long statePopulation) {
        this.statePopulation = statePopulation;
    }

    @Override
    public String toString() {
        return String.format("[%s,%d]", stateName, statePopulation);
    }
}
