import java.util.ArrayList;

public class Translator {
    public static void main(String[] args){
        Engine e = new Engine();
        Double result = calculate("+", 2.0, 3.0, e);
        System.out.println(result);
        System.out.println(parseAdd("2 * 34 + 7 / 3", e));
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

    public static ArrayList<Integer> getNumbers(String expression, char operator){
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        // firstNum, lastNum, startingIndex, endingIndex
        int location = expression.indexOf(operator);
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

    public static String parseAdd(String expression, Engine e){
        
        while(expression.indexOf('+') > -1){
            ArrayList <Integer> numbers = getNumbers(expression, '+');
            int firstNum = numbers.get(0);
            int lastNum = numbers.get(1);
            int startingIndex = numbers.get(2);
            int endingIndex = numbers.get(3);


            double answer = e.add((double) firstNum, (double) lastNum);

            expression = expression.substring(0, startingIndex) + " " +  Integer.toString((int) answer) + expression.substring(endingIndex);
        }
        return expression;
    }
}
