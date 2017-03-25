package image_mirroring;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import javax.imageio.ImageIO;

public class image {
	public static void main(String args[]){
		int[][] test = new int[][]
				{
					{1,2,3},
					{4,5,6},
					{7,8,9},
					{10,11,12},
				};
		mirroring(test);
		
	}
	
	public static void loadImage(String filename){
		BufferedImage img = null;
		try {
		    img = ImageIO.read(new File(filename));
		} catch (IOException e) {
		}
	}
	
	public static void mirroring(int[][] a){
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
			for (int j = 0; j < a[i].length; j++) {
				System.out.print(Arrays.toString(a[i][j]));
			}
		}
	}
}
