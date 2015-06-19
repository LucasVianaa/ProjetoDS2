
package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    public FilmeDAO() throws SQLException {
        try {
            this.con = new ConexaoPostgreSQL();
            this.obter = con.getConnection().prepareStatement("select * from filme where id = ?;");
            this.buscar = con.getConnection().prepareStatement("select * from filme where titulo ilike ?;");
            this.listar = con.getConnection().prepareStatement("select * from filme order by titulo;");
            this.excluir = con.getConnection().prepareStatement("delete from filme where id = ?;");
            this.atualizar = con.getConnection().prepareStatement("update filme set titulo = ?, genero = ? where id = ?;"); 
            this.adicionar = con.getConnection().prepareStatement("insert into filme (titulo, genero) values (?,?) returning id;");         
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    public Filme obter(int id) throws SQLException {
        this.obter.setInt(1, id);
        ResultSet rs = this.obter.executeQuery();
        Filme filme = new Filme();
        if (rs.next()) {
            filme.setId(rs.getInt("id"));
            filme.setTitulo(rs.getString("titulo"));
            filme.setGenero(rs.getString("genero"));
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
                todos.add(new Filme(rs.getInt("id"), rs.getString("titulo"), rs.getString("genero")));
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
            this.atualizar.setInt(3, filme.getId());
            this.atualizar.execute();
            this.atualizar.close();
            return true;
        } catch (SQLException erro) {
            return false;
        }
    }

    public boolean autenticar(String login, String senha) {
        return login.equals("admin") && senha.equals("123");
    }

    public Filme buscar(String titulo) throws SQLException {
        this.buscar.setString(1, "%"+titulo.trim()+"%");
        ResultSet rs = this.buscar.executeQuery();
        Filme filme = new Filme();
        if (rs.next()) {
            filme.setId(rs.getInt("id"));
            filme.setTitulo(rs.getString("titulo"));
            filme.setGenero(rs.getString("genero"));
        }
        this.buscar.close();
        return filme;
    }
}
