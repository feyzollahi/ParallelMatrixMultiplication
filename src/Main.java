public class Main {

    public static void main(String[] args) {

        int numOfThreads = 15;

        try {
            float[][] matrix1 = Matrix.generateMatrix(700, 1000, 1);
//            Matrix.print(matrix1);
            float[][] matrix2 = Matrix.generateMatrix(1000, 700, 1);
            long first = System.currentTimeMillis();
            float[][] answer1 = Matrix.muliplyParallel(matrix1, matrix2, 15);
            long second = System.currentTimeMillis();
            System.out.println(second - first);
            first = System.currentTimeMillis();
            float[][] answer2 = Matrix.muliplySerial(matrix1, matrix2);
            second = System.currentTimeMillis();
            System.out.println(second - first);
//            Matrix.print(answer1);
            System.out.println();
//            Matrix.print(answer2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}