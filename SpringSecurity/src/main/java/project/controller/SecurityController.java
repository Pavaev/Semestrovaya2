package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import project.model.Town;
import project.model.User;
import project.repo.UserAuthorityRepository;
import project.service.TownService;
import project.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;

/**
 * Created by Daniel Shchepetov on 27.04.2016.
 */
@Controller
public class SecurityController {

    @Autowired
    TownService townServ;

    @Autowired
    private UserService userServ;

    @Autowired
    private UserAuthorityRepository userAuthorityRepo;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    @PreAuthorize("isAnonymous()")
    public String reg(ModelMap map) {
        ArrayList<Town> townList = townServ.getTowns();
        map.put("user", new User());
        map.put("townList", townList);
        return "register";
    }


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @PreAuthorize("isAnonymous()")
    public String register(
            RedirectAttributes redirectAttributes,
            @Valid @ModelAttribute("user") User user,
            BindingResult result,
            ModelMap map
    ) {
        ArrayList<Town> townList = townServ.getTowns();
        map.put("townList", townList);
        if (result.hasErrors()) {
            return "register";
        } else {
            userServ.register(user);
            redirectAttributes.addFlashAttribute("message", "<span style=\"color:green\">User with email: \"" + user.getEmail() + "\" has been added successfully</span>");
            return "redirect:" + MvcUriComponentsBuilder.fromMappingName("UC#register").build();
        }

    }

    @RequestMapping("/user/id{id}")
    public String profile(HttpServletRequest request, @PathVariable int id, ModelMap map) {
        map.put("user", userServ.getOne(id));
        return "profile";
    }



}
