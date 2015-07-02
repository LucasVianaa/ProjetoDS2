
package controller;

import database.ElencoDAO;
import database.FilmeDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.servlet.ServletException;
import model.Elenco;
import model.Filme;

public class FilmeController extends Controller{
    public void tela_editar() throws ServletException, IOException, SQLException {
        this.request.setAttribute("filme", new FilmeDAO().obter(Integer.parseInt(this.request.getParameter("id"))));
    }
    public void tela_adicionar() throws ServletException, IOException, SQLException {
        //redirect pra tela_adicionar
    }
    
    public void adicionar() throws ServletException, IOException, SQLException {
        FilmeDAO filmeDao = new FilmeDAO();
        Filme filme = new Filme();
        filme.setGenero(this.request.getParameter("genero"));
        filme.setDiretor(this.request.getParameter("diretor"));
        filme.setDuracao(Integer.parseInt(this.request.getParameter("duracao")));
        filme.setFaixaEtaria(Integer.parseInt(this.request.getParameter("faixaEtaria")));
        filme.setSinopse(this.request.getParameter("sinopse"));
        filme.setTitulo(this.request.getParameter("titulo"));
        filme.setTrailer(this.request.getParameter("trailer"));
        filmeDao.adicionar(filme);
        ElencoDAO elencoDao = new ElencoDAO();
        List<String> atores = new ArrayList();
        atores.addAll(Arrays.asList(this.request.getParameterValues("elenco")));
        Elenco elenco = new Elenco();
        elenco.setAtores(atores);
        elenco.setFilme(filmeDao.getLast());
        elencoDao.adicionar(elenco);
        this.redirect(AdministradorController.class, "menuAdmin");
    }
    
}
