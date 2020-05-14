public class MatrixThread extends Thread{
    private static int n;
    private static float[][] matrix1;
    private static float[][] matrix2;
    private static float[][] ans;
    private int i1;
    private int k1;
    private int i2;
    private int k2;

    @Override
    public void run(){
        //for debug
//        System.out.println(Thread.currentThread().getName() + " i1 = " + String.valueOf(i1) + " i2 = " + String.valueOf(i2)
//                + " k1 = " + String.valueOf(k1) + " k2 = " + String.valueOf(k2));
        float sum = 0;
        for(int k = k1; k < matrix2[0].length; k++){
            sum = 0;
            for(int j = 0; j < n; j++){
                sum += matrix1[i1][j] * matrix2[j][k];
            }
            ans[i1][k] = sum;
        }

        for(int i = i1 + 1; i < i2; i++){
            for(int k = 0; k < matrix2[0].length; k++){
                sum = 0;
                for(int j = 0; j < n; j++){
                    sum += matrix1[i][j] * matrix2[j][k];
                }
                ans[i][k] = sum;
            }
        }
        for(int k = 0; k < k2; k++){
            sum = 0;
            for(int j = 0; j < n; j++){
                sum += matrix1[i2][j] * matrix2[j][k];
            }
            ans[i2][k] = sum;
        }

    }


    public static int getN() {
        return n;
    }

    public static void setN(int n) {
        MatrixThread.n = n;
    }

    public static float[][] getMatrix1() {
        return matrix1;
    }

    public static void setMatrix1(float[][] matrix1) {
        MatrixThread.matrix1 = matrix1;
    }

    public static float[][] getMatrix2() {
        return matrix2;
    }

    public static void setMatrix2(float[][] matrix2) {
        MatrixThread.matrix2 = matrix2;
    }

    public static float[][] getAns() {
        return ans;
    }

    public static void setAns(float[][] ans) {
        MatrixThread.ans = ans;
    }

    public int getI1() {
        return i1;
    }

    public void setI1(int i1) {
        this.i1 = i1;
    }

    public int getK1() {
        return k1;
    }

    public void setK1(int k1) {
        this.k1 = k1;
    }

    public int getI2() {
        return i2;
    }

    public void setI2(int i2) {
        this.i2 = i2;
    }

    public int getK2() {
        return k2;
    }

    public void setK2(int k2) {
        this.k2 = k2;
    }
}