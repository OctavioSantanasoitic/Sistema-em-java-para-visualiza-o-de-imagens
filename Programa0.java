
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Programa0 extends JFrame
        implements WindowListener, ActionListener {

    JButton botaoPrimeira, botaoUltima,
            botaoProxima, botaoAnterior;
    
    Dimension dimensaoMonitor; 
    int largura, altura, indice;
    
    ImageIcon[] listaImagens;
    JLabel[] imagens;

    public Programa0() {
        
        dimensaoMonitor = Toolkit.getDefaultToolkit().getScreenSize();
	largura = dimensaoMonitor.width;
	altura = dimensaoMonitor.height;

        System.out.println("Iniciando em Java...");
	System.out.println("Largura = " + largura);
	System.out.println("Altura  = " + altura);
                
        getContentPane().setLayout(null);
        setBounds(0, 0, largura/2, altura/2);
        altura = altura / 2;
        setResizable(false);
        setTitle("Nosso programa de referência");
        getContentPane().setBackground(Color.darkGray);

        botaoPrimeira = new JButton("Primeira Imagem");
        botaoPrimeira.setBounds(20, altura - 60, 140, 25);
        botaoPrimeira.setBackground(Color.darkGray);
        botaoPrimeira.setForeground(Color.lightGray);
        botaoPrimeira.addActionListener(this);

        botaoUltima = new JButton("Última Imagem");
        botaoUltima.setBounds(170, altura - 60, 140, 25);
        botaoUltima.setBackground(Color.darkGray);
        botaoUltima.setForeground(Color.lightGray);
        botaoUltima.addActionListener(this);
        botaoUltima.setEnabled(false);

        botaoProxima = new JButton("Proxima Imagem");
        botaoProxima.setBounds(320, altura - 60, 140, 25);
        botaoProxima.setBackground(Color.darkGray);
        botaoProxima.setForeground(Color.lightGray);
        botaoProxima.addActionListener(this);
        botaoProxima.setEnabled(false);

        botaoAnterior = new JButton("Imagem Anterior");
        botaoAnterior.setBounds(470, altura - 60, 140, 25);
        botaoAnterior.setBackground(Color.darkGray);
        botaoAnterior.setForeground(Color.lightGray);
        botaoAnterior.addActionListener(this);
        botaoAnterior.setEnabled(false);

        // Preparando as imagens
        listaImagens = new ImageIcon[3];
        imagens = new JLabel[3];
        
        listaImagens[0] = new ImageIcon("imagem1.jpg");
        listaImagens[0].setImage(listaImagens[0].getImage().getScaledInstance(300, 300, 100));
        listaImagens[1] = new ImageIcon("imagem2.gif");
        listaImagens[1].setImage(listaImagens[1].getImage().getScaledInstance(300, 300, 100));
        listaImagens[2] = new ImageIcon("imagem3.jpg");
        listaImagens[2].setImage(listaImagens[2].getImage().getScaledInstance(300, 300, 100));

        imagens[0] = new JLabel(listaImagens[0]);
        imagens[1] = new JLabel(listaImagens[1]);
        imagens[2] = new JLabel(listaImagens[2]);
        
        imagens[0].setBounds((largura/4)-150,10,300,300);
        imagens[1].setBounds((largura/4)-150,10,300,300);
        imagens[2].setBounds((largura/4)-150,10,300,300);
        
        getContentPane().add(botaoPrimeira);
        getContentPane().add(botaoUltima);
        getContentPane().add(botaoProxima);
        getContentPane().add(botaoAnterior);
        
        getContentPane().add(imagens[0]);
        indice = 0;

        addWindowListener(this);
    }

    public static void main(String args[]) {
        Programa0 aplicacao = new Programa0();
        aplicacao.setVisible(true);
    }

    @Override
    public void windowOpened(WindowEvent we) {
    }

    @Override
    public void windowClosing(WindowEvent we) {
        this.dispose();
        System.exit(1);
    }

    @Override
    public void windowClosed(WindowEvent we) {
        //this.dispose();
        //System.exit(1);
    }

    @Override
    public void windowIconified(WindowEvent we) {
    }

    @Override
    public void windowDeiconified(WindowEvent we) {
    }

    @Override
    public void windowActivated(WindowEvent we) {
    }

    @Override
    public void windowDeactivated(WindowEvent we) {
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == botaoPrimeira) {
            System.out.println("Primeira...");
            botaoUltima.setEnabled(true);
            botaoProxima.setEnabled(true);
            botaoAnterior.setEnabled(true);
            
            getContentPane().remove(imagens[indice]);
            indice = 0;
            getContentPane().add(imagens[indice]);
            getContentPane().repaint();
        }

        if (evento.getSource() == botaoUltima) {
            System.out.println("Última...");
            getContentPane().remove(imagens[indice]);
            indice = 2;
            getContentPane().add(imagens[indice]);
            getContentPane().repaint();
        }

        if (evento.getSource() == botaoProxima) {
            System.out.println("Próxima...");
            getContentPane().remove(imagens[indice]);
            if (indice == 2)
                indice = 0;
            else
                indice++;
            getContentPane().add(imagens[indice]);
            getContentPane().repaint();
        }

        if (evento.getSource() == botaoAnterior) {
            System.out.println("Anterior...");
            getContentPane().remove(imagens[indice]);
            if (indice == 0)
                indice = 2;
            else
                indice--;
            getContentPane().add(imagens[indice]);
            getContentPane().repaint();
        }
    }
}
