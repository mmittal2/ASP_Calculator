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

    public Double sin(Double a) {
        return Math.sin(a);
    }

    public Double cos(Double a) {
        return Math.cos(a);
    }

    public Double tan(Double a) {
        return Math.tan(a);
    }

    public Double log(Double a) {
        return Math.log10(a);
    }

    public Double ln(Double a) {
        return Math.log(a);
    }

    // public static void main(String[] args){
    //     System.out.prDoubleln(divide(5, 2));
    // }
}
