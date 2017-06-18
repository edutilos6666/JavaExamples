package com.edutilos.jaxb;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.Arrays;
import java.util.List;

/**
 * Created by edutilos on 18.06.17.
 */
public class Runner {
    public static void main(String[] args) {
      marshall();
      unmarshall();
    }


    private static void unmarshall() {
        try {
            JAXBContext ctx = JAXBContext.newInstance(Country.class);
            Unmarshaller unmarshaller = ctx.createUnmarshaller();
            Country c = (Country)unmarshaller.unmarshal(new File("marshalled.xml"));
            System.out.println(c.toString());
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void marshall() {
        Country c = new Country();
        c.setCountryName("Germany");
        c.setCountryPopulation(430);
        List<State> states = Arrays.asList(
                new State("NRW", 100),
                new State("Bayern",110)
        );
        c.setStates(states);
        try {
            JAXBContext ctx = JAXBContext.newInstance(Country.class);
            Marshaller marshaller = ctx.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(c , new File("marshalled.xml"));
            marshaller.marshal(c , System.out);

        } catch(Exception ex) {
              ex.printStackTrace();
        }
    }
}
