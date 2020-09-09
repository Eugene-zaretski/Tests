package ru.stqa.pft.addreddbook.model;

import java.io.File;

public class ContactData {
    private  int id;
    private  String firstname;
    private  String middlename;
    private  String lastname;
    private  String phone_home;
    private  String phone_mobile;
    private  String phone_work;
    private  String allPhones;
    private File photo;

    public File getPhoto() {
        return photo;
    }

    public ContactData withPhoto(File photo) {
        this.photo = photo;
        return this;
    }

    public String getAllPhones() {
        return allPhones;
    }

    public ContactData withAllPhones(String allPhones) {
        this.allPhones = allPhones;
        return this;
    }
/* public ContactData(String firstname, String middlename, String lastname, String phone_home, String phone_mobile, String phone_work) {
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.phone_home = phone_home;
        this.phone_mobile = phone_mobile;
        this.phone_work = phone_work;
    }*/

    public String getFirstname() {
        return firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public String getLastname() {
        return lastname;
    }

    public String getPhone_home(){ return phone_home; }
    public String getPhone_mobile(){ return phone_mobile; }
    public String getPhone_work(){ return phone_work; }

    public ContactData withFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public ContactData withMiddlename(String middlename) {
        this.middlename = middlename;
        return this;
    }

    public ContactData withLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public ContactData withPhone_home(String phone_home) {
        this.phone_home = phone_home;
        return this;
    }

    public ContactData withPhone_mobile(String phone_mobile) {
        this.phone_mobile = phone_mobile;
        return this;
    }

    public ContactData withPhone_work(String phone_work) {
        this.phone_work = phone_work;
        return this;

    }

    public int getId() {
        return id;
    }

    public ContactData withId(int id) {
        this.id = id;
        return this;
    }
}


