import java.util.ArrayList;

public class Translator {
    public static void main(String[] args){
    }

    public String parsing(String calculation) {
        Engine e = new Engine();
        String[] operators = new String[]{"^", "*", "/", "+", "-"};
        
        for(int i = 0; i < operators.length; i++){
            calculation = calculate(calculation, e, operators[i]);
        }
        return calculation;
    }

    public static ArrayList<Double> getNumbers(String expression, int location){
        ArrayList<Double> numbers = new ArrayList<Double>();
        // firstNum, lastNum, startingIndex, endingIndex
        Double startingIndex = 0.0;
        Double endingIndex = (double) expression.length();
        String firstNum = "";
        String lastNum = "";
        for(int i = location - 2; i >= 0; i--){
            if(expression.charAt(i) == ' '){
                startingIndex = (double) i;
                break;
            }
            firstNum = expression.charAt(i) + firstNum;
        }

        for(int i = location + 2; i < expression.length(); i++){
            if(expression.charAt(i) == ' '){
                endingIndex = (double) i;
                break;
            }
            lastNum = lastNum + expression.charAt(i);
        }
        
        numbers.add(Double.valueOf(firstNum));
        numbers.add(Double.valueOf(lastNum));
        numbers.add(startingIndex);
        numbers.add(endingIndex);
        
        return numbers;
    }

    public static String calculate(String calculation, Engine e, String operator){
        int index = calculation.indexOf(operator);
        index = checkNegative(calculation, index, operator);
        while (index > -1) {
            ArrayList<Double> nums = getNumbers(calculation, index);
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
            int endingIndex = nums.get(3).intValue();
            int startingIndex = nums.get(2).intValue();
            calculation = calculation.substring(0, startingIndex) + " " + Double.toString(result) + calculation.substring(endingIndex);
            index = calculation.indexOf(operator);
            
            index = checkNegative(calculation, index, operator);     
        }
        return calculation;
    }

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
    
}
