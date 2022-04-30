
public class loadedNumber
{
    // Type of Numbers
    public static enum Type {DECIMAL, HEX, BINARY}

    private String binValue;
    private String decValue;
    private String hexValue;

    public loadedNumber(String value, Type valueType)
    {
        if (valueType.equals(Type.DECIMAL)) {
            decValue = value;
            hexValue = Function.DecimalToHex(value);
            binValue = Function.DecimalToBinary(value);
        } else if (valueType.equals(Type.HEX)) {
            hexValue = value;
            decValue = Function.HexToDecimal(value);
            binValue = Function.HexToBinary(value);
        } else if (valueType.equals(Type.BINARY)){
            binValue = value;
            decValue = Function.BinaryToDecimal(value);
            hexValue = Function.BinaryToHex(value);
        }
    }
    
    // Get the value of the number
    public String getBinValue()
    {
        return this.binValue;
    }

    // Set the value of the number
    public void setBinValue(String value)
    {
        this.binValue = value;
    }

    // Get the value of the number
    public String getDecValue()
    {
        return this.decValue;
    }

    // Set the value of the number
    public void setDecValue(String value)
    {
        this.decValue = value;
    }

    // Get the value of the number
    public String getHexValue()
    {
        return this.hexValue;
    }

    // Set the value of the number
    public void setHexValue(String value)
    {
        this.hexValue = value;
    }

    // To String Method
    public String toString()
    {
        return 
        "Decimal (10) Value: " + this.decValue +
        "\nBinary  (2)  Value: " + this.binValue +
        "\nHex     (16) Value: " + this.hexValue;
    }

    /**
     * See if two "Numbers" objects are the same
     * @param other Object that it is being compared to
     * @return Boolean if objects are the same
     */
    public boolean equals(Object other) {
        loadedNumber num;

        if (other instanceof loadedNumber) {
            num = (loadedNumber) other;
        } else {
            return false;
        }

        // Every "Number" has a Decimal value and the
        // rest will be equal if the Decimal number is
        // The same
        return this.decValue.equals(num.getDecValue());
    }
}
