package com.yanis.realestateagency.service;

import com.yanis.realestateagency.model.Agent;
import com.yanis.realestateagency.repository.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgentService {
    @Autowired
    private AgentRepository agentRepository;

    public List<Agent> getAllAgents() {
        return agentRepository.findAll();
    }

    public Agent getAgentById(Long id) {
        return agentRepository.findById(id).orElse(null);
    }

    public Agent addAgent(Agent agent) {
        return agentRepository.save(agent);
    }

    public Agent updateAgent(Long id, Agent agentDetails) {
        Agent agent = agentRepository.findById(id).orElse(null);
        if (agent != null) {
            agent.setFirstName(agentDetails.getFirstName());
            agent.setLastName(agentDetails.getLastName());
            return agentRepository.save(agent);
        }
        return null;
    }

    public void deleteAgent(Long id) {
        agentRepository.deleteById(id);
    }
}
