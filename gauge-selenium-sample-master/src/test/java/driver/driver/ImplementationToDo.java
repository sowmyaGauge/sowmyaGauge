package driver.driver;

import com.thoughtworks.gauge.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class ImplementationToDo {

    private final WebDriver driver;
    WebElement budgetMin;

    public ImplementationToDo() {
        this.driver = new DriverFactory().getDriver();
    }

  @Step("Open the input app")
  public void gotoApp() throws InterruptedException {

      //  System.out.println(this.driver);
        driver.get("https://noteb.com");

        
  }

  @Step("Select the by class from UI")
  public void selectByClass() throws InterruptedException {
      WebElement byClass = driver.findElement(By.xpath("//ul[2]/li/a"));
      if(byClass.isDisplayed()){
       System.out.println("by class is displayed");
             byClass.click();
             WebElement budget =driver.findElement(By.xpath("(//a[text()='Budget'])[1]"));
            budget.click();   
         }
        else{
         System.out.println("By class is not displayed");
      }
    }
@Step("Scroll down to budget")
public void scrollToBudget() throws InterruptedException 
{
  JavascriptExecutor js = (JavascriptExecutor) driver;
  budgetMin= driver.findElement(By.xpath("//*[@id='bdgmin'][1]"));
 js.executeScript("arguments[0].scrollIntoView();", budgetMin);
 Thread.sleep(2000);
    
}
@Step("Enter Minimun value<minValue> and Maximun value<maxValue> in Budget field")
public void enterMinMaxBudget(String minValue, String maxValue) throws InterruptedException{
  JavascriptExecutor js = (JavascriptExecutor) driver;
  budgetMin.sendKeys(minValue);
  Thread.sleep(1000);
  WebElement budgetMax = driver.findElement(By.xpath("//*[@id='bdgmax'][1]"));
  budgetMax.sendKeys(maxValue);
  Thread.sleep(1000);
  WebElement searchBnt = driver.findElement(By.xpath("//*[@id='s_search_btn']"));
  js.executeScript("arguments[0].scrollIntoView();", searchBnt);
  searchBnt.click();

}
//for validation need a unique loctors 
 @Step("Validate on the Min and Max value entered")
 public void validateMinMaxValue(){
 
 }
 @Step("Sliding the min and max value")
 public void slideValue(){
  WebElement slideMin = driver.findElement(By.xpath("//*[@id='budget']/div/div[2]/div/div"));
  
  Actions move = new Actions(driver);
  Action action1 = (Action) move.dragAndDropBy(slideMin, 60, 0).build();
  action1.perform();
WebElement slideMax = driver.findElement(By.xpath("//*[@id='budget']/div/div[3]/div/div"));
  Actions move1 = new Actions(driver);
  Action action11 = (Action) move1.dragAndDropBy(slideMax, 60, 0).build();
  action11.perform();
 }
@Step("Add new item <itemName>")
  public void addNewItem(String itemName) throws InterruptedException {

      WebElement addItem  = driver.findElement(By.id("sampletodotext"));
      addItem.sendKeys(itemName);
      Thread.sleep(2000);

      WebElement addButton = driver.findElement(By.id("addbutton"));
      addButton.click();
  }
}
