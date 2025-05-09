package com.Registro.MSCliente.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.Registro.MSCliente.model.cliente;

@Repository
public class clienteRepository {
    
    private Map<Integer, cliente> db = new HashMap<>();
    private int idCounter = 1;

    public cliente guardar(cliente cliente) {
        cliente.setIdCliente(idCounter++);
        db.put(cliente.getIdCliente(), cliente);
        return cliente;
    }

    public cliente buscarPorCorreo(String correoCliente) {
        return db.values().stream()
                .filter(c -> c.getCorreoCliente().equals(correoCliente))
                .findFirst()
                .orElse(null);
    }

    public cliente buscarPorId(int id) {
        return db.get(id);
    }

    public cliente actualizar(cliente cliente) {
        db.put(cliente.getIdCliente(), cliente);
        return cliente;
    }

    public List<cliente> listarTodos() {
        return new ArrayList<>(db.values());
    }
}