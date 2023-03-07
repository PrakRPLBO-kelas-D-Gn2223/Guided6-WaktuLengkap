package com.rplbo.waktu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static java.lang.System.lineSeparator;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit test for simple App.
 */
public class AppTest 
{

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    /**
     * Rigorous Test :-)
     */

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }
    @Test
    public void testSelisih()
    {
        Waktu w1 = new Waktu(14,0,0);
        Waktu w2 = new Waktu(15,0,0);
        int h = w1.selisih(w2);
        assertEquals(3600,h);
        h = w1.selisih(new Waktu(17,0,0));
        assertEquals(3*3600,h);
    }

    @Test
    public void testGetterSetter(){
        Waktu w1 = new Waktu(14,0,0);
        w1.setDetik(200);
        w1.setJam(25);
        w1.setDetik(140);
        assertEquals(0,w1.getDetik());
        assertEquals(0,w1.getJam());
        assertEquals(0,w1.getDetik());
    }

    @Test
    public void testTambahWaktu(){
        Waktu w1 = new Waktu(14,0,0);
        w1.tambahDetik(61);
        assertEquals(new Waktu(14,1,1).getMenit(),w1.getMenit());
        w1 = new Waktu(14,59,59);
        w1.tambahDetik(2);
        assertEquals(new Waktu(15,0,1).getJam(),w1.getJam());
        w1 = new Waktu(14,59,59);
        w1.tambahJam(2);
        assertEquals(new Waktu(16,59,59).getJam(),w1.getJam());
    }

    @Test
    public void tampilWaktu(){
        Waktu w1 = new Waktu(14,0,0);
        w1.tampilWaktu();
        assertEquals("14:0:0",outputStreamCaptor.toString().trim());
    }
}
