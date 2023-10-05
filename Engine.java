import java.lang.Math;
public class Engine {

    public Double add(Double a, Double b){
        return a + b;
    }
    
    public Double subtract(Double a, Double b){
        return a - b;
    }
    
    public Double multiply(Double a, Double b){
        return a * b;
    }

    public Double divide(Double a, Double b){
        return (Double) a / (Double) b;
    }

    public Double power(Double a, Double b){
        return Math.pow(a, b);
    }

    public Double squareRoot(Double a){
        return Math.pow(a, 0.5);
    }

    // public static void main(String[] args){
    //     System.out.prDoubleln(divide(5, 2));
    // }
}
