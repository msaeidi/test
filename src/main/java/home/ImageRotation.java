package home;

public class ImageRotation {

	public static void main(String[] args) {
//TODO		byte[][][] image = new byte[n][n][4];
		rotateAndPrint(2);
		rotateAndPrint(3);
		rotateAndPrint(4);
		rotateAndPrint(5);
		rotateAndPrint(6);
	}
	
	public static void rotateAndPrint(int n) {
		int[][] image = populate(n);
		print(image);
		print(rotateClockWiseByIndex(image));
		rotateClockWise(image);
		print(image);		
	}
	
	public static int[][] populate(int n) {
	
		int[][] image = new int[n][n];
		int k=1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				image[i][j] = k++;
//				image[i][j] = (i+1)*(j+1);
			}
		}
		return image;
	}
	
	public static void print(int[][] image) {
		int n = image.length;
		System.out.println();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print("  " + image[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void rotateClockWise(int[][] image) {
		int n = image.length;
		int h = (n+1)/2;
		for (int i = 0; i < n-h; i++) {
			int nm1mi = n - 1 -i;
			for (int j = 0; j < h; j++) {
				int swaped = image[i][j];
				int nm1mj = n - 1 - j;
				image[i][j] = image[nm1mj][i];
				image[nm1mj][i] = image[nm1mi][nm1mj];
				image[nm1mi][nm1mj] = image[j][nm1mi];
				image[j][nm1mi] = swaped;
			}
		}
	}

	public static int[][] rotateClockWiseByIndex(int[][] image) {
		int n = image.length;
		int nm1 = n - 1;
		int[][] rotated = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				rotated[i][j] = image[nm1-j][i];
			}
		}
		return rotated;
	}
}
