package springfarmework.petclinic.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import springfarmework.petclinic.services.VetService;

@RequestMapping({"/vets","/vets.html"})
@Controller
public class VetController {

    private final VetService vetService;

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    @RequestMapping({"","/","/index","/index.html"})
    public String listVets(Model model){

        model.addAttribute("vets",vetService.findAll());

        return "vets/index";
    }


}
