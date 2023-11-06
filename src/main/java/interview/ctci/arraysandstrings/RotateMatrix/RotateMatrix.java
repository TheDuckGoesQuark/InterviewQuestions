package interview.ctci.arraysandstrings.RotateMatrix;

/**
 * Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes,
 * write a method to rotate the image by 90 degrees. In place?
 */
public class RotateMatrix {
    public static int[][] rotateImage(int[][] imageArr) {
        if (imageArr.length == 0) return imageArr;

        var output = new int[imageArr.length][imageArr[0].length];
        for (int i = 0; i < imageArr.length; i++) {
            for (int j = 0; j < imageArr[i].length; j++) {
                var rotatedJ = imageArr.length - 1 - i;
                output[j][rotatedJ] = imageArr[i][j];
            }
        }

        return output;
    }
}
