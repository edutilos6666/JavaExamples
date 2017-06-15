package com.edutilos.designpattern.filter;

import java.util.Arrays;
import java.util.List;

/**
 * Created by edutilos on 15.06.17.
 */
public class Runner {
    public static void main(String[] args) {
        List<Programmer> list = Arrays.asList(
           new Programmer(1, "foo", 10, 100.0, true),
                new Programmer(2, "bar", 20 , 200.0 , false),
                new Programmer(3, "bim", 31, 300.0 , true),
                new Programmer(4, "edu", 40, 1400.0, false)
        );

        printList("<<All Programmers>>", list);
        List<Programmer> youngProgrammers = new CriteriaYoung().filter(list);
        printList("<<Young Programmers>>", youngProgrammers);
        List<Programmer> richProgrammers = new CriteriaRich().filter(list);
         printList("<<Rich Programmers>>", richProgrammers);
        List<Programmer> activeProgrammers = new CriteriaActive().filter(list);
        printList("<<Active Programmers>>", activeProgrammers);

        Criteria cYoung = new CriteriaYoung(),
                cActive = new CriteriaActive();
        List<Programmer> youngAndActive = new CriteriaAnd(cYoung , cActive).filter(list);
        printList("<<Young and Active Programmers>>", youngAndActive);
        List<Programmer> youngOrActive = new CriteriaOr(cYoung, cActive).filter(list);
        printList("<<Young or Active Programmers>>", youngOrActive);
        List<Programmer> notYoungAndActive = new CriteriaNot(youngOrActive).filter(list);
        printList("<<Not Young and Active Programmers>>", notYoungAndActive);
    }

    private static void printList(String header , List<Programmer> list) {
        System.out.println(header);
        for(Programmer p: list)
            System.out.println(p.toString());
        System.out.println();
    }
}
