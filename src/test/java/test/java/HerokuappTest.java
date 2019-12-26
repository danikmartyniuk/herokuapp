package test.java;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class HerokuappTest {

    @Test
    public void addRemoveElements() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
        driver.findElement(By.tagName("button")).click();
        driver.findElement(By.tagName("button")).click();
        driver.findElements(By.className("added-manually")).get(0).click();
        int numberOfDeleteButtons = driver.findElements(By.className("added-manually")).size();
        assertEquals(numberOfDeleteButtons, 1, "Number of elements is not correct");
        driver.quit();
    }

    @Test
    public void checkCheckboxes() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/checkboxes");
        List<WebElement> checkBoxes = driver.findElements(By.tagName("input"));
        assertEquals(checkBoxes.get(0).isSelected(), false, "The button is checked");
        checkBoxes.get(0).click();
        assertEquals(checkBoxes.get(0).isSelected(), true, "The button is checked");
        assertEquals(checkBoxes.get(1).isSelected(), true, "The button is not checked");
        checkBoxes.get(1).click();
        driver.quit();
    }

    @Test
    public void checkDropdown() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/dropdown");
        Select options = new Select(driver.findElement(By.id("dropdown")));
        options.selectByVisibleText("Option 1");
        List<WebElement> option1 = options.getAllSelectedOptions();
        String[] o1 = new String[option1.size()];
        int i = 0;
        for (WebElement a : option1) {
            o1[i] = a.getText();
            i++;
        }
        assertEquals(o1[0], "Option 1", "The other option is chosen");
        options.selectByVisibleText("Option 2");
        List<WebElement> option2 = options.getOptions();
        String[] o2 = new String[option2.size()];
        int g = 0;
        for (WebElement a : option2) {
            o2[g] = a.getText();
            g++;
        }
        assertEquals(o2[0], "Option 2", "The other option is chosen");
    }

    @Test
    public void checkHovers() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/hovers");
        Actions action = new Actions(driver);

        WebElement img1 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/img"));
        action.moveToElement(img1).moveToElement(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/a"))).click().build().perform();
        String notFound1 = driver.findElement(By.xpath("/html/body/h1")).getText();
        assertEquals(notFound1, "Not Found", "There is no error");
        driver.navigate().back();

        WebElement img2 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/img"));
        action.moveToElement(img2).moveToElement(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/a"))).click().build().perform();
        String notFound2 = driver.findElement(By.xpath("/html/body/h1")).getText();
        assertEquals(notFound2, "Not Found", "There is no error");
        driver.navigate().back();

        WebElement img3 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[3]/img"));
        action.moveToElement(img3).moveToElement(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[3]/div/a"))).click().build().perform();
        String notFound3 = driver.findElement(By.xpath("/html/body/h1")).getText();
        assertEquals(notFound3, "Not Found", "There is no error");
    }

    @Test
    public void arrowUpDown() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        Actions action = new Actions(driver);
        driver.get("http://the-internet.herokuapp.com/inputs");
        driver.findElement(By.tagName("input")).sendKeys("100");
        action.sendKeys(Keys.ARROW_UP).build().perform();
        String digitValue = driver.findElement(By.tagName("input")).getAttribute("value");
        assertEquals(digitValue, "101", "Keys.ARROW_UP doesn't work properly!");
        driver.findElement(By.tagName("input")).clear();
        driver.findElement(By.tagName("input")).sendKeys("privet");
        action.sendKeys(Keys.ARROW_DOWN).build().perform();
        String nonDigitValue = driver.findElement(By.tagName("input")).getAttribute("value");
        assertEquals(nonDigitValue, "-1", "The text must be not allowed!");
    }

    @Test
    public void checkNotification() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/notification_message_rendered");
        driver.findElement(By.linkText("Click here")).click();
        String notification = driver.findElement(By.id("flash")).getText();
        assertEquals(notification, "Action successful\n" +
                "×", "Oh, shit! The action is not successful!");
    }

    @Test
    public void checkTypos() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/typos");
        String textWithTypoOrNot = driver.findElement(By.xpath("//*[@id=\"content\"]/div/p[2]")).getText();
        assertEquals(textWithTypoOrNot, "Sometimes you'll see a typo, other times you won't.", "There is an error " +
                "in the word WON,T");
    }
}
