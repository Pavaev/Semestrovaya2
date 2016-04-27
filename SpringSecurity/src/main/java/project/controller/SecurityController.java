package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import project.model.Login;
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




    protected String showRegisterForm(ModelMap map){
        map.put("userAuthorities", userAuthorityRepo.findAll());
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    @PreAuthorize("isAnonymous()")
    public String reg(ModelMap map) {
        ArrayList<Town> townList = townServ.getTowns();
        map.put("user", new User());
        map.put("townList", townList);
        return showRegisterForm(map);
    }


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @PreAuthorize("isAnonymous()")
    public String register(
            RedirectAttributes redirectAttributes,
            @Valid User user,
            BindingResult result,
            ModelMap map
    ) {
        ArrayList<Town> townList = townServ.getTowns();
        map.put("townList", townList);
        if (result.hasErrors()) {
            return "register";
        } else {
            try {
                userServ.register(user);
                redirectAttributes.addFlashAttribute("message", "Success!");
                redirectAttributes.addFlashAttribute("messageType", "success");
                return "redirect:" + MvcUriComponentsBuilder.fromPath("/").build();
            } catch (DuplicateKeyException ex) {
                result.rejectValue("email", "entry.duplicate", "There is account with such email already.");
            }
        }
        return showRegisterForm(map);
    }


    @RequestMapping(value = "/login")
    @PreAuthorize("isAnonymous()")
    public String login(@RequestParam(required = false) String error, @ModelAttribute("login") Login login, BindingResult result, ModelMap map) {
        map.put("error", error);
        return "login";
    }


    @RequestMapping("/user/id{id}")
    public String profile(HttpServletRequest request, @PathVariable int id, ModelMap map) {
        map.put("user", userServ.getOne(id));
        return "profile";
    }


}