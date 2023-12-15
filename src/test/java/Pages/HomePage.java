package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends Pages.BasePage {

    @FindBy(css = ".avatar")
    private WebElement userAvatarIcon;
    // userAvatarIcon: Represents the user avatar element on the page.

    @FindBy(css = ".playlist:nth-child(3)")
    private WebElement firsPlaylist;
    // firsPlaylist: Represents the first playlist item on the page.

    @FindBy(css = "input[name='name']")
    private WebElement playlistInputField;
    // playlistInputField: Represents the input field on the page used for entering the playlist name.

    @FindBy(css = ".fa-plus-circle")
    private WebElement addNewPlaylist;
    // addNewPlaylist: Represents the element on the page indicating the addition of a new playlist.

    @FindBy(css = ".btn-delete-playlist")
    private WebElement deletePlaylistBtn;
    // deletePlaylistBtn: Represents the button on the page used for deleting a playlist.

    @FindBy(css = ".show.success")
    private WebElement notification;
    // notification: Represents the element on the page displaying a notification or message.

    @FindBy(css = ".songs")
    private WebElement allSongs;
    // allSongs: Represents the block or container containing all songs.

    @FindBy(css = "[data-testid='playlist-context-menu-create-simple']")
    private WebElement chooseCreateNewPlaylist;
    // chooseCreateNewPlaylist: Represents the element on the page used for selecting to create a new playlist.
    @FindBy (xpath = "//li[@class='playlist playlist']")
    private WebElement playlistk1;
    @FindBy (xpath = "[name='name']")
    private WebElement editPlaylistBtn;
    @FindBy (css = "div.success.show")
    private WebElement notification1;

    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }
// This is the constructor of the "HomePage" class that takes a WebDriver object as a parameter
// and invokes the constructor of the superclass (parent class) with this parameter.
// The constructor is used to initialize the object of the class when an instance is created.

    /*public boolean getUserAvatar() {
        return userAvatarIcon.isEnabled();
    }*/
// The "getUserAvatar" method returns a boolean value (true or false)
// depending on whether the "userAvatarIcon" element is enabled.
// If the element is enabled, the method returns true; otherwise, it returns false.

    public HomePage chooseFirstPlaylist() {
        firsPlaylist.click();
        return this;
    }
// The "chooseFirstPlaylist" method performs an action to select the first playlist.
// It clicks on the "firstPlaylist" element (link corresponding to the first playlist)
// and returns an instance of the current "HomePage" class.

    public HomePage deletePlaylist() {
        deletePlaylistBtn.click();
        return this;
    }
// The "deletePlaylist" method performs an action to delete the playlist.
// It clicks on the "deletePlaylistBtn" element
// and returns an instance of the current "HomePage" class.

    public boolean notificationText() {
        findElement(notification);
        return notification.isDisplayed();
    }
// It uses the "findElement" method to locate the "notification" element.
// It returns a boolean value (true or false) depending on whether the "notification" element is displayed on the page.
// If the element is displayed, the method returns true; otherwise, it returns false.
    

    public WebElement getUserAvatar(){
        return findElement(userAvatarIcon);
    }

    public WebElement hoverPlay() throws InterruptedException {
        //WebElement play = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid='play-btn']")));
        WebElement play = driver.findElement(By.cssSelector("[data-testid='play-btn']"));
        actions.moveToElement(play).perform();
        return  wait.until(ExpectedConditions.visibilityOf(play));
    }
    public void doubleClickPlaylist() {
        wait.until(ExpectedConditions.visibilityOfElementLocated((By) playlistk1));
        Actions a = new Actions(driver);
        a.doubleClick(playlistk1).perform();
    }

    public void renamePlaylistk() {
        //WebElement editPlaylistBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(/*"li.playlist.playlist.editing"*/"[name='name']")));
        // Actions a = new Actions(driver);
        // a.doubleClick(editPlaylistBtn).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated((By) editPlaylistBtn));
        editPlaylistBtn.sendKeys(Keys.chord(Keys.CONTROL,"A", Keys.BACK_SPACE));
        String newPlaylistName = "p";
        editPlaylistBtn.sendKeys(newPlaylistName);
        editPlaylistBtn.sendKeys(Keys.ENTER);
    }
    public String getUpdatedPlaylistSuccessMessage() {
        //WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        wait.until(ExpectedConditions.visibilityOfElementLocated((By) notification1));
        return notification1.getText();
    }


    public void chooseAllSongsList() {
    }
}