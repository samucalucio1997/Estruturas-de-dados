package utils;

import java.util.Comparator;

public class ComparatorUtil<T> implements Comparator<T>{

    @Override
    public int compare(T o1, T o2) {
        if (o1 instanceof Integer && o2 instanceof Integer) {
            // TODO Auto-generated method stub
            final var number1 = (Integer)o1;
            final var number2 = (Integer)o2;
            return number1 - number2;
        }

        return 0;
    }
}
