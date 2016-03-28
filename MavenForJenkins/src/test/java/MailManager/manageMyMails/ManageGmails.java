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

public class ManageGmails {
	
	@Test
	public void manageGmails() throws InterruptedException{
	//	ie_Driver = C:\\AutFramework\\Drivers\\IEDriverServer.exe
		//		Chrome_Driver = C:\\AutFramework\\Drivers\\chromedriver.exe
		//System.setProperty("webdriver.ie.driver", "C:\\AutFramework\\Drivers\\IEDriverServer.exe");
		File file = new File("C:/AutFramework/Drivers/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
		WebDriver dr=new ChromeDriver();
		//WebDriver dr=new InternetExplorerDriver();
		//WebDriver dr=new FirefoxDriver();
	    dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		dr.get("https://www.google.com/intl/en/mail/help/about.html");
		//click sign in
		dr.findElement(By.id("gmail-sign-in")).click();
		//Enter username and password
		dr.findElement(By.xpath("//*[@id='Email']")).clear();
		dr.findElement(By.xpath("//*[@id='Email']")).sendKeys("awahab03");
		//click next
		dr.findElement(By.id("next")) .click();
		Thread.sleep(2000);
		dr.findElement(By.xpath("//*[@id='Passwd']")).clear();
		dr.findElement(By.xpath("//*[@id='Passwd']")).sendKeys("usa&bd12");
		dr.findElement(By.xpath("//*[@id='signIn']")).click();
		
		//check all read emails to delete
		dr.manage().window().maximize();
		Thread.sleep(2000);
		
		for(int i=0;i<2;i++){
			Thread.sleep(3000);
			//Selecting all read mails in chrome, id=:2_ in other browsers
			dr.findElement(By.xpath("//*[@id=':2y']/div/div")).click();
			Thread.sleep(3000);
		    dr.findElement(By.xpath("//*[@id=':kp']")).click();
			Thread.sleep(3000);
		    //click delete
			dr.findElement(By.xpath("//*[@class='D E G-atb']/div[1]/div[1]/div/div/div[2]/div[3]")).click();	
		}
		

		
	
	}

} 
