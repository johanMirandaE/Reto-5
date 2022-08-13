import view.ReportesView;
import java.awt.*;

import javax.swing.*;

public class App {
  public static void main(String[] args) {

    var reportesView = new ReportesView();
    reportesView.setLayout(new FlowLayout());
    reportesView.setSize(600, 400);
    reportesView.setVisible(true);
    reportesView.setResizable(false);
    reportesView.setTitle(" Reto 5 -INFORMES");
    reportesView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    reportesView.setLocationRelativeTo(null);

  }
}