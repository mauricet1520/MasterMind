package com.tiy.practice;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by crci1 on 1/21/2017.
 */
@Controller
public class MasterMindController {
    List<String> listOfColors = new ArrayList<>();

    @RequestMapping(path = "/mastermind", method = RequestMethod.GET)
    public String start_game(Model model, HttpSession httpSession) {
        ResultContainer resultContainer = new ResultContainer();
        model.addAttribute("list-of-colors", listOfColors);

        return "mastermind";
    }
}

