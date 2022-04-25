
abstract class Number 
{
    // Type of Numbers
    public static enum Type {DECIMAL, HEX, BINARY}

    private String binValue;
    private String decValue;
    private String hexValue;

    public Number(String binValue, String decValue, String hexValue)
    {
        this.binValue = binValue;
        this.decValue = decValue;
        this.hexValue = hexValue;
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
        "Decimal Value: " + this.decValue +
        "Binary Value: " + this.binValue + 
        "Hex Value: " + this.hexValue;
    }
}
