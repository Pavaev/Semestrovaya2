package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import project.model.Town;
import project.model.User;
import project.repo.TownRepository;
import project.service.IUserService;
import project.service.TownService;

import javax.validation.Valid;
import java.nio.file.attribute.UserPrincipalLookupService;
import java.time.LocalDate;
import java.util.ArrayList;


@Controller
public class UserController {

    @Autowired
    TownService townServ;



    @Autowired
    IUserService userServ;

    @RequestMapping("/")
    public String index() {

        return "index";
    }


    @RequestMapping("/user/id{id}")
    public String show(@PathVariable int id, ModelMap map) {
        map.put("user", userServ.getOne(id));
        return "profile";
    }

    @RequestMapping("/user/id{id}/delete")
    public String delete(@PathVariable int id, ModelMap map) {
        map.put("user", userServ.getOne(id));
        return "profile";
    }
    @RequestMapping("/user/id{id}/edit")
    public String edit(@PathVariable int id, ModelMap map) {
        map.put("user", userServ.getOne(id));
        return "profile";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String reg(ModelMap map) {
        ArrayList<Town> townList = townServ.getTowns();
        map.put("user", new User());
        map.put("townList", townList);
        return "register";
    }


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(
            RedirectAttributes redirectAttributes,
            @Valid @ModelAttribute("user")User user,
            BindingResult result,
            ModelMap map
    ) {
        ArrayList<Town> townList = townServ.getTowns();
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
