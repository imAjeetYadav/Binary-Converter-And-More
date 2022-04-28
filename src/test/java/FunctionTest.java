import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
        Assertions.assertEquals(Function.DecimalToBinary("97865652389"),"0001011011001001001111110101100010100101");
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
    public void convertDecimalToHex0() {
        Assertions.assertEquals(Function.DecimalToHex("2414"),"96E");
    }

    @Test
    public void convertDecimalToHex1() {
        Assertions.assertEquals(Function.DecimalToHex("15"),"F");
    }

    @Test
    public void convertDecimalToHex2() {
        Assertions.assertEquals(Function.DecimalToHex("0"),"0");
    }

    @Test
    public void convertDecimalToHex3() {
        Assertions.assertEquals(Function.DecimalToHex("341237"),"534F5");
    }

    @Test
    public void convertDecimalToHex4() {
        Assertions.assertEquals(Function.DecimalToHex("97865652389"),"16C93F58A5");
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
        Assertions.assertEquals(Function.HexToBinary("C57DFE2"),"1100010101111101111111100010");
    }

    @Test
    public void convertHexToBinary1() {
        Assertions.assertEquals(Function.HexToBinary("FFAA332"),"1111111110101010001100110010");
    }

    @Test
    public void convertHexToBinary2() {
        Assertions.assertEquals(Function.HexToBinary("00A42C"),"000000001010010000101100");
    }

    @Test
    public void convertHexToBinary3() {
        Assertions.assertEquals(Function.HexToBinary("0"),"0000");
    }

    @Test
    public void convertHexToBinary4() {
        Assertions.assertEquals(Function.HexToBinary("123"),"000100100011");
    }

    // Tests for Converting Binary to Decimal

    @Test
    public void convertBinaryToDecimal0() {
        Assertions.assertEquals(Function.BinaryToDecimal("1010101110001010"),"43914");
    }

    @Test
    public void convertBinaryToDecimal1() {
        Assertions.assertEquals(Function.BinaryToDecimal("0000"),"0");
    }

    @Test
    public void convertBinaryToDecimal2() {
        Assertions.assertEquals(Function.BinaryToDecimal("0"),"0");
    }

    @Test
    public void convertBinaryToDecimal3() {
        Assertions.assertEquals(Function.BinaryToDecimal("111111111111111111"),"262143");
    }

    @Test
    public void convertBinaryToDecimal4() {
        Assertions.assertEquals(Function.BinaryToDecimal("00000000011111111111"),"2047");
    }

    // Tests for Converting Binary to Hex

    @Test
    public void convertBinaryToHex0() {
        Assertions.assertEquals(Function.BinaryToHex("00101010101010111011"),"2AABB");
    }

    @Test
    public void convertBinaryToHex1() {
        Assertions.assertEquals(Function.BinaryToHex("0000"),"0");
    }

    @Test
    public void convertBinaryToHex2() {
        Assertions.assertEquals(Function.BinaryToHex("0"),"0");
    }

    @Test
    public void convertBinaryToHex3() {
        Assertions.assertEquals(Function.BinaryToHex("00101010101010111011"),"2AABB");
    }

    @Test
    public void convertBinaryToHex4() {
        Assertions.assertEquals(Function.BinaryToHex("00101010101010111011"),"2AABB");
    }
}