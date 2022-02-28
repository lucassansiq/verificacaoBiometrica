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
    
    //Metodo para retornar um boolean se existe o registro no banco
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
    
    // Metodo busca o registro e retorna apenas o nome do usuario para a tela de Menu
    //Fazer o mesmo para retornar o nivel do registro do usuario
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
    
    
    public int nivelUsuario(String login, String senha){
        int nivel = 0;
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

            nivel = rs.getInt("nivel");
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        
        return nivel;
    }
    
    public String fotoUsuario(String login, String senha){
        String foto = null;
        String sql;
        try {
            Connection conn = ConnectionFactory.getConnection();

            sql = "SELECT id,nome,usuario,senha,nivel,foto FROM Usuario WHERE usuario=? and senha=?";
            PreparedStatement ps;
            ps = conn.prepareStatement(sql);
            ps.setString(1, login);
            ps.setString(2, senha);

            ResultSet rs;
            rs = ps.executeQuery();

            foto = rs.getString("foto");
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        
        return foto;
    }

    public int getAcesso() {
        return Acesso;
    }

    public void setAcesso(int Acesso) {
        this.Acesso = Acesso;
    }

}
