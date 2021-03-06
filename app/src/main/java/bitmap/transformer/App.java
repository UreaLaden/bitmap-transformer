/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package bitmap.transformer;

import java.util.Map;

public class App {

    public static void main(String[] args) {
        BitMap map;
        switch(args.length)
        {
            case 0:
                map = new BitMap();
                break;
            case 1:
                map = new BitMap(args[0]);
                map.read();
                break;
            case 2:
                map = new BitMap(args[0],args[1]);
                map.write();
                break;
            case 3:
                map = new BitMap(args[0],args[1],args[2]);
                map.write();
                break;
            default:
                System.out.println("Too many arguments");
        }
    }

}
