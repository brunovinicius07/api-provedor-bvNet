package com.api.provedorbvNET.repositories;

import com.api.provedorbvNET.entities.ConexaoPPPoE;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConexaoPPPoERepository extends JpaRepository<ConexaoPPPoE, Long> {
}
