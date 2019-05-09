package tests.steps.serenity;


import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.webdriver.WebDriverFacade;
import tests.pages.GoogleSearchPage;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;

public class UserSteps {

    GoogleSearchPage googleSearchPage;
 private List<String> listStringLinks;
    @Step
    public void enters(String keyword) {
        googleSearchPage.enter_keywords(keyword);
    }

    @Step
    public void starts_search() {
        googleSearchPage.search();
    }

    @Step
    public void should_see_definition(String definition) {
        assertThat(googleSearchPage.getDefinitions(), hasItem(containsString(definition)));
    }

    @Step
    public void is_on_the_home_page() {
       // System.setProperty("webdriver.http.factory", "apache");
       /* if(System.getProperty("webdriver.driver").toUpperCase().equals("chrome".toUpperCase()))
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/"+System.getProperty("webdriver.chrome.driver"));
*/
        googleSearchPage.open();
    }

    @Step
    public void looks_for(String term) {
        enters(term);
        starts_search();
    }
    @Step
    public void collect_links() {
        listStringLinks=googleSearchPage.getDefinitionLinks();
    }

    @Step
    public  WebElementFacade generateLink(String hrefString) {

        return googleSearchPage.getLink(hrefString);
    }
    @Step
    public void clickLink(WebElementFacade link) {
        googleSearchPage.clickSearchResult(link);
    }

    @Step
    public void navigate_to_each_link() {
        for(String href:listStringLinks){
            String homeSearchResultPage=googleSearchPage.getHomePageResult();
            System.out.println("Link of the ResultPage is: "+ homeSearchResultPage);

            clickLink(generateLink(href));
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Link of the Page is : "+ href);
            googleSearchPage.navigateBack();
           // break;
        }
       // googleSearchPage.navigateEachItem();
    }
}