package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultsPage extends BasePage {

    @FindBy(xpath = "//a[contains(@class,'PromoLink')]//span[@aria-hidden='false']")
    private List<WebElement> searchResultsList;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public String getNameOfFirstSearchResult() {
        return searchResultsList.get(0).getText();
    }
}
