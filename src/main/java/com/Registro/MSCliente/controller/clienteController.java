package com.Registro.MSCliente.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Registro.MSCliente.model.cliente;
import com.Registro.MSCliente.model.perfilCliente;
import com.Registro.MSCliente.service.clienteService;


@RestController
@RequestMapping("/api/cliente")
public class clienteController {

    @Autowired
    private clienteService service;

    @PostMapping("/registro")
    public cliente registro(@RequestBody cliente cliente) {
        return service.registrarse(cliente);
    }

     @PostMapping("/login")
    public boolean login(@RequestParam String correo) {
        return service.iniciarSesion(correo);
    }

    @GetMapping("/{id}/perfil")
    public perfilCliente perfil(@PathVariable int id) {
        return service.verPerfil(id);
    }

    @PutMapping("/{id}/desactivar")
    public void desactivar(@PathVariable int id) {
        service.desactivarCuenta(id);
    }

    @PutMapping("/{id}/activar")
    public void activar(@PathVariable int id) {
        service.activarCuenta(id);
    }

    @PutMapping("/{id}/editar")
    public cliente editar(@PathVariable int id, @RequestBody cliente cliente) {
        return service.editarPerfil(id, cliente);
    }


}
