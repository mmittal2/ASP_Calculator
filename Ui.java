import java.util.Scanner;

public class Ui {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Let's start calculating!\n");
        printInstructions();
        while (true) {
            String calculation = getInput(sc);
            String calculation_without_spaces = calculation.replaceAll("\\s", "");
            if (calculation_without_spaces != "") {
                Translator t = new Translator();
                String result = t.parsing(calculation);
                System.out.println("=" + result);
                System.out.println();
            }
            else {
                System.out.println("Thank you for using our lovely calculator! We hope you have a great day! Continue Calculating!\n");
                break;
            }
        }
        sc.close();
    }

    public static void printInstructions() {
        System.out.println("Instructions for how to use the calculator:");
        System.out.println("\t1. The calculator only takes integers (no decimals).");
        System.out.println("\t2. The calculator can perform the following functions: subtract, add, multiply, divide, and powers.");
        System.out.println("\t3. Type a space between all numbers and operators (ex: 23 * 4).");
        System.out.println("  These are the symbols that represent each calculation:");
        System.out.println("\t- subtract: -");
        System.out.println("\t- add: +");
        System.out.println("\t- multiply: *");
        System.out.println("\t- divide: /");
        System.out.println("\t- power: ^\n");
        System.out.println("To close the calculator, simply hit enter again.\n");
    }

    public static String getInput(Scanner sc) {
        System.out.println("Please enter your calculation: ");
        String calculation = sc.nextLine();
        return calculation;
    }

}