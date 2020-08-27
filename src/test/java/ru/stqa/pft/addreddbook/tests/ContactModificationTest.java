package ru.stqa.pft.addreddbook.tests;

import org.junit.Assert;
import org.junit.Test;
import ru.stqa.pft.addreddbook.model.ContactData;

public class ContactModificationTest extends TestBase{

    @Test
    public void testContactModification() {
        int before = app.contact().getContactCount();
        app.goTo().contactPage("ADD_NEW");
        app.contact().fillContactForm(
                new ContactData()
                        .withFirstname("Phone_test").withLastname("test").withMiddlename("test")
                        .withPhone_home("123").withPhone_mobile("6564035").withPhone_work("999"));
        app.contact().submitContactCreation("submit");
        app.goTo().homePage("home page");
        int after = app.contact().getContactCount();
        Assert.assertEquals(after, before);
     /*   app.getContactHelper().modifyContact(new ContactData()
                .withFirstname("Phone_test").withLastname("test").withMiddlename("test")
                .withPhone_home("123").withPhone_mobile("6564035").withPhone_work("999"));
        //int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(after, before);*/
    }
}
