package com.loja.Roana.dto;

import com.loja.Roana.model.Produto;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class RequisicaoNovoProduto {

    @NotBlank
    private String nomeProduto;

    @NotBlank
    private String precoDeCusto;

    @NotBlank
    private String quantidade;

    private String urlImagem;

    private String descricao;

    public Produto toProduto() {
        Produto produto = new Produto();
        produto.setNome(nomeProduto);
        try{
            BigDecimal precoDeCustoBigDecimal = new BigDecimal(precoDeCusto);
            produto.setValorDeCusto(precoDeCustoBigDecimal);
            produto.setQuantidade(Integer.parseInt(quantidade));
        }catch (Exception e){
            System.out.println(e);
        }
        produto.setUrlImagem(urlImagem);
        produto.setDescricao(descricao);
        return produto;
    }
}
