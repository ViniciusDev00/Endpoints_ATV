package com.example.ex1;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

// Classe de usuário

@RestController
public class FirstEndpoint {

    // Instanciando um usuário
    Usuario usl = new Usuario("12345678900", "João Silva", "(11) 98765-4321");

    // Endpoint GET
    @GetMapping("/hello")
    public String getInformations() {
        return "<h1>Bom dia " + usl.getNome() + "!</h1>" +
                "<p>CPF: " + usl.getCpf() + "</p>" +
                "<p>Telefone: " + usl.getTelefone() + "</p>";
    }

    // Endpoint POST
    @PostMapping("/hello")
    public String createUser(@RequestBody Usuario usuario) {
        this.usl = usuario;
        return "<h1>Usuário " + usl.getNome() + " criado com sucesso!</h1>";
    }

    // Endpoint PUT
    @PutMapping("/hello")
    public String updateUser(@RequestBody Usuario usuario) {
        // Atualizando os dados do usuário
        usl.setNome(usuario.getNome());
        usl.setCpf(usuario.getCpf());
        usl.setTelefone(usuario.getTelefone());
        return "<h1>Usuário atualizado com sucesso!</h1>";
    }

    // Endpoint DELETE
    @DeleteMapping("/hello")
    public String deleteUser() {
        usl = null; // Deletando o usuário
        return "<h1>Usuário deletado com sucesso!</h1>";
    }
}
