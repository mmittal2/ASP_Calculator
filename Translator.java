import java.util.ArrayList;

public class Translator {
    public static void main(String[] args){
        String result = parsing("3 + 2");
        System.out.println(result);
    }

    public static String parsing(String calculation) {
        Engine e = new Engine();
        String[] operators = new String[]{"^", "*", "/", "+", "-"};
        
        for(int i = 0; i < operators.length; i++){
            calculation = calculate(calculation, e, operators[i]);
        }

        // calculation = parsePower(calculation, e);
        // calculation = parseMultiply(calculation, e);
        // calculation = parseDivide(calculation, e);
        // calculation = parseAdd(calculation, e);
        // calculation = parseSubtract(calculation, e);
        return calculation;
    }

    public static ArrayList<Integer> getNumbers(String expression, int location){
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        // firstNum, lastNum, startingIndex, endingIndex
        int startingIndex = 0;
        int endingIndex = 0;
        String firstNum = "";
        String lastNum = "";
        for(int i = location - 2; i >= 0; i--){
            if(expression.charAt(i) == ' '){
                startingIndex = i;
                break;
            }
            firstNum = expression.charAt(i) + firstNum;
        }

        for(int i = location + 2; i < expression.length(); i++){
            if(expression.charAt(i) == ' '){
                endingIndex = i;
                break;
            }
            lastNum = lastNum + expression.charAt(i);
        }
        
        numbers.add(Integer.valueOf(firstNum));
        numbers.add(Integer.valueOf(lastNum));
        numbers.add(startingIndex);
        numbers.add(endingIndex);
        
        return numbers;
    }

    public static String calculate(String calculation, Engine e, String operator){
        int index = calculation.indexOf(operator);
        while (index > -1) {
            ArrayList<Integer> nums = getNumbers(calculation, index);
            double result = 0.0;
            if(operator == "^"){
                result = e.power((double)(nums.get(0)), (double)(nums.get(1)));
            } else if(operator == "*"){
                result = e.multiply((double)(nums.get(0)), (double)(nums.get(1)));
            } else if(operator == "/"){
                result = e.divide((double)(nums.get(0)), (double)(nums.get(1)));
            } else if(operator == "+"){
                result = e.add((double)(nums.get(0)), (double)(nums.get(1)));
            } else if(operator == "-"){
                result = e.subtract((double)(nums.get(0)), (double)(nums.get(1)));
            }
            
            calculation = calculation.substring(0, nums.get(2)) + " " + Integer.toString((int)result) + calculation.substring(nums.get(3), calculation.length());
            index = calculation.indexOf("-");
        }
        return calculation;
    }
    /*
    public static String parseAdd(String calculation, Engine e){
        int index = calculation.indexOf("+");
        while(index > -1){
            ArrayList <Integer> numbers = getNumbers(calculation, index);
            int firstNum = numbers.get(0);
            int lastNum = numbers.get(1);
            int startingIndex = numbers.get(2);
            int endingIndex = numbers.get(3);

            double answer = e.add((double) firstNum, (double) lastNum);

            calculation = calculation.substring(0, startingIndex) + " " +  Integer.toString((int) answer) + calculation.substring(endingIndex);
            index = calculation.indexOf("+");
        }
        return calculation;
    }

    public static String parseSubtract(String calculation, Engine e) {
        int index = calculation.indexOf("-");
        while (index > -1) {
            ArrayList<Integer> nums = getNumbers(calculation, index);
            double result = e.subtract((double)(nums.get(0)), (double)(nums.get(1)));
            calculation = calculation.substring(0, nums.get(2)) + " " + Integer.toString((int)result) + calculation.substring(nums.get(3), calculation.length());
            index = calculation.indexOf("-");
        }
        return calculation;
    }

    public static String parseMultiply(String calculation, Engine e) {
        int index = calculation.indexOf("*");
        while (index > -1) {
            ArrayList<Integer> nums = getNumbers(calculation, index);
            double result = e.multiply((double)(nums.get(0)), (double)(nums.get(1)));
            calculation = calculation.substring(0, nums.get(2)) + " " + Integer.toString((int)result) + calculation.substring(nums.get(3), calculation.length());
            index = calculation.indexOf("*");
        }
        return calculation;
    }

    public static String parseDivide(String calculation, Engine e) {
        int index = calculation.indexOf("/");
        while (index > -1) {
            ArrayList<Integer> nums = getNumbers(calculation, index);
            double result = e.divide((double)(nums.get(0)), (double)(nums.get(1)));
            calculation = calculation.substring(0, nums.get(2)) + " " + Integer.toString((int)result) + calculation.substring(nums.get(3), calculation.length());
            index = calculation.indexOf("/");
        }
        return calculation;
    }

    public static String parsePower(String calculation, Engine e) {
        int index = calculation.indexOf("^");
        while (index > -1) {
            ArrayList<Integer> nums = getNumbers(calculation, index);
            double result = e.power((double)(nums.get(0)), (double)(nums.get(1)));
            calculation = calculation.substring(0, nums.get(2)) + " " + Integer.toString((int)result) + calculation.substring(nums.get(3), calculation.length());
            index = calculation.indexOf("^");
        }
        return calculation;
    }
    */
    
}
