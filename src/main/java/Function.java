import java.util.ArrayList;
import java.lang.Math;
import java.util.Map;

/**
 * @author Teo
 * This Java file is the main function of the
 * program. It houses the methods to check if
 * inputted values are valid, methods to convert
 * between Dec, Hex, and Bin. The main methods such
 * as ConvertNumber and LoadHistory are meant to
 * run the right methods depending on the User Input.
 * The conversion methods are used in the loadedNumber
 * constructor to properly create a Number with all
 * three types of value conversions. The last part is the
 * ARC Assembly implementation that converts a 32-char long
 * Binary value into ARC Commands.
 */
public class Function 
{
    // Array List to store history of numbers
    private static final ArrayList<loadedNumber> history = new ArrayList<>();

    // Map to store all possible values of letters in a Hex number
    private static final Map<String, Integer> hexValues = Map.of(
            "A",10,
            "B",11,
            "C",12,
            "D",13,
            "E",14,
            "F",15
    );

    /**
     * Check if the Decimal value is valid
     * @param value Given Decimal value to check
     * @return Boolean if the value is in Decimal
     */
    public static boolean checkDecimal(String value) {
        try {
            // Try converting the value into an integer
            if (Long.parseLong(value) >= 0){
                return true;
            }
            System.out.println("Currently Does Not Support Signed!");
            return false;
        } catch(Exception e) {
            // If the value can't be converted to an integer
            return false;
        }
    }

    /**
     * Check if the hex value is valid
     * @param value Given Hex value to check
     * @return Boolean if the value is in Hex
     */
    public static boolean checkHex(String value) {
        // Check if every char is a number or hex letter
        for (int index = 0; index < value.length(); index++) {
            if (!Character.isDigit(value.charAt(index)) && !hexValues.containsKey(""+value.charAt(index))) {
                return false; // Value at index is not number or hex letter
            }
        }
        return value.length()>0; // All characters passed
    }

    /**
     * Check if the binary value is valid
     * @param value Given Binary value to check
     * @return Boolean if the value is in Binary
     */
    public static boolean checkBinary(String value) {
        // Check if every char is a 1 or 0
        for (int index = 0; index < value.length(); index++) {
            if (value.charAt(index) != '1' && value.charAt(index) != '0') {
                return false; // Value at index is not a 1 or 0
            }
        }
        return true; // Passed all tests
    }

    /**
     * Convert value given from Base Decimal to Base Binary
     * @param value Value that will be converted
     * @return String representation of the binary value
     */
    public static String DecimalToBinary(String value) {
        // Variables to be used later
        StringBuilder binary = new StringBuilder();
        long num = Long.parseLong(value);

        // If value is empty or 0 return accordingly
        if (value.equals("0") || value.equals("")) { return "0000"; }

        while (num != 0) { // When the number is 0 we've divided enough
            // Simple decimal to binary algorithm
            binary.insert(0, num % 2); // Insert backwards
            num = num/2;
        }

        // This is to maintain we send each binary in groups of 4.
        // Very important later for hex
        for (int i = 0; i < binary.length()%4; i++) {
            binary.insert(0, "0");
        }
        return binary.toString();
    }

    /**
     * Convert value given from Base Decimal to Base Hex
     * @param value Value that will be converted
     * @return String representation of the hex value
     */
    public static String DecimalToHex(String value) {
        // Check if the value is just '0' and return if it is
        if (value.equalsIgnoreCase("0")) {
            return value;
        }

        long num = Long.parseLong(value); // Parse long for larger number
        StringBuilder hex = new StringBuilder();

        // Conversion algorithm while num is not 0
        while (num != 0) {
            // The character we have to add to the start of Hex
            int addChar = (int)(16 * (((double) num / 16) - (num / 16)));

            if (addChar > 9) { // If we need a letter representation
                // Done with Java Char Casting
                hex.insert(0, (char) (addChar + 55));
            } else { // We can just add the number directly
                hex.insert(0, addChar);
            }

            num = num/16; // Update num
        }
        // Return the Hex representation
        return hex.toString();
    }

