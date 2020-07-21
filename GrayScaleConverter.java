import edu.duke.*;
import java.io.*;
/**
 * Escreva a descrição da classe GrayScaleConverter aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class GrayScaleConverter {
    
    public ImageResource makeGray(ImageResource inImage) {
    
        ImageResource outImage = new ImageResource(inImage.getWidth(), inImage.getHeight());
        
        for (Pixel pixel: outImage.pixels()){
            Pixel inPixel = inImage.getPixel( pixel.getX(), pixel.getY());
            
            int average = ( inPixel.getRed() + inPixel.getBlue() + inPixel.getGreen() ) / 3;
            
            pixel.setRed(average);
            pixel.setBlue(average);
            pixel.setGreen(average);
            
        }
        
        return outImage;
    }
    
    public void testGray() {
        ImageResource ir = new ImageResource();         
        ImageResource gray = makeGray(ir);     
        gray.draw();      
    }
    
    public void selectAndConvert() {
        DirectoryResource dr = new DirectoryResource();
        
        for (File f: dr.selectedFiles()){
            ImageResource inImage = new ImageResource(f);
            ImageResource gray = makeGray(inImage); 
            saveImage(gray, "gray-" + inImage.getFileName() );
        }
        
    }
    
    public void saveImage(ImageResource outImage, String fileName ) {        
           outImage.setFileName(fileName);
           outImage.save();              
    }
}
