package com.company;

import java.text.DecimalFormat;

public class Main {
    Algorithme1 algorithme1 = new Algorithme1();
    Algorithme2 algorithme2 = new Algorithme2();
    public void print(int k){
        DecimalFormat df = new DecimalFormat("#0.00");
//        System.out.println(algorithme.doAlgorithme(0.9,0.8,100));
        System.out.print("p/q " + "\t");
        for(double i = 0; i <= 100; i+=10)
            System.out.print(df.format(i/100) + "\t");
        System.out.println();
        for(double p = 0; p <= 100; p+=10){
            System.out.print(df.format(p/100) + "\t");
            for(double q = 0; q <= 100; q+=10){
                double sum = 0;
                for(int i = 0; i < 100; i++) {
                    if(k == 1)
                        sum += algorithme1.doAlgorithme(p/100, q/100, 100);
                    else if(k == 2)
                        sum += algorithme2.doAlgorithme(p/100, q/100, 100);
                }
//                matrixGraph.print();

                System.out.print(df.format(sum/100) + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println("algorithm1");
        main.print(1);
        System.out.println("algorithm2");
        main.print(2);

    }

}
