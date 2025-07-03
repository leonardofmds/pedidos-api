package br.com.cotiinformatica.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
public class OutboxMessage {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false)
    private LocalDateTime dataHoraCriacao;

    @Column(nullable = false, length = 1000)
    private String mensagem;

    @Column(nullable = false)
    private Boolean transmitido;

}
