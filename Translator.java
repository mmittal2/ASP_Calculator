import java.util.ArrayList;

public class Translator {
    public static void main(String[] args){
    }

    // call the recursive parsing method to return the calculation result
    public String parsing(String calculation) {
        Engine e = new Engine();
        String[] operators = new String[]{"^", "R", "L", "N", "S", "C", "T", "None", "*", "/", "+", "-"};
        return parsing_recursive(calculation, e, operators, "");
    }

    public static String parsing_recursive(String calculation, Engine e, String[] operators, String fp) {
        int parenIndex = calculation.indexOf("(");
        int parenEndIndex = calculation.indexOf(")");
        // if there are no more parentheses in the calculation, do the calculation and return the result
        if (parenIndex == -1 && parenEndIndex == -1) {
            calculation = callOperatorsToCalculate(calculation, e, operators);
            if (calculation.equals(" User error. Invalid Input.")) {
                return calculation;
            }
            return callOperatorsToCalculate(calculation, e, operators);
        }
        // if there are no opening parentheses but there are closing paranthesis, excute smaller calculation inside parentheses
        else if (parenIndex == -1) {
            String smallCalc = calculation.substring(0, parenEndIndex - 1);
            smallCalc = callOperatorsToCalculate(smallCalc, e, operators);
            if (smallCalc.equals(" User error. Invalid Input.")) {
                return smallCalc;
            }
            if (smallCalc.charAt(0) != ' ') {
                    smallCalc = " " + smallCalc;
                }
            if (calculation.substring(parenEndIndex + 1).indexOf(")") != -1) {
                calculation = fp + " (" + smallCalc + calculation.substring(parenEndIndex + 1);
            }
            else {
                calculation = fp + smallCalc + calculation.substring(parenEndIndex + 1);
            }
            return parsing_recursive(calculation, e, operators, "");
        }
        // if there is a parentheses in the beginning, excute the smaller calculation inside parentheses
        else if (parenEndIndex < parenIndex) {
            String smallCalc = calculation.substring(0, parenEndIndex - 1);
            smallCalc = callOperatorsToCalculate(smallCalc, e, operators);
            if (smallCalc.equals(" User error. Invalid Input.")) {
                return smallCalc;
            }
            calculation = fp + smallCalc + calculation.substring(parenEndIndex + 1);
            return parsing_recursive(calculation, e, operators, "");
        }
        // if there are nested parantheses, calculate the expression in the innermost parentheses
        else {
            String smallCalc = calculation.substring(parenIndex + 2);
            if (parenIndex == 0) {
                parenIndex += 1;
            }
            String firstPart = fp + " " + calculation.substring(0, parenIndex - 1);
            return parsing_recursive(smallCalc, e, operators, firstPart);
        }
    }

    // calculate the expression
    public static String callOperatorsToCalculate(String calculation, Engine e, String[] operators) {
        for(int i = 0; i < operators.length; i+=2){
            calculation = calculate(calculation, e, operators[i], operators[i+1]);
        }
        return calculation;
    }

    // find the numbers involved in the operation (for each operator in the expression)
    public static ArrayList<Double> getNumbers(String expression, int location){
        ArrayList<Double> numbers = new ArrayList<Double>();
        Double startingIndex = 0.0;
        Double endingIndex = (double) expression.length();
        String firstNum = "";
        String lastNum = "";

        ArrayList<Character> oneNumOperations = new ArrayList<Character>();
        oneNumOperations.add('R');
        oneNumOperations.add('L');
        oneNumOperations.add('N');
        oneNumOperations.add('S');
        oneNumOperations.add('C');
        oneNumOperations.add('T');

        // if the operator is root, log, ln, sin, cos, or tan only find the number after the operator
        if (!(oneNumOperations.contains(expression.charAt(location)))) {
            for(int i = location - 2; i >= 0; i--){
                if(expression.charAt(i) == ' '){
                    startingIndex = (double) i;
                    break;
                }
                firstNum = expression.charAt(i) + firstNum;
            }
            if (firstNum.equals("PI")) {
                numbers.add(Math.PI);
            }
            else {
                numbers.add(Double.valueOf(firstNum));
            }
        }
        else {
            startingIndex = (double) location - 1.0;
            if (startingIndex < 0.0) {
                startingIndex = 0.0;
            }
            numbers.add(0.0);
        }
        
        for(int i = location + 2; i < expression.length(); i++){
            if(expression.charAt(i) == ' '){
                endingIndex = (double) i;
                break;
            }
            lastNum = lastNum + expression.charAt(i);
        }
        if (lastNum.equals("PI")) {
            numbers.add(Math.PI);
        }
        else {
            numbers.add(Double.valueOf(lastNum));
        }
        
        numbers.add(startingIndex);
        numbers.add(endingIndex);
        
        return numbers;
    }

