package br.com.fiap.Model.Dto;

public class Cliente {
    //Criando atributos da classe
    private int idCliente;
    private String nomeCLiente;
    private String placa;

    //Criando construtor vazio
    public Cliente(){}

    //Criando getters e setters
    public int getIdCliente() {
        return idCliente;
    }
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
    public String getNomeCLiente() {
        return nomeCLiente;
    }
    public void setNomeCLiente(String nomeCLiente) {
        this.nomeCLiente = nomeCLiente;
    }
    public String getPlaca() {
        return placa;
    }
    public void setPlaca(String placa) {
        this.placa = placa;
    }
}
