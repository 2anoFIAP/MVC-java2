package br.com.fiap.View;

import br.com.fiap.Controller.ClienteController;

import javax.swing.*;

public class ClienteView {
    String nomeCliente, placa;
    String[] escolha = {"Inserir", "Alterar", "Excluir", "Listar"};
    int idCliente, opcao;

    public String submenu(){
        ClienteController clienteController = new ClienteController();
        do {
            try {
                opcao = JOptionPane.showOptionDialog(null, "Escolha uma das opções para manipular um cliente", "Escolha", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, escolha, escolha[0]);
                idCliente = Integer.parseInt(JOptionPane.showInputDialog("Informe o ID do cliente"));
                switch (opcao){
                    case 0:
                        nomeCliente = JOptionPane.showInputDialog("Digite o nome do cliente");
                        placa = JOptionPane.showInputDialog("Digite a placa do cliente");
                        System.out.println(clienteController.inserir(idCliente, nomeCliente, placa));
                        break;
                    case 1:
                        nomeCliente = JOptionPane.showInputDialog("Digite o novo nome do cliente");
                        placa = JOptionPane.showInputDialog("Digite placa do cliente");
                        System.out.println(clienteController.alterar(idCliente, nomeCliente, placa));
                        break;
                    case 2:
                        System.out.println(clienteController.excluir(idCliente));
                        break;
                    case 3:
                        System.out.println(clienteController.listarUm(idCliente));
                        break;
                    default:
                        System.out.println("Opção inválida");
                        break;
                }
            } catch (Exception e) {
                System.out.println("ERRO:" + e.getMessage());
            }
        } while(JOptionPane.showConfirmDialog(null, "Ainda deseja continuar?", "Anteção", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0);
        JOptionPane.showMessageDialog(null, "Voltando ao menu principal");
        return "";
    }
}
