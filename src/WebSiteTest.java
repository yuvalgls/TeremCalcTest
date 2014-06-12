import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;


public class WebSiteTest {

	public static String TeremApptest(int t, String MiniCalcStartDate,String MiniCalcEndDate ,String MiniCalcTotalSum, String TeremResult) {
		org.openqa.selenium.WebDriver driver = null;
		//System.out.println( "Outside t = " + t);
		switch (t) {
	    case 0: {
	    	driver = new FirefoxDriver();
	        break;
	    	}
	    case 1: {
	    	//driver = new ChromeDriver();
	    	System.setProperty("webdriver.chrome.driver", "C:/Selenium/chromedriver.exe");
			driver = new ChromeDriver();
	        break;
	    	}
	    case 2: {
	    	System.setProperty("webdriver.ie.driver", "C:/Selenium/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
	        break;
	    	}
	    //default:  
	    //	driver = new InternetExplorerDriver();
		// 	break;
		}
		driver.manage().window().maximize();
		driver.get("http://www.terem.co.il/");
		//enter start date
		WebElement queryStartDate = driver.findElement(By.name("MiniCalcStartDate"));
        queryStartDate.sendKeys(new String[]{MiniCalcStartDate});
        //enter end date from MiniCalcEndDate
        WebElement queryEndDate = driver.findElement(By.name("MiniCalcEndDate"));
        queryEndDate.sendKeys(new String[]{MiniCalcEndDate});
        //enter sun to calc from MiniCalcTotalSum
        WebElement queryTotalSum = driver.findElement(By.name("MiniCalcTotalSum"));
        queryTotalSum.sendKeys(new String[]{MiniCalcTotalSum});
        //press submit button from miniCalcSubmitButton
        WebElement querySubmitButton = driver.findElement(By.name("MiniCalcTotalSum"));
        querySubmitButton.submit();
        try {
        	//System.out.println("Pausing for 30 Secs");
        	//txtRunStatus.setText("Pausing for 30 Secs");
    		for(int i=30; i>1; i--){
                Thread.sleep(1000);
           }
		} catch (InterruptedException e) {
			//e.printStackTrace();
		} 
        //System.out.println("Start getting Result");
        //txtRunStatus.setText("Start getting Result");
        //get Result from MiniCalcResult 
        TeremResult = driver.findElement(By.xpath("/html/body/div[4]/div[2]/div/div/ol/li[3]/input")).getAttribute("value");
    	//System.out.println("The total by terem calc is : " + TeremResult);
        driver.quit();
        return TeremResult;
		// TODO Auto-generated method stub
	}
	public static String ExtApptest(int t, String MiniCalcStartDate,String MiniCalcEndDate ,String MiniCalcTotalSum, String TeremResult){
	 	org.openqa.selenium.WebDriver driver = null;
	 	//System.out.println( "Outside t = " + t);
	 	switch (t) {
	    case 0: {
	    	driver = new FirefoxDriver();
	        break;
	    	}
	    case 1: {
	    	//driver = new ChromeDriver();
	    	System.setProperty("webdriver.chrome.driver", "C:/Selenium/chromedriver.exe");
			driver = new ChromeDriver();
	        break;
	    	}
	    case 2: {
	    	System.setProperty("webdriver.ie.driver", "C:/Selenium/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
	        break;
	    	}
	    //default:  
	    //	driver = new InternetExplorerDriver();
		// 	break;
		}
	 	driver.manage().window().maximize();
		driver.get("http://www.cbs.gov.il/reader/?MIval=%2Fprices_db%2FMachshevon_4_H.html&MD=a&MySubject=37&MyCode=11120010");
		//enter start date
		WebElement queryStartDateDay = driver.findElement(By.name("Days_1"));
		WebElement queryStartDateMonth = driver.findElement(By.name("Months_1"));
		WebElement queryStartDateYear = driver.findElement(By.name("Years_1"));
		String MiniCalcStartDateDay = MiniCalcStartDate.substring(0, 2);
		String MiniCalcStartDateMonth = MiniCalcStartDate.substring(3, 5);
		String MiniCalcStartDateYear = MiniCalcStartDate.substring(6, 10);
		String Zero = "0";
		if(MiniCalcStartDateDay.charAt(0) == Zero.charAt(0)){
			MiniCalcStartDateDay = MiniCalcStartDate.substring(1, 2);
		}
     new Select (queryStartDateDay).selectByValue(MiniCalcStartDateDay);
     
		if(MiniCalcStartDateMonth.charAt(0) == Zero.charAt(0)){
			MiniCalcStartDateMonth = MiniCalcStartDateMonth.substring(1, 2);
		}
     new Select (queryStartDateMonth).selectByValue(MiniCalcStartDateMonth);
     new Select (queryStartDateYear).selectByValue(MiniCalcStartDateYear);
     
     //enter end date
     WebElement queryEndDateDay = driver.findElement(By.name("Days_2"));
		WebElement queryEndDateMonth = driver.findElement(By.name("Months_2"));
		WebElement queryEndDateYear = driver.findElement(By.name("Years_2"));
		String MiniCalcEndDateDay = MiniCalcEndDate.substring(0, 2);
		String MiniCalcEndDateMonth = MiniCalcEndDate.substring(3, 5);
		String MiniCalcEndDateYear = MiniCalcEndDate.substring(6, 10);
		if(MiniCalcEndDateDay.charAt(0) == Zero.charAt(0)){
			MiniCalcEndDateDay = MiniCalcEndDateDay.substring(1, 2);
		}
     new Select (queryEndDateDay).selectByValue(MiniCalcEndDateDay);
     
		if(MiniCalcEndDateMonth.charAt(0) == Zero.charAt(0)){
			MiniCalcEndDateMonth = MiniCalcEndDateMonth.substring(1, 2);
		}
     new Select (queryEndDateMonth).selectByValue(MiniCalcEndDateMonth);
     new Select (queryEndDateYear).selectByValue(MiniCalcEndDateYear);
     //enter sum
     WebElement queryTotalSum = driver.findElement(By.name("ssum"));
     queryTotalSum.sendKeys(new String[]{MiniCalcTotalSum});
     
     //press submit button from miniCalcSubmitButton
     WebElement querySubmitButton = driver.findElement(By.className("kaftor"));
     querySubmitButton.click();
     try {
    	 Thread.sleep(5000);
		} catch (InterruptedException e) {
			//e.printStackTrace();
		}
     final String CBSResult = driver.findElement(By.xpath("/html/body/table/tbody/tr[3]/td/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr[2]/td/b/font")).getText();
     //txtcbsResult.setText(CBSResult);
     driver.quit();
     return CBSResult;
     
 }
}