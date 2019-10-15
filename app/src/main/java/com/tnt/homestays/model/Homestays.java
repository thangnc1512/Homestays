package com.tnt.homestays.model;

public class Homestays {
    String url,name,address;

    public Homestays(String url, String name, String address) {
        this.url = url;
        this.name = name;
        this.address = address;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
