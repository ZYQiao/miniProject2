package com.company;

public class Algorithme {
    MatrixGraph matrixGraph;
    Algorithme(){}
    public int doAlgorithme(int p, int q){
        matrixGraph = new MatrixGraph(100);
        matrixGraph.print();
//        matrixGraph.setRandomRedVertex(p *100,100);
//        matrixGraph.setRandomBlueEdge(q *9900,100);
        int k = 0;
//        System.out.println(matrixGraph.getRedOutDegreMaxVertex());
//        while (matrixGraph.getRedVertexNum() != 0){
//            matrixGraph.deleteVertex(matrixGraph.getRedOutDegreMaxVertex());
//            k++;
//        }
        return k;
    }

    public static void main(String[] args) {
        Algorithme algorithme = new Algorithme();
        algorithme.doAlgorithme(0,0);
//        System.out.println(algorithme.doAlgorithme(0,0));
    }

}
