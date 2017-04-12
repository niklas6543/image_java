package image_mirroring;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import javax.imageio.ImageIO;


public class image {
	//change mirroring condition
	static char how = 'y';
	public static void main(String args[]){
		BufferedImage img = loadImage("img/IMG_5432.JPG");
		
		saveImage(mirroringImage(img, getImage2D(img)));
	}
	
	public static BufferedImage loadImage(String filename){
		BufferedImage img = null;
		try {
			//read image data from file
		    img = ImageIO.read(new File(filename));
		    System.out.println("load image");
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
	
	public static int[][] getImage2D(BufferedImage img){
		
		int[][] img2D = null;
		switch (how) {
		case 'y':
			img2D = new int[img.getHeight()][img.getWidth()];
			for (int y = 0; y < img.getHeight(); y++) {
				for (int x = 0; x < img.getWidth(); x++) {
					img2D[y][x] = img.getRGB(x, y);
				}
			}
			break;
		case 'x':
			img2D = new int[img.getWidth()][img.getHeight()];
			for (int x = 0; x < img.getWidth(); x++) {
				for (int y = 0; y < img.getHeight(); y++) {
					img2D[x][y] = img.getRGB(x, y);
				}
			}
			break;
		case 'r':
			img2D = new int[img.getHeight()][img.getWidth()];
			for (int y = 0; y < img.getHeight(); y++) {
				for (int x = 0; x < img.getWidth(); x++) {
					img2D[y][x] = img.getRGB(x, y);
				}
			}
			break;
		case 'l':
			img2D = new int[img.getWidth()][img.getHeight()];
			for (int x = 0; x < img.getWidth(); x++) {
				for (int y = 0; y < img.getHeight(); y++) {
					img2D[x][y] = img.getRGB(x, y);
				}
			}
			break;
		default:
			break;
		}
		
		
		return img2D;
		
	}
	
	public static BufferedImage mirroringImage(BufferedImage simg, int[][] img2D){
		//create empty image with sizes from the original
		BufferedImage mimg = new BufferedImage(simg.getWidth(), simg.getHeight(), simg.getType());
		
		
		switch (how) {
		case 'y':
			for (int y = 0; y < img2D.length; y++) {
				//go from right and left to the middle [->|<-]
				for (int leftX = 0,  rightX = img2D[y].length-1; leftX < img2D[y].length; leftX++, rightX-- ) {
					mimg.setRGB(leftX, y, img2D[y][rightX]);
					mimg.setRGB(rightX, y, img2D[y][leftX]);
				}
			}
			break;
		case 'x':
			for (int x = 0; x < img2D.length; x++) {
				for (int bottonY = 0,  topY = img2D[x].length-1; bottonY < img2D[x].length; bottonY++, topY-- ) {
					mimg.setRGB(x, bottonY, img2D[x][topY]);
					mimg.setRGB(x, topY, img2D[x][bottonY]);
				}
			}
			break;
		case 'r':
			mimg = new BufferedImage(simg.getHeight(), simg.getWidth(), simg.getType());
			for (int y = 0; y < img2D.length; y++) {
				for (int x = 0; x < img2D[y].length; x++) {
					mimg.setRGB(y, x, img2D[img2D.length-1-y][x]);
				}
			}
			break;
		case 'l':
			mimg = new BufferedImage(simg.getHeight(), simg.getWidth(), simg.getType());
			for (int x = 0; x < img2D.length; x++) {
				for (int y = 0; y < img2D[x].length; y++) {
					mimg.setRGB(y, x, img2D[img2D.length-1-x][y]);
				}
			}
		default:
			break;
		}
		
		return mimg;
		
	}
	
}
