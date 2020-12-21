package com.company;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class Main {
    private static  WebDriver webDriver = null;

    public static void main(String[] args) {
        try {
            if (webDriver == null) {
                System.setProperty("webdriver.chrome.driver", "chromedriver_win32/driver/chromedriver.exe");
                webDriver = new ChromeDriver();
                webDriver.manage().deleteAllCookies();
                webDriver.manage().window().maximize();
                webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            } else {
                webDriver = new ChromeDriver();
            }

            String [] arr = {"spk.spw@","spk.spw@gmail.","!#$%^@gmail.com"};
//            for(int j=0;j>3;j++) {
                webDriver.get("https://member.geneusdna.com/login");
                webDriver.findElement(By.xpath("//*[text()='Register']")).click();
                webDriver.findElement(By.id("sexRadio1")).click();
                webDriver.findElement(By.id("firstNameInput")).sendKeys("Supakorn");
                webDriver.findElement(By.id("lastNameInput")).sendKeys("Supawong");
                Select days = new Select(webDriver.findElement(By.id("birthdate_dayInput")));
                days.selectByVisibleText("19");
                Select month = new Select(webDriver.findElement(By.id("birthdate_monthInput")));
                month.selectByVisibleText("June");
                Select year = new Select(webDriver.findElement(By.id("birthdate_yearInput")));
                year.selectByVisibleText("1997");
                webDriver.findElement(By.id("heightInput")).sendKeys("172");
                webDriver.findElement(By.id("weightInput")).sendKeys("62");

                for (int i = 0; i < arr.length; i++) {
                    webDriver.findElement(By.id("emailInput")).clear();
                    webDriver.findElement(By.id("emailInput")).sendKeys(arr[i].toString());
                    webDriver.findElement(By.id("passwordInput")).sendKeys("123456");
                    webDriver.findElement(By.id("confirmPasswordInput")).sendKeys("123456");
                    webDriver.findElement(By.xpath("//*[text()='สมัครสมาชิก']")).click();
                }
                System.out.println("Success");

                webDriver.close();
//            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("==== Fail =====");
        }
    }


}
