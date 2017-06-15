package com.edutilos.designpattern.filter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by edutilos on 15.06.17.
 */
public class CriteriaNot implements Criteria {
    private List<Programmer> target;

    public CriteriaNot(List<Programmer> target) {
        this.target = target;
    }


    private boolean testIfExists(Programmer p) {
        for(Programmer p2: target) {
            if(p.equals(p2)) return true ;
        }
        return false ;
    }

    @Override
    public List<Programmer> filter(List<Programmer> src) {
        List<Programmer> ret = new ArrayList<>();
        for(Programmer p: src) {
            if(!testIfExists(p)) ret.add(p);
        }

        return ret;
    }
}
