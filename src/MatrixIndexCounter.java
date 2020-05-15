public class MatrixIndexCounter {
    int row;
    int column;
    int currentI;
    int currentK;
    public MatrixIndexCounter(int row, int column) {
        this.row = row;
        this.column = column;
        this.currentI = 0;
        this.currentK = -1;
    }
    public int[] count(int count){
        int[] indexes = new int[2];

        if(count - (column - currentK - 1) <= 0){
            indexes[0] = currentI;
            indexes[1] = currentK + count;
            return indexes;
        }
        count -= (column - currentK - 1);
        int rowAfter;
        rowAfter = ((count - 1) / column);
        count -= rowAfter * column;
        count--;
        indexes[0] = currentI + rowAfter + 1;
        indexes[1] = count;
        return indexes;
    }
    public int[][] divideMatrix(int divider){
        int[][] indexes = new int[divider][2];
        int[] eachDividend = new int[divider];
        int upperDividend = ((row * column) / divider) + 1;
        int upperDividendCount = (row * column) % divider;
        for(int i = 0; i < upperDividendCount; i++)
            eachDividend[i] = upperDividend;
        for(int i = upperDividendCount; i < divider; i++)
            eachDividend[i] = upperDividend - 1;

        indexes[0][0] = 0;
        indexes[0][1] = 0;
        int[] index = count(1);
        this.currentI = index[0];
        this.currentK = index[1];
        if(divider == 1){
            return  indexes;
        }
        for(int i = 1; i < divider; i++){
            index = count(eachDividend[i]);
            indexes[i][0] = index[0];
            indexes[i][1] = index[1];
            this.currentI = index[0];
            this.currentK = index[1];
        }
        return indexes;
    }
}