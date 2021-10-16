package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultsPage extends BasePage {

    @FindBy(xpath = "//a[@class='ssrcss-bxvqns-PromoLink e1f5wbog0']//span[@aria-hidden='false']")
    private List<WebElement> searchResultsList;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public String getNameOfFirstSearchResult() {
        return searchResultsList.get(0).getText();
    }
}
