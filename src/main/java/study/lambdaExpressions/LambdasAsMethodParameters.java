package study.lambdaExpressions;


public class LambdasAsMethodParameters {
    public static void main(String[] args) {
        Expression expression=(n)->n%2==0;
        int[] nums = {1,2,3,4,5,6,7,7,8};
        System.out.println(sum(nums,expression));
        int x = sum(nums,n -> n>5);
    }

    private static int sum(int[] nums, Expression expression) {

        int result = 0;
        for (int num : nums) {
            if(expression.isEqual(num)) result+=num;
        }
        return result;
    }
}

