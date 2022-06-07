package com.loja.Roana.controller;

import com.loja.Roana.model.Produto;
import com.loja.Roana.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping
    String home(Model model){

        List<Produto> produtos = produtoRepository.findAll();
        model.addAttribute("produtos", produtos);

        return "home";
    }
}
