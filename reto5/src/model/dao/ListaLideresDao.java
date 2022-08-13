package model.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.vo.ListaLideresVo;
import util.JDBCUtilities;

public class ListaLideresDao {
  public List<ListaLideresVo> listar() throws SQLException {
    ArrayList<ListaLideresVo> respuesta = new ArrayList<ListaLideresVo>();
    Connection conn = JDBCUtilities.getConnection();
    Statement stmt = null;
    ResultSet rset = null;
    String consulta = "SELECT ID_Lider as id, Nombre, Primer_Apellido as apellido, Ciudad_Residencia as ciudad FROM Lider l ORDER BY Ciudad_Residencia ASC;";
    try {
      stmt = conn.createStatement();
      rset = stmt.executeQuery(consulta);
      while (rset.next()) {
        ListaLideresVo vo = new ListaLideresVo();
        vo.setId(rset.getInt("id"));
        vo.setNombre(rset.getString("Nombre"));
        vo.setApellido(rset.getString("apellido"));
        vo.setCiudad(rset.getString("ciudad"));

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
