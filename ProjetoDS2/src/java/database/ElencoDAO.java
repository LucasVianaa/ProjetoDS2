
package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Elenco;
import model.Filme;
public class ElencoDAO {
    private PreparedStatement obter;
    private PreparedStatement excluir;
    private PreparedStatement atualizar;
    private PreparedStatement adicionar;    

    // Conexao
    private ConexaoPostgreSQL con;

    public ElencoDAO() throws SQLException {
        try {
            this.con = new ConexaoPostgreSQL(); 
            this.obter = con.getConnection().prepareStatement("select * from elenco where id_filme = ?;");
            this.excluir = con.getConnection().prepareStatement("delete from elenco where id = ?;");
            this.atualizar = con.getConnection().prepareStatement("update elenco set nome_ator = ? where id = ?;"); 
            this.adicionar = con.getConnection().prepareStatement("insert into elenco (id_filme, nome_ator) values (?,?);");         
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    public List<Elenco> obter(int idFilme) throws SQLException {
        this.obter.setInt(1, idFilme);
        ResultSet rs = this.obter.executeQuery();
        List<Elenco> elenco = new ArrayList();
        while(rs.next()){
            Elenco linha = new Elenco();
            Filme filme = new Filme();
            filme.setId(idFilme);
            linha.setFilme(filme);
            String ator = rs.getString("nome_ator");
            linha.setId(rs.getInt("id"));
            linha.setAtor(ator);
            elenco.add(linha);
        }
        this.obter.close();
        return elenco;
    }

    public void adicionar(Elenco elenco) {
        try {
            System.out.println(elenco.getAtor());
                this.adicionar.setInt(1, elenco.getFilme().getId());
                this.adicionar.setString(2, elenco.getAtor());
                this.adicionar.execute();     
        } catch (SQLException ex) {
            Logger.getLogger(FilmeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }      
    }

    public void excluir(int id) throws SQLException {
        this.excluir.setInt(1, id);
        this.excluir.execute();
        this.excluir.close();  
    }

    public void editar(Elenco elenco) {
        try {
            
                this.atualizar.setString(1, elenco.getAtor());
                this.atualizar.setInt(2, elenco.getId());
                this.atualizar.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(FilmeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }      
    }
}
