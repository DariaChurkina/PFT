package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Daria on 06.06.2016.
 */
public class NavigationHelper extends HelperBase {

    public NavigationHelper(WebDriver wd) {

        super(wd);
    }

    public void gotoGroupPage() {

        click(By.linkText("groups"));
    }

    public void goToAddNewPage() {

        click(By.linkText("add new"));
    }
}