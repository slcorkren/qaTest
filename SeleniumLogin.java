import java.util.concurrent.TimeUnit;

import org.junit.Test;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.By;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedCondition;

import org.openqa.selenium.support.ui.WebDriverWait;

import org.junit.Assert.*;

import org.openqa.selenium.Keys;

import org.openqa.selenium.JavascriptExecutor;

/**
 *
 * @author Lisa
 */
public class SeleniumLogin {
    
    @Test
    public void testSimple() throws Exception {

        WebDriver driver = new ChromeDriver();

        driver.get("http://www.shipt.com");
        driver.manage().window().maximize();
        // Check the title of the page
        // Wait for the page to load, timeout after 30 seconds
        (new WebDriverWait(driver, 30)).until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver d) {
                return d.getTitle().contains("Shipt");
            }
        });
        
        driver.findElement(By.xpath("/html/body/div[3]/div[1]/header/div/div/nav/ul[2]/li[3]/a")).click();
        
       (new WebDriverWait(driver, 30)).until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver d) {
                return d.getTitle().contains("Shipt");
            }
        });
       
        driver.findElement(By.xpath("//*[@id=\'myid\']/div/ion-content/div/div/div[2]/form/div/label[1]/input")).sendKeys("qatest@shipt.com");
        
        driver.findElement(By.xpath("//*[@id=\'myid\']/div/ion-content/div/div/div[2]/form/div/label[2]/input")).sendKeys("Sh1pt123!");

        driver.findElement(By.xpath("//*[@id=\'start_shopping_login_button\']")).click();
        
        (new WebDriverWait(driver, 30)).until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver d) {
                return d.getTitle().contains("Shipt");
            }
        });
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //search for something add to cart
        driver.findElement(By.xpath("/html/body/ion-nav-view/ion-side-menus/ion-side-menu-content/ion-nav-bar/div[2]/ion-header-bar/div[2]/span/div/form/label/input")).sendKeys("eggs");
        
        driver.findElement(By.xpath("/html/body/ion-nav-view/ion-side-menus/ion-side-menu-content/ion-nav-bar/div[2]/ion-header-bar/div[2]/span/div/form/label/input")).sendKeys(Keys.ENTER);
        
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //get the product name for verification 
        String productName = driver.findElement(By.xpath("//*[@id=\'homeIonContent\']/div/div/div[1]/div/div/div[1]/ion-item")).getText();
        
            if (productName.contains("Egg")){
                driver.findElement(By.xpath("//*[@id=\'homeIonContent\']/div/div/div[1]/div/div/div[1]/ion-item/div[1]/div[4]/button[2]")).click();
            }else{
                System.out.println(productName);
            }
        
        //open cart
        driver.findElement(By.xpath("/html/body/ion-nav-view/ion-side-menus/ion-side-menu-content/ion-nav-bar/div[2]/ion-header-bar/div[3]/span/web-cart-button/button")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            String cart = driver.findElement(By.xpath("/html/body/ion-nav-view/ion-side-menus/ion-side-menu-content/ion-nav-bar/div[1]/ion-header-bar/div[2]")).getText();
              if(cart.contains("Cart")){
                System.out.print(cart);
            }else{
                System.out.print("Cart not found.");
              }
        //validate item is in cart
        String productlist = driver.findElement(By.xpath("/html/body/ion-nav-view/ion-side-menus/ion-side-menu-content/ion-nav-view/ion-view[2]/ion-content/div/div/div[1]")).getText();
            if(productlist.contains("Eggs")){
                System.out.print(productlist);
            }else{
                System.out.print("Product list not found.");
              }
            
       //remove the product
       driver.findElement(By.xpath("/html/body/ion-nav-view/ion-side-menus/ion-side-menu-content/ion-nav-view/ion-view[2]/ion-content/div/div/div[1]/div[1]/div/div[4]/div[2]/button[1]/i")).click();
       
       //select home icon
       driver.findElement(By.xpath("/html/body/ion-nav-view/ion-side-menus/ion-side-menu-content/ion-nav-bar/div[1]/ion-header-bar/div[1]/span/web-home-logo-button/button/img")).click();
        
       //logout
       driver.findElement(By.xpath("/html/body/ion-nav-view/ion-side-menus/ion-side-menu-content/ion-nav-view/ion-view[1]/div/button[3]/i")).click();
        
//Close the browser
        //driver.quit();
    }
    
}
