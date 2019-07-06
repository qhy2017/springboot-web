package com.example.demo.dao;

/**
 * 测试类
 */
public class DemoTest {

    private final int ignoreCount;

    public DemoTest(int ignoreCount) {this.ignoreCount = ignoreCount;}

    public int getIgnoreCount() {
        return ignoreCount;
    }

    public static void main(String[] s) {
//        int count = 0;
//        int j = 2;
//        for (int i = 101; i < 201; i++) {
//            for(j=2;j<i;j++) {
//                if ((i % j) == 0) {
//                    break;
//                }
//            }
//            if (j==i) {
//                count++;
//                System.out.println(i+"这个数为素数");
//            }
//        }
//        System.out.println("101-200之间一共"+count+"个素数");

        math(8);
    }

    private static void math(int n) {

        for(int i=2;i<n;i++){
            if (n%i==0) {
                System.out.print(i+"*");
                math(n/i);
            }
        }

        System.out.println(n+"");
        System.exit(0);
    }
}
