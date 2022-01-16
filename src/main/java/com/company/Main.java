package com.company;

import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

import java.io.FileWriter;
import java.io.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final String URL = "https://virtuo.ciussscn.rtss.qc.ca/GuichetWeb/";
    private static List<WebElement> elements = null;
    private static List<WebElement> dateTable = null;
    private static List<WebElement> row = null;
    private static final ChromeDriver driver = new ChromeDriver();



    public static void main(String[] args) {
            //Automate l
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");

            JSONObject employeeDetails = new JSONObject();
            employeeDetails.put("firstName,", "Lokesh");
            employeeDetails.put("lastName", "Gupta");
            employeeDetails.put("website", "howtodoinghjava.com");
            try (FileWriter file = new FileWriter("Employee.json")) {
                file.write(employeeDetails.toJSONString());
                file.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.setProperty("webdriver.Chrome.driver", "C:\\chromedriver.exe");
            //Go to virtuo's front webPage
            driver.get(URL);
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            driver.findElement(By.cssSelector(".full-height > .ng-scope > .ng-scope > .ng-scope:nth-child(1)")).click();
            WebElement username = driver.findElement(By.cssSelector(".ng-touched"));
            username.sendKeys("510217");
            WebElement password = driver.findElement(By.cssSelector(".form-group:nth-child(2) .form-control"));
            password.sendKeys("Satan258069911!");
            WebElement login = driver.findElement(By.id("LoginFormButtonloginBtn"));
            login.click();
            WebElement button = driver.findElement(By.xpath("//*[@id=\"page-body\"]/ui-view/div/div[2]/div[3]/div[2]/div[3]/a/div/div"));
            button.click();

            //Calendar case's info
            WebElement infoBox = driver.findElement(By.xpath("//*[@id=\"calendar\"]/div[2]/div/table/tbody/tr/td/div/div/div[1]/div[2]/table/tbody/tr[1]/td[2]/a/div/span[1]"));
            String workInfo = infoBox.getAttribute("class");
            //Calendar's cases date
            WebElement dateElement = driver.findElement(By.xpath("//*[@id=\"calendar\"]/div[2]/div/table/tbody/tr/td/div/div/div[1]/div[2]/table/thead/tr/td[1]"));
            String date = dateElement.getText();

            //Find a specfic element by looping through 'em
            //looper("28");

            //enumerate all shifts
            //looper("au", "//*[@id=\"calendar\"]/div[2]/div/table/tbody/tr/td/div/div/div[1]/div[2]/table/tbody/tr");
            //looper("5", "//*[@id=\"calendar\"]/div[2]/div/table/tbody/tr/td/div/div/div[2]/div[2]/table/thead/tr");

            //DatingCoach();
        }
            public static void looper(String value, String xpath) {
                //Find a specfic element by looping through 'em
                 elements = driver.findElements(By.xpath(xpath));
                 for (WebElement element : elements) {
                         if (element.getText().contains(value)) {
                                        System.out.println(element.getText());
                                        System.out.println("It worked");
                                }
                        }

                }
                private static int date;
                private static String poste;
                private static String location;
                private static FileWriter file;
                public static void DatingCoach() throws IOException {

                    for(int i = 0; i <= 4; i++) {
                        int column = i + 1;
                row = driver.findElements(By.xpath("//*[@id=\"calendar\"]/div[2]/div/table/tbody/tr/td/div/div/div["+column+"]/div[2]/table/tbody/tr[1]/td"));
                int counter = 0;
                int workday = 0;
                switch (column) {
                        case 1:
                                date = 25;
                                break;
                        case 2:
                                date = 1;
                                break;
                        case 3:
                                date = 8;
                                break;
                        case 4:
                                date = 15;
                                break;
                        case 5:
                                date = 22;
                                break;
                        case 6:
                                date = 29;
                }

                for (WebElement element : row) {
                        if (element.getText().contains("Site")) {
                                if(date > 31) {
                                    date = 1;
                                }
                                date += 1;
                                workday += 1;
                                String jobDescription = element.getText();
                                System.out.println(date);
                                System.out.println(jobDescription);
                                //Parse out the 'jobdescription" into import information tidbits
                                //shfit
                                for(int j = 0; j<jobDescription.length(); j++) {
                                    int nCounter = 0;
                                    if (jobDescription.charAt(j) == '\n') {
                                        poste = jobDescription.substring(0, j);
                                        break;
                                    }else{
                                        continue;
                                    }
                                }

                                JSONObject shiftDetails = new JSONObject();
                                shiftDetails.put("shift", poste);
                                shiftDetails.put("date", date);
                                shiftDetails.put("location", location);
                                try (FileWriter file = new FileWriter("Work.json", true)) {
                                    file.write(shiftDetails.toJSONString());
                                    file.flush();
                                    file.close();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }

                        } else {
                                date += 1;
                        }
                }

                    }

    }
        }



