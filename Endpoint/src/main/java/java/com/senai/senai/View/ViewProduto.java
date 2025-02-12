package com.senai.senai.View;

import com.senai.senai.Controller.BancoController;
import com.senai.senai.Model.Produto;
import org.springframework.web.bind.annotation.*;

@RestController
public class ViewProduto {

    BancoController controller = new BancoController();

    Produto produto ;
    @GetMapping("/produto")
    public Produto getProduto() {
       return produto;
    }


    @PostMapping("/produto")
    public String createProduto(@RequestBody Produto novoProduto) {
        this.produto = novoProduto;
        return "<h1>Produto " + produto.getNomeProduto() + " criado com sucesso!</h1>";
    }

    @PutMapping("/produto")
    public String updateProduto(@RequestBody Produto produtoAtualizado) {
        // Atualizando os dados do produto
        produto.setNomeProduto(produtoAtualizado.getNomeProduto());
        produto.setDescricao(produtoAtualizado.getDescricao());
        produto.setPreco(produtoAtualizado.getPreco());
        produto.setQuantidade(produtoAtualizado.getQuantidade());
        produto.setPontoDeVenda(produtoAtualizado.getPontoDeVenda());
        return "<h1>Produto atualizado com sucesso!</h1>";
    }

    @DeleteMapping("/produto")
    public String deleteProduto() {
        produto = null; // Deletando o produto
        return "<h1>Produto deletado com sucesso!</h1>";
    }
}
