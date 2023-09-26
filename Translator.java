import java.util.ArrayList;

public class Translator {
    public static void main(String[] args){
    }

    public String parseDivide(String calculation, Engine e) {
        int index = calculation.indexOf("/");
        while (index > -1) {
            ArrayList<Integer> nums = getNumbers(calculation, index, startingIndex, endingIndex);
            double result = e.divide((double)(nums.get(0)), (double)(nums.get(1)));
            calculation = calculation.substring(0, nums.get(2)) + Integer.toString((int)result) + calculation.substring(nums.get(3), calculation.length());
            index = calculation.indexOf("/");
        }
        return calculation;
    }
    
    /*
    public static Double calculate(String operator, Double a, Double b, Engine e){
        Double answer = 0.0;
        if(operator == "+"){
            answer = e.add(a, b);
        }
        else if(operator == "-"){
            answer = e.subtract(a, b);
        }
        else if(operator == "/"){
            answer = e.divide(a, b);
        }
        else if(operator == "*"){
            answer = e.multiply(a, b);
        }
        else if(operator == "^"){
            answer = e.power(a, b);
        }
        return answer;
    }
    */

    public String calculate(String calculation) {
        Engine e = new Engine();
        calculation = parsePower(calculation, e);
        calculation = parseMultiply(calculation, e);
        calculation = parseDivide(calculation, e);
        calculation = parseAdd(calculation, e);
        calculation = parseSubtract(calculation, e);
        return calculation;
    }
}
