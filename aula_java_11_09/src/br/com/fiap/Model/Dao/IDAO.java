package br.com.fiap.Model.Dao;

public interface IDAO {
    //O object é um parametro que aceita todos os tipo de dado. Faz isso para realizar a passagem de qualquer parametro dentro do metodo. já que serão usados em varias classes e terão varios valores passando neles.
    public String inserir(Object object);
    public String alterar(Object object);
    public String excluir(Object object);
    public String listarUm(Object object);
}
