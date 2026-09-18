package br.com.fiap.View;

import javax.swing.*;

public class ParkingView {
    static void main() {
        String[] escolha = {"Carro", "Cliente"};
        int opcao;
        CarroView carroView = new CarroView();
        ClienteView clienteView = new ClienteView();
        do {
            try {
                opcao = JOptionPane.showOptionDialog(null, "Escolha Qual opção deseja manipular", "Bem vindo ao menu príncipal!", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, escolha, escolha[0]);
                switch (opcao){
                    case 0:
                        carroView.submenu();
                        break;
                    case 1:
                        clienteView.submenu();
                        break;
                    default:
                        System.out.println("Opção inválida");
                        break;
                }
            } catch (Exception e) {
                System.out.println("ERRO:" + e.getMessage());
            }
        } while(JOptionPane.showConfirmDialog(null, "Ainda deseja continuar?", "Anteção", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0);
        JOptionPane.showMessageDialog(null, "fim do programa....");

    }
}
