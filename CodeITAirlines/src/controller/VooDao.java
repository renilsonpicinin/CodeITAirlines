
package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.ConexaoBd;
import model.Voo;

/**
 *
 * @author renilson
 */
public class VooDao {
    private final ConexaoBd conexao;

    public VooDao() {
        conexao = new ConexaoBd();
    }
    
    public void inserirVoo(Voo v){
        conexao.conectar();
        try {
            conexao.setPreparedStatement(conexao.getConnection().prepareStatement("insert into voo (voo_data,voo_hora,aer_id_or,aer_id_dt,"
                    + "avi_id) values (?,?,?,?,?)"));
            conexao.getPreparedStatement().setString(1, v.getData());
            conexao.getPreparedStatement().setString(2, v.getHora());
            conexao.getPreparedStatement().setInt(3, v.getOrigem().getId());
            conexao.getPreparedStatement().setInt(4, v.getDestino().getId());
            conexao.getPreparedStatement().setInt(5, v.getAviao().getId());
            conexao.getPreparedStatement().execute();
            conexao.desconectar();
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar");
            Logger.getLogger(VooDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<Voo> buscarVoos(String data){
        conexao.conectar();
        ArrayList<Voo> voos = new ArrayList<>();
        try {
            conexao.setPreparedStatement(conexao.getConnection().prepareStatement("select * from voo where voo_data like ? order by voo_data"));
            conexao.getPreparedStatement().setString(1, "%"+data+"%");
            conexao.setResultSet(conexao.getPreparedStatement().executeQuery());
            while(conexao.getResultSet().next()){
                voos.add(new Voo(conexao.getResultSet().getInt("voo_id"),
                        conexao.getResultSet().getString("voo_data"),
                        conexao.getResultSet().getString("voo_hora"),
                        null,null,null,null,null
                ));
            }
            conexao.desconectar();
            return voos;
        } catch (SQLException ex) {
            Logger.getLogger(VooDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public Integer buscarVoo (Voo v){
        conexao.conectar();
        Integer voo = 0;
        try {
            conexao.setPreparedStatement(conexao.getConnection().prepareStatement("select * from voo "
                    + "where voo_data like ? and voo_hora like ? "
                    + "and aer_id_or = ? and aer_id_dt = ? and avi_id = ?"
                    + " order by voo_data"));
            conexao.getPreparedStatement().setString(1, v.getData());
            conexao.getPreparedStatement().setString(2, v.getHora());
            conexao.getPreparedStatement().setInt(3, v.getOrigem().getId());
            conexao.getPreparedStatement().setInt(4, v.getDestino().getId());
            conexao.getPreparedStatement().setInt(5, v.getAviao().getId());
            conexao.setResultSet(conexao.getPreparedStatement().executeQuery());
            while(conexao.getResultSet().next()){
                voo = conexao.getResultSet().getInt("voo_id");
            }
            conexao.desconectar();
            return voo;
        } catch (SQLException ex) {
            Logger.getLogger(VooDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
