package com.company;

public class Algorithme {
    MatrixGraph matrixGraph;
    Algorithme(){}
    //p: num of red vertex, q: num of blue edge, size: num of vertex

    public int doAlgorithme1(double p, double q, int size){
        matrixGraph = new MatrixGraph(size);
        matrixGraph.setRandomRedVertex((int)(p*size),size);
        matrixGraph.setRandomBlueEdge((int)(q*size*(size-1)),size);
//        matrixGraph.print();
        int k = 0;
        while (matrixGraph.getRedVertexNum() != 0){
            matrixGraph.deleteVertex(matrixGraph.getRedOutDegreMaxVertex());
            k++;
        }
//        matrixGraph.print();
        return k;
    }

    public int doAlgorithme2(double p, double q, int size){
        matrixGraph = new MatrixGraph(size);
        matrixGraph.setRandomRedVertex((int)(p*size),size);
        matrixGraph.setRandomBlueEdge((int)(q*size*(size-1)),size);
//        matrixGraph.print();
        int k = 0;
        while (matrixGraph.getRedVertexNum() != 0){
            matrixGraph.deleteVertex(matrixGraph.getBlueInDegreMaxVertex());
            k++;
        }
//        matrixGraph.print();
        return k;
    }





    public void print(int k){
        java.text.DecimalFormat df = new java.text.DecimalFormat("#0.00");
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
                        sum += doAlgorithme1(p/100, q/100, 100);
                    else if(k == 2)
                        sum += doAlgorithme2(p/100, q/100, 100);
                }
//                matrixGraph.print();

                System.out.print(df.format(sum/100) + "\t");
            }
            System.out.println();
        }
    }



    public static void main(String[] args) {
        Algorithme algorithme = new Algorithme();
        System.out.println("algorithm1");
        algorithme.print(1);
        System.out.println("algorithm2");
        algorithme.print(2);

    }

}
