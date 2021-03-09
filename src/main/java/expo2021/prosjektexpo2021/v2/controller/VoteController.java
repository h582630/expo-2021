package expo2021.prosjektexpo2021.v2.controller;

import expo2021.prosjektexpo2021.v2.models.Stand;
import expo2021.prosjektexpo2021.v2.models.Vote;
import expo2021.prosjektexpo2021.v2.service.StandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
public class VoteController {

    private final StandService standService;

    @Autowired
    public VoteController(StandService standService){
        this.standService = standService;
    }


    @RequestMapping("/vote/{id}")
    public ModelAndView showNewVotePage(@PathVariable("id") int id, Vote vote){

        ModelAndView modelAndView = new ModelAndView(("vote_stand"));
        Stand stand = standService.findById(id);

        var haha = vote;
        modelAndView.addObject("stand", stand);
        modelAndView.addObject("vote", vote);

        return modelAndView;

    }

    @RequestMapping(value = "/saveVote", method = RequestMethod.POST)
    public RedirectView addVoteToStand(@ModelAttribute("stand") Stand stand, @ModelAttribute("vote") Vote vote){

        // får ikke tak i verdiene!!

        var hehe = stand;

        standService.addVoteToStand(stand, vote);

        return new RedirectView("/showStands");



    }


    /*

    @RequestMapping(value = "/submitVote", method = RequestMethod.POST)
    public RedirectView showVotingPage(@ModelAttribute("vote") Vote vote, @ModelAttribute("stand") Stand stand){

        standService.addVoteToStand(stand, vote);

        return new RedirectView("/showStands");
    }
*/

}
