package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    @FindBy(css = "a.view-profile")
    WebElement profileIcon;

    @FindBy(css = "img[class='avatar']")
    WebElement avatarIcon;
    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }
    public HomePage clickProfileIcon(){
        click((By) profileIcon);
        return this;
    }

    public boolean isAvatarDisplayed(){
        return avatarIcon.isDisplayed();
    }
}