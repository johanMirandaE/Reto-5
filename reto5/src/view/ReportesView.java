package view;

import java.util.List;

import javax.swing.*;

import javax.swing.table.*;
import java.awt.event.*;
import java.awt.*;
import controller.ReportesController;
import model.vo.ListaLideresVo;
import model.vo.ComprasRealizadasVo;
import model.vo.ProyectosVo;

public class ReportesView extends JFrame implements ActionListener {
  private static ReportesController controller;

  private JMenuBar menuBar;
  private JMenu menu;

  private JMenuItem primerInf, segundoInf, tercerInf;

  private JTable tabla;

  private DefaultTableModel modelo;
  private JLabel lblTitulo, lblConsulta;

  public ReportesView() {
    controller = new ReportesController();
    menu();
    etiqueta1();
    etiqueta2();
    tabla();

  }

  public void tabla() {
    tabla = new JTable(modelo);
    tabla.setPreferredScrollableViewportSize(new Dimension(500, 200));
    add(tabla);
    JScrollPane pane = new JScrollPane(tabla);
    add(pane);

  }

  public void etiqueta1() {
    lblTitulo = new JLabel("Consultas Reto 5");
    lblTitulo.setPreferredSize(new Dimension(500, 30));
    lblTitulo.setFont(new Font("Arial", Font.BOLD, 20));
    lblTitulo.setForeground(Color.BLACK);
    lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);

    add(lblTitulo);

  }

  public void etiqueta2() {
    lblConsulta = new JLabel();
    lblConsulta.setPreferredSize(new Dimension(500, 30));
    lblConsulta.setFont(new Font("Arial", Font.BOLD, 20));
    add(lblConsulta);

  }

  public void menu() {
    menuBar = new JMenuBar();

    setJMenuBar(menuBar);
    menu = new JMenu("Informes");
    menuBar.add(menu);
    primerInf = new JMenuItem("Primer Informe");
    segundoInf = new JMenuItem("Segundo Informe");
    tercerInf = new JMenuItem("Tercer Informe");
    menu.add(primerInf);
    menu.add(segundoInf);
    menu.add(tercerInf);
    primerInf.addActionListener(this);
    segundoInf.addActionListener(this);
    tercerInf.addActionListener(this);
  }

  public void segundoInforme() {

    try {
      List<ProyectosVo> proyectos = controller.listarProyectos();
      modelo = new DefaultTableModel();
      modelo.addColumn("ID proyecto");
      modelo.addColumn("Constructora");
      modelo.addColumn("Habitaciones");
      modelo.addColumn("Ciudad");
      for (ProyectosVo proyecto : proyectos) {
        Object[] fila = new Object[4];
        fila[0] = proyecto.getId();
        fila[1] = proyecto.getConstructora();
        fila[2] = proyecto.getHabitaciones();
        fila[3] = proyecto.getCiudad();
        modelo.addRow(fila);

      }
      tabla.setModel(modelo);
      modelo.fireTableDataChanged();

    } catch (Exception ex) {
      System.err.println("Error: " + ex);
      ex.printStackTrace();
    }
  }

  public void tercerInforme() {
    try {
      List<ComprasRealizadasVo> Compras = controller.listarComprasRealizadas();
      modelo = new DefaultTableModel();
      modelo.addColumn("ID compra");
      modelo.addColumn("Constructora");
      modelo.addColumn("Banco");
      ;
      for (ComprasRealizadasVo compra : Compras) {
        Object[] fila = new Object[3];
        fila[0] = compra.getId();
        fila[1] = compra.getConstructora();
        fila[2] = compra.getBanco();

        modelo.addRow(fila);

      }
      tabla.setModel(modelo);
      modelo.fireTableDataChanged();

    } catch (Exception ex) {
      System.err.println("Error: " + ex);
      ex.printStackTrace();
    }
  }

  public void primerInforme() {

    try {
      List<ListaLideresVo> Lideres = controller.listarLideres();
      modelo = new DefaultTableModel();
      modelo.addColumn("ID");
      modelo.addColumn("Nombre");
      modelo.addColumn("Apellido");
      modelo.addColumn("Ciudad");
      for (ListaLideresVo lider : Lideres) {
        Object[] fila = new Object[4];
        fila[0] = lider.getId();
        fila[1] = lider.getNombre();
        fila[2] = lider.getApellido();
        fila[3] = lider.getCiudad();
        modelo.addRow(fila);

      }
      tabla.setModel(modelo);
      modelo.fireTableDataChanged();

    } catch (Exception ex) {
      System.err.println("Error: " + ex);
      ex.printStackTrace();
    }
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == primerInf) {
      primerInforme();
      lblConsulta.setText("Consultas Lideres");
    }

    if (e.getSource() == segundoInf) {
      segundoInforme();
      lblConsulta.setText("Consultas Proyectos Casas Campestres");
    }

    if (e.getSource() == tercerInf) {
      tercerInforme();
      lblConsulta.setText("Consultas Compras por Proyectos");
    }

  }

}
