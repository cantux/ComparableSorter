package com.cantux;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Person> personList = new ArrayList<Person>();
        personList.add(new Person("ssn1", new Date(1970,1,1), "Can", "Tuksavul", 177.0, 70.0));
        personList.add(new Person("ssn3", new Date(1970,2,1), "Dilara", "Saygi", 170.0, 55.0));
        personList.add(new Person("ssn2", new Date(1970,3,1), "Murat", "Zorer", 177.0, 65.0));

        Sorter.sort(personList, "ssn", "true").forEach(p -> System.out.println(p.firstName));
    }
}
