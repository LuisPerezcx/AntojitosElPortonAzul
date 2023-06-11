package GUI;

import adeudos.Adeudos;
import cliente.Cliente;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

public class ClienteGUI extends JFrame implements ChangeListener, ItemListener {
    private JPanel panelContenedor, panelAbajo,pnlAbajo1,pnlAbajo2,radio1,radio2,pnlPie,pnlEstado,pnlCiudad,pnlBtns;
    private final MiImagen miImagen;
    private JButton btnRegresar, btnGuardar;
    private JLabel dPersonales,nombre,aPaterno,aMaterno,contacto,telefono,telefono1,correo,correo1,ubicacion,estado,ciudad,
    colonia,cp;
    private JTextField txtNombre,txtAPaterno,txtAMaterno,txtTelefono,txtCorreo,txtColonia,txtCP;
    private ButtonGroup grupo1,grupo2;
    private JRadioButton si,no,si2,no2;
    private JComboBox<String> estadosCombo;
    private JComboBox<String> ciudadCombo;
    private String direccion = "";
    private static ArrayList<Cliente> clienteArrayList = new ArrayList<>();

    public static ArrayList<Cliente> getClienteArrayList() {
        return clienteArrayList;
    }

    public  ClienteGUI(MiImagen miImagen){
        initComponents();
        initFrame();
        this.miImagen = miImagen;
        setPanelContainer();
        addActionListeners();
        llenarCombo();
        add(panelContenedor);
    }
    private void initComponents(){
        panelContenedor = new JPanel();
        btnRegresar = new JButton("Regresar");
        btnGuardar = new JButton("Guardar");
        panelAbajo = new JPanel();


        dPersonales = new JLabel("DATOS PERSONALES");
        nombre = new JLabel("Nombre del cliente: ");
        aPaterno = new JLabel("Apellido Paterno: ");
        aMaterno = new JLabel("Apellido Materno: ");
        contacto = new JLabel("DATOS DE CONTACTO: ");
        telefono = new JLabel("¿Tiene telefono?");
        telefono1 = new JLabel("Telefono: ");
        correo = new JLabel("¿Tiene Correo?");
        correo1 = new JLabel("Correo: ");
        ubicacion = new JLabel("UBICACION");
        estado = new JLabel("Estado: ");
        ciudad = new JLabel("Ciudad: ");
        colonia = new JLabel("Colonia: ");
        cp = new JLabel("Codigo postal: ");

        txtNombre = new JTextField();
        txtAPaterno = new JTextField();
        txtAMaterno = new JTextField();
        txtTelefono = new JTextField();
        txtCorreo = new JTextField();
        txtColonia = new JTextField();
        txtCP = new JTextField();

        pnlAbajo1 = new JPanel();
        pnlAbajo2 = new JPanel();
        grupo1 = new ButtonGroup();
        grupo2 = new ButtonGroup();
        si = new JRadioButton("si");
        no = new JRadioButton("no");
        si2 = new JRadioButton("si");
        no2 = new JRadioButton("no");

        radio1 = new JPanel();
        radio2 = new JPanel();
        pnlEstado = new JPanel();
        pnlCiudad = new JPanel();

        pnlPie = new JPanel();
        estadosCombo = new JComboBox<>();
        ciudadCombo = new JComboBox<>();

        pnlBtns = new JPanel();
    }
    private void initFrame(){
        setTitle("Registrar Cliente");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        setSize(900,650);
        setVisible(true);
        setLocationRelativeTo(null);
    }
    private void setPanelContainer(){
        panelContenedor.setLayout(new GridLayout(4,1));
        panelContenedor.add(miImagen);

        panelAbajo.setLayout(new GridLayout(1,2));
        pnlAbajo1.setLayout(new GridLayout(5,2));
        pnlAbajo1.add(dPersonales);
        pnlAbajo1.add(new JLabel());
        pnlAbajo1.add(new JLabel());
        pnlAbajo1.add(new JLabel());
        pnlAbajo1.add(nombre);
        pnlAbajo1.add(txtNombre);
        pnlAbajo1.add(aPaterno);
        pnlAbajo1.add(txtAPaterno);
        pnlAbajo1.add(aMaterno);
        pnlAbajo1.add(txtAMaterno);

        pnlAbajo2.setLayout(new GridLayout(5,2));
        pnlAbajo2.add(contacto);
        pnlAbajo2.add(new JLabel());
        pnlAbajo2.add(telefono);
        grupo1.add(si);
        grupo1.add(no);
        radio1.setLayout(new FlowLayout());
        radio1.add(si);
        radio1.add(no);
        pnlAbajo2.add(radio1);

        pnlAbajo2.add(telefono1);
        pnlAbajo2.add(txtTelefono);
        pnlAbajo2.add(correo);
        radio2.setLayout(new FlowLayout());
        grupo2.add(si2);
        grupo2.add(no2);
        radio2.add(si2);
        radio2.add(no2);
        pnlAbajo2.add(radio2);
        pnlAbajo2.add(correo1);
        pnlAbajo2.add(txtCorreo);

        pnlPie.setLayout(new GridLayout(5,4));
        pnlPie.add(ubicacion);
        pnlPie.add(new JLabel());
        pnlPie.add(new JLabel());
        pnlPie.add(new JLabel());

        pnlEstado.setLayout(new FlowLayout());
        pnlEstado.add(estado);
        pnlEstado.add(estadosCombo);
        pnlPie.add(pnlEstado);
        pnlPie.add(new JLabel());
        pnlPie.add(colonia);
        pnlPie.add(txtColonia);

        pnlCiudad.setLayout(new FlowLayout());
        pnlCiudad.add(ciudad);
        pnlCiudad.add(ciudadCombo);
        pnlPie.add(pnlCiudad);
        pnlPie.add(new JLabel());
        pnlPie.add(cp);
        pnlPie.add(txtCP);

        pnlPie.add(new JLabel());
        pnlPie.add(new JLabel());
        pnlPie.add(new JLabel());
        pnlPie.add(new JLabel());
        pnlPie.add(new JLabel());

        pnlBtns.setLayout(new FlowLayout());
        pnlBtns.add(btnRegresar);
        pnlBtns.add(btnGuardar);

        panelAbajo.add(pnlAbajo1);
        panelAbajo.add(pnlAbajo2);
        panelContenedor.add(panelAbajo);
        panelContenedor.add(pnlPie);
        panelContenedor.add(pnlBtns);
    }
    private void addActionListeners(){
        btnGuardar.addActionListener(e -> {
            agregarCliente();
            clearAll();
        });
        btnRegresar.addActionListener(e -> {
            setVisible(false);
            new PrincipalGUI(new MiImagen(26,0));
        });
        si.addChangeListener(this);
        no.addChangeListener(this);
        si2.addChangeListener(this);
        no2.addChangeListener(this);
        ciudadCombo.addItemListener(this);
        estadosCombo.addItemListener(this);
    }
    private void agregarCliente(){
        String nombre = txtNombre.getText();
        String apellido = txtAPaterno.getText();
        String apellido2 = txtAMaterno.getText();
        String colonia = txtColonia.getText();
        String cp = txtCP.getText();
        String tel = txtTelefono.getText();
        String correo = txtCorreo.getText();

        direccion += (" Colonia: " + colonia + " CP: " + cp);
        clienteArrayList.add(new Cliente(nombre,apellido,apellido2,direccion,tel,correo));
        int index = clienteArrayList.size();
        ClienteGUI.getClienteArrayList().get(index-1).setAdeudos(new Adeudos("Sin adeudo","","","","",true));
        mostrar(clienteArrayList);
    }
    private void clearAll(){
        txtNombre.setText(null);
        txtAPaterno.setText(null);
        txtAMaterno.setText(null);
        txtColonia.setText(null);
        txtCP.setText(null);
        txtTelefono.setText(null);
        txtCorreo.setText(null);
        estadosCombo.setSelectedIndex(0);
        ciudadCombo.setSelectedIndex(0);
    }

