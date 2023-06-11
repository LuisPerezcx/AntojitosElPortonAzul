package GUI;

import adeudos.Adeudos;
import adeudos.AdeudoRenta;
import cliente.Cliente;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

public class AdeudoGUI extends JFrame implements ItemListener {
    private JPanel pnlContenedor,pnlAbajo,pnlBotones,pnlLista;
    private JTable Table;
    private DefaultTableModel modelo;
    private JLabel  nombre, apellido, apellido1, tipoAdeudo, concepto, monto, fecha, descripcion;
    private JTextField txtNombre, txtApellido1, txtApellido2, txtConcepto, txtMonto, txtFecha,txtDescripcion;
    private JComboBox<String> tipoAdeudoCombo;
    private JButton registrar, cancelar;
    private JList<Cliente>jList;
    private DefaultListModel<Cliente> elementos;
    private GridBagConstraints constraints = new GridBagConstraints();
    public  AdeudoGUI(){
        initComponents();
        initControl();
        setupFrame();
        configLista();
        configContenedor();
        llenarCombo();
        configTable();
        addActionListeners();
        add(pnlContenedor);
    }
    private void initComponents(){
        pnlContenedor = new JPanel();
        pnlAbajo = new JPanel();
        nombre = new JLabel("Nombre del cliente:");
        apellido = new JLabel("Apellido paterno:");
        apellido1 = new JLabel("Apellido materno:");
        tipoAdeudo = new JLabel("Tipo de adeudo:");
        concepto = new JLabel("Concepto de adeudo:");
        monto = new JLabel("Monto de adeudo:");
        fecha = new JLabel("Fecha de adeudo:");
        descripcion = new JLabel("Descripcion:");

        txtNombre = new JTextField();
        txtApellido1 = new JTextField();
        txtApellido2 = new JTextField();

        txtNombre.setEditable(false);
        txtApellido1.setEditable(false);
        txtApellido2.setEditable(false);

        tipoAdeudoCombo = new JComboBox<>();
        txtConcepto = new JTextField();
        txtMonto = new JTextField();
        txtFecha = new JTextField();
        txtDescripcion = new JTextField();

        pnlBotones = new JPanel();
        registrar = new JButton("Registrar");
        cancelar = new JButton("Cancelar");

        pnlLista = new JPanel();
        jList = new JList<>();

    }
    private void configContenedor(){
        pnlContenedor.setLayout(new GridBagLayout());
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weightx = 1.0;

        pnlLista.setLayout(new GridLayout(1,0));
        pnlLista.setPreferredSize(new Dimension(300,200));
        pnlLista.add(jList);
        constraints.gridy = 0;
        pnlContenedor.add(pnlLista,constraints);


        //pnlContenedor.add(Table);
        pnlAbajo.setLayout(new GridLayout(4,5));
        pnlAbajo.add(nombre);
        pnlAbajo.add(txtNombre);
        pnlAbajo.add(new JLabel(""));
        pnlAbajo.add(concepto);
        pnlAbajo.add(txtConcepto);
        pnlAbajo.add(apellido);
        pnlAbajo.add(txtApellido1);
        pnlAbajo.add(new JLabel(""));
        pnlAbajo.add(monto);
        pnlAbajo.add(txtMonto);
        pnlAbajo.add(apellido1);
        pnlAbajo.add(txtApellido2);
        pnlAbajo.add(new JLabel(""));
        pnlAbajo.add(fecha);
        pnlAbajo.add(txtFecha);
        pnlAbajo.add(tipoAdeudo);
        pnlAbajo.add(tipoAdeudoCombo);
        pnlAbajo.add(new JLabel(""));
        pnlAbajo.add(descripcion);
        pnlAbajo.add(txtDescripcion);

        constraints.gridy = 1;
        pnlContenedor.add(pnlAbajo,constraints);

        pnlBotones.setLayout(new FlowLayout());
        pnlBotones.add(registrar);
        pnlBotones.add(cancelar);
        constraints.gridy = 2;
        pnlContenedor.add(pnlBotones,constraints);
        pnlContenedor.add(Table);
    }
    private void setupFrame() {
        setTitle("Registro de nuevo adeudo");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(true);
        setSize(700, 410);
        setLocationRelativeTo(null);
    }
    private void configLista(){
        elementos = new DefaultListModel<>();
        for (Cliente elemento : ClienteGUI.getClienteArrayList()) {
            elementos.addElement(elemento);
        }
        jList.setModel(elementos);
    }
    private void initControl(){
        modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(Util.titulos);
        Table = new JTable(modelo);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {

    }

    public class Util{
        public static String[] titulos={"ID","NOMBRE","APELLIDO 1","APELLIDO 2","TELEFONO","CORREO","DIRECCION"};
        public static String[] tipoAdeudo={"Comida","Renta"};
    }
    private void llenarCombo(){
        String[] stringArrayList = Util.tipoAdeudo;
        for (String s: stringArrayList) {
            tipoAdeudoCombo.addItem(s);
        }
    }
    private void configTable() {
        Table.setGridColor(new Color(88, 214, 141));
        Table.setPreferredScrollableViewportSize(new Dimension(620, 0));
        JScrollPane scrollPane = new JScrollPane(Table);
        getContentPane().add(scrollPane,BorderLayout.CENTER);
    }
    private void addActionListeners() {
        tipoAdeudoCombo.addItemListener(this);
        registrar.addActionListener(e -> {
            registrar();
        });
        cancelar.addActionListener(e -> {
            setVisible(false);
            new PrincipalGUI(new MiImagen(26,0));
        });
        jList.addListSelectionListener(e -> {
            getCliente();
        });
    }

    private void registrar(){
        String tipoAdeudo = (String) tipoAdeudoCombo.getSelectedItem();
        String concepto = txtConcepto.getText();
        String monto = txtMonto.getText();
        String fecha = txtFecha.getText();
        String descripcion = txtDescripcion.getText();
        int x = jList.getSelectedIndex();
        Cliente cliente = ClienteGUI.getClienteArrayList().get(x);

        cliente.setAdeudos(new Adeudos(tipoAdeudo,concepto,monto,fecha,descripcion,false));
        clear();

    }
    private void clear(){
        txtNombre.setText(null);
        txtApellido1.setText(null);
        txtApellido2.setText(null);
        txtConcepto.setText(null);
        txtMonto.setText(null);
        txtFecha.setText(null);
        txtDescripcion.setText(null);
        tipoAdeudoCombo.setSelectedIndex(0);
    }
    private void getCliente(){
        int x = jList.getSelectedIndex();
        txtNombre.setText(ClienteGUI.getClienteArrayList().get(x).getNombre());
        txtApellido1.setText(ClienteGUI.getClienteArrayList().get(x).getApellidos());
        txtApellido2.setText(ClienteGUI.getClienteArrayList().get(x).getApellidos2());
    }
}
