import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import Pages.LoginPage;
import Pages.HomePage;

import org.testng.annotations.Test;

public class Homework23 extends BaseTest {

    public String expectedUpdatedPlaylistMessage = "Updated playlist \"p.\"";

    @Test
        public void renamePlaylist() throws InterruptedException {
            LoginPage loginPage = new LoginPage(driver);
            HomePage homePage = new HomePage(driver);
            navigateToLoginPage();
            loginPage.provideLoginSucceed();
            Thread.sleep(2000);
            homePage.doubleClickPlaylist();
            homePage.renamePlaylistk();
            Assert.assertEquals(homePage.getUpdatedPlaylistSuccessMessage(), expectedUpdatedPlaylistMessage);
        }

    }

