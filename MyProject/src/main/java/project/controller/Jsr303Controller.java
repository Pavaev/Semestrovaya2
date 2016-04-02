package project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import project.model.User;

import javax.validation.Valid;


@Controller
public class Jsr303Controller {


    @RequestMapping("/")
    public String index() {

        return "index";
    }

    @RequestMapping("/show")
    public String show() {

        return "complaint";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String reg(ModelMap map) {
        map.put("user", new User());
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(
            RedirectAttributes redirectAttributes,
            @Valid User user,
            BindingResult result,
            ModelMap map
    ) {
        if (result.hasErrors()) {
            return "register";
        } else {
            redirectAttributes.addFlashAttribute("message", "<span style=\"color:green\">User with email: \"" + user.getEmail() + "\" has been added successfully</span>");
            return "redirect:" + MvcUriComponentsBuilder.fromMappingName("JC#register").build();
        }

    }


}
