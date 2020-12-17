package study.lambdaExpressions;

public class ClassLevelVariable {
    private static int x = 10;
    private static int y = 20;
    public static void main(String[] args) {
        Operation operation = ()->{
          x=30;
          return x+y;
        };
        System.out.println(operation.calculate());
        System.out.println(x);
    }

}

interface Operation{
    int calculate();
}
