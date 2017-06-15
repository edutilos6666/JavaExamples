package com.edutilos.designpattern.filter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by edutilos on 15.06.17.
 */
public class CriteriaOr implements Criteria {
    private Criteria first, second;

    public CriteriaOr(Criteria first, Criteria second) {
        this.first = first;
        this.second = second;
    }


    private boolean testIfExistsOr(List<Programmer> filter1,
                                   List<Programmer> filter2,
                                   Programmer p) {
        boolean ret = false;
        for(Programmer p2: filter1) {
            if(p2.equals(p)) {
                ret = true ;
                break;
            }
        }

        for(Programmer p2: filter2) {
            if(p2.equals(p)) {
                ret = true;
                break;
            }
        }
        return ret ;
    }

    @Override
    public List<Programmer> filter(List<Programmer> src) {
        List<Programmer> ret = new ArrayList<>();
        List<Programmer> filter1 = first.filter(src);
        List<Programmer> filter2 = second.filter(src);
        for(Programmer p: src) {
            if(testIfExistsOr(filter1, filter2, p))
                ret.add(p);
        }
        return ret;
    }
}
