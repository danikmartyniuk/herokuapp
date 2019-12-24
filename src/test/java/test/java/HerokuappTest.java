package test.java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class HerokuappTest {

    @Test
    public void addRemoveElements () {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
        driver.findElement(By.tagName("button")).click();
        driver.findElement(By.tagName("button")).click();
        driver.findElement(By.className("added-manually")).click();
        int numberOfDeleteButtons = driver.findElements(By.className("added-manually")).size();
        assertEquals(numberOfDeleteButtons, 1, "Number of elements is not correct");
        driver.quit();
    }
}
