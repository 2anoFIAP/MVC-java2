package br.com.fiap.Model.Dto;

public class Carro {
    //Criando atributos da classe
    private String placa;
    private String cor;
    private String descricao;

    //Criando construtor
    public Carro(){}

    //Adicionando getters e setters
    public String getPlaca() {
        return placa;
    }
    public void setPlaca(String placa) {
        this.placa = placa;
    }
    public String getCor() {
        return cor;
    }
    public void setCor(String cor) {
        this.cor = cor;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
