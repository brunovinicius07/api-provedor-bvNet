package com.api.provedorbvNET.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConexaoPPPoEDto {
    private String login;

    private String senha;

    private int ip;
}
