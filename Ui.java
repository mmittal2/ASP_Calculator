import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;

public class Ui {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Hashtable<String, String> equations = new Hashtable<String, String>();
        System.out.println("Let's start calculating!\n");
        printInstructions();
        while (true) {
            String type = getTypeInput(sc);
            if(Integer.valueOf(type) == 1){
                String calculation = getCalcInput(sc);
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
            } else if(Integer.valueOf(type) == 2){
                ArrayList<String> equation = getStoreInput(sc);
                equations.put(equation.get(0), equation.get(1));
                System.out.println("We have stored the following expression!\n");
                System.out.println(equation.get(0) + " = " + equation.get(1) + "\n");
            } else{
                ArrayList<String> info = getUseEquationInput(sc);
                
                // PLAN: go through and find all the 'x's in the expression, and then replace them all with the val, then just use calculate
            }
        }
        sc.close();
    }

    public static void printInstructions() {
        System.out.println("Instructions for how to use the calculator:");
        System.out.println("To begin calculating, type '1', to being storing, type '2', to use stored equations, type '3'");
        System.out.println("\t1. The calculator only takes integers.");
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

    public static String getCalcInput(Scanner sc) {
        System.out.println("Please enter your calculation: ");
        String calculation = sc.nextLine();
        return calculation;
    }

    public static String getTypeInput(Scanner sc){
        System.out.println("Please specify wheter you want to calculate an expression or store an expression: ");
        String type = sc.nextLine();
        return type;
    }

    public static ArrayList<String> getStoreInput(Scanner sc) {
        System.out.println("\n Please enter the variable under which you would like to store your expreesion: ");
        String name = sc.nextLine();
        System.out.println("\n Please enter your expression: ");
        String expression = sc.nextLine();

        ArrayList<String> equation = new ArrayList<String>();
        equation.add(name);
        equation.add(expression);
        return equation;
    }

    public static ArrayList<String> getUseEquationInput(Scanner sc){
        System.out.println("\n Please enter the variable under which your expression is stored: ");
        String name = sc.nextLine();
        System.out.println("\n Please enter your x value: ");
        String val = sc.nextLine();

        ArrayList<String> info = new ArrayList<String>();
        info.add(name);
        info.add(val);
        return info;
    }

}