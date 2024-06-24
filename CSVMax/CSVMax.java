
/**
 * 在这里给出对类 CSVMax 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class CSVMax {
    public CSVRecord hottesHourInFile(CSVParser parser) {
        CSVRecord largestSoFar = null;
        for (CSVRecord currentRow : parser) {
            // largestSoFar = getLargestOfTwo(currentRow, largestSoFar);
            if (largestSoFar == null) {
                largestSoFar = currentRow;
            } else {
                double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
                double largestTemp = Double.parseDouble(largestSoFar.get("TemperatureF"));
                if (currentTemp > largestTemp) {
                    largestSoFar = currentRow;
                }
            } 
        }
        return largestSoFar;
    }
    
    public void testHottesHourInFile() {
        FileResource fr = new FileResource("data/2015/weather-2015-01-01.csv");
        CSVRecord largest = hottesHourInFile(fr.getCSVParser());
        System.out.println("Hottest temperature was " + largest.get("TemperatureF") + " at " + largest.get("TimeEST"));
    }
    public CSVRecord hottestInManyDays() {
        CSVRecord largestSoFar = null;

        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            CSVRecord currentRow = hottesHourInFile(fr.getCSVParser());
            if (largestSoFar == null) {
                largestSoFar = currentRow;
            } else {
                double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
                double largestTemp = Double.parseDouble(largestSoFar.get("TemperatureF"));
                if (currentTemp > largestTemp) {
                    largestSoFar = currentRow;
                }
            } 
        }
        return largestSoFar;
    }
    public void testHottersInManyDays() {
        CSVRecord largest = hottestInManyDays();
        System.out.println("Hottest temperature was " + largest.get("TemperatureF") + " at " + largest.get("DateUTC"));
    }
}
