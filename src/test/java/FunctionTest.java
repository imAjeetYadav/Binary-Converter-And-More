import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FunctionTest {

    // Tests for Converting Decimal to Binary

    @Test
    public void convertDecimalToBinary0() {
        Assertions.assertEquals(Function.DecimalToBinary("25"),"00011001");
    }

    @Test
    public void convertDecimalToBinary1() {
        Assertions.assertEquals(Function.DecimalToBinary("523"),"001000001011");
    }

    @Test
    public void convertDecimalToBinary2() {
        Assertions.assertEquals(Function.DecimalToBinary("123"),"01111011");
    }

    @Test
    public void convertDecimalToBinary3() {
        Assertions.assertEquals(Function.DecimalToBinary("0"),"0000");
    }

    @Test
    public void convertDecimalToBinary4() {
        Assertions.assertEquals(Function.DecimalToBinary("100001"),"00011000011010100001");
    }

    // Tests for Converting Decimal to Hex

    @Test
    public void convertDecimalToHex() {

    }

    // Tests for Converting Hex To Decimal

    @Test
    public void convertHexToDecimal0() {
        Assertions.assertEquals(Function.HexToDecimal("A43CF8"),"10763512");
    }

    @Test
    public void convertHexToDecimal1() {
        Assertions.assertEquals(Function.HexToDecimal("0"),"0");
    }

    @Test
    public void convertHexToDecimal2() {
        Assertions.assertEquals(Function.HexToDecimal("100"),"256");
    }

    @Test
    public void convertHexToDecimal3() {
        Assertions.assertEquals(Function.HexToDecimal("FF23A"),"1045050");
    }

    @Test
    public void convertHexToDecimal4() {
        Assertions.assertEquals(Function.HexToDecimal("00A3FF"),"41983");
    }

    // Tests for Converting Hex to Binary

    @Test
    public void convertHexToBinary0() {
        Assertions.assertEquals(Function.HexToBinary("C57DFE2"),"01100010101111101111111100010");
    }

    @Test
    public void convertHexToBinary1() {
        Assertions.assertEquals(Function.HexToBinary("FFaa332"),"1111111110101010001100110010");
    }

    @Test
    public void convertHexToBinary2() {
        Assertions.assertEquals(Function.HexToBinary("00A42C"),"000000001010010000101100");
    }

    @Test
    public void convertHexToBinary3() {
        Assertions.assertEquals(Function.HexToBinary("0"),"0");
    }

    @Test
    public void convertHexToBinary4() {
        Assertions.assertEquals(Function.HexToBinary("123"),"000100100011");
    }

    // Tests for Converting Binary to Decimal

    @Test
    public void convertBinaryToDecimal() {
        Assertions.assertEquals(Function.BinaryToDecimal("1010101110001010"),"43914");
    }

    @Test
    public void convertBinaryToHex() {
        Assertions.assertEquals(Function.BinaryToHex("00101010101010111011"),"2AABB");
    }
}