package com.warehouse.user.Repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.warehouse.user.Model.Item;
import com.warehouse.user.Model.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class ItemRepo {

    @Value("${BASE_URL}")
    private  String BASE_URL;

    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    RestTemplate restTemplate;

    //Add data from API
    public void addItem(String dep, Item item) {
        String buildURL = BASE_URL + dep + "/add";
        postItemReq(item, buildURL);
    }

    //Getting data from API
    public Item getItem(String dep, int id) {
        String buildURL = BASE_URL + dep + "/get/" + id;
        Item item = getItemReq(buildURL);
        return item;
    }

    //Getting all data from API
    public List<Item> getAllItems(String dep) {
        String buildURL = BASE_URL + dep + "/get_all";
        List<Item> items = getAllItemsReq(buildURL);
        return items;
    }

    //Update item
    public void updateItem(String dep, Item item) {
        String buildURL = BASE_URL + dep + "/update/" + item.getId();
        putItemReq(item, buildURL);
    }

    //Send item
    public void sendItem(String dep, Item item) throws IOException {
        String buildURL = BASE_URL + dep + "/send_to/" + item.getTo() + "/" + item.getId();
        sendItemReq(buildURL);
    }

    //Get Log
    public List<Log> getLog(String dep, int id) {
        String buildURL = BASE_URL + dep + "/logs/" + id;
        return getLogRmeq(buildURL);
    }

    //Request for logs
    private List<Log> getLogRmeq(String url) {
        ResponseEntity<Log[]> response = restTemplate.getForEntity(url, Log[].class);
        ArrayList<Log> list = new ArrayList<>(Arrays.asList(response.getBody()));
        return list;
    }

    //POST to API to add item
    private void postItemReq(Item item, String url) {
        HttpEntity<Item> entity = new HttpEntity<>(item);
        restTemplate.exchange(url, HttpMethod.POST, entity, Item.class);

        //TODO paderinti atsaka
//        if(response.getStatusCode() == HttpStatus.CREATED) {
//            System.out.println("Gerai");
//        } else {
//            System.out.println("Blogai");
//        }
    }

    //PUT request to API to add item
    private void putItemReq(Item item, String url) {
        HttpEntity<Item> entity = new HttpEntity<>(item);
        restTemplate.exchange(url, HttpMethod.PUT, entity, Item.class);

        //TODO paderinti atsaka
//        if(response.getStatusCode() == HttpStatus.CREATED) {
//            System.out.println("Gerai");
//        } else {
//            System.out.println("Blogai");
//        }
    }
    //PUT request to send item to another place
    private void sendItemReq(String builedURL) throws IOException {
        URL url = new URL(builedURL);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setDoOutput(true);
        con.setRequestMethod("PUT");
        OutputStreamWriter out = new OutputStreamWriter(
                con.getOutputStream());
        out.write("Resource content");
        out.close();
        con.getInputStream();
    }

    //Call API to get item
    private Item getItemReq(String url) {
        ResponseEntity<Item> response = restTemplate.getForEntity(url, Item.class, 1);
        if(response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        } else {
            return null;
        }
    }
    //Call API to get item
    private List<Item> getAllItemsReq(String url) {
        ResponseEntity<Item[]> response = restTemplate.getForEntity(url, Item[].class);
        ArrayList<Item> list = new ArrayList<>(Arrays.asList(response.getBody()));
        return list;
    }

    public List<Item> searchItems(String dep, String value) {
        String buildURL = BASE_URL + dep + "/search/"+ value;
        List<Item> items = getAllItemsReq(buildURL);
        return items;
    }
}
