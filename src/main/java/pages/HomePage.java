package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    @FindBy(xpath = "//div[@id='orb-nav-links']//a[contains(@href,'https://www.bbc.com/news')]")
    private WebElement newsButton;

    @FindBy(xpath = "//div[@id='orb-nav-links']//li[contains(@class,'sport')]")
    private WebElement sportButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void openHomePage(final String url) {
        driver.get(url);
    }

    public void clickNewsButton() {
        newsButton.click();
    }

    public void clickSportButton() {
        sportButton.click();
    }
}
