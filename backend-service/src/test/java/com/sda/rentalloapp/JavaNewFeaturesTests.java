package com.sda.rentalloapp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JavaNewFeaturesTests {

    @Test
    public void multilineStrings() {
        String meWithAddressOldWay =
                "Mariusz P.     " +
                "Warsaw         ";


        String meWithAddressNewWay =
                """
                Mariusz P.      
                Warsaw      
                """;
        String me = "Mariusz P.     ";
        String me2 = "Mariusz P.     ";
        Assertions.assertEquals(me, me2);
        System.out.println("me == me2: " + (me == me2));
        Assertions.assertSame(me, me2);

        String howMany = "one" + "two" + "three";
    }
}
