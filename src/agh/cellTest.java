package agh;

import junit.framework.Assert;
import junit.framework.TestCase;

public class cellTest extends TestCase {

    @org.junit.Test
    public void testGetStan() {
        cell komorka = new cell();
        komorka.setStan(1);
        Assert.assertEquals(1,komorka.getStan());
    }

    public void testZmienStan() {
        cell komorka = new cell();
        komorka.setStan(2);
        komorka.zmienStan(true);
        Assert.assertEquals(3,komorka.getStan());

        komorka.setStan(3);
        komorka.zmienStan(true);
        Assert.assertEquals(0, komorka.getStan());

        komorka.setStan(2);
        komorka.zmienStan(false);
        Assert.assertEquals(0,komorka.getStan());

        komorka.setStan(0);
        komorka.zmienStan(false);
        Assert.assertEquals(1, komorka.getStan());

    }

    public void testSetSuma() {

        cell komorka = new cell();
        komorka.setSuma(8);
        Assert.assertEquals(8,komorka.getSuma());

    }




    public void testprocess() {

        cell komorka = new cell();
        komorka.setSuma(3);
        komorka.setStan(0);
        komorka.process(false);
        Assert.assertEquals(1,komorka.getStan());

        komorka.process(false);
        Assert.assertEquals(1,komorka.getStan());

        komorka.setSuma(5);
        komorka.process(false);
        Assert.assertEquals(0,komorka.getStan());

    }

}