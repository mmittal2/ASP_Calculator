import java.text.DecimalFormat;
import java.util.ArrayList;

public class Translator {
    public static void main(String[] args){
    }

    public String parsing(String calculation) {
        Engine e = new Engine();
        String[] operators = new String[]{"^", "*", "/", "+", "-"};
        calculation = calculate(calculation, e, operators[0], "None");
        for(int i = 1; i < operators.length; i+=2){
            calculation = calculate(calculation, e, operators[i], operators[i+1]);
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

    public static String calculate(String calculation, Engine e, String operator1, String operator2){
        ArrayList<String> indexAndOperator = findIndex(calculation, operator1, operator2);
        String index_str = indexAndOperator.get(0);
        int index = Integer.valueOf(index_str);
        String operator = indexAndOperator.get(1);

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
            DecimalFormat df = new DecimalFormat("#.########");
            String result_str = df.format(result);
            calculation = calculation.substring(0, startingIndex) + " " + result_str + calculation.substring(endingIndex);
            
            indexAndOperator = findIndex(calculation, operator1, operator2);
            index_str = indexAndOperator.get(0);
            index = Integer.valueOf(index_str);
            operator = indexAndOperator.get(1);
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
    
    public static String replaceVars(String expression, String val){
        int index = expression.indexOf("x");
        while(index > -1){
            expression = expression.substring(0, index) + val + expression.substring(index + 1);
            index = expression.indexOf("x");
        }

        return expression;
    }
}