    /**
     * Convert value given from Base Hex to Base Binary
     * @param value Value that will be converted
     * @return String representation of the binary value
     * NOTICE: Will always return a value of length divisible by 4!
     */
    public static String HexToBinary(String value) {
        // If this is the last time to recurse Hex
        if (value.length() == 0) {return "";}
        // Try converting first character to an integer
        try {
            // Convert first character to binary through Decimal
            StringBuilder binary = new StringBuilder(DecimalToBinary("" + Integer.parseInt("" + value.charAt(0))));
            int binary_length = binary.length(); // Since every 0 increases length

            // Add extra 0's to express number as a 4 character long version
            for (int num = 0; num < 4-binary_length; num++) {
                binary.insert(0, "X");
            }

            // Return binary and HexToBinary of rest of value
            return (binary + HexToBinary(value.substring(1)));
        }
        // If error arose, find letter to express character
        catch (NumberFormatException error) {
            return (DecimalToBinary(""+hexValues.get(""+value.charAt(0)))) + HexToBinary(value.substring(1));
        }
    }

    /**
     * Convert value given from Base Hex to Base Decimal
     * @param value Value that will be converted
     * @return String representation of the decimal value
     */
    public static String HexToDecimal(String value) {
        // Add the value of each binary digit
        int sum = 0;

        // Loop through each digit
        for (int index = 0; index < value.length(); index++) {
            // Add it to the sum using their significant figure
            // First digit most significant so the highest power
            // If the value can't be converted into an integer
            // Find the value of the letter in hexValues
            double pow = Math.pow(16, (value.length() - index - 1));
            try {
                sum += Integer.parseInt(""+value.charAt(index)) * pow;
            } catch (Exception e) {
                sum += hexValues.get(""+value.charAt(index)) * pow;
            }
        }
        // Return the Decimal Representation
        return ""+sum;
    }

    /**
     * Convert value given from Base Binary to Base Decimal
     * @param value Value that will be converted
     * @return String representation of the decimal value
     */
    public static String BinaryToDecimal(String value) {
        // If the value is nothing not zero
        if (value.length() == 0) {
            return "";
        }

        // Add the value of each binary digit
        int sum = 0;

        // Loop through each digit
        for (int index = 0; index < value.length(); index++) {
            // Add it to the sum using their significant figure
            // First digit most significant so the highest power
            sum += Integer.parseInt(""+value.charAt(index)) * (Math.pow(2, (value.length() - index - 1)));
        }
        // Return the Decimal Representation
        return ""+sum;
    }

    /**
     * Convert value given from Base Binary to Base Hex
     * @param value Value that will be converted
     * @return String representation of the hex value
     */
    public static String BinaryToHex(String value) {
        // If the length is 4 it can be converted directly from binary
        if (value.length() >= 4) {
            // bitSum is equal to the last 4 digits converted to a number
            int bitSum = Integer.parseInt(BinaryToDecimal(value.substring(value.length()-4)));

            // If bitSum can be expressed as a decimal
            String substring = value.substring(0, value.length() - 4);
            if (bitSum <= 9) {
                // Express it as a decimal
                return BinaryToHex(substring) + bitSum;
            }
            else {
                // Look for a letter to express it
                for (String key : hexValues.keySet()) {
                    if (hexValues.get(key) == bitSum) {
                        // Express it as found letter
                        return BinaryToHex(substring) + key;
                    }
                }
            }
        }
        // Return the Decimal Representation
        return BinaryToDecimal(value);
    }

    /**
     * Get the number base type by checking Valid Type is a real
     * Base and Value is in the Right Base
     * @param value Value that should be in said valueType base
     * @param valueType ValueTyp Base to convert to a Number Type
     * @return Number Type version of the String given
     */
    public static loadedNumber.Type validType(String value, String valueType) {
        // If the value type is Decimal (10)
        if (valueType.equalsIgnoreCase("DEC") || valueType.equalsIgnoreCase("DECIMAL")
                || valueType.equalsIgnoreCase("10")) {
            if (checkDecimal(value)) {
                // Check if value follows the base
                return loadedNumber.Type.DECIMAL;
            }
            // Else raise a error
            throw new Exceptions.InvalidValueException("\nERROR VALUE : " + value + " is not in " + loadedNumber.Type.DECIMAL + "\n");
        }
        // If the value type is Hexadecimal (16)
        else if (valueType.equalsIgnoreCase("HEX") || valueType.equalsIgnoreCase("HEXADECIMAL")
                || valueType.equalsIgnoreCase("16")) {
            if (checkHex(value)) {
                // Check if value follows the base
                return loadedNumber.Type.HEX;
            }
            // Else raise a error
            throw new Exceptions.InvalidValueException("\nERROR VALUE : " + value + " is not in " + loadedNumber.Type.HEX + "\n");
        }
        // If the value type is Binary (2)
        else if (valueType.equalsIgnoreCase("BIN") || valueType.equalsIgnoreCase("BINARY")
                || valueType.equalsIgnoreCase("2")) {
            if (checkBinary(value)) {
                // Check if value follows the base
                return loadedNumber.Type.BINARY;
            }
            // Else raise a error
            throw new Exceptions.InvalidValueException("\nERROR VALUE : " + value + " is not in " + loadedNumber.Type.BINARY + "\n");
        }
        // Else raise a error
        throw new Exceptions.InvalidBaseException("\nERROR TYPE : " + valueType + " is not a real / supported type!" + "\n");
    }

