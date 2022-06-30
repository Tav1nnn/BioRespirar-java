/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package br.edu.ifpr.biorespirar.Servlet;

import br.edu.ifpr.biorespirar.Entities.Usuario;
import br.edu.ifpr.biorespirar.Models.ModelUsuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author otavio
 */
@WebServlet(name = "Cadastro", urlPatterns = {"/Cadastro"})
public class Cadastro extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.getRequestDispatcher("WEB-INF/cadastro.jsp").
                forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nome, email, senha, confirmarSenha;
         
        nome = request.getParameter("nome");
        email = request.getParameter("email");
        senha = request.getParameter("senha");
        confirmarSenha = request.getParameter("confirmarSenha");
        
        System.out.println(nome);
        
        ModelUsuario model = new ModelUsuario();
        
        Usuario u = new Usuario(nome, email, senha);
        
        if (model.confirmarSenha(senha, confirmarSenha)== true) {
    
            try {
                model.add(u);
                request.getRequestDispatcher("WEB-INF/cadastro.jsp").
                forward(request, response);
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            } 
            
        }else{
            request.getRequestDispatcher("WEB-INF/teste.jsp").
                forward(request, response);
        }
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void processRequest(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
