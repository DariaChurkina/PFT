package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class ContactCreationTest extends TestBase {
    
    @Test
    public void testContactCreation() {

        goToAddNewPage();
        fillContactData(new ContactData("Daria", "Churkina", "123", "daria.churkina@inbox.ru"));
        submitNewContact();
        goToHomePage();
    }

}
