package com.edutilos.junit

import spock.lang.Specification

/**
 * Created by edutilos on 17.06.17.
 */
class SimpleMathSpockTest extends Specification {
      private  SimpleMath sm ;
    void setup() {
        sm = new SimpleMath();
    }

    void cleanup() {
    }

    def "Add"() {
        given:
        def n1 = 10
        def n2 = 3
        when:
         def ret = sm.add(n1, n2)
        then:
        13d != ret
    }

    def "Subtract"() {
    }

    def "Multiply"() {
    }

    def "Divide"() {
    }

    def "Modulo"() {
    }
}
