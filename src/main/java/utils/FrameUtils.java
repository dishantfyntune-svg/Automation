package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.NoSuchElementException;

public class FrameUtils {
    public static WebElement findElementInFrames(WebDriver driver, By locator) {
        List<WebElement> frames = driver.findElements(By.tagName("iframe"));
        for (int i = 0; i < frames.size(); i++) {
            driver.switchTo().frame(i);
            List<WebElement> elements = driver.findElements(locator);
            if (!elements.isEmpty()) return elements.get(0);
            driver.switchTo().defaultContent();
        }
        List<WebElement> elementsOnMain = driver.findElements(locator);
        if (!elementsOnMain.isEmpty()) return elementsOnMain.get(0);
        throw new NoSuchElementException("Element not found: " + locator);
    }
}
