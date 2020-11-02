package FrameworkPkg;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class MainClass {

	Properties prop=new Properties();
	FileInputStream FileInput = null;
	
	@BeforeTest
	public static void BeforeTest(ITestContext context) {
		System.out.println("We can add some actions Before Test");
	}
	
	@DataProvider(name="TestData")
	public Object[] GetData() throws IOException {

		FileInput = new FileInputStream("config.properties");
		prop.load(FileInput);
		
		String InputFilePath = 	prop.getProperty("Input"); //context.getCurrentXmlTest().getParameter("Input");	//"C:\\Krupa\\Employment\\TechnicalTest\\archive\\car_input.txt"; //context.getCurrentXmlTest().getSuite().getParameter("Input");
		ArrayList<String> ReadRegNumber = new ReadData().ReadInputFile(InputFilePath);
		Object[] objData = ReadRegNumber.toArray();
		return objData;
	}
	
	
	@Test (dataProvider="TestData")
	public void TestNGFramework(String CarRegNum) throws IOException, InterruptedException{
		
		SoftAssert softAssert= new SoftAssert();
		
		FileInput = new FileInputStream("config.properties");
		prop.load(FileInput);
		
		String OutputFilePath = prop.getProperty("Output");
		String DriverPath = prop.getProperty("Driver");
		String urlName = prop.getProperty("URL");
			
		ArrayList<String> ReadOutput = new ReadData().ReadOutputFile(OutputFilePath,CarRegNum);
		ArrayList<String> DataFromPage = new GetDataFromPage().GetData(urlName, DriverPath, CarRegNum);
		
		boolean isEqual = DataFromPage.equals(ReadOutput); 

		softAssert.assertEquals(isEqual, true);
		softAssert.assertAll();
	
	}

	
	@AfterTest
	public void AfterTest() {
		System.out.println("We can add some actions After Test");
	}

}
