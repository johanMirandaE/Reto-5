package controller;

import java.sql.*;
import java.util.List;

import model.dao.ListaLideresDao;
import model.dao.ComprasRealizadasDao;
import model.dao.ProyectosDao;
import model.vo.ListaLideresVo;
import model.vo.ComprasRealizadasVo;
import model.vo.ProyectosVo;

public class ReportesController {
  private ProyectosDao proyectosDao;
  private ListaLideresDao ListaLideresDao;
  public ComprasRealizadasDao ComprasRealizadasDao;

  public ReportesController() {
    proyectosDao = new ProyectosDao();
    ListaLideresDao = new ListaLideresDao();
    ComprasRealizadasDao = new ComprasRealizadasDao();
  }

  public List<ProyectosVo> listarProyectos() throws SQLException {
    return proyectosDao.listar();
  }

  public List<ComprasRealizadasVo> listarComprasRealizadas() throws SQLException {
    return ComprasRealizadasDao.listar();
  }

  public List<ListaLideresVo> listarLideres() throws SQLException {
    return ListaLideresDao.listar();
  }
}
