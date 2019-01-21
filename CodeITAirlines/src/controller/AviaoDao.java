/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Aviao;
import model.ConexaoBd;
import model.Empresa;

/**
 *
 * @author renilson
 */
public class AviaoDao {
    
    private ConexaoBd conexao;

    public AviaoDao() {
        conexao = new ConexaoBd();
    }
    
    public void inserirAviao(Aviao a){
        conexao.conectar();
        try {
            conexao.setPreparedStatement(conexao.getConnection().
                    prepareStatement("insert into aviao (avi_modelo,avi_capacidade,emp_id) values (?,?,?)"));
            conexao.getPreparedStatement().setString(1, a.getModelo());
            conexao.getPreparedStatement().setInt(2, a.getCapacidade());
            conexao.getPreparedStatement().setInt(3, a.getEmpresa().getId());
            conexao.getPreparedStatement().execute();
            conexao.desconectar();
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar");
            Logger.getLogger(AviaoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<Aviao> listarAviao(){
        conexao.conectar();
        ArrayList<Aviao> avioes = new ArrayList<>();
        try {
            conexao.setPreparedStatement(conexao.getConnection()
                    .prepareStatement("select * " +
                            "from aviao as av " +
                            "left join empresa as e on av.emp_id = e.emp_id order by avi_modelo"));
            conexao.setResultSet(conexao.getPreparedStatement().executeQuery());
            while(conexao.getResultSet().next()){
                avioes.add(new Aviao(conexao.getResultSet().getInt("avi_id"),
                        conexao.getResultSet().getString("avi_modelo"),
                        new Empresa(conexao.getResultSet().getInt("emp_id"),conexao.getResultSet().getString("emp_nome")),
                        conexao.getResultSet().getInt("avi_capacidade")));
            }
            conexao.desconectar();
            return avioes;
        } catch (SQLException ex) {
            Logger.getLogger(AviaoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Aviao buscarAviao(Integer id) {
        conexao.conectar();
        Aviao aviao;
        try {
            conexao.setPreparedStatement(conexao.getConnection()
                    .prepareStatement("select * " +
                            "from aviao as av " +
                            "inner join empresa as e on av.emp_id = e.emp_id and avi_id = ?"));
            conexao.getPreparedStatement().setInt(1, id);
            conexao.setResultSet(conexao.getPreparedStatement().executeQuery());
            conexao.getResultSet().next();
            aviao = new Aviao(conexao.getResultSet().getInt("avi_id"),
                        conexao.getResultSet().getString("avi_modelo"),
                        new Empresa(conexao.getResultSet().getInt("emp_id"),conexao.getResultSet().getString("emp_nome")),
                        conexao.getResultSet().getInt("avi_capacidade"));
            conexao.desconectar();
            return aviao;
        } catch (SQLException ex) {
            Logger.getLogger(AviaoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public ArrayList<Aviao> buscarAviaoByString(String s){
        conexao.conectar();
        ArrayList<Aviao> avioes = new ArrayList<>();
        try {
            conexao.setPreparedStatement(conexao.getConnection().prepareStatement("select * " +
                            "from aviao as av " +
                            "inner join empresa as e on av.emp_id = e.emp_id and avi_modelo ilike ? order by avi_modelo"));
            conexao.getPreparedStatement().setString(1, "%"+s+"%");
            conexao.setResultSet(conexao.getPreparedStatement().executeQuery());
            while(conexao.getResultSet().next()){
                avioes.add(new Aviao(conexao.getResultSet().getInt("avi_id"),
                        conexao.getResultSet().getString("avi_modelo"),
                        new Empresa(conexao.getResultSet().getInt("emp_id"),conexao.getResultSet().getString("emp_nome")),
                        conexao.getResultSet().getInt("avi_capacidade")));
            }
            conexao.desconectar();
            return avioes;
        } catch (SQLException ex) {
            Logger.getLogger(AviaoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
