
package controller;

import database.ElencoDAO;
import database.FilmeDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.servlet.ServletException;
import model.Elenco;
import model.Filme;

public class FilmeController extends Controller{
    public void tela_alterar() throws ServletException, IOException, SQLException {
        this.request.setAttribute("filme", new FilmeDAO().obter(Integer.parseInt(this.request.getParameter("id"))));
      
    }
    public void excluir() throws ServletException, IOException, SQLException {
        FilmeDAO filmeDao = new FilmeDAO();
        filmeDao.excluir(Integer.parseInt(this.request.getParameter("id")));
        this.redirect(AdministradorController.class, "menuAdmin");
        
    }
    public void tela_adicionar() throws ServletException, IOException, SQLException {
        //redireciona
        
    }
    
    public void alterar() throws ServletException, IOException, SQLException {
        FilmeDAO filmeDao = new FilmeDAO();
        Filme filme = new Filme();
        filme.setId(Integer.parseInt(this.request.getParameter("idFilme")));
        filme.setGenero(this.request.getParameter("genero"));
        filme.setDiretor(this.request.getParameter("diretor"));
        filme.setDuracao(Integer.parseInt(this.request.getParameter("duracao")));
        filme.setFaixaEtaria(Integer.parseInt(this.request.getParameter("faixaEtaria")));
        filme.setSinopse(this.request.getParameter("sinopse"));
        filme.setTitulo(this.request.getParameter("titulo"));
        filme.setTrailer(this.request.getParameter("trailer"));
        filmeDao.editar(filme);
        ElencoDAO elencoDao;
        List<String> atores = new ArrayList();
        atores.addAll(Arrays.asList(this.request.getParameterValues("elenco")));
        List<Integer> ids = new ArrayList();
        for (String parameterValue : this.request.getParameterValues("idElenco")) {
            ids.add(Integer.parseInt(parameterValue));
        }

        for (int i = 0;i < atores.size();i++) {
            filmeDao = new FilmeDAO();
            elencoDao = new ElencoDAO();
            Elenco elenco = new Elenco();
            elenco.setAtor(atores.get(i));
            elenco.setId(ids.get(i));
            elenco.setFilme(filmeDao.obter(Integer.parseInt(this.request.getParameter("idFilme"))));
            elencoDao.editar(elenco);
        }
        this.redirect(AdministradorController.class, "menuAdmin");
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
        for (String ator : atores) {
            filmeDao = new FilmeDAO();
            Elenco elenco = new Elenco();
            elenco.setAtor(ator);
            elenco.setFilme(filmeDao.getLast());
            elencoDao.adicionar(elenco);
        }
        System.out.println("aqui");
        this.redirect(AdministradorController.class, "menuAdmin");
    }
    
}
