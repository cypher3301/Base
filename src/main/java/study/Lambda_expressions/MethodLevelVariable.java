package Lambda_expressions;

public class MethodLevelVariable {
    public static void main(String[] args) {
        int n = 80;
        int x = 70;

        Opr opr = ()->{
            //n=199; not correct
          return n+x;
        };
        //n=199;// not correct
    }
}

interface Opr{
    int calc();
}
