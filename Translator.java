public class Translator {
    public static void main(String[] args){
        Engine e = new Engine();
        Double result = calculate("+", 2.0, 3.0, e);
        System.out.println(result);
    }
    
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

    public void translate(String calculation) {
    }
}
