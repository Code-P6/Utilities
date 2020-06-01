package utility.imageCompare;

// Java Program to compare two images 
import java.awt.image.BufferedImage; 
import javax.imageio.ImageIO;





import java.io.File; 
import java.io.IOException; 
  
/* Step 1 – Check  dimensions match
Step 2 – Get the RGB values of the images.
Step 3 – Calculate the difference in two corresponding pixel of three color components.
Step 4 – Repeat Step 2-3 for each pixel of the images.
Step 5 – Calculate the percentage by dividing the sum of differences with:

If Different percentage is 0. Image is perfect. Else image is not the same*/

public class ImageComparison 
{ 
    public static void main(String[] args) 
    { 
        BufferedImage imgA = null; 
        BufferedImage imgB = null; 
  
        
        try
        {  
           
            File fileA = new File(System.getProperty("user.dir") + File.separator+ "ImagesCompare" + File.separator +"A101704313143_Lrg.jpg"); 
            File fileB = new File(System.getProperty("user.dir") + File.separator+ "ImagesCompare" + File.separator +"bucket"+File.separator+"A1000_00_07_31_A100000073191_9780582603912_big.jpg"); 
  
            imgA = ImageIO.read(fileA); 
            imgB = ImageIO.read(fileB); 
        } 
        catch (IOException e) 
        { 
            System.out.println(e); 
        } 
        int width1 = imgA.getWidth(); 
        int width2 = imgB.getWidth(); 
        int height1 = imgA.getHeight(); 
        int height2 = imgB.getHeight(); 
  
        if ((width1 != width2) || (height1 != height2)) 
            System.out.println("Error: Images dimensions"+ 
                                             " mismatch"); 
        else
        { 
            long difference = 0; 
            for (int y = 0; y < height1; y++) 
            { 
                for (int x = 0; x < width1; x++) 
                { 
                    int rgbA = imgA.getRGB(x, y); 
                    int rgbB = imgB.getRGB(x, y); 
                    int redA = (rgbA >> 16) & 0xff; 
                    int greenA = (rgbA >> 8) & 0xff; 
                    int blueA = (rgbA) & 0xff; 
                    int redB = (rgbB >> 16) & 0xff; 
                    int greenB = (rgbB >> 8) & 0xff; 
                    int blueB = (rgbB) & 0xff; 
                    difference += Math.abs(redA - redB); 
                    difference += Math.abs(greenA - greenB); 
                    difference += Math.abs(blueA - blueB); 
                } 
            } 
  
            double total_pixels = width1 * height1 * 3; 
  
            // Normalizing the value of different pixels 
            // for accuracy(average pixels per color 
            // component) 
            double avg_different_pixels = difference / 
                                          total_pixels; 

            double percentage = (avg_different_pixels / 
                                            255) * 100; 
  
            if (percentage > 0){
                System.out.println("Images are not identical");
            } else{
                System.out.println("Images are identical");
            } 
        } 
    } 
} 
