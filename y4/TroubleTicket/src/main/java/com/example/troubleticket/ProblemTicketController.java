package com.example.troubleticket;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping
public class ProblemTicketController {
    private final ProblemTicketService problemTicketService;

    public ProblemTicketController(ProblemTicketService problemTicketService) {
        this.problemTicketService = problemTicketService;
    }

    @GetMapping("/new")
    public ModelAndView getProblemTicketForm() {
        return new ModelAndView("new");
    }

    @GetMapping
    public String getTicketList(Model model) {
        List<ProblemTicket> tickets = problemTicketService.findAll();
        model.addAttribute("tickets", tickets);
        for (ProblemTicket t : tickets) {
            System.out.printf("%s\n", t.getProblem());
        }
        return "table";
    }

    @PostMapping("/new-problem-ticket")
    public void newProblemTicket(@RequestBody ProblemTicket problemTicket) {
        problemTicketService.createProblemTicket(problemTicket);
    }

}
