package com.cantux;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Person> personList = new ArrayList<Person>();
        personList.add(new Person("1", new Date(1970,1,1), "Can", "Tuksavul", 177.0, 70.0));
        personList.add(new Person("3", new Date(1970,2,1), "Dilara", "Saygi", 170.0, 55.0));
        personList.add(new Person("2", new Date(1970,3,1), "Murat", "Zorer", 177.0, 65.0));

        System.out.println("\ncompare ssn");
        Sorter.sort(personList, "ssn", "true").forEach(p -> System.out.println(p.firstName));

        System.out.println("\ncompare firstName");
        Sorter.sort(personList, "firstName", "true").forEach(p -> System.out.println(p.firstName));

        System.out.println("\ncompare lastName");
        Sorter.sort(personList, "lastName", "true").forEach(p -> System.out.println(p.lastName));

        System.out.println("\ncompare heightIn asc false");
        Sorter.sort(personList, "heightIn", "true").forEach(p -> System.out.println(p.heightIn));

        System.out.println("\ncompare heightIn asc false");
        Sorter.sort(personList, "heightIn", "false").forEach(p -> System.out.println(p.heightIn));

        System.out.println("\ncompare weightLb asc false");
        Sorter.sort(personList, "weightLb", "false").forEach(p -> System.out.println(p.weightLb));

        System.out.println("\ncompare weight wrong asc");
        try {
            Sorter.sort(personList, "weightLb", "crash").forEach(p -> System.out.println(p.weightLb));
        } catch(Exception e){e.printStackTrace();}

        System.out.println("\nwrong sortfield");
        try {
            Sorter.sort(personList, "crash", "true").forEach(p -> System.out.println(p.firstName));
        } catch(Exception e){e.printStackTrace();}
    }
}
