
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
/*
import model.Pessoa;
import database.PessoaDAO;
*/

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
/*
    public void tela_editar() throws ServletException, IOException, SQLException {
        this.request.setAttribute("pessoa", new PessoaDAO().obter(Integer.parseInt(this.request.getParameter("id"))));
    }

    public void adicionar() throws ServletException, IOException, SQLException {
        // depois de executar a função de adicionar - redireciono para a função de listar (que está no mesmo controller)
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(this.request.getParameter("nome"));
        pessoa.setSobrenome(this.request.getParameter("sobrenome"));
        System.out.println("Nome = "+pessoa.getNome() + "  Sobrenome = "+pessoa.getSobrenome());
        PessoaDAO pessoaDao = new PessoaDAO();
        pessoaDao.adicionar(pessoa);
        // momento do redirecionamento
        this.redirect("listar");
    }

    public void excluir() throws ServletException, IOException, SQLException {
        new PessoaDAO().excluir(Integer.parseInt(this.request.getParameter("id")));
        this.redirect(PessoaController.class, "listar");
    }

    public void editar() throws ServletException, IOException, SQLException {
        Pessoa pessoa = new Pessoa();
        pessoa.setId(Integer.parseInt(this.request.getParameter("id")));
        pessoa.setNome(this.request.getParameter("nome"));
        pessoa.setSobrenome(this.request.getParameter("sobrenome"));
        new PessoaDAO().editar(pessoa);
        // a função do redirecionamento recebe Controller.class (neste caso PessoaController) e o method (como String)
        this.redirect(PessoaController.class, "listar");
    }
    
     public void search() throws IOException, SQLException {        
        // como é uma requisicao ajax (não haverá redirecionamento)      
        this.hasPageJsp = false;        
        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        if (!request.getParameter("user").isEmpty()) {
            PessoaDAO pessoaDAO = new PessoaDAO();           
            System.out.println("=================================");
            System.out.println("=================================");
            System.out.println("User:"+request.getParameter("user"));
            System.out.println("=================================");
            System.out.println("=================================");
            Pessoa pessoa = pessoaDAO.buscar(request.getParameter("user"));
            // essa será a string retornada
            if (pessoa.getId()>0) {
                response.getWriter().write("Pessoa encontrada:"+pessoa.getNome()+" "+pessoa.getSobrenome());
            } else {
                response.getWriter().write("Nenhuma pessoa encontrada");
            }
        } else {
           response.getWriter().write("User em branco...");
        }
    }*/
    
}
