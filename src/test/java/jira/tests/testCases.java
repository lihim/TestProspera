package jira.tests;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.annotations.Test;
import org.testng.xml.XmlSuite;

import java.io.Console;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;

import static org.testng.AssertJUnit.assertTrue;

public class testCases {

    WebDriver driver;

    @Test
    public void test1() throws IOException {

//        String url = "https://api.prospera.ag/api/v1/auth/login/";
//
//        HttpClient client = HttpClientBuilder.create().build();
//        HttpPost post = new HttpPost(url);
//        String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36";
//
//        List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
//        urlParameters.add(new BasicNameValuePair("password", "lihi3263"));
//        urlParameters.add(new BasicNameValuePair("username", "lihi"));
//
//        post.setEntity(new UrlEncodedFormEntity(urlParameters));
//        HttpResponse response = client.execute(post);


        System.out.print("test 1 is running");
        System.setProperty("webdriver.chrome.driver", "C:\\automation\\drivers\\chromedriver.exe");
        //setting the website test
      //  Assert.assertEquals("3", "6");
     //   DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        ChromeOptions options = new ChromeOptions();
        LoggingPreferences loggingprefs = new LoggingPreferences();
        loggingprefs.enable(LogType.BROWSER, Level.ALL);
        options.setCapability(CapabilityType.LOGGING_PREFS, loggingprefs);
        driver =new ChromeDriver(options);

        driver.get("https://int.prospera.ag/macro/agro%20analytics/111");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("//input[@type = 'email']")).sendKeys("lihi");
        driver.findElement(By.xpath("//input[@type = 'password']")).sendKeys("lihi3263");
        driver.findElement(By.xpath("//div[@_ngcontent-c2]//button[@_ngcontent-c2]")).click();




        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("//div[@_ngcontent-c5 and @class='dropdown-arrow']")).click();
        driver.findElements(By.xpath("//a[@_ngcontent-c5 and @angulartics2on='click' and contains(text(), 'Zapotlan')]")).get(0).click();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("//span[@_ngcontent-c5 and @class='greenhouse']")).click();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElements(By.xpath("//span[@_ngcontent-c10 and @class='name' and contains(text(), 'A07')]")).get(0).click();





        ExtractJSLogs();

    }


    public void ExtractJSLogs() {
        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
        logEntries.forEach((k)->{if("SERVER".equals(k.getLevel().toString()))System.out.println(k.getMessage()); });
        for (LogEntry entry : logEntries) {
            if(entry.getLevel().toString() == "SEVERE"){
                System.out.println(entry.getMessage());
            }
           // System.out.println(new Date(entry.getTimestamp()) + " " + entry.getLevel() + " " + entry.getMessage());

        }
        int i = 8;
    }




    @Test
    public void test2(){
        System.out.print("test 2 is running");
    }

    @Test
    public void test3(){
        System.out.print("test 2 is running");
    }

    @Test
    public void test4(){
        System.out.print("test 2 is running");
    }

}
