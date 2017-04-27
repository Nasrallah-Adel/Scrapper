/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Scrapper;


import java.util.List;
import java.util.concurrent.TimeUnit;
import jdbc.insert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 *
 * @author nasrallah
 */
public class Tedx {
    
    public static void Getter() {
        insert in = new insert();
        e_model mod = new e_model();
       // e_model[] r_model = new e_model[40];
        int q = 0;
        System.setProperty("webdriver.gecko.driver", "/usr/geckodriver");
        WebDriver dr = new FirefoxDriver();
        dr.get("https://www.ted.com/talks?sort=newest&topics%5B%5D=Technology&language=en");
        dr.manage().window().maximize();
        dr.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        List<WebElement> list = dr.findElements(By.className("talk-link"));
        java.util.Iterator<WebElement> i = list.iterator();
        while (i.hasNext()) {
            if (q > 40) {
                break;
            }
            
            WebElement row = i.next();
            
            mod.setE_name(row.findElement(By.className("media__message")).findElement(By.cssSelector(".m5")).getText());
            mod.setSrc(row.findElement(By.className("media__message")).findElement(By.cssSelector(".m5")).findElement(By.tagName("a")).getAttribute("href"));
            mod.setImg(row.findElement(By.className("thumb__tugger")).findElement(By.tagName("img")).getAttribute("src"));//            mod.setSpeaker(row.findElement(By.cssSelector(".talk-link__speaker")).getText());
            mod.setDate(row.findElement(By.className("meta__val")).getText());
            mod.setSpeaker(row.findElement(By.className("talk-link__speaker")).getText());
            
//            System.out.println(mod.getE_name());
//            System.out.println(mod.getSrc());
//            System.out.println(mod.getImg());
//            System.out.println(mod.getDate());
//            System.out.println(mod.getSpeaker());
            in.insert_Event(mod);
            //r_model[q++] = mod;
        }
        dr.quit();
    // return r_model;
    }
    
}
