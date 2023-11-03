import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;



public class Homework17 extends BaseTest{

    @Test

    public void addSongToPlaylist() throws InterruptedException {

        String expectedSongAddedMessage = "Added 1 song into \"k.\"";

        navigateToLoginPage();
        provideEmail("faizan.khan@testpro.io");
        providePassword("master21");
        clickSubmit();
        Thread.sleep(2000);
        searchSong("birthday");
        clickViewAllBtn();
        selectFirstSongResult();
        clickAddToBtn();
        choosePlaylist();
        Assert.assertEquals(getAddToPlaylistSuccessMessage(), expectedSongAddedMessage);

    }

    public void searchSong (String name) throws InterruptedException {
        WebElement searchField = driver.findElement(By.cssSelector("div#searchForm input[type='search']"));
        searchField.sendKeys(name);
        Thread.sleep(2000);
    }
    public void clickViewAllBtn () throws InterruptedException {
        WebElement viewAll = driver.findElement(By.xpath("//button[@data-test='view-all-songs-btn']"));
        viewAll.click();
        Thread.sleep(2000);
    }
    public void selectFirstSongResult() throws InterruptedException {
        WebElement firstSong = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//tr[@class='song-item'][1]"));
        firstSong.click();
        Thread.sleep(2000);
    }
    public void clickAddToBtn() throws InterruptedException {
        WebElement addToBtn = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//button[@data-test='add-to-btn']"));
        addToBtn.click();
        Thread.sleep(2000);
    }
    public void choosePlaylist() throws InterruptedException {
        WebElement playlist = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//li[contains(text(), 'k')]"));
        playlist.click();
        Thread.sleep(2000);
    }
    public String getAddToPlaylistSuccessMessage() throws InterruptedException {
        WebElement notification = driver.findElement(By.cssSelector("div.success.show"));
        return notification.getText();
    }

}