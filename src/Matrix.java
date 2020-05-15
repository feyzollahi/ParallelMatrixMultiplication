import java.util.ArrayList;
import java.util.Random;

public class Matrix {
    public static float[][] muliplySerial(float[][] arg1, float[][] arg2) throws Exception {
        if(!multipliable(arg1, arg2)){
            throw new Exception("no multipliable");
        }
        float[][] answer = new float[arg1.length][arg2[0].length];
        float mul;
        float sum = 0;

        for(int i = 0; i < arg1.length; i++){
            for(int k = 0; k < arg2[0].length; k++){
                sum = 0;
                for(int j = 0; j < arg2.length; j++){
                    mul = arg1[i][j] * arg2[j][k];
                    sum += mul;
                }
                answer[i][k] = sum;
            }
        }
        return answer;
    }
    public static float[][] muliplyParallel(float[][] arg1, float[][] arg2, int numOfThread) throws Exception {
        if(!multipliable(arg1, arg2)){
            throw new Exception("no multipliable");
        }
        float[][] matrix1 = arg1;
        float[][] matrix2 = arg2;
        float[][] answer = new float[arg1.length][arg2[0].length];

        ArrayList<MatrixThread> threads = new ArrayList<>();
        for(int i = 0; i < numOfThread; i++){
            threads.add(new MatrixThread());
        }
        MatrixThread.setMatrix1(matrix1);
        MatrixThread.setMatrix2(matrix2);
        MatrixThread.setAns(answer);
        MatrixThread.setN(matrix1[0].length);
        // mxn * nxp => mxp
        int m = matrix1.length;
        int p = matrix2[0].length;
        MatrixIndexCounter matrixIndexCounter = new MatrixIndexCounter(m, p);
        int[][] indexes = matrixIndexCounter.divideMatrix(numOfThread);
        for(int i = 0; i < threads.size() - 1; i++){
            threads.get(i).setI1(indexes[i][0]);
            threads.get(i).setI2(indexes[i + 1][0]);
            threads.get(i).setK1(indexes[i][1]);
            threads.get(i).setK2(indexes[i + 1][1]);
            threads.get(i).start();
        }

        int lastThreadK2 = 0;
        threads.get(threads.size() - 1).setI1(indexes[threads.size() - 1][0]);
        threads.get(threads.size() - 1).setI2(m);
        threads.get(threads.size() - 1).setK1(indexes[threads.size() - 1][1]);
        threads.get(threads.size() - 1).setK2(lastThreadK2);

        threads.get(threads.size() - 1).start();

        for(Thread thread: threads){
            thread.join();
        }
        return MatrixThread.getAns();
    }

    public static float[][] generateMatrix(int row, int column, int upperBound){
        Random random = new Random();
        float[][] matrix = new float[row][column];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < column; j++){
                float x = random.nextFloat();
                matrix[i][j] = x * upperBound;
            }
        }
        return matrix;
    }
    public static void print(float[][] matrix){
        for (float[] floats : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(floats[j]);
                System.out.print(" ");
            }
            System.out.println("");
        }
    }

    public static boolean multipliable(float[][] arg1, float[][] arg2){
        int n1 = arg1[0].length;
        int n2 = arg2.length;
        if(n1 == 0 || n2 == 0)
            return false;
        return n2 == n1;
    }
}