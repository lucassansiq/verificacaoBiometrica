/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import model.Agrotoxicos;

/**
 *
 * @author Lucas Hype
 */
public class AgrotoxicosDAO implements Persistencia<Agrotoxicos>{
    
private static AgrotoxicosDAO dao = null ;
    
    public AgrotoxicosDAO(){
        
    }
    
    public static AgrotoxicosDAO getInstance(){
        if(dao == null) dao = new AgrotoxicosDAO();
        
        return dao;
    }

    @Override
    public Agrotoxicos findByCodigo(int id) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;
        Agrotoxicos c = null;
        String sql = "SELECT * FROM Agrotoxicos where cdProdutora = ?";
        try{
            pst = con.prepareStatement(sql);
            pst.setInt(1,id);
            rs = pst.executeQuery();
            while (rs.next()){
                int CdProdutora = rs.getInt("cdProdutora");
                String Agrotoxicos = rs.getString("Agrotoxicos");   
                c = new Agrotoxicos(CdProdutora,Agrotoxicos);
            }
            
        }catch(SQLException ex){
            throw new RuntimeException("Erro no Select");
        }finally{
            ConnectionFactory.closeConnection(con, pst, rs);
        }
        return c;
    }
   
    @Override
    public Agrotoxicos findByUsuario(String user){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;
        int codigo = 0;
        Agrotoxicos c = null;
        String sql = "SELECT codigo FROM Produtora where Nome = ?";
        try{
            pst = con.prepareStatement(sql);
            pst.setString(1,user);
            rs = pst.executeQuery();
            codigo = rs.getInt("codigo");                 
            
        }catch(SQLException ex){
            throw new RuntimeException("Erro no Select");
        }finally{
            ConnectionFactory.closeConnection(con, pst, rs);
        }
        
        c = dao.findByCodigo(codigo);
        
        return c;
    }

    @Override
    public void delete(String user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Agrotoxicos obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Agrotoxicos> read() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int create(Agrotoxicos obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
