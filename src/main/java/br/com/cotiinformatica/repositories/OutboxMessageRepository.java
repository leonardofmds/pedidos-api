package br.com.cotiinformatica.repositories;

import br.com.cotiinformatica.entities.OutboxMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OutboxMessageRepository extends JpaRepository<OutboxMessage, Integer> {

    @Query("""
            SELECT om FROM OutboxMessage om
            WHERE om.transmitido = false
            """)
    List<OutboxMessage> findByNaoTransmitidos();
}