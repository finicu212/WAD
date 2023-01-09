package com.example.troubleticket;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProblemTicketService {

    private final ProblemTicketRepository problemTicketRepository;
//    private final FranchiseeService franchiseeService;

    public ProblemTicketService(ProblemTicketRepository problemTicketRepository/*, FranchiseeService franchiseeService*/) {
        this.problemTicketRepository = problemTicketRepository;
//        this.franchiseeService = franchiseeService;
    }

    public void createProblemTicket(ProblemTicket problemTicket) {
        problemTicketRepository.save(problemTicket);

//        franchiseeService.forwardServiceRequest(problemTicket);
    }

    public List<ProblemTicket> findAll() {
        List<ProblemTicket> tickets = problemTicketRepository.findAll();
        System.out.println(tickets);
        return tickets;
    }
}
