package com.cantux;

import java.lang.reflect.Field;
import java.util.*;

public class Sorter {

    static List<Person> sort(Iterable<Person> people, String sortField,
                             String ascending){

        // Java backwards compatiblity doesn't allow runtime generics. Suddenly I get the urge to use JNI.
        // Never did, was close to using it when I saw Process apis though. What a joke amiright
//            List<Person> sorted = peopleList.stream()
//                .sorted(Comparator.comparing(field::get).reversed())
//                .collect(Collectors.toList());

        // So this exercise is a simul of dealing with complex code you didn't write or a 3rd party library.
        // We don't have Olingo https://olingo.apache.org/doc/odata4/tutorials/sqo_o/tutorial_sqo_o.html
        // Person is a POJO
        // and then there is this library that tries to do too much, why not deep compare while you are at it?
        // https://github.com/stonefl/GenericComparator/blob/master/src/GenericComparator.java
        // Eew, we will simplify that. Let's not bother with runtime type checking also just because.

        boolean asc = Boolean.valueOf(ascending);

        PrimitivesComparator cc = null;
        try {
            final Field field = Person.class.getDeclaredField(sortField);
            cc = new PrimitivesComparator(asc, field);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        if(cc != null)
        {
            List<Person> peopleList = new ArrayList<>();
            for(Person p : people)
            {
                peopleList.add(p);
            }

            // imperative with side effects but it works when it works
            Collections.sort(peopleList, cc);
            return peopleList;
        }
        return null;
    }
}
