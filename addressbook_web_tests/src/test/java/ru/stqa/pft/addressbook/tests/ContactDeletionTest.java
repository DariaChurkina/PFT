package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class ContactDeletionTest extends TestBase {

    @Test
    public void testContactDeletion() {
        app.goToHomePage();
        app.selectContact();
        app.deleteSelectedContact();
        app.getAccept(); //Как бороться с незаписывающимися действиями для диалогового окна
        app.goToHomePage();

    }

}
