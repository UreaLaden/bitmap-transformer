package bitmap.transformer;

import sun.lwawt.macosx.CInputMethod;

import java.io.OutputStream;

public class BitMap {
    String inputFilePath;
    String outputFilePath;
    String transformName;
    
    public BitMap(String inputFilePath, String outputFilePath, String transformName) {
        this.inputFilePath = inputFilePath;
        this.outputFilePath = outputFilePath;
        this.transformName = transformName;
    }
}
