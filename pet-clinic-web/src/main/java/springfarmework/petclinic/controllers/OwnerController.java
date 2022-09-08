package springfarmework.petclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import springfarmework.petclinic.model.Owner;
import springfarmework.petclinic.services.OwnerService;

import java.util.List;

@RequestMapping("/owners")
@Controller
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    //@RequestMapping({"","/","/index","/index.html"})
    //public String listOwners(Model model){
    //
    //      model.addAttribute("owners", ownerService.findAll());
    //      return "owners/index";
    //}
    @RequestMapping("/find")
    public String findOwners(Model model) {

        model.addAttribute("owner", new Owner());
        return "owners/findOwners";
    }

    @GetMapping
    public String processFindForm(Owner owner, BindingResult result, Model model) {
        // allow parameterless GET request for /owners to return all records
        if (owner.getLastName() == null) {
            owner.setLastName(""); // empty string signifies broadest possible search
        }

        // find owners by last name
        List<Owner> results = ownerService.findAllByLastNameLike("%"+ owner.getLastName() + "%");

        if (results.isEmpty()) {
            // no owners found
            result.rejectValue("lastName", "notFound", "not found");
            return "owners/findOwners";
        } else if (results.size() == 1) {
            // 1 owner found
            owner = results.get(0);
            return "redirect:/owners/" + owner.getId();
        } else {
            // multiple owners found
            model.addAttribute("selections", results);
            return "owners/ownersList";
        }
    }

    @GetMapping("/{ownerId}")
    public ModelAndView showOwner(@PathVariable("ownerId") Long ownerId) {
        ModelAndView mav = new ModelAndView("owners/ownerDetails");
        Owner owner = ownerService.findById(ownerId);
        mav.addObject(owner);
        return mav;
    }

    @GetMapping("/new")
    public String initCreationForm(Model model) {
        Owner owner = new Owner();
        model.addAttribute("owner", owner);
        return "owners/createOrUpdateOwnerForm";
    }

    @PostMapping("/new")
    public String processCreationForm(Owner owner, BindingResult result) {
        if (result.hasErrors()) {
            return "owners/createOrUpdateOwnerForm";
        }
        else {
            ownerService.save(owner);
            return "redirect:/owners/" + owner.getId();
        }
    }

    @GetMapping("/{ownerId}/edit")
    public String initUpdateOwnerForm(@PathVariable("ownerId") Long ownerId, Model model) {
        Owner owner = this.ownerService.findById(ownerId);
        model.addAttribute(owner);
        return "owners/createOrUpdateOwnerForm";
    }

    @PostMapping("/{ownerId}/edit")
    public String processUpdateOwnerForm( Owner owner, BindingResult result,
                                         @PathVariable("ownerId") Long ownerId) {
        if (result.hasErrors()) {
            return "owners/createOrUpdateOwnerForm";
        }
        else {
            owner.setId(ownerId);
            return "redirect:/owners/"+ownerService.save(owner).getId();
        }
    }
}
