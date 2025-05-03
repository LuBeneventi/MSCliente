package com.Registro.MSCliente.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class cliente {
    private int idCliente;
    private String nomCliente;
    private String apCliente;
    private String correoCliente;
    private String contraseña;
    private String dirCliente;
    private estadoCliente estado;
}
