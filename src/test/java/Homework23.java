import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework23 extends BaseTest {

        String newPlaylistName = "p";

        String expectedUpdatedPlaylistMessage = "Updated playlist \"p.\"";

        @FindBy (xpath = "//li[@class='playlist playlist']")
        WebElement playlistk1;
        @FindBy (xpath = "[name='name']")
        WebElement editPlaylistBtn;
        @FindBy (css = "div.success.show")
        WebElement notification;
        @Test
        public void renamePlaylist() throws InterruptedException {
            navigateToLoginPage();
            provideEmail("faizan.khan@testpro.io");
            providePassword("master21");
            clickSubmit();
            Thread.sleep(2000);
            doubleClickPlaylist();
            //clickEdit();
            renamePlaylistk();
            Assert.assertEquals(getUpdatedPlaylistSuccessMessage(), expectedUpdatedPlaylistMessage);
        }

        public void doubleClickPlaylist() {
           // WebElement playlistk1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='playlist playlist']")));
            Actions a = new Actions(driver);
            a.doubleClick(playlistk1).perform();
        }
        /* public void clickEdit() {
             WebElement editButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@data-testid='playlist-context-menu-edit-75543']")));
             editButton.click();
         } */
        public void renamePlaylistk() {
           // WebElement editPlaylistBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(/*"li.playlist.playlist.editing"*/"[name='name']")));
            // Actions a = new Actions(driver);
            // a.doubleClick(editPlaylistBtn).perform();
            editPlaylistBtn.sendKeys(Keys.chord(Keys.CONTROL,"A", Keys.BACK_SPACE));
            editPlaylistBtn.sendKeys(newPlaylistName);
            editPlaylistBtn.sendKeys(Keys.ENTER);
        }
        public String getUpdatedPlaylistSuccessMessage () {
            //WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
            return notification.getText();
        }
    }

