package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTest extends TestBase {
    
    @Test
    public void testContactCreation() {

        app.goToHomePage();
        app.getNavigationHelper().goToAddNewPage();
        app.getContactHelper().fillContactData(new ContactData("Daria", "Churkina", "123", "daria.churkina@inbox.ru", "Test1"), true);
        app.getContactHelper().submitNewContact();
        app.goToHomePage();
    }

}
