package com.senai.senai.Controller;

import com.senai.senai.DataBase.BancoDeProdutos;
import com.senai.senai.Model.Produto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class BancoController {

    BancoDeProdutos banco = new BancoDeProdutos();


    @PostMapping("/adicionar")
    public String adicionarProduto(@RequestBody Produto produto) {
        banco.insert(produto);
        return "Produto " + produto.getNomeProduto() + " adicionado com sucesso!";
    }


    @GetMapping("/listar")
    public List<Produto> listarProdutos() {
        return banco.getAll();
    }


    @PutMapping("/atualizar")
    public String atualizarProduto(@RequestBody Produto produtoAtualizado) {
        banco.update(produtoAtualizado); // Atualiza o produto diretamente com os dados recebidos
        return "Produto atualizado com sucesso!";
    }


    @DeleteMapping("/excluir")
    public String excluirProduto(@RequestBody Produto produto) {
        banco.delete(produto.getId()); // Exclui o produto com o ID fornecido no corpo
        return "Produto com ID " + produto.getId() + " excluído com sucesso!";
    }
}
