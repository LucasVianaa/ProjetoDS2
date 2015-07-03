
package controller;

import database.AdministradorDAO;
import database.FilmeDAO;
import database.SessaoDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import model.Sessao;


public class AdministradorController extends Controller {


    public void autenticar() throws SQLException, IOException {
        AdministradorDAO administradorDao = new AdministradorDAO();
       
        HttpSession session = this.request.getSession(true);
        session.setAttribute("login", this.request.getParameter("login"));
        session.setAttribute("senha", this.request.getParameter("senha"));
        
        if(administradorDao.autenticar(this.request.getParameter("login"), this.request.getParameter("senha"))){
            this.redirect("menuAdmin");
        }
    }

    public void menuAdmin() throws ServletException, IOException, SQLException {
        this.request.setAttribute("vetSessoes", new SessaoDAO().listar());
        this.request.setAttribute("vetFilmes", new FilmeDAO().listar());
        
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
