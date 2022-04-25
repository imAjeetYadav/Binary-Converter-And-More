import java.util.Scanner;

public class Interface
{   
    public static void main(String[] args) {
        // Initialize Scanner
        Scanner scanner = new Scanner(System.in);

        System.out.print(">"); // Make Console

        while (true)
        {
            String input = scanner.nextLine();

            // Add keys and values to HashMap
            Function.hashAdd("A", 10);
            Function.hashAdd("B", 11);
            Function.hashAdd("C", 12);
            Function.hashAdd("D", 13);
            Function.hashAdd("E", 14);
            Function.hashAdd("F", 15);
            // Test

            // End Program
            if (input.equalsIgnoreCase("QUIT"))
            {
                System.out.println("See You Soon!");
                scanner.close(); // To close program properly
                break;
            }
            // Number Conversion
            else if (input.equalsIgnoreCase("CONVERT"))
            {
                // Values to be used later
                Number.Type valueType; // Removed null
                String value;          // Removed null

                // Get the value of the number
                System.out.println("\nWhat is the value?");
                value = scanner.nextLine();

                // Get the value type as a string and convert it to Type
                // validType also checks if value is in valueType
                System.out.println("\nWhat is the base of value?");
                valueType = Function.validType(value, scanner.nextLine());

                // If the type exists else error happened
                if (valueType != null)
                {
                    System.out.println("Made it!");
                    Function.convertNumber(value, null);
                }
                else
                {
                    System.out.println(Function.getError());
                }
            }
            // Assembly Related Command
            else if (input.equalsIgnoreCase("ASSEMBLY"))
            {
                continue;
            }
            // Load older input
            else if (input.equalsIgnoreCase("LOAD"))
            {
                continue;
            }
            System.out.print(">");
        }
    }
}