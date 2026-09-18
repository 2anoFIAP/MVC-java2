package br.com.fiap.Controller;

import br.com.fiap.Model.Dao.CarroDao;
import br.com.fiap.Model.Dao.ConnectionFactory;
import br.com.fiap.Model.Dto.Carro;

import java.sql.Connection;
import java.sql.SQLException;

public class CarroController {
    //Esse metodo vai receber os três valores vindo da view e vai realizar o metodo de inserir do DAO.
    public String inserir(String placa, String cor, String descricao) throws ClassNotFoundException, SQLException{
        String resultado; //Cria nova variavel.
        Connection con = ConnectionFactory.abrirConexao(); //Abre conexão com o banco de dados.
        Carro carro = new Carro(); //Instancia novo objeto carro.
        //seta os valores do atributo da classe.
        carro.setPlaca(placa);
        carro.setCor(cor);
        carro.setDescricao(descricao);
        CarroDao carroDao = new CarroDao(con); //Instancia novo objeto carroDao para chamar o metodo inserir.
        resultado = carroDao.inserir(carro); //Armazena o metodo de inserção do CarroDao dentro da váriavel resultado.
        ConnectionFactory.fecharConexao(con); //Fecha a conexão.
        return resultado; //Retorna o resultado, se foi possivel ou não inserir um novo carro.
    }

    public String alterar(String placa, String cor, String descricao) throws ClassNotFoundException, SQLException{
        String resultado;
        Connection con = ConnectionFactory.abrirConexao();
        Carro carro = new Carro();
        carro.setPlaca(placa);
        carro.setCor(cor);
        carro.setDescricao(descricao);
        CarroDao carroDao = new CarroDao(con);
        resultado = carroDao.alterar(carro);
        ConnectionFactory.fecharConexao(con);
        return resultado;
    }

    public String excluir(String placa) throws ClassNotFoundException, SQLException{
        String resultado;
        Connection con = ConnectionFactory.abrirConexao();
        Carro carro = new Carro();
        carro.setPlaca(placa);
        CarroDao carroDao = new CarroDao(con);
        resultado = carroDao.excluir(carro);
        ConnectionFactory.fecharConexao(con);
        return resultado;
    }

    public String listarUm(String placa) throws ClassNotFoundException, SQLException{
        String resultado;
        Connection con = ConnectionFactory.abrirConexao();
        Carro carro = new Carro();
        carro.setPlaca(placa);
        CarroDao carroDao = new CarroDao(con);
        resultado = carroDao.listarUm(carro);
        ConnectionFactory.fecharConexao(con);
        return resultado;
    }

}
