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
import model.Cargo;
import model.ConexaoBd;
import model.Empresa;

/**
 *
 * @author renilson
 */
public class EmpresaDao {
    private ConexaoBd conexao;

    public EmpresaDao() {
        conexao = new ConexaoBd();
    }
    
    public ArrayList<Empresa> listarEmpresa(){
        conexao.conectar();
        ArrayList<Empresa> empresa = new ArrayList<>();
        try {
            conexao.setPreparedStatement(conexao.getConnection()
                    .prepareStatement("select * from empresa order by emp_nome"));
            conexao.setResultSet(conexao.getPreparedStatement().executeQuery());
            while(conexao.getResultSet().next()){
                empresa.add(new Empresa(conexao.getResultSet().getInt("emp_id"),
                        conexao.getResultSet().getString("emp_nome")));
            }
            conexao.desconectar();
            return empresa;
        } catch (SQLException ex) {
            Logger.getLogger(EmpresaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
