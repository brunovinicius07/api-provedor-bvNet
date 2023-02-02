package com.api.provedorbvNET.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDto {

    private String nome;

    private String endereco;

    private Long telefone;

    private String email;

}
