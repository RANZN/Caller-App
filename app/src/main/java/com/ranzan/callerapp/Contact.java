package com.ranzan.callerapp;

public class Contact {
    private String name;
    private String contactNo;

    public Contact(String name, String contactNo) {
        this.name = name;
        this.contactNo = contactNo;
    }

    public String getName() {
        return name;
    }

    public String getContactNo() {
        return contactNo;
    }
}
