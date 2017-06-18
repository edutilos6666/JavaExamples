package com.edutilos.jaxb;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;



@XmlRootElement
@XmlType(propOrder = {"countryPopulation", "countryName", "states"})
public class Country {

   private String countryName;

   private long countryPopulation;

   private List<State> states;


    public Country(String countryName, long countryPopulation, List<State> states) {
        this.countryName = countryName;
        this.countryPopulation = countryPopulation;
        this.states = states;
    }

    public Country() {
    }

    public String getCountryName() {
        return countryName;
    }

    @XmlElement
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public long getCountryPopulation() {
        return countryPopulation;
    }
    @XmlElement
    public void setCountryPopulation(long countryPopulation) {
        this.countryPopulation = countryPopulation;
    }

    public List<State> getStates() {
        return states;
    }
    @XmlElementWrapper(name = "stateList")
    @XmlElement
    public void setStates(List<State> states) {
        this.states = states;
    }

    @Override
    public String toString() {
        return String.format("[%s,%d,%s]", countryName,
                countryPopulation, states.toString());
    }
}
