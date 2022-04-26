import java.util.ArrayList;
import java.util.HashMap;
import java.lang.Math;
import java.util.Map;

public class Function 
{
    // Array List to store history of numbers
    private final ArrayList<Number> history = new ArrayList<Number>();

    // HashMap to store all possible values of letters in a Hex number
    // private static final HashMap<String, Integer> hexValues = new HashMap<String, Integer>();
    private static final Map<String, Integer> hexValues = Map.of(
            "A",10,
            "B",11,
            "C",12,
            "D",13,
            "E",14,
            "F",15
    );

    // Check if the decimal value is valid
    private static boolean checkDecimal(String value)
    {
        try
        {
            // Try converting the value into a integer
            if (Integer.parseInt(value) >= 0){
                return true;
            }
            System.out.println("Currently Does Not Support Signed!");
            return false;
        }
        catch(Exception e)
        {
            // If the value can't be converted to a integer
            return false;
        }
    }

    // Check if the hex value is valid
    private static boolean checkHex(String value)
    {
        // Convert all values to uppercase
        value = value.toUpperCase();

        // Check if every char is a number or hex letter
        for (int index = 0; index < value.length(); index++)
        {
            if (Character.isDigit(value.charAt(index)) || hexValues.containsKey(""+value.charAt(index)))
            {
                continue;
            }
            else
            {
                return false; // Value at index is not number or hex letter
            }
        }
        return true; // All characters passed
    }

    // Check if the binary value is valid
    private static boolean checkBinary(String value)
    {
        try
        {
            // Try converting the value into a integer
            Integer.parseInt(value);

            // Check if every char is a 1 or 0
            for (int index = 0; index < value.length(); index++)
            {
                if (value.charAt(index) == '1' || value.charAt(index) == '0')
                {
                    continue;
                }
                else
                {
                    return false; // Value at index is not a 1 or 0
                }
            }
            return true; // Passed all tests
        }
        catch(Exception e)
        {
            // If the value can't be converted to a integer
            return false;
        }
    }

    //? Convert from decimal to binary
    public static String DecimalToBinary(String value)
    {
        // If the value is 0 return nothing
        if (value.length() == 0 || Integer.parseInt(value) == 0)
        {
            return "";
        }
        // If the value divided by two has no floating point add 0
        else if ((Double.parseDouble(value) % 2) == 0)
        {   
            return DecimalToBinary(""+(int)(Double.parseDouble(value) / 2)) + "0";
        } 
        // If the value divided by two has a floating point add 1
        else
        {
            return DecimalToBinary(""+(int)(Double.parseDouble(value) / 2)) + "1";
        }
    }

    //? Convert from decimal to hex
    // TODO
    public static void DecimalToHex(String value)
    {
        System.out.println(""+null);
    }

    //? Convert from hex to binary
    public static String HexToBinary(String value)
    {
        // If this is the last time to recurse Hex
        if (value.length() == 1)
        {
            // Try converting first character to a integer
            try
            {
                // Convert character to binary through Decimal
                String binary = DecimalToBinary(""+Integer.parseInt(value.substring(0,1)));
                int binary_length = binary.length(); // Since every 0 increases length

                // Add extra 0's to express number as 4 characters long
                for (int num = 0; num < 4-binary_length; num++)
                {
                    binary = "0" + binary;
                }

                // Return just number
                System.out.println(binary);
                return (binary);
            }
            catch (Exception e)
            {
                // If error arose, find letter to express character
                return (DecimalToBinary(""+hexValues.get(value.substring(0,1))));
            }
        }
        else
        {
            // Try converting first character to a integer
            try
            {
                // Convert first character to binary through Decimal
                String binary = DecimalToBinary(""+Integer.parseInt(value.substring(0,1)));
                int binary_length = binary.length(); // Since every 0 increases length

                // Add extra 0's to express number as 4 characters long
                for (int num = 0; num < 4-binary_length; num++)
                {
                    binary = "0" + binary;
                }

                // Return binary and HexToBinary of rest of value
                return (binary + HexToBinary(value.substring(1)));
            }
            // If error arose, find letter to express character
            catch (Exception e)
            {
                return (DecimalToBinary(""+hexValues.get(value.substring(0,1)))) + HexToBinary(value.substring(1));
            }
        }
    }

