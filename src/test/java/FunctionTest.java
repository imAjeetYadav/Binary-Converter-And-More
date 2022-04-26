import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FunctionTest {

    @Test
    public void convertDecimalToBinary() {
        Assertions.assertEquals(Function.DecimalToBinary("25"),"11001");
    }

    @Test
    public void convertDecimalToHex() {

    }

    @Test
    public void convertHexToDecimal() {
        Assertions.assertEquals(Function.HexToDecimal("A43CF8"),"10763512");
    }

    @Test
    public void convertHexToBinary() {
        Assertions.assertEquals(Function.HexToBinary("C57DFE2"),"1100010101111101111111100010");
    }

    @Test
    public void convertBinaryToDecimal() {
        Assertions.assertEquals(Function.BinaryToDecimal("1010101110001010"),"43914");
    }

    @Test
    public void convertBinaryToHex() {
        Assertions.assertEquals(Function.BinaryToHex("00101010101010111011"),"2AABB");
    }
}