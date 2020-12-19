package com.company;

public class Algorithme1 {
    MatrixGraph matrixGraph;
    Algorithme1(){}
    //p: num of red vertex, q: num of blue edge, size: num of vertex

    public int doAlgorithme(double p, double q, int size){
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



    public static void main(String[] args) {
        Algorithme1 algorithme1 = new Algorithme1();
        int k = algorithme1.doAlgorithme(0.1, 0.8, 100);
//        algorithme1.matrixGraph.print();
        System.out.println("k: "+k);

    }




}