    // iterate over the expression until all operations have been calculated
    public static String calculate(String calculation, Engine e, String operator1, String operator2){
        ArrayList<String> indexAndOperator = findIndex(calculation, operator1, operator2);
        String index_str = indexAndOperator.get(0);
        int index = Integer.valueOf(index_str);
        String operator = indexAndOperator.get(1);

        // use PEMDAS to calculate the expression, replacing each operator/operands pair with the result, until no more operators exist
        while (index > -1) {
            ArrayList<Double> nums = getNumbers(calculation, index);
            double result = 0.0;
            if(operator == "^"){
                // if given an invalid input, throw an error
                if (nums.get(0) < 0 && nums.get(1) < 1 && nums.get(1) > 0) {
                    return " User error. Invalid input.";
                }
                result = e.power((double)(nums.get(0)), (double)(nums.get(1)));
            } else if (operator == "R") {
                if (nums.get(1) < 0) {
                    return " User error. Invalid input.";
                }
                result = e.squareRoot((double)(nums.get(1)));
            } else if (operator == "L") {
                if (nums.get(1) <= 0) {
                    return " User error. Invalid input.";
                }
                result = e.log((double)(nums.get(1)));
            } else if (operator == "N") {
                if (nums.get(1) <= 0) {
                    return " User error. Invalid input.";
                }
                result = e.ln((double)(nums.get(1)));
            } else if (operator == "S") {
                result = e.sin((double)(nums.get(1)));
            } else if (operator == "C") {
                result = e.cos((double)(nums.get(1)));
            } else if (operator == "T") {
                result = e.tan((double)(nums.get(1)));
            } else if(operator == "*"){
                result = e.multiply((double)(nums.get(0)), (double)(nums.get(1)));
            } else if(operator == "/"){
                result = e.divide((double)(nums.get(0)), (double)(nums.get(1)));
            } else if(operator == "+"){
                result = e.add((double)(nums.get(0)), (double)(nums.get(1)));
            } else if(operator == "-"){
                result = e.subtract((double)(nums.get(0)), (double)(nums.get(1)));
            }
            int endingIndex = nums.get(3).intValue();
            int startingIndex = nums.get(2).intValue();
            calculation = calculation.substring(0, startingIndex) + " " + Double.toString(result) + calculation.substring(endingIndex);
            indexAndOperator = findIndex(calculation, operator1, operator2);
            index_str = indexAndOperator.get(0);
            index = Integer.valueOf(index_str);
            operator = indexAndOperator.get(1);
        }
        return calculation;
    }

    // differentiate between the subtraction sign and negative numbers
    public static int checkNegative(String calculation, int index, String operator) {
        if (calculation.charAt(index + 1) != ' ') {
            int storeIndex = index;
            String calcSubstring = calculation.substring(index + 1);
            index = calcSubstring.indexOf(operator);
            if (index != -1) {
                index += storeIndex + 1;
            }
        }
        return index;
    }

    // find the index of the operator that needs to be calculated next (using PEMDAS)
    public static ArrayList<String> findIndex(String calculation, String operator1, String operator2) {
        ArrayList<String> result = new ArrayList<String>();
        String operator = operator1;
        int index = calculation.indexOf(operator1);
        index = checkNegative(calculation, index, operator1);
        if (operator2 != "None") {
            int index2 = calculation.indexOf(operator2);
            index2 = checkNegative(calculation, index2, operator2);
            if ((index == -1 && index2 != -1) || (index != -1 && index2 != -1 && index2 < index)) {
                index = index2;
                operator = operator2;
            }
        }
        String index_str = Integer.toString(index);
        result.add(index_str);
        result.add(operator);
        return result;
    }
    
    // when storing and getting expressions, replace "x" with the value for x given by the user
    public static String replaceVars(String expression, String val){
        int index = expression.indexOf("x");
        while(index > -1){
            expression = expression.substring(0, index) + val + expression.substring(index + 1);
            index = expression.indexOf("x");
        }

        return expression;
    }
}
