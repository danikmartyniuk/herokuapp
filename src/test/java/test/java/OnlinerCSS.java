package test.java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class OnlinerCSS {

    @Test
    public void findByCssXPath () {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.onliner.by/");

        driver.findElement(By.cssSelector("#container"));
        driver.findElement(By.cssSelector("#adfox_154469864721127801"));
        driver.findElement(By.cssSelector("#navigation-sidebar"));
        driver.findElement(By.xpath("//*[@id=\"container\"]"));
        driver.findElement(By.xpath("//*[@id=\"adfox_154469864721127801\"]"));
        driver.findElement(By.xpath("//*[@id=\"navigation-sidebar\"]"));
        driver.findElement(By.cssSelector(".modal"));
        driver.findElement(By.cssSelector("span[helpers_hide_mobile-small::contains(text(),'«Минималки на жизнь не хватает, " +
                "но на новогоднем столе было все!» Как в глубинке готовились к празднику, а потом отходили от него']"));
        driver.findElement(By.cssSelector("p.g-middle"));
        driver.findElement(By.xpath("g-middle::*"));
        driver.findElement(By.xpath("cfix::node()"));
        driver.findElement(By.cssSelector("[name=\"chats-helper-iframe\"]"));
        driver.findElement(By.xpath("//iframe[1]"));
        driver.findElement(By.cssSelector("[g-top]"));
        driver.findElement(By.xpath("//*[@id=\"container\"]/div/div/header"));
        driver.findElement(By.xpath("//*[@id=\"container\"]//a"));
        driver.findElement(By.cssSelector("#container > a"));
        driver.findElement(By.xpath("//div//img"));
        driver.findElement(By.xpath(".//*[text()='Минималки на жизнь не хватает, но на новогоднем столе было все!» " +
                "Как в глубинке готовились к празднику, а потом отходили от него']/.."));
        driver.findElement(By.cssSelector("footer,a"));
        driver.findElement(By.cssSelector("div > header"));
        driver.findElement(By.cssSelector("div ~ h3"));
        driver.findElement(By.cssSelector("href"));

        driver.quit();
    }
}
