package GUI;

import adeudos.AdeudoComida;
import adeudos.Adeudos;
import cliente.Cliente;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Adeudo2GUI extends JFrame implements ChangeListener {

    private JPanel pnlContenedor,pnlAbajo,pnlBotones,pnlRadio,radioPanel, pnlLista;
    private JTable Table = new JTable();
    private DefaultTableModel modelo;
    private JLabel  nombre, apellido, apellido1, tipoAdeudo, concepto, monto, fecha, descripcion,pagado;
    private JTextField txtNombre, txtApellido1, txtApellido2, txtConcepto, txtMonto, txtFecha,txtDescripcion, txtTipo;
    private JButton registrar, cancelar;
    private ButtonGroup radio;
    private JRadioButton si,no;
    private JList<Cliente>jList;
    private DefaultListModel<Cliente> elementos;
    private GridBagConstraints constraints = new GridBagConstraints();
    public Adeudo2GUI(){
        initComponents();
        initControl();
        setupFrame();
        configLista();
        configContenedor();
        configTable();
        addActionListeners();
        add(pnlContenedor);
    }
    private void initComponents() {
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
        txtTipo = new JTextField();
        txtConcepto = new JTextField();
        txtMonto = new JTextField();
        txtFecha = new JTextField();
        txtDescripcion = new JTextField();

        txtNombre.setEditable(false);
        txtApellido1.setEditable(false);
        txtApellido2.setEditable(false);

        txtTipo.setEditable(false);
        txtConcepto.setEditable(false);
        txtMonto.setEditable(false);
        txtFecha.setEditable(false);
        txtDescripcion.setEditable(false);


        pnlBotones = new JPanel();
        registrar = new JButton("Registrar");
        cancelar = new JButton("Cancelar");


        pnlRadio = new JPanel();
        radioPanel = new JPanel();
        pagado = new JLabel("¿Registrar como pagado?");
        si = new JRadioButton("Si");
        no = new JRadioButton("No");
        radio = new ButtonGroup();

        jList = new JList<>();
        pnlLista = new JPanel();

    }
    private void configLista(){
        elementos = new DefaultListModel<>();
        for (Cliente elemento : ClienteGUI.getClienteArrayList()) {
            elementos.addElement(elemento);
        }
        jList.setModel(elementos);
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
        pnlAbajo.add(txtTipo);
        pnlAbajo.add(new JLabel(""));
        pnlAbajo.add(descripcion);
        pnlAbajo.add(txtDescripcion);

        constraints.gridy = 1;
        pnlContenedor.add(pnlAbajo,constraints);

        pnlRadio.setLayout(new GridLayout(3,1));
        pnlRadio.add(pagado);
        radio.add(si);
        radio.add(no);
        radioPanel.setLayout(new FlowLayout());
        radioPanel.add(si);
        radioPanel.add(no);
        pnlRadio.add(radioPanel);
        pnlRadio.add(new JLabel());



        pnlBotones.setLayout(new FlowLayout());
        pnlBotones.add(registrar);
        pnlBotones.add(cancelar);
        constraints.gridy = 2;
        pnlContenedor.add(pnlRadio,constraints);
        constraints.gridy = 3;
        pnlContenedor.add(pnlBotones,constraints);

        pnlContenedor.add(Table);
    }
    private void setupFrame() {
        setTitle("Registro de nuevo adeudo");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setSize(700, 500);
        setLocationRelativeTo(null);
    }
    private void initControl(){
        modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(AdeudoGUI.Util.titulos);
        Table = new JTable(modelo);
    }
    private void configTable() {
        Table.setGridColor(new Color(88, 214, 141));
        Table.setPreferredScrollableViewportSize(new Dimension(620, 0));
        JScrollPane scrollPane = new JScrollPane(Table);
        getContentPane().add(scrollPane,BorderLayout.CENTER);
    }
    private void addActionListeners() {
        registrar.addActionListener(e -> {
            int x = jList.getSelectedIndex();
            String tipoAdeudo = ClienteGUI.getClienteArrayList().get(x).getAdeudo().getTipo();
            if(si.isSelected() && !(tipoAdeudo.equals("Sin adeudo"))){
                Cliente cliente = (ClienteGUI.getClienteArrayList().get(x));
                cliente.setAdeudos(new Adeudos());
                ClienteGUI.getClienteArrayList().get(x).setAdeudos(new Adeudos("Sin adeudo","","","","",true));
            }
            if(si.isSelected() && (tipoAdeudo.equals("Sin adeudo"))){
                JOptionPane.showMessageDialog(this,"El cliente no tiene adeudos");
            }
            getCliente();
        });
        cancelar.addActionListener(e -> {
            setVisible(false);
            new PrincipalGUI(new MiImagen(26,0));
        });
        jList.addListSelectionListener(e -> {
            getCliente();
        });
        si.addChangeListener(this);
        no.addChangeListener(this);
    }
    private void getCliente(){
        int x = jList.getSelectedIndex();
        txtNombre.setText(ClienteGUI.getClienteArrayList().get(x).getNombre());
        txtApellido1.setText(ClienteGUI.getClienteArrayList().get(x).getApellidos());
        txtApellido2.setText(ClienteGUI.getClienteArrayList().get(x).getApellidos2());

        String tipoAdeudo = ClienteGUI.getClienteArrayList().get(x).getAdeudo().getTipo();
        String concepto = ClienteGUI.getClienteArrayList().get(x).getAdeudo().getConcepto();
        String monto = ClienteGUI.getClienteArrayList().get(x).getAdeudo().getMontoAdeudo();
        String fecha = ClienteGUI.getClienteArrayList().get(x).getAdeudo().getFechaAdeudo();
        String descripcion = ClienteGUI.getClienteArrayList().get(x).getAdeudo().getDescripcion();

        txtTipo.setText(tipoAdeudo);
        txtConcepto.setText(concepto);
        txtMonto.setText(monto);
        txtFecha.setText(fecha);
        txtDescripcion.setText(descripcion);

        //txtTipo.setText(AdeudoComida.getTipoAdeudo());
        /*txtTipo.setText(ClienteGUI.getClienteArrayList().get(x).getNombre());
        txtConcepto.setText(ClienteGUI.getClienteArrayList().get(x).getNombre());
        txtMonto.setText(ClienteGUI.getClienteArrayList().get(x).getNombre());
        txtFecha.setText(ClienteGUI.getClienteArrayList().get(x).getNombre());
        txtDescripcion.setText(ClienteGUI.getClienteArrayList().get(x).getNombre());*/
    }

    @Override
    public void stateChanged(ChangeEvent e) {

    }
}
