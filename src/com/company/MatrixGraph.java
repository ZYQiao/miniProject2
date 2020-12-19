package com.company;

import java.util.HashSet;
import java.util.Random;

public class MatrixGraph {
    int size;//number of the vertexs
    char[] vertexs;
    int[][] matrix;
    int degreMax;
    int numberEdge;

    public MatrixGraph(int size){
        this.size = size;//size = 100 in this problem
        matrix = new int[size][size];
        vertexs = new char[size];
        for (int i = 0; i < size; i++) {
            vertexs[i] = 'b';
        }
        for (int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++){
                if(i == j){
                    matrix[i][j] = -1; //the edge should
                    continue;
                }
                matrix[i][j] = 0;
            }
        }
    }

    public void print(){
        for (char i: vertexs) {
            System.out.print(i+" ");
        }
        System.out.println();
        for(int[] i:matrix){
            for(int j:i){
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }

    public void setEdge(int i,int j,int value){
        //i,j are the sequence number of the vertex
        matrix[i-1][j-1] = value;
        matrix[j-1][i-1] = value;//the related position should -1
    }

    public boolean existEdge(int i,int j){
        if (matrix[i-1][j-1] == 1)
            return true;
        return false;
    }

    //return the degree of vertex i
    public int getDegree(int i){
        int k = 0;
        for(int j:matrix[i-1]){
            if(j == 1)
                k++;
        }
        return k;
    }
    public int getMaxDegree(){
        int max=0;

        for(int i = 0;i<100;i++){
            int k = 0;
            for(int j=0;j<100;j++) {
                k += matrix[i][j];
            }
            if(k>max){
                max=k;
            }
        }
        return max;


    }
    public int getEdge(){
        int num=0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix.length;j++){
                num+=matrix[i][j];
            }
        }
        return num/2;
    }

    public int calculateDegreeMax(){
        for(int i = 0;i < size;i++){
            if(getDegree(i+1)>degreMax)
                degreMax = getDegree(i+1);
        }
        return degreMax;
    }

    public int calculateNumberEdge(){
        for(int i = 0;i < size;i++){
                for(int j = i+1;j < size;j++)
                    if(matrix[i][j] == 1)
                        numberEdge++;
        }
        return numberEdge;
    }

    public void setRandomRedVertex(int num, int range){
        if (num > range) {
            throw new ArithmeticException("the num is more than range");
        }

        Random ran1 = new Random();
        int c = 0;
        // set red vertexs
        while (c != num){
            int tmp = ran1.nextInt(range);
            if(vertexs[tmp] != 'r') {
                vertexs[tmp] = 'r';
                c++;
            }
        }

    }

    public void setRandomBlueEdge(int num, int range){
        if (num > range*(range-1)) {
            throw new ArithmeticException("the num is more than range");
        }
        Random ran1 = new Random();
        int c = 0;
        // set blue edges
        while (c != num){
            int i = ran1.nextInt(range);
            int j = ran1.nextInt(range);
            // red edge is 0, blue edge is 1
            if(matrix[i][j] != 1 && i != j) {
                matrix[i][j] = 1;
                c++;
            }
        }

    }

    public void deleteVertex(int v){
        for(int i = 0; i < size; i++){
            //each row, v col is delete, value = -1
            matrix[i][v] = -1;
            //if out edge is red, the destination vertex change to red
            if(matrix[v][i] == 0)
                vertexs[i] = 'r';
            //if out edge is blue, the destination vertex change to blue
            else if(matrix[v][i] == 1)
                vertexs[i] = 'b';
            //each col, v row is delete, value = -1
            matrix[v][i] = -1;
            //vertex is deleted, color = d
            vertexs[v] = 'd';
        }
    }

    public int getRedOutDegreMaxVertex(){
        int Max = 0, v = -1;
        for(int i = 0; i < size; i++){
            if(vertexs[i] != 'r') continue;
            int count = 0;
            for(int j = 0; j < size; j++){
                if(matrix[i][j] == 0) count++;
            }
            if(Max <= count){
                v = i;
                Max = count;
            }
        }
        //if v = -1, no red out degre
        return v;
    }


    public int getBlueInDegreMaxVertex(){
        int Max = 0, v = -1;
        for(int i = 0; i < size; i++){
            if(vertexs[i] != 'r') continue;
            int count = 0;
            for(int j = 0; j < size; j++){
                if(matrix[j][i] == 1) count++;
            }
            if(Max <= count){
                v = i;
                Max = count;
            }
        }
        //if v = -1, no red out degre
        return v;
    }

    public int getRedVertexNum(){
        int n = 0;
        for(char i : vertexs){
            if(i == 'r')
                n++;
        }
        return n;
    }

    public static void main(String[] args) {
        int size = 100;
        double p = 0.1, q = 0.8;
        MatrixGraph matrixGraph = new MatrixGraph(size);
        matrixGraph.setRandomRedVertex((int)(p*size),size);
        matrixGraph.setRandomBlueEdge((int)(q*size*(size-1)),size);
        matrixGraph.print();
    }
}
