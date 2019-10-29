package Verifica_Barcode_1;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void Test(){
        assertEquals(App.readBarcode(5,"10100010110100111011001100100110111101001110101010110011011011001000010101110010011101000100101"),"5901234123457");
    }

    @Test
    public void Test1(){
        assertEquals(App.readBarcode(6,"10101111010000101010011101110010010011001001101010101110011011001001000111001010000101000100101"),"6360522428037");
    }

    @Test
    public void Test2(){
        assertEquals(App.readBarcode(0,"10100100110111011010001100010110001011011110101010111001010001001100110111010011001101001000101"),"0274993071918");
    }

    @Test
    public void Test3(){
        assertEquals(App.readBarcode(5,"10100010110100111011001100100110111101001110101010110011011011001000010101110010011101000100101"),"5901234123457");
    }
}
