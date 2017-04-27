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
public class Udemy {

    insert in;

    public Udemy() {
        in = new insert();
    }

    public void Getter_beginner(String Key) {

        c_model mod = new c_model();
        // c_model[] r_model = new c_model[40];
        int q = 0;
        System.setProperty("webdriver.gecko.driver", "/usr/geckodriver");
        WebDriver dr = new FirefoxDriver();
        dr.get("https://www.udemy.com/courses/search/?ref=home&src=ukw&q=" + Key + "&instructionalLevel=beginner&price=price-free");
        dr.manage().window().maximize();
        dr.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        List<WebElement> list = dr.findElements(By.className("card__inner"));
        java.util.Iterator<WebElement> i = list.iterator();
        while (i.hasNext()) {
            if (q > 40) {
                break;
            }

            WebElement row = i.next();

            mod.setC_name(row.findElement(By.className("card__title")).getText());
            mod.setC_src(row.findElement(By.className("card__title")).getAttribute("href"));
            mod.setC_img_src(row.findElement(By.className("card__image")).getAttribute("src"));
            mod.setC_insta(row.findElement(By.className("card__instructor-inner")).getText());
            mod.setType(Key);
            mod.setLevel("1");
            in.insert_course(mod);
            //  r_model[q++] = mod;
        }
        dr.quit();
        // return r_model;
    }

    public void Getter_intermediate(String Key) {

        c_model mod = new c_model();
        //c_model[] r_model = new c_model[40];
        int q = 0;
        System.setProperty("webdriver.gecko.driver", "/usr/geckodriver");
        WebDriver dr = new FirefoxDriver();
        dr.get("https://www.udemy.com/courses/search/?ref=home&src=ukw&q=" + Key + "&instructionalLevel=intermediate&price=price-free");
        dr.manage().window().maximize();
        dr.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        List<WebElement> list = dr.findElements(By.className("card__inner"));
        java.util.Iterator<WebElement> i = list.iterator();
        while (i.hasNext()) {
            if (q > 40) {
                break;
            }

            WebElement row = i.next();

            mod.setC_name(row.findElement(By.className("card__title")).getText());
            mod.setC_src(row.findElement(By.className("card__title")).getAttribute("href"));
            mod.setC_img_src(row.findElement(By.className("card__image")).getAttribute("src"));
            mod.setC_insta(row.findElement(By.className("card__instructor-inner")).getText());
             mod.setType(Key);
            mod.setLevel("2");
            in.insert_course(mod);
            ///r_model[q++] = mod;
        }
        dr.quit();
        //return r_model;
    }

    public void Getter_expert(String Key) {

        c_model mod = new c_model();
        // c_model[] r_model = new c_model[40];
        int q = 0;
        System.setProperty("webdriver.gecko.driver", "/usr/geckodriver");
        WebDriver dr = new FirefoxDriver();
        dr.get("https://www.udemy.com/courses/search/?ref=home&src=ukw&q=" + Key + "&instructionalLevel=expert&price=price-free");
        dr.manage().window().maximize();
        dr.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        List<WebElement> list = dr.findElements(By.className("card__inner"));
        java.util.Iterator<WebElement> i = list.iterator();
        while (i.hasNext()) {
            if (q > 40) {
                break;
            }

            WebElement row = i.next();

            mod.setC_name(row.findElement(By.className("card__title")).getText());
            mod.setC_src(row.findElement(By.className("card__title")).getAttribute("href"));
            mod.setC_img_src(row.findElement(By.className("card__image")).getAttribute("src"));
            mod.setC_insta(row.findElement(By.className("card__instructor-inner")).getText());
             mod.setType(Key);
            mod.setLevel("3");
            in.insert_course(mod);
            // r_model[q++] = mod;
        }
        dr.quit();
        //  return r_model;
    }

}
