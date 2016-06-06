package ru.stqa.pft.addressbook;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class ContactDeletionTest extends TestBase {

    @Test
    public void testContactDeletion() {
        goToHomePage();
        selectContact();
        deleteSelectedContact();
        getAccept(); //Как бороться с незаписывающимися действиями для диалогового окна
        goToHomePage();

    }

}
