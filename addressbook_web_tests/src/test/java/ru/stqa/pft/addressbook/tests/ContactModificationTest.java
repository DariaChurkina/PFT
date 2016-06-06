package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTest extends TestBase {

    @Test

    public void testContactModification() {
        app.goToHomePage();
        app.getContactHelper().selectContact();
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillContactData(new ContactData("Maria", "Churkina", "789", "daria.churkina@inbox.ru"));
        app.getContactHelper().submitContactModification();
        app.goToHomePage();
    }
}
