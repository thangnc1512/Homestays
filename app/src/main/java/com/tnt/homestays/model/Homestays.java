package com.tnt.homestays.model;

public class Homestays {
    String Title, Images, Address, Arearoom, Phone, price, Description;

    public Homestays() {

    }

    public Homestays(String title, String images, String address, String arearoom, String phone, String price, String description) {
        Title = title;
        Images = images;
        Address = address;
        Arearoom = arearoom;
        Phone = phone;
        this.price = price;
        Description = description;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getImages() {
        return Images;
    }

    public void setImages(String images) {
        Images = images;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getArearoom() {
        return Arearoom;
    }

    public void setArearoom(String arearoom) {
        Arearoom = arearoom;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
