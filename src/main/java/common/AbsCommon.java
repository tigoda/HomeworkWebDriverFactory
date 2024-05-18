package common;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import waiters.Waiters;


public abstract class AbsCommon {

    protected WebDriver driver = null;
    protected Faker faker = null;
    protected Waiters waiters =null;

    public AbsCommon(WebDriver driver) {
        this.driver = driver;
        this.faker = new Faker();
        this.waiters = new Waiters(driver);

        PageFactory.initElements(driver, this);
    }

    public WebElement $(By locator){
        return driver.findElement(locator);
    }

    public Faker getFaker(){
        return faker;
    }
}
