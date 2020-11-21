package study.Lambda_expressions.FunctionalInterfaces;

import study.Lambda_expressions.expression.User;

import java.util.Scanner;
import java.util.function.*;

public class Main {

    public static void main(String[] args) {
        Predicate<Integer> isPositive  = x->x>0;
        System.out.println(isPositive.test(56));
        System.out.println(isPositive.test(-5));


        BinaryOperator<Integer> integerBinaryOperator = (x,y)->x*y;
        System.out.println(integerBinaryOperator.apply(56,23));
        System.out.println(integerBinaryOperator.apply(-5,93));

        UnaryOperator<Integer> integerUnaryOperator = x->x*x;
        System.out.println(integerUnaryOperator.apply(23));

        Function<Integer, String> integerStringFunction = x->String.valueOf(x)+"asdf";
        System.out.println(integerStringFunction.apply(6));

        Consumer<Integer> integerConsumer = x-> System.out.printf("%d asdasd",x);
        integerConsumer.accept(499);

        Supplier<User> userSupplier = ()->{
            Scanner scanner = new Scanner(System.in);
            System.out.println("enter name");
            String name = scanner.nextLine();
            return new User(name);
        };

        User user1 = userSupplier.get();
        User user2 = userSupplier.get();
        System.out.println("user1 name: "+ user1.getName());
        System.out.println("user2 name: "+ user2.getName());


    }
}
