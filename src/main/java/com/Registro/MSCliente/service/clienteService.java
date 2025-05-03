package com.Registro.MSCliente.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Registro.MSCliente.model.cliente;
import com.Registro.MSCliente.model.estadoCliente;
import com.Registro.MSCliente.model.perfilCliente;
import com.Registro.MSCliente.repository.clienteRepository;

@Service
public class clienteService {

    @Autowired
    private clienteRepository repo;

    public cliente registrarse(cliente c){
        c.setEstado(estadoCliente.ACTIVO);
        return repo.guardar(c);
    }
    

    public boolean iniciarSesion(String correo, String contraseña) {
        cliente c = repo.buscarPorCorreo(correo);
        return c != null && c.getContraseña().equals(contraseña)
               && c.getEstado() == estadoCliente.ACTIVO;
    }

    public perfilCliente verPerfil(int id) {
        cliente c = repo.buscarPorId(id);
        return c == null ? null : new perfilCliente(
                c.getNomCliente(),
                c.getApCliente(),
                c.getCorreoCliente(),
                c.getDirCliente()
        );
    }

    public void desactivarCuenta(int id) {
        cliente c = repo.buscarPorId(id);
        if (c != null) {
            c.setEstado(estadoCliente.INACTIVO);
            repo.actualizar(c);
        }
    }

    public void activarCuenta(int id) {
        cliente c = repo.buscarPorId(id);
        if (c != null) {
            c.setEstado(estadoCliente.ACTIVO);
            repo.actualizar(c);
        }
    }

    public cliente editarPerfil(int id, cliente nuevosDatos) {
        cliente c = repo.buscarPorId(id);
        if (c != null) {
            c.setNomCliente(nuevosDatos.getNomCliente());
            c.setApCliente(nuevosDatos.getApCliente());
            c.setCorreoCliente(nuevosDatos.getCorreoCliente());
            c.setDirCliente(nuevosDatos.getDirCliente());
            return repo.actualizar(c);
        }
        return null;
    }

    public List<cliente> listarTodos() {
        return repo.listarTodos();
    }
}
