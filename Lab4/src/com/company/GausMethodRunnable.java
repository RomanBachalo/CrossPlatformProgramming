package com.company;

public class GausMethodRunnable implements Runnable {
    public double[][] matrix;

    public GausMethodRunnable(double[][] input)
    {
        matrix = input;
    }

    public static double[] SubtractRows(double[] first, double[] second, int index)
    {
        double firstElement = second[index];

        for (int i = index; i < first.length; ++i)
        {
            second[i] -= first[i] * firstElement;
        }

        return second;
    }

    public static double[][] Calculate(double[][] input)
    {
        int rows = input.length;
        int cols = input[0].length;
        double[][] output = input;

        for (int k = 0; k < rows; ++k) {
            double firstElementFirstRow = output[k][k];
            for (int i = k; i < cols; ++i) {
                output[k][i] /= firstElementFirstRow;
            }

            for (int i = k + 1; i < rows; ++i) {
                output[i] = SubtractRows(output[k], output[i], k);
            }

        }

        for (int k = rows - 1; k > 0 ; --k)
        {
            for (int i = k - 1; i >= 0; --i)
            {
                output[i] = SubtractRows(output[k], output[i], k);
            }
        }
        return output;
    }


    @Override
    public void run() {
        matrix = Calculate(matrix);
    }
}
