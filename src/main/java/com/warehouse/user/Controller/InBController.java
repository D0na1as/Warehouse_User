package com.warehouse.user.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.warehouse.user.Model.Item;
import com.warehouse.user.Model.Log;
import com.warehouse.user.Model.Page;
import com.warehouse.user.Service.ItemService;
import com.warehouse.user.Service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/inbound")
public class InBController {

    @Autowired
    ItemService itemService;
    @Autowired
    PageService pageService;
    private final String department = "inbound";

    @RequestMapping("/")
    public String getUserPage(Model model)  {
        Page page = new Page(1, 25);
        page = pageService.getPage(department, page );
        List<Item> list = page.getList();
        model.addAttribute("items", list);
        model.addAttribute("page", page);
        model.addAttribute("newItem", new Item());
        return "tables";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addItem(@ModelAttribute("item") Item item)  {
        itemService.addItem("inbound", item);
        return "redirect:/inbound/";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateItem(@ModelAttribute("item") Item item)  {
        itemService.updateItem("inbound", item);
        return "redirect:/inbound/";
    }

    @RequestMapping(value = "/send", method = RequestMethod.POST)
    public String sendItem(@ModelAttribute("item") Item item) throws IOException {
        itemService.sendItem("inbound", item);
        return "redirect:/inbound/";
    }

    //Items history
    @RequestMapping (value = "/logs/{id}")
    public String getLogs(@PathVariable("id") int id, Model model ) throws JsonProcessingException {
        List<Log> logs = itemService.getLogs(department, id);
        Item item = itemService.getItem(department, id);
        model.addAttribute("item", item);
        model.addAttribute("logs", logs);
        return "history";

    }

    @Controller
    @RequestMapping("/inbound/search")
    public class InSearchController {

        @RequestMapping("/")
        public String searchItems(@RequestParam("value") String value, Model model) {
            if (value.isEmpty()) {
                return "redirect:/inbound/";
            } else {
                Page page = new Page(1, 25);
                List<Item> list = itemService.searchItems("inbound", value);
                model.addAttribute("items", list);
                model.addAttribute("newItem", new Item());
                model.addAttribute("page", page);
                return "tables";
            }
        }

        @RequestMapping(value = "/add", method = RequestMethod.POST)
        public String addItem(@ModelAttribute("item") Item item)  {
            itemService.addItem("inbound", item);
            return "redirect:/inbound/search/";
        }

        @RequestMapping(value = "/update", method = RequestMethod.POST)
        public String updateItemSearch (@ModelAttribute("item") Item item){
            itemService.updateItem("inbound", item);
            return "redirect:/inbound/search/";
        }

        @RequestMapping(value = "/send", method = RequestMethod.POST)
        public String sendItemSearch (@ModelAttribute("item") Item item) throws IOException {
            itemService.sendItem("inbound", item);
            return "redirect:/inbound/search/";
        }
    }
}
