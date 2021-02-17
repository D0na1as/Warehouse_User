package com.warehouse.user.Repository;

import com.warehouse.user.Model.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class PageRepo {

    @Value("${BASE_URL}")
    private  String BASE_URL;

    @Autowired
    RestTemplate restTemplate;

    //Get page information
    public Page getPage(String dep, Page page) {
        String buildURL = BASE_URL + dep + "/get_all";
        page= getPageReq(buildURL, page);
        return page;
    }

    private Page getPageReq(String buildURL, Page page) {
        HttpEntity<Page> entity = new HttpEntity<>(page);
        return restTemplate.postForObject(buildURL, entity, Page.class);

    }
}
