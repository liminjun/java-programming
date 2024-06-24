
/**
 * 在这里给出对类 ImageSaver 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
import edu.duke.*;
import java.io.File;
public class ImageSaver {
    public void doSave() {
        DirectoryResource dr = new DirectoryResource();
        for (File f: dr.selectedFiles()) {
            ImageResource image = new ImageResource(f);
            String fname = image.getFileName();
            String newName = "copy-" + fname;
            image.setFileName(newName);
            image.draw();
            image.save();
        }
    }
}
