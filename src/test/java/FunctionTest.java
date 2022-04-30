import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FunctionTest {

    // Test if full Valid Type method works
    @Test
    public void validTypeCheck0() {
        Assertions.assertEquals(Function.validType("97865652389","DECIMAL"),loadedNumber.Type.DECIMAL);
    }

    @Test
    public void validTypeCheck1() {
        Assertions.assertEquals(Function.validType("123456789ABCDEF","HEX"),loadedNumber.Type.HEX);
    }

    @Test
    public void validTypeCheck2() {
        Assertions.assertEquals(Function.validType("0000000101001010100","BINARY"),loadedNumber.Type.BINARY);
    }

    @Test
    public void validTypeCheck3() {
        Assertions.assertEquals(Function.validType("97865652389","HEX"),loadedNumber.Type.HEX);
    }

    @Test
    public void validTypeCheck4() {
        Assertions.assertThrows(Exceptions.InvalidValueException.class, () -> {Function.validType("123456789ABCDEF","BINARY");});
    }

    @Test
    public void validTypeCheck5() {
        Assertions.assertThrows(Exceptions.InvalidValueException.class, () -> {Function.validType("123456789ABCDEF","DECIMAL");});
    }

    @Test
    public void validTypeCheck6() {
        Assertions.assertThrows(Exceptions.InvalidBaseException.class, () -> {Function.validType("1","TEST");});
    }

    // Check if it makes Number Object properly
    @Test
    public void checkNumberObject0() {
        Assertions.assertEquals(new loadedNumber("123456789",loadedNumber.Type.DECIMAL),
                new loadedNumber("123456789",loadedNumber.Type.DECIMAL));
    }

    @Test
    public void checkNumberObject1() {
        Assertions.assertEquals(new loadedNumber("123456789",loadedNumber.Type.DECIMAL),
                new loadedNumber("75BCD15",loadedNumber.Type.HEX));
    }

    @Test
    public void checkNumberObject2() {
        Assertions.assertEquals(new loadedNumber("123456789",loadedNumber.Type.DECIMAL),
                new loadedNumber("111010110111100110100010101",loadedNumber.Type.BINARY));
    }

    @Test
    public void checkNumberObject3() {
        Assertions.assertNotEquals(new loadedNumber("123456789",loadedNumber.Type.DECIMAL),
                new loadedNumber("0",loadedNumber.Type.DECIMAL));
    }

    // Check if Value is Decimal
    @Test
    public void checkValueIsDecimal0() {
        Assertions.assertTrue(Function.checkDecimal("0"));
    }

    @Test
    public void checkValueIsDecimal1() {
        Assertions.assertTrue(Function.checkDecimal("632122"));
    }

    @Test
    public void checkValueIsDecimal2() {
        Assertions.assertTrue(Function.checkDecimal("101001010101"));
    }

    @Test
    public void checkValueIsDecimal3() {
        Assertions.assertFalse(Function.checkDecimal("1.1"));
    }

    @Test
    public void checkValueIsDecimal4() {
        Assertions.assertFalse(Function.checkDecimal(""));
    }

    @Test
    public void checkValueIsDecimal5() {
        Assertions.assertFalse(Function.checkDecimal("-5419"));
    }

    // Check if Value is Binary
    @Test
    public void checkValueIsBinary0() {
        Assertions.assertTrue(Function.checkBinary("0"));
    }

    @Test
    public void checkValueIsBinary1() {
        Assertions.assertTrue(Function.checkBinary("1101010010101000"));
    }

    @Test
    public void checkValueIsBinary2() {
        Assertions.assertFalse(Function.checkBinary("21323647574567456"));
    }

    @Test
    public void checkValueIsBinary3() {
        Assertions.assertFalse(Function.checkBinary("45AC23D"));
    }

    @Test
    public void checkValueIsBinary4() {
        Assertions.assertFalse(Function.checkBinary("-101010"));
    }

    @Test
    public void checkValueIsBinary5() {
        Assertions.assertTrue(Function.checkBinary("00000010101010010"));
    }

    // Check if Value is Hex

    @Test
    public void checkValueIsHex0() {
        Assertions.assertTrue(Function.checkHex("0"));
    }

    @Test
    public void checkValueIsHex1() {
        Assertions.assertTrue(Function.checkHex("101001"));
    }

    @Test
    public void checkValueIsHex2() {
        Assertions.assertTrue(Function.checkHex("A3BDCF87"));
    }

    @Test
    public void checkValueIsHex3() {
        Assertions.assertFalse(Function.checkHex("ABCDEFG"));
    }

    @Test
    public void checkValueIsHex4() {
        Assertions.assertFalse(Function.checkHex("-A"));
    }

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