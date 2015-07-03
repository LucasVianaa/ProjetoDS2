
package controller;

import database.FilmeDAO;
import database.SessaoDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import model.Sessao;

public class SessaoController extends Controller{
    
    public void listar() throws ServletException, IOException, SQLException {
        if(request.getSession().getAttribute("login") == null){
            RequestDispatcher rd = request.getRequestDispatcher("/index.html");
            rd.forward(request, response);
        }else{
            this.request.setAttribute("vetSessoes", new SessaoDAO().listar());

            ArrayList<String> dataInicio = new ArrayList();
            ArrayList<String> dataFim = new ArrayList();
            ArrayList<String> horaInicio = new ArrayList();
            ArrayList<String> horaFim = new ArrayList();
            for(Sessao sessao : new SessaoDAO().listar()){
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                String totalInicio;
                totalInicio = sdf.format(sessao.getHoraInicio().getTime());
                dataInicio.add(totalInicio.split(" ")[0]);
                horaInicio.add(totalInicio.split(" ")[1]);

                 String totalFim;
                totalFim = sdf.format(sessao.getHoraFim().getTime());
                dataFim.add(totalFim.split(" ")[0]);
                horaFim.add(totalFim.split(" ")[1]);

            }
            this.request.setAttribute("dataInicio", dataInicio);
            this.request.setAttribute("horaInicio", horaInicio);
            this.request.setAttribute("dataFim", dataFim);
            this.request.setAttribute("horaFim", horaFim);
        
        }
    }
    
    public void tela_alterar() throws ServletException, IOException, SQLException {
        if(request.getSession().getAttribute("login") == null){
            RequestDispatcher rd = request.getRequestDispatcher("/index.html");
            rd.forward(request, response);
        }else{
            Sessao now = new SessaoDAO().obter(Integer.parseInt(this.request.getParameter("id")));
             this.request.setAttribute("filmes", new FilmeDAO().listar());
             this.request.setAttribute("sessao", now);
             SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
             String total;
             total = sdf.format(now.getHoraInicio().getTime());

             this.request.setAttribute("data", total.split(" ")[0]);
             this.request.setAttribute("hora", total.split(" ")[1]);
         
        }
    }
    
    public void alterar() throws ServletException, IOException, SQLException, ParseException {
        if(request.getSession().getAttribute("login") == null){
            RequestDispatcher rd = request.getRequestDispatcher("/index.html");
            rd.forward(request, response);
        }else{
            Sessao sessao = new Sessao();
            sessao.setIts3d(Boolean.parseBoolean(this.request.getParameter("3d")));
            sessao.setItsLegendado(Boolean.parseBoolean(this.request.getParameter("legendado")));
            sessao.setFilme(new FilmeDAO().obter(Integer.parseInt(this.request.getParameter("filme"))));
            sessao.setPrecoAdulto(Double.parseDouble(this.request.getParameter("precoAdulto")));
            sessao.setPrecoEstudante(Double.parseDouble(this.request.getParameter("precoEstudante")));
            sessao.setPrecoIdoso(Double.parseDouble(this.request.getParameter("precoIdoso")));
            sessao.setId(Integer.parseInt(this.request.getParameter("id")));
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            Calendar horaInicio  = Calendar.getInstance();
            horaInicio.setTime(df.parse(this.request.getParameter("data")+" "+this.request.getParameter("hora")));
            Date intermedio = horaInicio.getTime();
            Calendar horaFim  = Calendar.getInstance();
            horaFim.setTime(intermedio);
            horaFim.add(Calendar.MINUTE, sessao.getFilme().getDuracao());
            sessao.setHoraFim(horaFim);
            sessao.setHoraInicio(horaInicio);
            sessao.setSala(Integer.parseInt(this.request.getParameter("sala")));
            SessaoDAO sessaoDao = new SessaoDAO();
           sessaoDao.editar(sessao);
            this.redirect(AdministradorController.class, "menuAdmin");
        }

    }
    
    public void tela_adicionar() throws ServletException, IOException, SQLException {
        if(request.getSession().getAttribute("login") == null){
            RequestDispatcher rd = request.getRequestDispatcher("/index.html");
            rd.forward(request, response);
        }else{
            this.request.setAttribute("filmes", new FilmeDAO().listar());
        }
    }
     public void adicionar() throws ServletException, IOException, SQLException, ParseException {
         if(request.getSession().getAttribute("login") == null){
            RequestDispatcher rd = request.getRequestDispatcher("/index.html");
            rd.forward(request, response);
        }else{
            Sessao sessao = new Sessao();
            sessao.setIts3d(Boolean.parseBoolean(this.request.getParameter("3d")));
            sessao.setItsLegendado(Boolean.parseBoolean(this.request.getParameter("legendado")));
            sessao.setFilme(new FilmeDAO().obter(Integer.parseInt(this.request.getParameter("filme"))));
            sessao.setPrecoAdulto(Double.parseDouble(this.request.getParameter("precoAdulto")));
            sessao.setPrecoEstudante(Double.parseDouble(this.request.getParameter("precoEstudante")));
            sessao.setPrecoIdoso(Double.parseDouble(this.request.getParameter("precoIdoso")));
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            Calendar horaInicio  = Calendar.getInstance();
            horaInicio.setTime(df.parse(this.request.getParameter("data")+" "+this.request.getParameter("hora")));
            Date intermedio = horaInicio.getTime();
            Calendar horaFim  = Calendar.getInstance();
            horaFim.setTime(intermedio);
            horaFim.add(Calendar.MINUTE, sessao.getFilme().getDuracao());
            sessao.setHoraFim(horaFim);
            sessao.setHoraInicio(horaInicio);
            sessao.setSala(Integer.parseInt(this.request.getParameter("sala")));
            SessaoDAO sessaoDao = new SessaoDAO();
            sessaoDao.adicionar(sessao);
            this.redirect(AdministradorController.class, "menuAdmin");
         }

    }
     
    public void excluir() throws ServletException, IOException, SQLException {
        if(request.getSession().getAttribute("login") == null){
            RequestDispatcher rd = request.getRequestDispatcher("/index.html");
            rd.forward(request, response);
        }else{
            SessaoDAO sessaoDao = new SessaoDAO();
            sessaoDao.excluir(Integer.parseInt(this.request.getParameter("id")));
            this.redirect(AdministradorController.class, "menuAdmin");
        }
        
    }
    
}
