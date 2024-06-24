package com.yanis.realestateagency.repository;

import com.yanis.realestateagency.model.Agent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgentRepository extends JpaRepository<Agent, Long> {

}
