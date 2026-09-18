package br.com.fiap.Model.Dao;

import br.com.fiap.Model.Dto.Carro;
import oracle.jdbc.proxy.annotation.Pre;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CarroDao implements IDAO {
    //Atributos
    private Connection con;
    private Carro carro;


    public CarroDao(Connection con){
        this.con = con;
    }

    public Connection getCon(){
        return con;
    }

    public String inserir(Object object){
        carro = (Carro) object;
        String sql = "insert into ddd_carro(placa, cor, descricao) values(?, ?, ?)";
        try(PreparedStatement ps = getCon().prepareStatement(sql)) {
            ps.setString(1, carro.getPlaca());
            ps.setString(2, carro.getCor());
            ps.setString(3, carro.getDescricao());
            if (ps.executeUpdate() > 0) {
                return "Carro inserido com sucesso!";
            } else {
                return "Não foi possivel inserir um carro!";
            }
        } catch (SQLException e) {
            return "ERRO: erro de SQL" + e.getMessage();
        }
    }

    public String alterar(Object object){
        carro = (Carro) object;
        String sql = "update ddd_carro set placa = ?, cor = ?, descricao = ? where placa = ?";
        try(PreparedStatement ps = getCon().prepareStatement(sql)) {
            ps.setString(1, carro.getPlaca());
            ps.setString(2, carro.getCor());
            ps.setString(3, carro.getDescricao());
            ps.setString(4, carro.getPlaca());
            if (ps.executeUpdate() > 0) {
                return "Carro alterado com sucesso";
            } else {
                return "Não foi possivel alterar informações do carro";
            }
        } catch (SQLException e) {
            return "ERRO: erro de SQL:" + e.getMessage();
        }
    }

    public String excluir(Object object){
        carro = (Carro) object;
        String sql = "delete from ddd_carro where placa = ?";
        try(PreparedStatement ps = getCon().prepareStatement(sql)) {
            ps.setString(1, carro.getPlaca());
            if (ps.executeUpdate() > 0) {
                return "Carro excuido com sucesso!";
            } else {
                return "Não foi possivel excluir o carro informado!";
            }
        } catch (SQLException e) {
            return "ERRO: erro de SQL:" + e.getMessage();
        }
    }

    public String listarUm(Object object){
        carro = (Carro) object;
        String sql = "select * from ddd_carro where placa = ?";
        try(PreparedStatement ps = getCon().prepareStatement(sql)) {
            ps.setString(1, carro.getPlaca());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) { //.next: Funciona enquanto tiver uma próxima linha preenchida.
                return "Placa: " + carro.getPlaca() + "\nCor: " + rs.getString("cor") + "\nDescrição: " + rs.getString("descricao");
            } else {
                return "Resgistro do carro não encontrado!";
            }
        } catch (Exception e) {
            return "ERRO: erro de SQL" + e.getMessage();
        }

    }

}
