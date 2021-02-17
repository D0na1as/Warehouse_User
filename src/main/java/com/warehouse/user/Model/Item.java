package com.warehouse.user.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Item {

    private int id;
    private String title;
    private String serial;
    private String comments;
    private String place;
    private String from;
    private String to;

    public Item() {
    }

    public Item(String title, String serial, String comments, String place, String from, String to) {
        this.title = title;
        this.serial = serial;
        this.comments = comments;
        this.place = place;
        this.from = from;
        this.to = to;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String description) {
        this.comments = description;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }
//
//    public String formLog() {
//        return "{" +
//                "   \"From\": \"" +getFrom()+ "\"," +
//                "   \"To\": \"" +getTo()+ "\"," +
//                "   \"Time\": \"" +Utils.getDate()+"\""+
//                "}";
//    }
}
