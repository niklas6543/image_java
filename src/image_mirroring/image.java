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
		//mirroring(test);
		
		System.out.println(loadImage(""));
	}
	
	public static BufferedImage loadImage(String filename){
		BufferedImage img = null;
		try {
		    //img = ImageIO.read(new File(filename));
		    //img = ImageIO.read((getClass().getResourceAsStream(filename)));
		} catch (IOException e) {
			System.out.println("cant load image");
		}
		return img;
	}
	
	public static void arrayMirroing(int a[]){
		int h;
		for (int i = 1; i < a.length; i++) {
			h = a[i-1];
			a[i-1] = a[a.length-i];
			a[a.length-i] = h;
		}
	}
	
	public static void mirroring(int[][] a){
		for (int i = 0; i < a.length; i++) {
			//System.out.println(Arrays.toString(a[i]));
			arrayMirroing(a[i]);
			System.out.println(Arrays.toString(a[i]));			
		}
	}
}
