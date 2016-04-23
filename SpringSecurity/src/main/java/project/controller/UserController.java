package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import project.model.Town;
import project.model.User;
import project.service.IUserService;

import javax.validation.Valid;
import java.nio.file.attribute.UserPrincipalLookupService;
import java.util.ArrayList;


@Controller
public class UserController {


    @Autowired
    IUserService userServ;

    @RequestMapping("/")
    public String index() {

        return "index";
    }


    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String reg(ModelMap map) {
        ArrayList<Town> townList = userServ.getTowns();

        map.put("user", new User());
        map.put("townList", townList);
        return "register";
    }


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(
            RedirectAttributes redirectAttributes,
            @Valid User user,
            BindingResult result,
            ModelMap map
    ) {
        ArrayList<Town> townList = userServ.getTowns();
        map.put("townList", townList);
        if (result.hasErrors()) {
            return "register";
        } else {
            userServ.add(user);
            redirectAttributes.addFlashAttribute("message", "<span style=\"color:green\">User with email: \"" + user.getEmail() + "\" has been added successfully</span>");
            return "redirect:" + MvcUriComponentsBuilder.fromMappingName("UC#register").build();
        }

    }


}
