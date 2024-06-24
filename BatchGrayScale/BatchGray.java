
/**
 * 在这里给出对类 BatchGray 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
import edu.duke.*;
import java.io.*;

public class BatchGray {
    // 单个图片转为灰色图片函数
    public ImageResource makeGray(ImageResource inImage) {
        //I made a blank image of the same size
        ImageResource outImage = new ImageResource(inImage.getWidth(), inImage.getHeight());
        //for each pixel in outImage
        for (Pixel pixel: outImage.pixels()) {
        
            //look at the corresponding pixel in inImage
            Pixel inPixel = inImage.getPixel(pixel.getX(), pixel.getY());
            //compute inPixel's red + inPixel's blue + inPixel's green
            //divide that sum by 3 (call it average)
            int average = (inPixel.getRed() + inPixel.getBlue() + inPixel.getGreen()) / 3;
            //set pixel's red to average
            pixel.setRed(average);
            //set pixel's green to average
            pixel.setGreen(average);
            //set pixel's blue to average
            pixel.setBlue(average);
        }
        //outImage is your answer
        return outImage;
    }
    //读取图片调用转换函数，并写入新文件
    public void testBatchGray() {
        DirectoryResource dr = new DirectoryResource();
        for (File f: dr.selectedFiles()) {
            ImageResource inImage = new ImageResource(f);
            ImageResource gray = makeGray(inImage);
            
            String fname = inImage.getFileName();
            String newName = "gray-" + fname;
            
            gray.setFileName(newName);
            gray.save();
            gray.draw();
        }
    }
}
