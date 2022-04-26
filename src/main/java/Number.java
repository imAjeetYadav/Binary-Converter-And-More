
public class Number
{
    // Type of Numbers
    public static enum Type {DECIMAL, HEX, BINARY}

    private String binValue;
    private String decValue;
    private String hexValue;
    private Type valueType;

    public Number(String value, Type valueType)
    {
        this.valueType = valueType;

        if (valueType.equals(Type.DECIMAL)) {
            decValue = value;
        } else if (valueType.equals(Type.HEX)) {
            hexValue = value;
        } else if (valueType.equals(Type.BINARY)){
            binValue = value;
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

    // Get the base of the number
    public Type getBase() {
        return this.valueType;
    }

    // Set the base of the number
    public void setBase(Type valueType) {
        this.valueType = valueType;
    }

    // To String Method
    public String toString()
    {
        return 
        "Decimal Value: " + this.decValue +
        "Binary Value: " + this.binValue + 
        "Hex Value: " + this.hexValue;
    }
}
