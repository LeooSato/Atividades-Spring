package org.generation.loja.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

@Entity
@Table(name = "tb_produto")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    private String nome;
    @NotNull
    private String console;
    @NotNull
    @Positive
    private BigDecimal preco;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getConsole() {
        return console;
    }

    public void setConsole(String console) {
        this.console = console;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreço(BigDecimal preco) {
        this.preco = preco;
    }

    @ManyToOne
    @JsonIgnoreProperties("produto")
    private Categoria categoria;
}
