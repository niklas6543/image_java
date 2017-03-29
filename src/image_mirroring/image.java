package image_mirroring;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
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
		
		saveImage(mirroringImage(loadImage("img/streifen.jpg")));
	}
	
	public static BufferedImage loadImage(String filename){
		BufferedImage img = null;
		try {
			//read image data from file
		    img = ImageIO.read(new File(filename));
		    
		   
		    //get pixels
		    //byte[] pixels = ((DataBufferByte)img.getRaster().getDataBuffer()).getData();
		    //System.out.println(img.getWidth() + " x " + img.getHeight());
		    //img = ImageIO.read((getClass().getResourceAsStream(filename)));
		} catch (IOException e) {
			System.out.println("cant load image");
		}
		return img;
	}
	
	public static void saveImage(BufferedImage img){
		try {
			//create and save the mirroring image
			ImageIO.write(img, "jpg", new File("img/mirror.jpg")); 
		} catch (IOException e) {
			System.out.println("cant save image");
		}
		
		System.out.println("the image mirroring was succesfully");
	}
	
	public static BufferedImage mirroringImage(BufferedImage simg){
		//create empty image with sizes from the original
		BufferedImage mimg = new BufferedImage(simg.getWidth(), simg.getHeight(), simg.getType());
		
		for (int y = 0; y < simg.getHeight(); y++) {
			//go from right an left into the middle [->|<-]
			for (int leftX = 0,  rightX = simg.getWidth()-1; leftX < simg.getWidth(); leftX++, rightX-- ) {
				//change the right and left pixel colors
				int pixelColorR = simg.getRGB(rightX, y);
				int pixelColorL = simg.getRGB(leftX, y);
				mimg.setRGB(leftX, y, pixelColorR);
				mimg.setRGB(rightX, y, pixelColorL);
			}
		}
		
		return mimg;
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
