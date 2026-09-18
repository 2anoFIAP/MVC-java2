package br.com.fiap.View;

import br.com.fiap.Controller.CarroController;

import javax.swing.*;
import java.awt.*;

public class CarroView {
    //instanciando atributos
    String placa, cor, descricao;
    String[] escolha = {"Inserir","Alterar","Excluir","Listar"};
    int opcao;

    CarroController carroController = new CarroController();
    public String submenu(){
        do {
            try {
                opcao = JOptionPane.showOptionDialog(null, "Escolha uma das opções para manipular um carro", "Escolha", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, escolha, escolha[0]);
                placa = JOptionPane.showInputDialog("Digite a placa do Carro");
                switch (opcao){
                    case 0 :
                        cor = JOptionPane.showInputDialog("Informe a cor do Carro");
                        descricao = JOptionPane.showInputDialog("Informe uma descrição para o Carro");
                        System.out.println(carroController.inserir(placa, cor, descricao));
                        break;
                    case 1:
                        cor = JOptionPane.showInputDialog("Informe a nova cor do Carro");
                        descricao = JOptionPane.showInputDialog("Informe uma nova descrição para o Carro");
                        System.out.println(carroController.alterar(placa, cor, descricao));
                        break;
                    case 2:
                        System.out.println(carroController.excluir(placa));
                        break;
                    case 3:
                        System.out.println(carroController.listarUm(placa));
                        break;
                    default:
                        System.out.println("Opção inválida!");
                        break;
                }
            } catch (Exception e) {
                System.out.println("ERRO:" + e.getMessage());
            }

        } while(JOptionPane.showConfirmDialog(null, "Deseja Continuar?", "Atenção", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0);
        JOptionPane.showMessageDialog(null, "Voltando ao menu principal...");
        return "";
    }
}
