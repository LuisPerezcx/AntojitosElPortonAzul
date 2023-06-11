package GUI;

import javax.swing.*;
import java.awt.*;

public class PrincipalGUI extends JFrame {
    private JPanel panelContenedor,panelBtn1;
    private final MiImagen miImagen;
    private JButton btnCliente,btnRAdeudo,btnCAdeudos;
    private JLabel a,b;
    public  PrincipalGUI(MiImagen miImagen){
        initComponents();
        initFrame();
        this.miImagen = miImagen;
        setPanelContainer();
        addActionListeners();
        add(panelContenedor);
    }
    private void initComponents(){
        panelContenedor = new JPanel();
        btnCliente = new JButton("Registrar nuevo cliente");
        btnRAdeudo = new JButton("Registrar nuevo Adeudo");
        btnCAdeudos = new JButton("Consultar adeudos");
        panelBtn1 = new JPanel();
        a = new JLabel("");
        b = new JLabel("");

    }
    private void initFrame(){
        setTitle("inicio");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(400,500);
        setVisible(true);
        setLocationRelativeTo(null);
    }
    private void setPanelContainer(){
        panelContenedor.setLayout(new GridLayout(2,1));
        panelContenedor.add(miImagen);

        panelBtn1.setLayout(new GridLayout(7,1));
        //btnCliente.setPreferredSize(new Dimension(2,2));

        panelBtn1.add(btnCliente);
        panelBtn1.add(a);
        panelBtn1.add(btnRAdeudo);
        panelBtn1.add(b);
        panelBtn1.add(btnCAdeudos);

        panelContenedor.add(panelBtn1);
    }
    private void addActionListeners(){
        btnCliente.addActionListener(e -> {
            setVisible(false);
            new ClienteGUI(new MiImagen(350,0));
        });
        btnRAdeudo.addActionListener(e -> {
            setVisible(false);
            new AdeudoGUI();
        });
        btnCAdeudos.addActionListener(e -> {
            setVisible(false);
            new Adeudo2GUI();
        });
    }
}
