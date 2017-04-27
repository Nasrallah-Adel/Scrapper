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
public class Coursera {

    insert in;

    public Coursera() {
        in = new insert();
    }

    public void Getter_beginner(String Key) {
        c_model mod = new c_model();
        // c_model[] r_model = new c_model[40];
        int q = 0;
        System.setProperty("webdriver.gecko.driver", "/usr/geckodriver");
        WebDriver dr = new FirefoxDriver();
        dr.get("https://www.coursera.org/courses?_facet_changed_=true&languages=en&primaryLanguages=en&query=" + Key);
        dr.manage().window().maximize();
        dr.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        List<WebElement> list = dr.findElements(By.className("offering-content"));
        List<WebElement> list2 = dr.findElements(By.name("offering_card"));
        java.util.Iterator<WebElement> i = list.iterator();
        java.util.Iterator<WebElement> u = list2.iterator();
        while (i.hasNext()) {
            if (q > 40) {
                break;
            }

            WebElement row = i.next();
            WebElement row2 = u.next();

            mod.setC_name(row.findElement(By.className("horizontal-box")).findElement(By.className("horizontal-box")).getText());
            mod.setC_src(row2.getAttribute("href"));
            mod.setC_img_src(row.findElement(By.className("offering-image")).getAttribute("src"));
            mod.setC_insta(row.findElement(By.className("offering-partner-names")).getText());
             mod.setType(Key);
            mod.setLevel("2");
            in.insert_course(mod);
          
        }
        dr.quit();
       
    }

}
