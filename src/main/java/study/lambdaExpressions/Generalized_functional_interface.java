package study.lambdaExpressions;

public class Generalized_functional_interface {
    public static void main(String[] args) {
        Op<Integer> integer  = ((x, y) -> x+y);
        Op<String> stringOp  = ((x, y) -> x+y);
    }
}

interface Op<T>{
    T calc(T x, T y);
}
