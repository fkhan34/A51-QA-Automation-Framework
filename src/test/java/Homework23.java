import org.testng.Assert;
import Pages.LoginPage;
import Pages.HomePage;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Homework23 extends BaseTest {

    public String expectedUpdatedPlaylistMessage = "Updated playlist \"p.\"";

    @BeforeMethod
    public void navigateToLoginPage() {
    }

    @Test
        public void renamePlaylist() throws InterruptedException {
            LoginPage loginPage = new LoginPage(driver);
            HomePage homePage = new HomePage(driver);
            loginPage.provideLoginSucceed();
            homePage.doubleClickPlaylist();
            homePage.renamePlaylistk();
            Assert.assertEquals(homePage.getUpdatedPlaylistSuccessMessage(), expectedUpdatedPlaylistMessage);
        }
    }

