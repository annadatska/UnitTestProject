package manager;

import org.openqa.selenium.WebDriver;
import pages.NewsPage;
import pages.HomePage;
import pages.SearchResultsPage;
import pages.SportPage;

public class PageFactoryManager {
    WebDriver driver;

    public PageFactoryManager(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage getHomePage() {
        return new HomePage(driver);
    }

    public NewsPage getNewsPage() {
        return new NewsPage(driver);
    }

    public SearchResultsPage getSearchResultsPage() {
        return new SearchResultsPage(driver);
    }

    public SportPage getSportPage() {
        return new SportPage(driver);
    }
}
