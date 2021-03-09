package expo2021.prosjektexpo2021.v2.controller;


import expo2021.prosjektexpo2021.v2.models.Stand;
import expo2021.prosjektexpo2021.v2.models.Vote;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import expo2021.prosjektexpo2021.v2.service.StandService;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;


import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class StandController {

    private final StandService standService;

    @Autowired
    public StandController(StandService standService){
        this.standService = standService;
    }

    @RequestMapping("/showStands")
    public ModelAndView showAllStand(){
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("show_stands");
        List<Stand> listOfStands = standService.getStands();

        List<Stand> sortedStands = listOfStands.stream()
                .sorted(Comparator.comparingInt(Stand::getId))
                .collect(Collectors.toList());

        modelAndView.addObject("listOfStands", sortedStands);
        return modelAndView;

    }

    @RequestMapping("/new")
    public ModelAndView showNewStandPage(Stand stand){

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("create_stand");

        modelAndView.addObject("stand", stand);
        return modelAndView;

    }


    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public RedirectView saveStand(@ModelAttribute("stand") Stand stand){

        standService.addStand(stand);

        return new RedirectView("/showStands");

    }


    @RequestMapping("/edit/{id}")
    public ModelAndView showEditPage(@PathVariable("id") int id){
        ModelAndView modelAndView = new ModelAndView("edit_stand");
        Stand stand = standService.findById(id);
        modelAndView.addObject("stand", stand);

        return modelAndView;
    }

    @RequestMapping("delete/{id}")
    public RedirectView deleteStand(@PathVariable("id") int id){
        standService.deleteById(id);

        return new RedirectView("/showStands");
    }



}
