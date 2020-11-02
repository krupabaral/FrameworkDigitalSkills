package FrameworkPkg;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener {

   
    @Override		
    public void onTestSuccess(ITestResult result) {					
        // TODO Auto-generated method stub				
    	System.out.println(result.getName() + " Test Pass");
    }
    
    @Override		
    public void onTestFailure(ITestResult result) {					
        // TODO Auto-generated method stub				
    	System.out.println(result.getName() + " Test Fail");   
    	//We can add screenshots here
    }  
}
