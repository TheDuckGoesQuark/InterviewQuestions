package interview.ctci.arraysandstrings.RotateMatrix;

/**
 * Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes,
 * write a method to rotate the image by 90 degrees. In place?
 */
public class RotateMatrix {
    public static int[][] rotateImage(int[][] imageArr) {
        if (imageArr.length == 0) return imageArr;

        var numLayers = Math.ceil(((double) imageArr.length) / 2);
        for (int i = 0; i < numLayers; i++) {
            rotateLayer(i, imageArr);
        }

        return imageArr;
    }

    private static void rotateLayer(int layer, int[][] imageArr) {
        var layerWidth = imageArr.length - (layer * 2);

        var temp = new int[layerWidth - 1];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = imageArr[layer][layer + i];
        }

        for (int i = 0; i < layerWidth - 1; i++) {
            // move left to top
            imageArr[layer][layer + i] = imageArr[imageArr.length - layer - i - 1][layer];
            // move bottom to left
            imageArr[imageArr.length - layer - i - 1][layer] = imageArr[imageArr.length - layer - 1][imageArr.length - layer - 1 - i];
            // move right to bottom
            imageArr[imageArr.length - layer - 1][imageArr.length - layer - 1 - i] = imageArr[layer + i][imageArr.length - layer - 1];
            // move temp top to right
            imageArr[layer + i][imageArr.length - layer - 1] = temp[i];
        }
    }
}
