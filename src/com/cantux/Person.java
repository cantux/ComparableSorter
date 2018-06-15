package com.cantux;

import java.util.Date;

public class Person {
    String ssn;
    Date dateOfBirth;
    String firstName;
    String lastName;
    Double heightIn;
    Double weightLb;

    public Person(String ssn, Date dateOfBirth, String firstName, String lastName, Double heightIn, Double weightLb) {
        this.ssn = ssn;
        this.dateOfBirth = dateOfBirth;
        this.firstName = firstName;
        this.lastName = lastName;
        this.heightIn = heightIn;
        this.weightLb = weightLb;
    }
}
