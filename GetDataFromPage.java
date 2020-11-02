package FrameworkPkg;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GetDataFromPage {


	public ArrayList<String> GetData(String urlName,String DriverPath,String CarRegNum) throws InterruptedException{
		
		ArrayList<String> listOfValuesFromPage;
		listOfValuesFromPage = new ArrayList<>();
		
		System.setProperty("webdriver.chrome.driver", DriverPath);
		WebDriver chromeDriver1 = new ChromeDriver();
		
		chromeDriver1.get(urlName);	
		chromeDriver1.manage().window().maximize();
		chromeDriver1.findElement(By.id("vrm-input")).sendKeys(CarRegNum);
		chromeDriver1.findElement(By.xpath("//button[contains(text(),'Free Car Check')]")).click();
		 
		 By classLocator = By.className("jsx-3496807389");
		 List<WebElement> details = new WebDriverWait(chromeDriver1, 10).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(classLocator));
		 
	     //for(WebElement detailList : details){
	        //System.out.println(detailList.getText());
	        //}
		
	     for (int i=0 ; i<5 ; i++) {
	    	 listOfValuesFromPage.add(details.get(i).getText());
			}
	
	     chromeDriver1.quit();
		return listOfValuesFromPage;
		
	}
}