    //? Convert from hex to decimal
    public static String HexToDecimal(String value)
    {
        // Add the value of each binary digit
        int sum = 0;

        // Loop through each digit
        for (int index = 0; index < value.length(); index++)
        {
            // Add it to the sum using their significant figure
            // First digit most significant so highest power
            // If the value can't be converted into an integer
            // Find the value of the letter in hexValues
            try
            {
                sum += Integer.parseInt(""+value.charAt(index)) * (Math.pow(16, (value.length() - index - 1)));   
            }
            catch (Exception e)
            {
                sum += hexValues.get(""+value.charAt(index)) * (Math.pow(16, (value.length() - index - 1)));
            }
        }

        return ""+sum;
    }

    //? Convert from binary to decimal
    public static String BinaryToDecimal(String value)
    {
        // If the value is nothing not zero
        if (value.length() == 0)
        {
            return "";
        }

        // Add the value of each binary digit
        int sum = 0;

        // Loop through each digit
        for (int index = 0; index < value.length(); index++)
        {
            // Add it to the sum using their significant figure
            // First digit most significant so highest power
            sum += Integer.parseInt(""+value.charAt(index)) * (Math.pow(2, (value.length() - index - 1)));
        }

        return ""+sum;
    }

    //? Convert from binary to hex
    public static String BinaryToHex(String value)
    {
        // If the length is 4 it can be converted directly from binary
        if (value.length() >= 4)
        {
            // bitSum is equal to the last 4 digits converted to a number
            int bitSum = Integer.parseInt(BinaryToDecimal(value.substring(value.length()-4, value.length())));

            // If bitSum can be expressed as a decimal
            if (bitSum <= 9)
            {
                // Express it as a decimal
                return BinaryToHex(value.substring(0, value.length()-4)) + bitSum;
            }
            else
            {
                // Look for a letter to express it
                for (String key : hexValues.keySet())
                {
                    if (hexValues.get(key) == bitSum)
                    {
                        // Express it as found letter
                        return BinaryToHex(value.substring(0, value.length()-4)) + key;
                    }
                }
            }
        }

        return BinaryToDecimal(value);
    }

    //* Convert Value to all other types and make Number object
    public static void convertNumber(String value, Number.Type valueType) {}

    // Get the number base type
    // Valid Type also checks if the 
    // Value is in the right base
    public static Number.Type validType(String value, String valueType)
    {
        // If the value type is Decimal (10)
        if (valueType.equalsIgnoreCase("DEC") || valueType.equalsIgnoreCase("DECIMAL") || valueType.equalsIgnoreCase("10"))
        {
            if (checkDecimal(value))
            {
                // Check if value follows the base
                return Number.Type.DECIMAL;
            }
            // Else raise a error
            throw new Exceptions.InvalidValueException("\nERROR VALUE : " + value + " is not in " + Number.Type.DECIMAL + "\n");
        }
        // If the value type is Hexadecimal (16)
        else if (valueType.equalsIgnoreCase("HEX") || valueType.equalsIgnoreCase("HEXADECIMAL") || valueType.equalsIgnoreCase("16"))
        {
            if (checkHex(value))
            {
                // Check if value follows the base
                return Number.Type.HEX;
            }
            // Else raise a error
            throw new Exceptions.InvalidValueException("\nERROR VALUE : " + value + " is not in " + Number.Type.HEX + "\n");
        }
        // If the value type is Binary (2)
        else if (valueType.equalsIgnoreCase("BIN") || valueType.equalsIgnoreCase("BINARY") || valueType.equalsIgnoreCase("2"))
        {
            if (checkBinary(value))
            {
                // Check if value follows the base
                return Number.Type.BINARY;
            }
            // Else raise a error
            throw new Exceptions.InvalidValueException("\nERROR VALUE : " + value + " is not in " + Number.Type.BINARY + "\n");
        }
        // Else raise a error
        throw new Exceptions.InvalidBaseException("\nERROR TYPE : " + valueType + " is not a real / supported type!" + "\n");
    }
}
