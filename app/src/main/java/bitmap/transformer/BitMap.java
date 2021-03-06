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
    public int height;
    public int width;

    public BitMap (){
        inputFilePath = null;
        outputFilePath = null;
        transformName = null;
    }
    public BitMap(String inputFilePath ) {
        this.inputFilePath = inputFilePath;
        this.outputFilePath = null;
        this.transformName = null;
    }
    public BitMap(String inputFilePath, String outputFilePath) {
        this.inputFilePath = inputFilePath;
        this.outputFilePath = outputFilePath;
        this.transformName = null;
        write();
    }
    public BitMap(String inputFilePath, String outputFilePath, String transformName) {
        this.inputFilePath = inputFilePath;
        this.outputFilePath = outputFilePath;
        this.transformName = transformName;
        write();
    }

    public void read(){
        BufferedImage img;
        try
        {
            img = ImageIO.read(new File(this.inputFilePath));
            this.height = img.getHeight();
            this.width = img.getWidth();
            createColorList(img);
        }
        catch (IOException e)
        {
            System.out.println(
                    "Having trouble locating the input file. " +
                    "Double check the path.");
        }
    }
    public void createColorList(BufferedImage img){
        ArrayList<Color>bits = new ArrayList<>();
        for(int h =1; h < this.height; h++){
            for(int w = 1; w < this.width; w++){
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
//        System.out.println(result);
        return result;
    }

    public void write(){
        BufferedImage bi ;
        if(this.outputFilePath != null) {
            File outputFile = new File(this.outputFilePath);
            try {
                bi = ImageIO.read(new File(this.inputFilePath));
                width = bi.getWidth();
                height = bi.getHeight();

                for (int i = 0; i < height; i++) {
                    for (int j = 0; j < width; j++) {
                        Color c = new Color(bi.getRGB(j, i));
                        int red = (int) (c.getRed() * 0.299);
                        int green = (int) (c.getGreen() * 0.587);
                        int blue = (int) (c.getBlue() * 0.114);
                        Color newColor = new Color(red,green,blue);

                        if(this.transformName.equals("gray")){
                            newColor = grayscale(red,green,blue);
                        }else if(this.transformName.equals("invert")){
                            newColor = invert(red,green,blue);
                        }else if(this.transformName.equals("random")){
                            newColor = randomize(red,green,blue);
                        }
                        bi.setRGB(j, i, newColor.getRGB());
                    }
                }
                ImageIO.write(bi,"bmp",outputFile);
            } catch (IOException e) {
                System.out.println("Missing an outputFile");
            }
        }
        else
        {
            System.out.println("The output filepath has not been set");
        }
    }

    public Color randomize(int red, int green,int blue){
        Random rand = new Random();
        int r = rand.nextInt(red + 50);
        int g = rand.nextInt(green + 50);
        int b = rand.nextInt(blue + 50);
        System.out.println("Red: "+r+"Green: "+g + "Blue: "+b);
        return new Color(r,g,b);
    }
    public Color invert(int red, int green,int blue){
        return new Color(blue /2 + green / 2 + red/2);
    }
    public Color grayscale(int red, int green,int blue){
        return new Color(red + green + blue,
                red + green + blue, red + green + blue);
    }

}
