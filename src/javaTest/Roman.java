package javaTest;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public enum Roman {
    I(1),
    II(2),
    III(3),
    IV(4),
    V(5),
    VI(6),
    VII(7),
    VIII(8),
    IX(9),
    X(10),
    L(50),
    C(100);


    private int number;

    Roman(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public static List<Roman> getReverseSortedValues() {
        return Arrays.stream(values())
                .sorted(Comparator.comparing((Roman e) -> e.number).reversed())
                .collect(Collectors.toList());
    }

}
