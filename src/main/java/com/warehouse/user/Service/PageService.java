package com.warehouse.user.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.warehouse.user.Model.Page;
import com.warehouse.user.Repository.PageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PageService {


    @Autowired
    PageRepo pageRepo;

    @Autowired
    ObjectMapper objectMapper;

    //Get page
    public Page getPage(String dep, Page request) {
        return pageRepo.getPage(dep, request);
    }
}
