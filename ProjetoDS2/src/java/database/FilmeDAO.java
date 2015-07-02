
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

public class FilmeDAO {
    private PreparedStatement listar;
    private PreparedStatement obter;
    private PreparedStatement excluir;
    private PreparedStatement atualizar;
    private PreparedStatement adicionar;    
    private PreparedStatement buscar;

    // Conexao
    private ConexaoPostgreSQL con;
    private PreparedStatement last;

    public FilmeDAO() throws SQLException {
        try {
            this.con = new ConexaoPostgreSQL();
            this.obter = con.getConnection().prepareStatement("select * from filme where id = ?;");
            this.buscar = con.getConnection().prepareStatement("select * from filme where titulo ilike ?;");
            this.listar = con.getConnection().prepareStatement("select * from filme order by titulo;");
            this.excluir = con.getConnection().prepareStatement("delete from filme where id = ?;");
            this.atualizar = con.getConnection().prepareStatement("update filme set titulo = ?, genero = ?, duracao = ?, faixa_etaria = ?, sinopse = ?, trailer = ?, diretor = ? where id = ?;"); 
            this.adicionar = con.getConnection().prepareStatement("insert into filme (titulo, genero, duracao, faixa_etaria, sinopse, trailer, diretor) values (?,?,?,?,?,?,?) returning id;");         
            this.last = con.getConnection().prepareStatement("select * from filme order by id desc limit 1;");         
        
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }
    public Filme getLast() throws SQLException {
        ResultSet rs = this.last.executeQuery();
        Filme filme = new Filme();
        
        if(rs.next()){

            filme.setId(rs.getInt("id"));
            filme.setTitulo(rs.getString("titulo"));
            filme.setGenero(rs.getString("genero"));
            filme.setDuracao(rs.getInt("duracao"));
            filme.setFaixaEtaria(rs.getInt("faixa_etaria"));
            filme.setSinopse(rs.getString("sinopse"));
            filme.setTrailer(rs.getString("trailer"));
            filme.setDiretor(rs.getString("diretor"));
            
        }
        
        this.last.close();
        return filme;
    }

    public Filme obter(int id) throws SQLException {
        
        this.obter.setInt(1, id);
        ResultSet rs = this.obter.executeQuery();
        Filme filme = new Filme();
        
        if(rs.next()){

            filme.setId(rs.getInt("id"));
            filme.setTitulo(rs.getString("titulo"));
            filme.setGenero(rs.getString("genero"));
            filme.setDuracao(rs.getInt("duracao"));
            filme.setFaixaEtaria(rs.getInt("faixa_etaria"));
            filme.setSinopse(rs.getString("sinopse"));
            filme.setTrailer(rs.getString("trailer"));
            filme.setDiretor(rs.getString("diretor"));
            ElencoDAO elencoDao = new ElencoDAO();
            List<Elenco> elenco = elencoDao.obter(rs.getInt("id"));
            filme.setElenco(elenco);
            
            
        }
        
        this.obter.close();
        return filme;
    }

    public ArrayList<Filme> listar() throws SQLException {
        ArrayList<Filme> todos = new ArrayList();
        ResultSet rs;
        try {
            rs = this.listar.executeQuery();
            while (rs.next()) {
                ElencoDAO elencoDao = new ElencoDAO();
                List<Elenco> elenco = elencoDao.obter(rs.getInt("id"));
                todos.add(new Filme(rs.getInt("duracao"), rs.getInt("faixa_etaria"), rs.getInt("id"), rs.getString("trailer"), rs.getString("genero"), rs.getString("diretor"), rs.getString("sinopse"), rs.getString("titulo"), elenco));
                
            }
            this.listar.close();
        } catch (SQLException e) {
            return todos;
        }
        return todos;
    }

    public boolean adicionar(Filme filme) {
        try {
            this.adicionar.setString(1, filme.getTitulo());
            this.adicionar.setString(2, filme.getGenero());
            this.adicionar.setInt(3, filme.getDuracao());
            this.adicionar.setInt(4, filme.getFaixaEtaria());
            this.adicionar.setString(5, filme.getSinopse());
            this.adicionar.setString(6, filme.getTrailer());
            this.adicionar.setString(7, filme.getDiretor());
            return this.adicionar.execute();
        } catch (SQLException ex) {
            Logger.getLogger(FilmeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }      
        return false;
    }

    public void excluir(int id) throws SQLException {
        this.excluir.setInt(1, id); // deletando os dependentes
        this.excluir.execute();
        this.excluir.close();
    }

    public boolean editar(Filme filme) {
        try {
            this.atualizar.setString(1, filme.getTitulo());
            this.atualizar.setString(2, filme.getGenero());
            this.atualizar.setInt(3, filme.getDuracao());
            this.atualizar.setInt(4, filme.getFaixaEtaria());
            this.atualizar.setString(5, filme.getSinopse());
            this.atualizar.setString(6, filme.getTrailer());
            this.atualizar.setString(7, filme.getDiretor());
            this.atualizar.setInt(8, filme.getId());
            this.atualizar.execute();
            this.atualizar.close();
            return true;
        } catch (SQLException erro) {
            return false;
        }
    }
    
    public Filme buscar(String titulo) throws SQLException {
        this.buscar.setString(1, "%"+titulo.trim()+"%");
        ResultSet rs = this.buscar.executeQuery();
        Filme filme = new Filme();
        if (rs.next()) {
            filme.setId(rs.getInt("id"));
            filme.setTitulo(rs.getString("titulo"));
            filme.setGenero(rs.getString("genero"));
            filme.setDuracao(rs.getInt("duracao"));
            filme.setFaixaEtaria(rs.getInt("faixa_etaria"));
            filme.setSinopse(rs.getString("sinopse"));
            filme.setTrailer(rs.getString("trailer"));
            filme.setDiretor(rs.getString("diretor"));
        }
        this.buscar.close();
        return filme;
    }
}
