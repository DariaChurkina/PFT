package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.List;

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

    public void selectContactById(int id) {
        wd.findElement(By.cssSelector("input[id='" + id + "']")).click();
    }

    public void initContactModification(int id) {
        wd.findElement(By.cssSelector("a[href='edit.php?id="+id+"']")).click();
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
        contactCache = null;
        goToHomePage();
    }

    public void modify(ContactData contact) {
        selectContactById(contact.getId());
        initContactModification(contact.getId());
        fillContactData(contact, false);
        submitContactModification();
        contactCache = null;
        goToHomePage();
    }

    public int count() {
        return wd.findElements(By.name("selected[]")).size();
    }

    public void delete(ContactData contact) {
        selectContactById(contact.getId());
        deleteSelectedContact();
        getAccept(); //Как бороться с незаписывающимися действиями для диалогового окна
        contactCache = null;
        goToHomePage();
    }

    public void submit(ContactData contact) {
        fillContactData(contact, true);
        submitNewContact();
        goToHomePage();
    }

    private Contacts contactCache = null;

    public Contacts all() {
        if (contactCache != null) {
            return new Contacts(contactCache);
        }

        contactCache = new Contacts();
        List<WebElement> rows = wd.findElements(By.name("entry"));
        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            int id = Integer.parseInt(row.findElement(By.tagName("input")).getAttribute("value"));
            String lastName = cells.get(1).getText();
            String firstName = cells.get(2).getText();
            String allPhones = cells.get(5).getText();
            contactCache.add(new ContactData().withId(id).withFirstname(firstName).withLastname(lastName)
                    .withAllPhones(allPhones));
        }
        return new Contacts(contactCache);
    }

    public ContactData infoFromEditForm(ContactData contact) {
        goToHomePage();
        initContactModification(contact.getId());
        String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
        String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
        String home = wd.findElement(By.name("home")).getAttribute("value");
        String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
        String work = wd.findElement(By.name("work")).getAttribute("value");
        wd.navigate().back();
        return new ContactData().withId(contact.getId()).withFirstname(firstname).withLastname(lastname)
                .withHomePhone(home).withMobilePhone(mobile).withWorkPhone(work);
    }
}