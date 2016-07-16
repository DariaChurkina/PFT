package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ContactHelper extends HelperBase {

    public ContactHelper(FirefoxDriver wd) {

        super(wd);
    }

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void submitNewContact() {

        click(By.xpath("//div[@id='content']/form/input[21]"));
    }

    public void fillContactData(ContactData contactData, boolean creation) {
        type(By.name("firstname"), contactData.getFirstname());
        type(By.name("lastname"), contactData.getLastname());
        type(By.name("home"), contactData.getPhone());
        type(By.name("email"), contactData.getEmail());

        if (creation) {
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }
    }

    public void deleteSelectedContact() {
        click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
    }

    public void selectContactById(int index) {
        By Elements = By.name("selected[]");
        wd.findElements(Elements).get(index).click();
    }

    public void initContactModification(int index) {
        click(By.xpath("//table[@id='maintable']/tbody/tr[" + (index + 2) + "]/td[8]/a/img"));
    }

    public void submitContactModification() {
        click(By.xpath("//div[@id='content']/form[1]/input[22]"));
    }

    public boolean findContact() {
        return isElementPresent(By.name("selected[]"));
    }

    public void goToHomePage() {
        wd.findElement(By.linkText("home")).click();
    }

    public void getAccept() {
        wd.switchTo().alert().accept();
    }

    public void create(ContactData contact) {
        fillContactData(contact, true);
        submitNewContact();
    }

    public void modify(int index, ContactData contact) {
        selectContactById(index);
        initContactModification(index);
        fillContactData(contact, false);
        submitContactModification();
        goToHomePage();
    }

    public int getContactCount() {
        return wd.findElements(By.name("selected[]")).size();
    }

    public void delete(int index) {
        selectContactById(index);
        deleteSelectedContact();
        getAccept(); //Как бороться с незаписывающимися действиями для диалогового окна
        goToHomePage();
    }

    public void submit(ContactData contact) {
        fillContactData(contact, true);
        submitNewContact();
        goToHomePage();
    }

    public List<ContactData> list() {
        List<ContactData> contacts = new ArrayList<ContactData>();
        List<WebElement> elements = wd.findElements(By.name("entry"));
        for (WebElement element : elements) {
            String firstName = element.findElement(By.xpath("td[3]")).getText();
            String lastName = element.findElement(By.xpath("td[2]")).getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            contacts.add(new ContactData().withId(id).withFirstname(firstName).withLastname(lastName));
        }
        return contacts;
    }

    public Set<ContactData> all() {
        Set<ContactData> contacts = new HashSet<ContactData>();
        List<WebElement> elements = wd.findElements(By.name("entry"));
        for (WebElement element : elements) {
            String firstName = element.findElement(By.xpath("td[3]")).getText();
            String lastName = element.findElement(By.xpath("td[2]")).getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            contacts.add(new ContactData().withId(id).withFirstname(firstName).withLastname(lastName));
        }
        return contacts;
    }
}