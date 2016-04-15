package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import project.dao.IComplaintsDao;
import project.model.Complaint;
import project.model.ComplaintValidator;


@Controller
public class SpringController {

    @InitBinder
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(new ComplaintValidator());
    }

    @Autowired
    IComplaintsDao complaintsDao;

    @RequestMapping(value = "/complaint", method = RequestMethod.GET)
    public String complaint(ModelMap map) {
        map.put("complaint", new Complaint());
        return "add";
    }


    @RequestMapping(value = "/complaint", method = RequestMethod.POST)
    public String springHandler(
            RedirectAttributes redirectAttributes,
            @Validated Complaint complaint,
            BindingResult result,
            ModelMap map
    ) {
        if (result.hasErrors()) {
            return "add";
        } else {
            complaintsDao.create(complaint);
            redirectAttributes.addFlashAttribute("message", "<span style=\"color:green\">Complaint \"" + complaint.getHeader() + "\" has been added successfully</span>");

            return "redirect:" + MvcUriComponentsBuilder.fromMappingName("SC#complaint").build();
        }

    }


}