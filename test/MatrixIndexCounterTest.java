import org.junit.Test;
import static org.junit.Assert.*;

public class MatrixIndexCounterTest {
    @Test
    public void countTest(){
        MatrixIndexCounter matrixIndexCounter = new MatrixIndexCounter(3, 5);
        int[] index = matrixIndexCounter.count(3);
        assertTrue("third count of matrix is 0,2 but this function says " + String.valueOf(index[0]) + "," + String.valueOf(index[1]) , index[0] == 0 && index[1] == 2);
        matrixIndexCounter.currentK = index[1];
        matrixIndexCounter.currentI = index[0];
        index = matrixIndexCounter.count(5);
        assertTrue("8th count of matrix is 1,2 but this function says " + String.valueOf(index[0]) + "," + String.valueOf(index[1]), index[0] == 1 && index[1] == 2);
        matrixIndexCounter.currentK = index[1];
        matrixIndexCounter.currentI = index[0];
        index = matrixIndexCounter.count(7);
        assertTrue("last count of matrix is 2,4 but this function says " + String.valueOf(index[0]) + "," + String.valueOf(index[1]), index[0] == 2 && index[1] == 4);
    }

    @Test
    public void divideTest(){
        MatrixIndexCounter matrixIndexCounter = new MatrixIndexCounter(3, 5);
        int[][] indexes = matrixIndexCounter.divideMatrix(4);
        assertTrue("first divide must be 0,0 but it is " + indexes[0][0] + "," + indexes[0][0], indexes[0][0] == 0 && indexes[0][1] == 0);
        assertTrue("second divide must be 0,4 but it is " + String.valueOf(indexes[1][0]) + "," + String.valueOf(indexes[1][1]) , indexes[1][0] == 0 && indexes[1][1] == 4);
        assertTrue("third divide must be 1,3 but it is " + String.valueOf(indexes[2][0]) + "," + String.valueOf(indexes[2][1]) , indexes[2][0] == 1 && indexes[2][1] == 3);
        assertTrue("4th divide must be 2,2 but it is " + String.valueOf(indexes[3][0]) + "," + String.valueOf(indexes[3][1]) , indexes[3][0] == 2 && indexes[3][1] == 2);
    }

}
