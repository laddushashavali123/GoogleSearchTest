package tests.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import java.util.List;
import java.util.stream.Collectors;

@DefaultUrl("/")
public class GoogleSearchPage extends PageObject {

    @FindBy(name = "q")
    private WebElementFacade searchTerms;

    @FindBy(name = "btnK")
    private WebElementFacade searchButton;
    @FindBy(xpath = "//*[@class='pn']/span")
    private WebElementFacade nextButton;

    public void enter_keywords(String keyword) {
        searchTerms.type(keyword);
    }

    public void search() {
        searchButton.click();
    }

    public List<String> getDefinitions() {
        // "//*[text(),contains('')]
        WebElementFacade definitionList = find(By.xpath("//div[@class='r']"));
        return definitionList.findElements(By.tagName("a")).stream()
                .map(element -> element.getText())
                .collect(Collectors.toList());
    }

    public List<String> getDefinitionLinks() {
        getDriver().manage().window().maximize();
        List<WebElementFacade> definitionList = findAll(By.xpath("//div[@class='r']"));
        return definitionList.stream()
                .map(element -> element.findElement(By.tagName("a")).getAttribute("href"))
                .collect(Collectors.toList());
    }

    public void clickSearchResult(WebElementFacade webElementFacade){
        implicitTimoutMilliseconds();
        webElementFacade.click();
        implicitTimoutMilliseconds();
    }

    public WebElementFacade getLink(String href){
        return find(By.xpath("//a[@href='" + href + "']"));
    }

    public String getHomePageResult(){
        return getDriver().getCurrentUrl();
    }
    public void navigateBack(){
        JavascriptExecutor javascriptExecutor= (JavascriptExecutor)getDriver() ;
        javascriptExecutor.executeScript("javascript: setTimeout(\"history.go(-1)\", 2000)");
        implicitTimoutMilliseconds();
    }

}