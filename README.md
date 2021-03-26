# Bitmap Transformer

##Collaborated with [Amelia Waggoner](https://github.com/GoldenDog190)

##For this assignment we built a bitmap (.bmp) transformer Class Instance (CLI) with the ability to read a bitmap in from disk, run one or more color or raster transforms. Then write it out to a new file. This project required manipulating binary data and is composed of small tested methods that solve specific problems.

## Minimum Requirements
- The CLI should be architected using best modularization practices.
- The CLI should contain a Bitmap class, and reading in a file should create a new Bitmap instance.
- The CLI should require at least three arguments: input-file-path output-file-path transfrom-name.
- The CLI should support a minimum of three transforms, each of which is an instance method in the Bitmap class.
- The CLI should log useful Error messages if used incorrectly.
- The CLI should log a success message on completion.

## Methods

### **Read** 
#### This class method accepts no parameters and reads the contents of inputFile and creates a list of RGB values 
### **Write**
#### This class method accepts no arguments and creates a new image through helper functions.
### **Randomize**
#### This method accepts 3 arguments (`int red`, `int green`, `int blue`) and returns a random color
### **Invert**
#### This method accepts 3 arguments (`int red`, `int green`, `int blue`) and returns the opposite colors
### **Grayscale**
#### This method accepts 3 arguments (`int red`, `int green`, `int blue`) and returns a grayscale representation of the origin color
### **GetRGBA**
#### This helper method accepts a list of Color objects and returns a multi-dimensional array of r,g,b values.
