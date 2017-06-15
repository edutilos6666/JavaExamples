package com.edutilos.designpattern.iterator;

/**
 * Created by edutilos on 15.06.17.
 */
public interface CustomIterator<T> {
   boolean hasNext();
   T next();
   void addElement(T elem);
}
