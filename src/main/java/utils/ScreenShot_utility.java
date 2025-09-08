package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenShot_utility {
    public static String takeScreenshot(WebDriver driver, String testname)
    {
        String timespan = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String filepath = System.getProperty("user.dir")+"\\"+testname+"\\";

        File scr =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            Files.copy(scr.toPath(), new File(filepath+testname+".png").toPath());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return testname;
    }

}
