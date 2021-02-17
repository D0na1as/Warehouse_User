package com.warehouse.user.Model;

import java.io.Serializable;
import java.util.List;

public class Page implements Serializable {

    //Current page
    private int current;
    //Item counts per page
    private int count;
    //Overall items in department
    private int all;
    //List of items in current page
    private List<Item> list;

    public Page() {
    }

    public Page(int current, int count) {
        this.current = current;
        this.count = count;
    }

    public Page(int current, int all, List<Item> list) {
        this.current = current;
        this.all = all;
        this.list = list;
    }

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getAll() {
        return all;
    }

    public void setAll(int all) {
        this.all = all;
    }

    public List<Item> getList() {
        return list;
    }

    public void setList(List<Item> list) {
        this.list = list;
    }
}
