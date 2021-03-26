package bitmap.transformer;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class BitMap {
    public String inputFilePath;
    public String outputFilePath;
    public String transformName;

    public BitMap (){
        inputFilePath = null;
        outputFilePath = null;
        transformName = null;
    }
    public BitMap(String inputFilePath, String outputFilePath, String transformName) {
        this.inputFilePath = inputFilePath;
        this.outputFilePath = outputFilePath;
        this.transformName = transformName;
    }
//"app/src/main/resources/bitpam.bmp"
    public void read(){
        BufferedImage img;
        try
        {
            img = ImageIO.read(new File(this.inputFilePath));
            int height = img.getHeight();
            int width = img.getWidth();
            ArrayList<Color>bits = new ArrayList<>();
            for(int h =1; h < height; h++){
                for(int w = 1; w < width; w++){
                    int rgb = img.getRGB(w,h);
                    Color binaryColor = new Color(rgb);
                    bits.add(binaryColor);
                }
            }
            getRGBA(bits);
            System.out.println("test");
        }
        catch (IOException e)
        {
            System.out.println(
                    "Having trouble locating the input file. " +
                    "Double check the path.");
        }
    }
    public void createColorList(BufferedImage img){
        int height = img.getHeight();
        int width = img.getWidth();
        ArrayList<Color>bits = new ArrayList<>();
        for(int h =1; h < height; h++){
            for(int w = 1; w < width; w++){
                int rgb = img.getRGB(w,h);
                Color binaryColor = new Color(rgb);
                bits.add(binaryColor);
            }
        }
        getRGBA(bits);
    }

    public static ArrayList<ArrayList<Integer>> getRGBA(ArrayList<Color> input){
        ArrayList <ArrayList<Integer>> result = new ArrayList<>();
        for(Color binary: input) {
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(binary.getRed()) ;
            temp.add(binary.getGreen());
            temp.add(binary.getBlue());
            result.add(temp);
        }
        System.out.println(result);
        return result;
    }

    public void write(){

    }

    public void randomize(){

    }
    public void invert(){

    }
    public void grayscale(){

    }

}
