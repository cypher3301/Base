package study.Lambda_expressions.expression;

import study.Lambda_expressions.Expression;

public class MethodReferencesAsMethodParameters {

    public static void main(String[] args) {
        int[] nums = {1,2,4,5,6,7,78,8};
        ////////////////for static
        System.out.println(sum(nums, ExpHelper::isEven));

        Expression expression = ExpHelper::isEven;
        System.out.println(sum(nums,expression));


        ///////////////for objects
        ExpHelper expHelper = new ExpHelper();
        System.out.println(sum(nums,expHelper::isEven2));
        
        
        //////////////for constructors
        UserBuilder userBuilder = User::new;
        User user = userBuilder.create("Tom");
        System.out.println(user.getName());
        
    }

    private static int sum(int[] nums, Expression expression) {

        int result = 0;
        for (int num : nums) {
            if(expression.isEqual(num)) result+=num;
        }
        return result;
    }
}

class ExpHelper{
    static boolean isEven(int n){
        return n%2==0;
    }
    boolean isEven2(int n){
        return n%2==0;
    }
    static boolean isPositive(int n){
        return n>0;
    }
}

interface UserBuilder{
    User create(String name);
}


