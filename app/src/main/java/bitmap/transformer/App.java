/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package bitmap.transformer;

import javax.imageio.ImageIO;
import javax.xml.bind.SchemaOutputResolver;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class App {

    public static void main(String[] args) {
        try {

            BufferedImage img = ImageIO.read(new File("app/src/main/resources/bitpam.bmp"));
            int height = img.getHeight();
            int width = img.getWidth();
            int count = 0;
            ArrayList<Color>bits = new ArrayList<>();
            for(int h =1; h < height; h++){
                for(int w = 1; w < width; w++){
                    int rgb = img.getRGB(w,h);

                    Color binaryColor = new Color(rgb);
                    bits.add(binaryColor);
                    count ++;
                }
            }
            getRGBA(bits);
//            System.out.println(bits);

        } catch (IOException e) {
            System.out.println("Unable to find the file...");
        }

    }

    public static ArrayList<ArrayList<Integer>> getRGBA(ArrayList<Color> input){
        ArrayList <ArrayList<Integer>> result = new ArrayList<>();
        ArrayList <Integer> resultCount = new ArrayList<>();
        int currentLine = 1;
         for(Color binary: input) {

             ArrayList<Integer> temp = new ArrayList<>();
             temp.add(binary.getRed()) ;
             temp.add(binary.getGreen());
             temp.add(binary.getBlue());


            result.add(temp);
//            resultCount.add(temp.size());
         }
        System.out.println(result);
         return result;
    }
}
