package com.company;

public class Algorithme2 {

    MatrixGraph matrixGraph;
    Algorithme2(){}
    //p: num of red vertex, q: num of blue edge, size: num of vertex

    public int doAlgorithme(double p, double q, int size){
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


    public static void main(String[] args) {
        Algorithme2 algorithme2 = new Algorithme2();
        int k = algorithme2.doAlgorithme(0.1, 0.8, 100);
        System.out.println("k: "+k);

    }
}
