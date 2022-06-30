/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpr.biorespirar.Models;

import br.edu.ifpr.biorespirar.DAOs.UsuarioDAO;
import br.edu.ifpr.biorespirar.Entities.Usuario;
import java.sql.SQLException;

/**
 *
 * @author otavio
 */
public class ModelUsuario {
    public void add(Usuario u) throws SQLException{
      
       UsuarioDAO dao = new UsuarioDAO();
       dao.adcionar(u);
      
   }
    
    public boolean confirmarSenha(String senha, String confirmarSenha){
        
        if(senha.equals(confirmarSenha)){
            return true;
        }else{
            return false;
        }
        
    }
}
