package Stepdefinitions;

public class test {

    public String test(){

        String a = String.valueOf(1);

        String b = String.valueOf(2);

        int sum = Integer.parseInt(a) + Integer.parseInt(b);
        String c = String.valueOf(sum);

        System.out.println(c);
        return c;
    }

    public static void main(String[] args)
    {
        test t = new test();
        t.test();

    }
}