    /**
     * SETHI and BRANCH Format for a Value
     * @param value Binary Value to be Converted to ARC
     * @return ARC Assembly Code
     */
    public static String sethiBranch(String value) {
        switch(value.substring(7,10)) {
            // BRANCH
            case "010":
                if (value.charAt(2) == '0') {
                    return switch (value.substring(3, 7)) {
                        case "0001" -> "BE " + BinaryToDecimal(value.substring(10));
                        case "0101" -> "BCS " + BinaryToDecimal(value.substring(10));
                        case "0110" -> "BNEG " + BinaryToDecimal(value.substring(10));
                        case "0111" -> "BVS " + BinaryToDecimal(value.substring(10));
                        case "1000" -> "BA " + BinaryToDecimal(value.substring(10));
                        default -> throw new Exceptions.InvalidValueException("This value is not an ARC command!");
                    };
                }
                throw new Exceptions.InvalidValueException("This value is not an ARC command!");
            // SETHI
            case "100":
                return "SETHI 0x" + BinaryToHex(value.substring(10)) + ", %r" + BinaryToDecimal(value.substring(2,7));
            default:
                throw new Exceptions.InvalidValueException("This value is not an ARC command!");
        }
    }

    /**
     * CALL Format for a Value
     * @param value Binary Value to be Converted to ARC
     * @return ARC Assembly Code
     */
    public static String call(String value) {
        return "CALL " + BinaryToDecimal(value.substring(2));
    }

    public static String arithmetic(String value) {
        String op3 = switch (value.substring(7, 13)) {
            // Add Complement
            case "010000" -> "ADDCC";
            // And Complement
            case "010001" -> "ANDCC";
            // Or Complement
            case "010010" -> "ORCC";
            // Not Or Complement
            case "010110" -> "ORNCC";
            // Shift Right
            case "100110" -> "SRL";
            // Jump and Link
            case "111000" -> "JMPL";
            default -> throw new Exceptions.InvalidValueException("This value is not an ARC command!");
        };
        if (value.charAt(18) == '0') {
            return op3 + " %r" + BinaryToDecimal(value.substring(13,18)) + ", %r"
                    + BinaryToDecimal(value.substring(27)) + ", %r" + BinaryToDecimal(value.substring(2,7));
        } else { // Then equals 1
            return op3 + " %r" + BinaryToDecimal(value.substring(13,18)) + ", "
                    + BinaryToDecimal(value.substring(19)) + ", %r" + BinaryToDecimal(value.substring(2,7));
        }
    }

    public static String convertToAssembly(String value) {
        if (checkBinary(value)) {
            if (value.length() == 32) {
                switch(value.substring(0,2)) {
                    // SETHI Format
                    case "00":
                        return sethiBranch(value);
                    // CALL Format
                    case "01":
                        return call(value);
                    // ARITHMETIC Format
                    case "10":
                        return arithmetic(value);
                    // MEMORY Format
                    case "11":
                        break;
                    default:
                        throw new Exceptions.InvalidValueException("This value is not an ARC command!");
                }
            }
            throw new Exceptions.InvalidValueException("This value is not the right size! (32 chars Needed)");
        }
        throw new Exceptions.InvalidValueException("This value is not binary!");
    }

    /**
     * Take a passed Value and Base and create
     * a loaded Number
     * @param value Value Magnitude
     * @param valueType Base of the Value
     */
    public static void convertNumber(String value, loadedNumber.Type valueType) {
        history.add(new loadedNumber(value,valueType));
        System.out.println(history.get(history.size()-1));
    }

    /**
     * Print out the history of all
     * Numbers converted
     */
    public static void loadHistory() {
        for (loadedNumber num : history) {
            System.out.println(num.toString());
        }
    }
}
