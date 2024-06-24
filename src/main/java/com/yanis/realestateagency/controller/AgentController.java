package com.yanis.realestateagency.controller;

import com.yanis.realestateagency.model.Agent;
import com.yanis.realestateagency.service.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/agent")
public class AgentController {
    @Autowired
    private AgentService agentService;

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("agents", agentService.getAllAgents());
        return "agent/list";
    }

    @GetMapping("/add")
    public String displayAddForm(Model model) {
        model.addAttribute("agent", new Agent());
        return "agent/add";
    }

    @PostMapping("/add")
    public String processAdd(Agent agent) {
        agentService.addAgent(agent);
        return "redirect:/agent/list";
    }

    @GetMapping("/update/{id}")
    public String displayUpdateForm(@PathVariable("id") Long id, Model model) {
        Agent agent = agentService.getAgentById(id);
        model.addAttribute("agent", agent);
        return "agent/update";
    }

    @PostMapping("/update")
    public String processUpdate(Agent agent) {
        agentService.updateAgent(agent.getId(), agent);
        return "redirect:/agent/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        agentService.deleteAgent(id);
        return "redirect:/agent/list";
    }

    @GetMapping("/")
    public String home() {
        return "redirect:/agent/list";
    }

}
