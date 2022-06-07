package com.loja.Roana.controller;

import com.loja.Roana.dto.RequisicaoNovoProduto;
import com.loja.Roana.model.Produto;
import com.loja.Roana.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping("formulario")
    public String formulario(RequisicaoNovoProduto requisicao){
        return "produto/formulario";
    }

    @PostMapping("novo")
    public String novo(@Valid RequisicaoNovoProduto requisicao, BindingResult result){
        if(result.hasErrors()){
            return "produto/formulario";
        }

        Produto produto = requisicao.toProduto();
        produtoRepository.save(produto);

        return "redirect:/home";
    }
}
