package selenium.sample;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

public class Sample6Task {
    WebDriver driver;

    // method which is being run before each test
    @Before
    public void startingTests() throws Exception {
        // from Sample 1:
        String libWithDriversLocation = System.getProperty("user.dir") + File.separator + "lib" + File.separator;
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver" + new selenium.ChangeToFileExtension().extension());
        // declaration above:
        driver = new ChromeDriver();
        //open page:
        driver.get("https://kristinek.github.io/site/examples/locators");
    }

    // method which is being run after each test
    @After
    public void endingTests() throws Exception {
        driver.close();
    }

    @Test
    public void findElementByXPath() throws Exception {
//         TODO:
//        2 ways to find text: "Heading 2 text":
//        1-2 ways to find text: "Test Text 1"
//        1-2 ways to find text: "Test Text 2"
//        1-2 ways to find text: "Test Text 3"
//        1-2 ways to find text: "Test Text 4"
//        1-2 ways to find text: "Test Text 5"
//        1-2 ways to find text: "This is also a button"

        System.out.println("Find element by id using xPath:");
        System.out.println("\t text of element with id 'heading_2' is '" +
                driver.findElement(By.xpath("//*[@id='heading_2']")).getText() + "'");
        System.out.println("\t text of element with class 'test' is '" +
                driver.findElement(By.xpath("//*[@class='test']")).getText() + "'");
        System.out.println("\t text of element with class 'twoTest' is '" +
                driver.findElement(By.xpath("//*[@class='twoTest']")).getText() + "'");
        System.out.println("\t text of element with id 'test3' is '" +
                driver.findElement(By.xpath("//*[@id='test3']")).getText() + "'");
        System.out.println("\t text of element with class 'text' is '" +
                driver.findElement(By.xpath("//*[@class='Test']")).getText() + "'");


        System.out.println("\t value of element with name 'randomButton2' is '" +
                driver.findElement(By.xpath("//*[@name='randomButton2']")).getAttribute("value") + "'");
        System.out.println("\t name of element with value 'This is also a button' is '" +
                driver.findElement(By.xpath("//*[@value='This is also a button']")).getAttribute("name") + "'");
        System.out.println("\t value of element with type 'button' is '" +
                driver.findElement(By.xpath("//*[@type='button']")).getAttribute("value") + "'");


    }

    @Test
    public void findElementByCssName() throws Exception {
//         TODO:
//        1-2 ways to find text: "Heading 2 text"
//        1-2 ways to find text: "Test Text 1"
//        1-2 ways to find text: "Test Text 2"
//        1-2 ways to find text: "Test Text 3"
//        1-2 ways to find text: "This is also a button"
    }
}
