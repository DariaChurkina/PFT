package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.ContactData;

/**
 * Created by Daria on 06.06.2016.
 */
public class ContactHelper extends HelperBase {

    public ContactHelper(FirefoxDriver wd) {

        super(wd);
    }

    public void submitNewContact() {

        click(By.xpath("//div[@id='content']/form/input[21]"));
    }

    public void fillContactData(ContactData contactData) {
        type(By.name("firstname"), contactData.getFirstname());
        type(By.name("firstname"), contactData.getLastname());
        type(By.name("firstname"), contactData.getPhone());
        type(By.name("firstname"), contactData.getEmail());
    }

    public void deleteSelectedContact() {
        click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
    }

    public void selectContact() {

        click(By.name("selected[]"));
    }
}
