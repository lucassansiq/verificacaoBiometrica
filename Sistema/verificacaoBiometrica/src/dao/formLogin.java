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
import javax.swing.JOptionPane;

/**
 *
 * @author Lucas Hype
 */
public class formLogin {
    
    private int Acesso;
    
    public boolean consultar(String login, String senha) {
        boolean autenticado = false;
        String sql;
        try {
            Connection conn = ConnectionFactory.getConnection();

            sql = "SELECT id,nome,usuario,senha,nivel FROM Usuario WHERE usuario=? and senha=?";
            PreparedStatement ps;
            ps = conn.prepareStatement(sql);
            ps.setString(1, login);
            ps.setString(2, senha);

            ResultSet rs;
            rs = ps.executeQuery();

            if (rs.next()) {                
                autenticado = true;
            } else {
                ps.close();
                return autenticado;
            }
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        
        
        return autenticado;
    }
    
    public String nomeUsuario(String login, String senha){
        String nome = null;
        String sql;
        try {
            Connection conn = ConnectionFactory.getConnection();

            sql = "SELECT id,nome,usuario,senha,nivel FROM Usuario WHERE usuario=? and senha=?";
            PreparedStatement ps;
            ps = conn.prepareStatement(sql);
            ps.setString(1, login);
            ps.setString(2, senha);

            ResultSet rs;
            rs = ps.executeQuery();

            nome = rs.getString("nome");
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        
        return nome;
    }

    public int getAcesso() {
        return Acesso;
    }

    public void setAcesso(int Acesso) {
        this.Acesso = Acesso;
    }

}
