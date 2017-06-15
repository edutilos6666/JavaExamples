package com.edutilos.designpattern.filter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by edutilos on 15.06.17.
 */
public class CriteriaYoung implements Criteria {
    @Override
    public List<Programmer> filter(List<Programmer> src) {
        List<Programmer> ret = new ArrayList<>();
        for(Programmer p: src) {
            if(p.getAge()>0 && p.getAge() <= 30) ret.add(p);
        }
        return ret ;
    }
}
