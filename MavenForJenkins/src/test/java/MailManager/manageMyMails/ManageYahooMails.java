package MailManager.manageMyMails;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class ManageYahooMails {
	
	@Test
	public void manageYmails() throws InterruptedException{
	//	ie_Driver = C:\\AutFramework\\Drivers\\IEDriverServer.exe
		//		Chrome_Driver = C:\\AutFramework\\Drivers\\chromedriver.exe
		//System.setProperty("webdriver.ie.driver", "C:\\AutFramework\\Drivers\\IEDriverServer.exe");
		File file = new File("C:/AutFramework/Drivers/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
		WebDriver dr=new ChromeDriver();
		//WebDriver dr=new InternetExplorerDriver();
		//WebDriver dr=new FirefoxDriver();
	    dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		dr.get("https://mail.yahoo.com");
		
		dr.findElement(By.xpath("//*[@id='login-username']")).clear();
		dr.findElement(By.xpath("//*[@id='login-username']")).sendKeys("awahab03");
		dr.findElement(By.xpath("//*[@id='login-passwd']")).clear();
		dr.findElement(By.xpath("//*[@id='login-passwd']")).sendKeys("usa&bd12");
		dr.findElement(By.xpath("//*[@id='login-signin']")).click();
		
		//Sorting mails
		WebElement e=dr.findElement(By.xpath("//*[@id='btn-conv-view']"));
		e.click();
		Thread.sleep(3000);
		List<WebElement> sortOrdder = dr.findElements(By.xpath("//*[@id='menu-conv-view']/div/ul/li"));
		System.out.println(sortOrdder.size());
		String s=sortOrdder.get(1).getText();
		System.out.println(s);
		sortOrdder.get(1).click(); //clicks on oldest on top 
		
		//if mails are more than 10 counts
		Thread.sleep(3000);
		
		
		int operation=0;
		for(int i=1; i<=2; i++){
			//select all mails
			dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			//selecct all dropDown
			dr.findElement(By.xpath("//*[@id='btn-select-dd']")).click();
			//Select all menu list
			List<WebElement> allMail=dr.findElements(By.xpath("//*[@id='menu-ml-cbox']/ul/li"));
			//System.out.println(allMail.size());
			//clicking on 'All' link, which is first one of the list, 0 index
			allMail.get(0).click();
			
			//delete all mails
			Thread.sleep(3000);
			//clicking delete button for all selected mails
			dr.findElement(By.xpath("//*[@id='btn-delete']")).click();
			Thread.sleep(3000);
			//clicking on OK for warning alert
			if(dr.findElement(By.xpath("//*[@id='okModalOverlay']")).isDisplayed()){
				dr.findElement(By.xpath("//*[@id='okModalOverlay']")).click();
			}

			operation=operation+i;
			//Count mail counts
			List<WebElement> cBoxList=dr.findElements(By.xpath("//*[contains(@id,'yui_')]"));
			int cBoxCounts=cBoxList.size();
			System.out.println("Total mail counts: "+cBoxCounts);
			if(cBoxCounts<15){
				System.out.println("mail count is: "+cBoxCounts);
				break;
				
			}
			
		}
		System.out.println("Total delete operations run = "+operation);
		
	
	}

} 
