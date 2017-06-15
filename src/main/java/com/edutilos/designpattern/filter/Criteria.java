package com.edutilos.designpattern.filter;

import java.util.List;

/**
 * Created by edutilos on 15.06.17.
 */
public interface Criteria {
   List<Programmer> filter(List<Programmer> src);
}
