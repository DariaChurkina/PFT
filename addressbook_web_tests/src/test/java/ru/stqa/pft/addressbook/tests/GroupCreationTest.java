package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupCreationTest extends TestBase {

    @Test
    public void testGroupCreation() {
        app.getNavigationHelper().gotoGroupPage();
        app.getGroupHelper().startGroupCreation();
        app.getGroupHelper().fillGroupForm(new GroupData("Test1", null, null));
        app.getGroupHelper().submitNewGroup();
        app.getGroupHelper().returntoGroupPage();
    }

}
