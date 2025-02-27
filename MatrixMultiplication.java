public class MatrixMultiplication {

    static Double[][] matMult(double[][] a, double[][] b) {
        // Value if matrix is nullvalue
        Double[][] nullVal = { { null, null } };

        if (a == null || b == null || a.length == 0 || b.length == 0) {
            return nullVal;
        }

        // Matrix A row numbers
        int aRows = a.length;
        // Matrix A column numbers
        int aCols = a[0].length;

        //  Matrix B row numbers
        int bRows = b.length;
        // Matrix B column numbers
        int bCols = b[0].length;

        // Check if number of columns = number of rows of b
        if (aCols != bRows) {
            return nullVal;
        }

        // result matrix
        Double[][] result = new Double[aRows][bCols];

        // matrix multiplication
        for (int i = 0; i < aRows; i++) {
            for (int j = 0; j < bCols; j++) {
                double sum = 0.0;
                for (int k = 0; k < aCols; k++) {
                    sum += a[i][k] * b[k][j];
                }
                // store sum
                result[i][j] = sum;
            }
        }

        return result;
    }

    // testing matrix
    public static void main(String[] args) {
        double[][] A = {
            {1, 2, 3},
            {4, 5, 6}
        };

        double[][] B = {
            {7,  8},
            {9,  10},
            {11, 12}
        };

        Double[][] C = matMult(A, B);

        // print results
        if (C != null && C != new Double[][]{{null,null}}) {
            for (Double[] row : C) {
                for (Double val : row) {
                    System.out.print(val + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("Incompatible dimensions or null matrices.");
        }
    }
}
