import java.util.Scanner;

public class Ui {
    public static void main(String[] args) {
        System.out.println("Let's start calculating!\n");
        printInstructions();
        String calculation = getInput();
        Translator t = new Translator();
        String result = t.calculate(calculation);
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
    }

    public static String getInput() {
        Scanner sc=new Scanner(System.in);
        System.out.println("Please enter your calculation: ");
        String calculation = sc.nextLine();
        sc.close();
        return calculation;
    }

}