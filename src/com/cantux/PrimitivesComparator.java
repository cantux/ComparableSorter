package com.cantux;

import java.lang.reflect.Field;
import java.util.Comparator;

/**
 * It's almost cheating to work with primitives since the all implement Comparable
 */
//    class NaturalComparator<T extends Comparable<? super T>> implements Comparator<T> {
//        public int compare(T a, T b) {
//            return a.compareTo(b);
//        }
//    }
public class PrimitivesComparator implements Comparator<Object> {
    private static final String DATATYPE_STRING = "java.lang.String";
    private static final String DATATYPE_DATE = "java.util.Date";
    private static final String DATATYPE_INTEGER = "java.lang.Integer";
    private static final String DATATYPE_LONG = "java.lang.Long";
    private static final String DATATYPE_FLOAT = "java.lang.Float";
    private static final String DATATYPE_DOUBLE = "java.lang.Double";

    public boolean asc;
    public Field type;
    public boolean comparableIndeed;
    public PrimitivesComparator (boolean asc, Field type) {
        this.asc = asc;
        this.type = type;
        switch(type.getType().getName())
        {
            case DATATYPE_STRING:
            case DATATYPE_DATE:
            case DATATYPE_INTEGER:
            case DATATYPE_LONG:
            case DATATYPE_DOUBLE:
            case DATATYPE_FLOAT: {
                this.comparableIndeed = true;
            }
        }
    }

    @Override
    public int compare(Object obj1, Object obj2) {
        if(comparableIndeed) {
            try {
                return ((Comparable)type.get(obj1)).compareTo(type.get(obj2)) * (this.asc? 1 : -1);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }
}
