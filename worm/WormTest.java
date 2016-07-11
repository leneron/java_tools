package tools.worm;

import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.Scanner;

import static org.junit.Assert.*;

/**
 * Created by tetyana.kolodyazhna on 07.07.16.
 */

public class WormTest {
    @Test
    public void testInit()
    {
        Worm<String> w = new Worm<>();
        assertEquals(w.getData(), null);
    }

    @Test
    public void testEquals()
    {
        Worm<String> w1 = new Worm<>();
        Worm<String> w2 = new Worm<>();
        assertEquals(w1, w2);
    }

    @Test
    public void testHashCode()
    {
        Worm w1 = new Worm(1);
        Worm w2 = new Worm(2);
        boolean res = Objects.hashCode(w2) > Objects.hashCode(w1);
        assertTrue(res);
        System.out.println("w1.getValue()="+w1.getData());
    }

    @Test
    public void testUse1()
    {
        final Worm<String> w1 = new Worm();
        w1.setData("testUse1");
        assertTrue("testUse1".equals(w1.getData()));
    }

    @Test
    public void testGetInitializedData() {
        Worm<Integer> worm = new Worm<>();

        Integer data0;
        try {
            data0 = worm.getData();
        }
        catch (NullPointerException e) {
            assertTrue(true);
        }

        Integer data1 = 123;
        try {
            worm.setData(data1);
        }
        catch (IllegalAccessError e) {
            System.err.println();
        }
        assertEquals(worm.getData(), data1);


        Integer data2 = 345;
        try {
            worm.setData(data2);
        }
        catch (IllegalAccessError e) {
            ; // ignore
        }
        assertNotEquals(worm.getData(), data2);
    }
}
