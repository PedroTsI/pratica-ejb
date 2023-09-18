package com.gugawag.pdist.servlets;

import calculadora.CalculadoraIF;
import jakarta.ejb.EJB;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/calculadora.do"})
public class CalculadoraServlet extends HttpServlet {

    @EJB(lookup = "java:global/calculadoraejb-1.0-SNAPSHOT/calculadoraService")
    private CalculadoraIF calculadoraIF;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        String operacao = request.getParameter("oper");
        PrintWriter resposta = response.getWriter();
        switch (operacao){
            case "somar":{
                Integer n1 = Integer.parseInt(request.getParameter("n1"));
                Integer n2 = Integer.parseInt(request.getParameter("n2"));
                resposta.println(calculadoraIF.somar(n1,n2));
            }
        }
    }
}
