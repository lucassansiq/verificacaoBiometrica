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
import model.InformacoesFiscais;
import model.Produtora;

/**
 *
 * @author Lucas Hype
 */
public class InformacoesFiscaisDAO implements dao.Persistencia<InformacoesFiscais> {

    @Override
    public int create(InformacoesFiscais obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static InformacoesFiscaisDAO dao = null ;
    
    public InformacoesFiscaisDAO(){
        
    }
    
    public static InformacoesFiscaisDAO getInstance(){
        if(dao == null) dao = new InformacoesFiscaisDAO();
        
        return dao;
    }

    @Override
    public InformacoesFiscais findByCodigo(int id) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;
        InformacoesFiscais c = null;
        String sql = "SELECT * FROM InformacoesFiscais where cdProdutora = ?";
        try{
            pst = con.prepareStatement(sql);
            pst.setInt(1,id);
            rs = pst.executeQuery();
            while (rs.next()){
                int CdProdutora = rs.getInt("cdProdutora");
                String incentivosFiscais = rs.getString("incentivosFiscais");
                String impostosMunicipais = rs.getString("impostosMunicipais");
                String impostosEstaduais = rs.getString("impostosEstaduais");
                String impostosFederais = rs.getString("impostosFederais");
                String taxasFederais = rs.getString("taxasFederais");                
                c = new InformacoesFiscais(CdProdutora,incentivosFiscais,impostosMunicipais,impostosEstaduais,impostosFederais,taxasFederais);
            }
            
        }catch(SQLException ex){
            throw new RuntimeException("Erro no Select");
        }finally{
            ConnectionFactory.closeConnection(con, pst, rs);
        }
        return c;
    }
   
    @Override
    public InformacoesFiscais findByUsuario(String user){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;
        int codigo = 0;
        InformacoesFiscais c = null;
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
    public void update(InformacoesFiscais obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<InformacoesFiscais> read() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
