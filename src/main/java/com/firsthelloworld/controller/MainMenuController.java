/**
 * Project: sportyshoes
 * Package: com.firsthelloworld.controller
 * Created By: Mehmet Baran Ozkutuk
 */

package com.firsthelloworld.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainMenuController {

    @GetMapping("/")
    public String example(){

        return "mainpage";
    }

    @GetMapping("showMainMenu")
    public String showMainMenu(){

        return "mainpage";
    }

}
