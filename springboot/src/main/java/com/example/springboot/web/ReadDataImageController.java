package com.example.springboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReadDataImageController {

    @GetMapping("/extractdata")
    public String homePage(Model model) {

        return "/jsp/index";
    }
  /*  @RequestMapping()
    public List<HashMap> extractData(){
        Map<String><String> dataField = new HashMap();
        Map bid = new HashMap();
        List<HashMap> re = new ArrayList<>();
        re.add((HashMap) dataField);
        re.add(bid);
        return re;
    }*/
}
