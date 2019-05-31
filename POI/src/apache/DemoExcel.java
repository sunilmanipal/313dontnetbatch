package apache;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoExcel {

	public static void main(String[] args) throws IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sunilna\\Desktop\\IBM Data on Desktop\\IBM Upskill Project\\chrome\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		// To open that excel sheet and fetch the data
		File op = new File("D:\\data\\Testdata.xlsx");
		FileInputStream inp = new FileInputStream(op);
		
		// Write interfaces of apache poi to read the data from the excel sheet
		XSSFWorkbook wb = new XSSFWorkbook(inp);
		XSSFSheet sheet1 = wb.getSheetAt(0);
		
		int rowcount = sheet1.getLastRowNum();
		// Fetch the data in the excel sheet
		for(int i=0;i<=rowcount;i++)
		{
			String username = sheet1.getRow(i).getCell(0).getStringCellValue();
			String password = sheet1.getRow(i).getCell(1).getStringCellValue();
			driver.findElement(By.id("txtUsername")).sendKeys(username);
			driver.findElement(By.id("txtPassword")).sendKeys(password);
			driver.findElement(By.id("btnLogin")).click();
			Thread.sleep(3000);
			driver.findElement(By.id("welcome")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@id='welcome-menu']/ul/li[2]/a")).click();
			Thread.sleep(3000);
		}

	}

}