    public void mostrar(ArrayList<Cliente> lista){
        System.out.println("----------ALUMNOS----------");
        for (Cliente alumno:lista) {
            System.out.println(alumno);
            System.out.println("*********************************************************");
        }
    }

    private void llenarCombo(){
        String[] Estados = Util.estados;
        for (String s: Estados) {
            estadosCombo.addItem(s);
        }
        String[] Ciudades = Util.Ciudad;
        for(String s: Ciudades){
            ciudadCombo.addItem(s);
        }
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        if(no.isSelected()){
            txtTelefono.setEditable(false);
            txtTelefono.setText(null);
        }
        if(si.isSelected()){
            txtTelefono.setEditable(true);
        }
        if(no2.isSelected()){
            txtCorreo.setEditable(false);
            txtCorreo.setText(null);
        }
        if(si2.isSelected()){
            txtCorreo.setEditable(true);
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if(e.getSource() == estadosCombo){
            String item = (String) estadosCombo.getSelectedItem();
            direccion += (" Estado: " + item);
        }
        if(e.getSource() == ciudadCombo){
            String item = (String) ciudadCombo.getSelectedItem();
            direccion += (" Ciudad: " + item);
        }
    }

    public class Util{
        static String[] estados = new String[]{"Aguascalientes", "Baja California", "Baja California Sur", "Campeche", "Coahuila",
                "Colima", "Chiapas", "Chihuahua", "Ciudad de México", "Durango", "Guanajuato", "Guerrero", "Hidalgo", "Jalisco",
                "México", "Michoacán", "Morelos", "Nayarit", "Nuevo León", "Oaxaca", "Puebla", "Querétaro", "Quintana Roo",
                "San Luis Potosí", "Sinaloa", "Sonora", "Tabasco", "Tamaulipas", "Tlaxcala", "Veracruz", "Yucatán", "Zacatecas"};
        static String[] Ciudad  = new String[]{"Ciudad  A", "Ciudad  B", "Ciudad  C", "Ciudad  D", "Ciudad  E", "Ciudad  F",
                "Ciudad  G", "Ciudad  H", "Ciudad  I", "Ciudad  J", "Ciudad  K", "Ciudad  L", "Ciudad  M", "Ciudad  N",
                "Ciudad  O"};
    }
}
