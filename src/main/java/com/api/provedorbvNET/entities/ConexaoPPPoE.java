package com.api.provedorbvNET.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "tb_conexaoPPPoe")
@Entity
public class ConexaoPPPoE implements Serializable {

    @Serial
    private  static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String login;

    private String senha;

    private String ip;

    @JsonBackReference
    @ManyToOne
    private Cliente cliente;

    public ConexaoPPPoE(String login, String senha, String ip, Cliente cliente) {
        this.login = login;
        this.senha = senha;
        this.ip = ip;
        this.cliente = cliente;
    }
}
