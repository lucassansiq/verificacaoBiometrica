/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import view.Login;

/**
 *
 * @author Lucas Hype
 */
public class Principal {
    
    public static void main(String[] args) {
        //Verificar se o caminho está correto
        //System.out.println("jdbc:sqlite:" + System.getProperty("user.dir") + "\\db\\verificacaoBiometrica.db");
        dao.ConnectionFactory.getConnection();
        Login login = new Login();
        login.setVisible(true);
    }

}
