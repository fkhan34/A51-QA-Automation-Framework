import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework20 extends BaseTest {
    @Test

    public void deletePlaylist() throws InterruptedException {

        String expectedDeletedPlaylistMessage = "Deleted playlist \"k.\"";

        navigateToLoginPage();
        provideEmail("faizan.khan@testpro.io");
        providePassword("master21");
        clickSubmit();
        //Thread.sleep(2000);
        clickPlaylist();
        clickDeletePlaylist();
        clickOkConfirmation();
        Assert.assertEquals(getDeletedPlaylistSuccessMessage(), expectedDeletedPlaylistMessage);
    }
    public void clickPlaylist () throws InterruptedException{
        WebElement playlistk = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='playlist playlist']")));
        // WebElement playlistk = driver.findElement(By.xpath("//li[@class='playlist playlist']"));
        playlistk.click();
        //Thread.sleep(1000);
    }
    public void clickDeletePlaylist () throws InterruptedException {
        WebElement deletePlaylistBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".del.btn-delete-playlist")));
        //WebElement deletePlaylistBtn = driver.findElement(By.cssSelector(".del.btn-delete-playlist"));
        deletePlaylistBtn.click();
        //Thread.sleep(1000);
    }
    public void clickOkConfirmation () throws InterruptedException {
        WebElement okConfirmationBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//nav//button[@class='ok']")));
        //WebElement okConfirmationBtn = driver.findElement(By.xpath("//nav//button[@class='ok']"));
        okConfirmationBtn.click();
        //Thread.sleep(2000);
    }
    public String getDeletedPlaylistSuccessMessage () {
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        //WebElement notification = driver.findElement(By.cssSelector("div.success.show"));
        return notification.getText();
    }
}
