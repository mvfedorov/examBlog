package ru.fedorov.exam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.fedorov.exam.api.response.InitResponse;

@Controller
public class DefaultController {
    private InitResponse initResponse;

    public DefaultController(InitResponse initResponse) {
        this.initResponse = initResponse;
    }

    @RequestMapping("/")
    public String index(Model model)
    {
        System.out.println(initResponse.getTitle());
        return "index";
    }

}
