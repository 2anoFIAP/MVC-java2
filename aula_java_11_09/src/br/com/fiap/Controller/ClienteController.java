package br.com.fiap.Controller;

import br.com.fiap.Model.Dao.ClienteDao;
import br.com.fiap.Model.Dao.ConnectionFactory;
import br.com.fiap.Model.Dto.Cliente;

import java.sql.Connection;
import java.sql.SQLException;

public class ClienteController {

    public String inserir(int idCliente, String nomeCliente, String placa) throws ClassNotFoundException, SQLException{
        String resultado;
        Connection con = ConnectionFactory.abrirConexao();
        Cliente cliente = new Cliente();
        cliente.setIdCliente(idCliente);
        cliente.setNomeCLiente(nomeCliente);
        cliente.setPlaca(placa);
        ClienteDao clienteDao = new ClienteDao(con);
        resultado = clienteDao.inserir(cliente);
        ConnectionFactory.fecharConexao(con);
        return resultado;
    }

    public String alterar(int idCliente, String nomeCliente, String placa) throws ClassNotFoundException, SQLException{
        String resultado;
        Connection con = ConnectionFactory.abrirConexao();
        Cliente cliente = new Cliente();
        cliente.setIdCliente(idCliente);
        cliente.setNomeCLiente(nomeCliente);
        cliente.setPlaca(placa);
        ClienteDao clienteDao = new ClienteDao(con);
        resultado = clienteDao.alterar(cliente);
        ConnectionFactory.fecharConexao(con);
        return resultado;
    }

    public String excluir(int idCliente) throws ClassNotFoundException, SQLException{
        String resultado;
        Connection con = ConnectionFactory.abrirConexao();
        Cliente cliente = new Cliente();
        cliente.setIdCliente(idCliente);
        ClienteDao clienteDao = new ClienteDao(con);
        resultado = clienteDao.excluir(cliente);
        ConnectionFactory.fecharConexao(con);
        return resultado;
    }

    public String listarUm(int idCliente) throws ClassNotFoundException, SQLException{
        String resultado;
        Connection con = ConnectionFactory.abrirConexao();
        Cliente cliente = new Cliente();
        cliente.setIdCliente(idCliente);
        ClienteDao clienteDao = new ClienteDao(con);
        resultado = clienteDao.listarUm(cliente);
        ConnectionFactory.fecharConexao(con);
        return resultado;
    }

}
