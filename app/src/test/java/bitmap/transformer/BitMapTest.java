package bitmap.transformer;

import org.junit.Test;
import java.awt.*;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;

public class BitMapTest {
    @Test public void testgetRGB(){
        ArrayList<Color> colors = new ArrayList<>();
        colors.add(new Color(12,25,26));
        colors.add(new Color(12,25,250));
        colors.add(new Color(95,0,125));
        int expectedLength = 3;
        int actual = BitMap.getRGBA(colors).size();
        assertEquals("There should b 3 values in each array",expectedLength,actual);
    }

    @Test public void testCreateBitMap(){
        BitMap bitmap = new BitMap("filePath/thing.png","filePath/place.png");
        String expected = null;
        String actual = new BitMap("filePath/thing.png","filePath/place.png").transformName;
    }

}
