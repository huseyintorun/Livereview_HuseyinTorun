package MoneyGaming;
import MoneyGaming.utilities.WebDriverFactory;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Test1 {
    @BeforeMethod
    public void setUp(){
    driver = WebDriverFactory.getDriver("chrome");
    driver.manage().window().maximize();

    }
    @Test
    public void test1(){
        //Enter your first name and surname in the form
        WebElement userName = driver.findElement(By.cssSelector("#forename"));

        userName.sendKeys("Huseyin");
        WebElement userSurname = driver.findElement(By.cssSelector("input[name='map(lastName)']"));

        userSurname.sendKeys("Torun");

        WebElement checkbox = driver.findElement(By.cssSelector("input[name='map(terms)']"));
        checkbox.click();

        Assert.assertTrue(checkbox.isSelected(),"verify that if the checkbox is selected.");

        WebElement joinNowbutton = driver.findElement(By.cssSelector("[alt='Join Now']"));
        joinNowbutton.click();

        WebElement thisFieldRequered = driver.findElement(By.cssSelector("[for='dob']"));
        System.out.println("thisFieldRequered.getText() = " + thisFieldRequered.getText());

        Assert.assertTrue(thisFieldRequered.getText().equals("Dieses Feld ist erforderlich"),"verify that if the text matched");

    }

    @AfterMethod
    public void tearDown(){

        driver.close();
    }

    WebDriver driver;
}

