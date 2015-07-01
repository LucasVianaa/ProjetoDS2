
package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Elenco;
public class ElencoDAO {
    private PreparedStatement buscarPorFilmeENome;
    private PreparedStatement obter;
    private PreparedStatement excluir;
    private PreparedStatement atualizar;
    private PreparedStatement adicionar;    

    // Conexao
    private ConexaoPostgreSQL con;

    public ElencoDAO() throws SQLException {
        try {
            this.con = new ConexaoPostgreSQL();
            this.buscarPorFilmeENome = con.getConnection().prepareStatement("select * from elenco where id_filme = ? and nome_ator = ?;");
            this.obter = con.getConnection().prepareStatement("select * from elenco where id_filme = ?;");
            this.excluir = con.getConnection().prepareStatement("delete from elenco where id = ?;");
            this.atualizar = con.getConnection().prepareStatement("update elenco set nome_ator = ? where id_filme = ?;"); 
            this.adicionar = con.getConnection().prepareStatement("insert into elenco (id_filme, nome_ator) values (?,?);");         
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    public Elenco obter(int id) throws SQLException {
        this.obter.setInt(1, id);
        ResultSet rs = this.obter.executeQuery();
        Elenco elenco = new Elenco();
        FilmeDAO filmeDao = new FilmeDAO();
        elenco.setFilme(filmeDao.obter(id));
        List<String> atores = new ArrayList();
        while(rs.next()){
            atores.add(rs.getString("nome_ator"));
        }
        elenco.setAtores(atores);
        this.obter.close();
        return elenco;
    }

    public void adicionar(Elenco elenco) {
        try {
            for (String ator : elenco.getAtores()) {
                this.adicionar.setInt(1, elenco.getFilme().getId());
                this.adicionar.setString(2, ator);
                this.adicionar.execute();
            }
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
            for (String ator : elenco.getAtores()) {
                this.atualizar.setInt(2, elenco.getFilme().getId());
                this.atualizar.setString(1, ator);
                this.atualizar.execute();
            }
        } catch (SQLException ex) {
            Logger.getLogger(FilmeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }      
    }


    public int buscar(int idFilme, String nomeAtor) throws SQLException {
        this.buscarPorFilmeENome.setInt(1, idFilme);
        this.buscarPorFilmeENome.setString(1, nomeAtor);
        ResultSet rs = this.buscarPorFilmeENome.executeQuery();
        int id = 0;
        if (rs.next()) {
            id = rs.getInt("id");
        }
        this.buscarPorFilmeENome.close();
        return id;
    }
}
