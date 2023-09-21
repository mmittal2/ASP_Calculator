import java.lang.Math;
public class Engine {

    public static Double add(Double a, Double b){
        return a + b;
    }
    
    public static Double subtract(Double a, Double b){
        return a - b;
    }
    
    public static Double multiply(Double a, Double b){
        return a * b;
    }

    public static Double divide(Double a, Double b){
        return (Double) a / (Double) b;
    }

    public static Double power(Double a, Double b){
        return Math.pow(a, b);
    }

    // public static void main(String[] args){
    //     System.out.prDoubleln(divide(5, 2));
    // }
}
