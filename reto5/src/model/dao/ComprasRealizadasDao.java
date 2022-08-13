package model.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.vo.ComprasRealizadasVo;
import util.JDBCUtilities;

public class ComprasRealizadasDao {
  public List<ComprasRealizadasVo> listar() throws SQLException {
    ArrayList<ComprasRealizadasVo> respuesta = new ArrayList<ComprasRealizadasVo>();
    Connection conn = JDBCUtilities.getConnection();
    Statement stm = null;
    ResultSet rs = null;
    String consulta = "SELECT ID_Compra as id, p.Constructora, p.Banco_Vinculado as banco FROM Compra c JOIN Proyecto p ON c.ID_Proyecto = p.ID_Proyecto WHERE Proveedor = 'Homecenter' AND p.Ciudad = 'Salento'";
    try {
      stm = conn.createStatement();
      rs = stm.executeQuery(consulta);
      while (rs.next()) {
        ComprasRealizadasVo vo = new ComprasRealizadasVo();
        vo.setId(rs.getInt("id"));
        vo.setConstructora(rs.getString("constructora"));
        vo.setBanco(rs.getString("banco"));
        respuesta.add(vo);
      }
    } finally {
      if (rs != null) {
        rs.close();
      }
      if (stm != null) {
        stm.close();
      }
      if (conn != null) {
        conn.close();
      }
    }
    return respuesta;
  }
}