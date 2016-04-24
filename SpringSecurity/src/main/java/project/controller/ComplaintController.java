package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import project.model.Complaint;
import project.model.ComplaintValidator;
import project.service.IComplaintService;

/**
 * Created by Daniel Shchepetov on 14.04.2016.
 */
@Controller
public class ComplaintController {

    @InitBinder(value = "complaint")
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(new ComplaintValidator());

    }


    @Autowired
    IComplaintService complaintService;


    @RequestMapping("/complaint")
    public String show() {

        return "complaint";
    }


    @RequestMapping("/complaint/{id}")
    public String show(@PathVariable int id, ModelMap map) {
        map.put("complaint", complaintService.getOne(id));
        return "complaint";
    }

    @RequestMapping(value = "/new_complaint", method = RequestMethod.GET)
    public String complaint(ModelMap map) {
        map.put("complaint", new Complaint());
        return "add";
    }


    @RequestMapping(value = "/new_complaint", method = RequestMethod.POST)
    public String springHandler(
            RedirectAttributes redirectAttributes,
            @Validated Complaint complaint,
            BindingResult result,
            ModelMap map
    ) {
        if (result.hasErrors()) {
            return "add";
        } else {
            complaintService.add(complaint);
            redirectAttributes.addFlashAttribute("message", "<span style=\"color:green\">Complaint \"" + complaint.getHeader() + "\" has been added successfully</span>");
            redirectAttributes.addFlashAttribute("messageType", "success");
            return "redirect:" + MvcUriComponentsBuilder.fromMappingName("CC#complaint").build();
        }

    }

    @RequestMapping("/complaint/{id}/delete")
    public String delete(@PathVariable int id, RedirectAttributes redirectAttributes, ModelMap map) {
        try {
            complaintService.delete(id);
            redirectAttributes.addFlashAttribute("message", "Complaint has been deleted successfully");
            redirectAttributes.addFlashAttribute("messageType", "success");
        } catch (EmptyResultDataAccessException e) {
            redirectAttributes.addFlashAttribute("message", "Can't find complaint with id " + id);
            redirectAttributes.addFlashAttribute("messageType", "fail");
        } catch (DataAccessException e) {
            redirectAttributes.addFlashAttribute("message", "Can't delete complaint with id " + id);
            redirectAttributes.addFlashAttribute("messageType", "fail");
        }
        return "redirect:" + MvcUriComponentsBuilder.fromMappingName("CC#complaint").build();
    }

    @RequestMapping(value = "/list/{pageNum}*", method = RequestMethod.GET)
    public String showNew(@PathVariable Integer pageNum,
                          @RequestParam String from,
                          @RequestParam String to,
                          @RequestParam String comp,
                       ModelMap map) {
        Page<Complaint> page;

        if (pageNum != null) {
            page = complaintService.getPage(pageNum, from, to, comp);
        } else {
            page = complaintService.getPage(1,from,to,comp);
        }
        int current = page.getNumber() + 1;
        int begin = Math.max(1, current - 5);
        int end = Math.min(begin + 10, page.getTotalPages());
        map.addAttribute("page", page);
        map.addAttribute("beginIndex", begin);
        map.addAttribute("endIndex", end);
        map.addAttribute("currentIndex", current);
        return "list";
    }


}
