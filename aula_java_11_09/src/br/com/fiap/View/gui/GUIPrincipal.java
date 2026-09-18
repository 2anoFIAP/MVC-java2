import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

private Container contentPane;
private JMenuBar mnBarra;
private JMenu mnArquivo, mnCadastro;
private JMenuItem miSair, miCarro;

public GUIPrincipal() throws HeadlessException {
    inicializarComponentes();
    definirEventos();
}


setTitle("Janela Principal");
setBounds(0, 0, 600, 400);
contentPane = getContentPane();

mnBarra = new JMenuBar();
mnArquivo = new JMenu("Arquivo");
        mnArquivo.setMnemonic('A');
mnCadastro = new JMenu("Cadastro");
        mnCadastro.setMnemonic('C');
miSair = new JMenuItem("Sair", new ImageIcon(getClass().getResource("images/exit_icon.png")));
miCarro = new JMenuItem("Carro");

        setJMenuBar(mnBarra);
        mnBarra.add(mnArquivo);
        mnBarra.add(mnCadastro);
        mnArquivo.add(miSair);
        mnCadastro.add(miCarro);
        miSair.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }
});

private void definirEventos() {
}

private void inicializarComponentes() {
}

void main() {
}

void main() {
}




 