package jira.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class testCases {



    @Test
    public void test1(){
        System.out.print("test 1 is running");
        System.setProperty("webdriver.chrome.driver", "C:\\automation\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //setting the website test
        driver.get("http://www.google.com");

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
