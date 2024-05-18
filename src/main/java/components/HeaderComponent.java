package components;

import common.AbsCommon;
import components.popups.AuthorisationPopup;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderComponent extends AbsCommon {
    public HeaderComponent(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//button[text()='Войти']")
    private WebElement loginButton;

    public AuthorisationPopup loginButtonClick(){
        loginButton.click();

        return new AuthorisationPopup(driver);
    }



}