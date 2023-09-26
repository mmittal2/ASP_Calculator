public class Translator {
    public static void main(String[] args){
        Engine e = new Engine();
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
        calculation = parsePower(calculation);
        calculation = parseMultiply(calculation);
        calculation = parseDivide(calculation);
        calculation = parseAdd(calculation);
        calculation = parseSubtract(calculation);
        return calculation;
    }
}
