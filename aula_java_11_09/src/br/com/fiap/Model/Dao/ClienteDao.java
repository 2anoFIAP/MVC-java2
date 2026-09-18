package br.com.fiap.Model.Dao;

import br.com.fiap.Model.Dto.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteDao implements IDAO {
    private Connection con;
    private Cliente cliente;

    //Classe de conexão que vai ligar o DAO com o banco de dados
    public ClienteDao(Connection con){
        this.con = con;
    }

    //Retorna a conexão com o banco de dados
    public Connection getCon(){
        return con;
    }

    public String inserir(Object object){
        cliente = (Cliente) object;
        String sql = "insert into ddd_cliente(id_cliente, nome_cliente, placa) values(?, ?, ?)";
        try(PreparedStatement ps = getCon().prepareStatement(sql)) {
            ps.setInt(1, cliente.getIdCliente());
            ps.setString(2, cliente.getNomeCLiente());
            ps.setString(3, cliente.getPlaca());
            if (ps.executeUpdate() > 0) {
                return "Cliente foi inserido no sistema com sucesso!";
            } else{
                return "Não foi possivel inserir o cliente.";
            }
        } catch (SQLException e) {
            return "ERRO: de SQL" + e.getMessage();
        }
    }

    public String alterar(Object object){
        cliente = (Cliente) object;
        String sql = "update ddd_cliente set id_cliente = ?, nome_cliente = ?, placa = ? where id_cliente = ?";
        try(PreparedStatement ps = getCon().prepareStatement(sql)) {
            ps.setInt(1, cliente.getIdCliente());
            ps.setString(2, cliente.getNomeCLiente());
            ps.setString(3, cliente.getPlaca());
            ps.setInt(4, cliente.getIdCliente());
            if (ps.executeUpdate() > 0) {
                return "Informação(ões) do cliente fora(m) alterada(as) com sucesso!";
            } else {
                return "Não foi possivel alterar o cliente.";
            }
        } catch (SQLException e) {
            return "ERRO: erro de SQL " + e.getMessage();
        }
    }

    public String excluir(Object object){
        cliente = (Cliente) object;
        String sql = "delete from ddd_cliente where id_cliente = ?";
        try(PreparedStatement ps = getCon().prepareStatement(sql)) {
            ps.setInt(1, cliente.getIdCliente());
            if (ps.executeUpdate() > 0) {
                return "Cliente excluido com sucesso!";
            } else {
                return "Não foi possivel excluir o cliente citado";
            }
        } catch (SQLException e) {
            return "ERRO: erro de SQL" + e.getMessage();
        }
    }

    public String listarUm(Object object){
        cliente = (Cliente) object;
        String sql = "select * from ddd_cliente where id_cliente = ?";
        try(PreparedStatement ps = getCon().prepareStatement(sql)) {
            ps.setInt(1, cliente.getIdCliente());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return "Cliente encontrado!" + "\nID do cliente: " + cliente.getIdCliente() + "\nNome do cliente: " + rs.getString("nome_cliente") + "\nPlaca do carro: " + rs.getString("placa");
            } else {
                return "Não foi possivel encontrar o cliente para a listagem";
            }
        } catch (SQLException e) {
            return "ERRO: erro de SQL" + e.getMessage();
        }
    }


}
