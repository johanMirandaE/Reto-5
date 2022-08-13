package model.dao;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;

import model.vo.ProyectosVo;
import util.JDBCUtilities;

public class ProyectosDao {
  public List<ProyectosVo> listar() throws SQLException {
    ArrayList<ProyectosVo> respuesta = new ArrayList<ProyectosVo>();
    Connection conn = JDBCUtilities.getConnection();
    Statement stmt = null;
    ResultSet rset = null;
    String consulta = "SELECT ID_Proyecto as id, Constructora, Numero_Habitaciones as habitaciones, Ciudad FROM Proyecto p WHERE Ciudad IN ('Santa Marta', 'Cartagena', 'Barranquilla') AND Clasificacion = 'Casa Campestre';";
    try {
      stmt = conn.createStatement();

      rset = stmt.executeQuery(consulta);
      while (rset.next()) {
        ProyectosVo vo = new ProyectosVo();
        vo.setId(rset.getInt("id"));
        vo.setConstructora(rset.getString("constructora"));
        vo.setCiudad(rset.getString("ciudad"));
        vo.setHabitaciones((rset.getInt("habitaciones")));

        respuesta.add(vo);
      }
    } finally {
      if (rset != null) {
        rset.close();
      }
      if (stmt != null) {
        stmt.close();
      }
      if (conn != null) {
        conn.close();
      }
    }
    return respuesta;
  }
}
