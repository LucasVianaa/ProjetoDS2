
package database;

import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Filme;
import model.Sessao;

public class SessaoDAO {
     private PreparedStatement listar;
    private PreparedStatement obter;
    private PreparedStatement excluir;
    private PreparedStatement atualizar;
    private PreparedStatement adicionar;    
    private PreparedStatement buscar;

    // Conexao
    private ConexaoPostgreSQL con;

    public SessaoDAO() throws SQLException {
        try {
            this.con = new ConexaoPostgreSQL();
            this.obter = con.getConnection().prepareStatement("select * from sessao where id = ?;");
            this.buscar = con.getConnection().prepareStatement("select * from sessao where id_filme = ?;");
            this.listar = con.getConnection().prepareStatement("select * from sessao where hora_inicio > now() order by hora_inicio;");
            this.excluir = con.getConnection().prepareStatement("delete from sessao where id = ?;");
            this.atualizar = con.getConnection().prepareStatement("update sessao set hora_inicio = ?, hora_fim = ?, id_filme = ?, preco_adulto = ?, preco_estudante = ?, preco_idoso = ?, sala = ?, its3d = ?, itslegendado = ? where id = ?;"); 
            this.adicionar = con.getConnection().prepareStatement("insert into sessao (hora_inicio, hora_fim, id_filme, preco_adulto, preco_estudante, preco_idoso, sala, its3d, itslegendado) values (?,?,?,?,?,?,?,?,?) returning id;");         
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    public Sessao obter(int id) throws SQLException {
        this.obter.setInt(1, id);
        ResultSet rs = this.obter.executeQuery();
        Sessao sessoa = new Sessao();
        if (rs.next()) {
            Timestamp stamp1 = rs.getTimestamp("hora_inicio");
            Date date1 = new Date(stamp1.getTime());
            Calendar horaInicio = Calendar.getInstance();
            horaInicio.setTime(date1);
            sessoa.setHoraInicio(horaInicio);
            
            Timestamp stamp2 = rs.getTimestamp("hora_fim");
            Date date2 = new Date(stamp2.getTime());
            Calendar horaFim = Calendar.getInstance();
            horaInicio.setTime(date2);
            sessoa.setHoraFim(horaFim);
            
            sessoa.setId(rs.getInt("id"));
            sessoa.setSala(rs.getInt("sala"));
            sessoa.setIts3d(rs.getBoolean("its3d"));
            sessoa.setItsLegendado(rs.getBoolean("itslegendado"));
            
            FilmeDAO filmeDao = new FilmeDAO();
            Filme filme = filmeDao.obter(rs.getInt("id_filme"));
            sessoa.setFilme(filme);
            
            sessoa.setPrecoAdulto(rs.getFloat("preco_adulto"));
            sessoa.setPrecoEstudante(rs.getFloat("preco_estudante"));
            sessoa.setPrecoIdoso(rs.getFloat("preco_idoso"));
            
            
        }
        this.obter.close();
        return sessoa;
    }

    public ArrayList<Sessao> listar() throws SQLException {
        ArrayList<Sessao> todos = new ArrayList();
        ResultSet rs;
        try {
            rs = this.listar.executeQuery();
            while (rs.next()) {                
                Timestamp stamp1 = rs.getTimestamp("hora_inicio");
                Date date1 = new Date(stamp1.getTime());
                Calendar horaInicio = Calendar.getInstance();
                horaInicio.setTime(date1);

                
                
                Filme filme = new FilmeDAO().obter(rs.getInt("id_filme"));   
                            
                Timestamp stamp2 = rs.getTimestamp("hora_fim");
                Date date2 = new Date(stamp2.getTime());
                Calendar horaFim = Calendar.getInstance();
                horaFim.setTime(date2);

                todos.add(new Sessao(rs.getInt("id"), rs.getInt("sala"),
                        rs.getDouble("preco_adulto"), rs.getDouble("preco_estudante"), 
                        rs.getDouble("preco_idoso"), rs.getBoolean("its3d"),
                        rs.getBoolean("its3d"), filme, horaInicio, horaFim));

            }
            this.listar.close();
        } catch (SQLException e) {
            return todos;
        }
        return todos;
    }

    public boolean adicionar(Sessao sessao) {
  
        try {
            Timestamp timeInicio = new java.sql.Timestamp(sessao.getHoraInicio().getTime().getTime());
            Timestamp timeFim = new java.sql.Timestamp(sessao.getHoraFim().getTime().getTime());
            
            
            this.adicionar.setTimestamp(1, timeInicio);
            this.adicionar.setTimestamp(2, timeFim);
            this.adicionar.setInt(3, sessao.getFilme().getId());
            this.adicionar.setDouble(4, sessao.getPrecoAdulto());
            this.adicionar.setDouble(5, sessao.getPrecoEstudante());
            this.adicionar.setDouble(6, sessao.getPrecoIdoso());
            this.adicionar.setInt(7, sessao.getSala());
            this.adicionar.setBoolean(8, sessao.isIts3d());
            this.adicionar.setBoolean(9, sessao.isItsLegendado());
         
            
            return this.adicionar.execute();
        } catch (SQLException ex) {
            Logger.getLogger(FilmeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }      
        return false;
    }

    public void excluir(int id) throws SQLException {
        this.excluir.setInt(1, id); 
        this.excluir.execute();
        this.excluir.close();
    }

    public void editar(Sessao sessao) throws SQLException {
            Timestamp timeInicio = new java.sql.Timestamp(sessao.getHoraInicio().getTime().getTime());
            Timestamp timeFim = new java.sql.Timestamp(sessao.getHoraFim().getTime().getTime());
            this.atualizar.setTimestamp(1, timeInicio);
            this.atualizar.setTimestamp(2, timeFim);
            this.atualizar.setInt(3, sessao.getFilme().getId());
            this.atualizar.setDouble(4, sessao.getPrecoAdulto());
            this.atualizar.setDouble(5, sessao.getPrecoEstudante());
            this.atualizar.setDouble(6, sessao.getPrecoIdoso());
            this.atualizar.setInt(7, sessao.getSala());
            this.atualizar.setBoolean(8, sessao.isIts3d());
            this.atualizar.setBoolean(9, sessao.isItsLegendado());
            this.atualizar.setInt(10, sessao.getId());
            this.atualizar.execute();
            this.atualizar.close();
        

    }
    
    public Sessao buscar(int idFilme) throws SQLException {
        this.buscar.setInt(1, idFilme);
        ResultSet rs = this.buscar.executeQuery();
        Sessao sessoa = new Sessao();
        if (rs.next()) {
            Timestamp stamp1 = rs.getTimestamp("hora_inicio");
            Date date1 = new Date(stamp1.getTime());
            Calendar horaInicio = Calendar.getInstance();
            horaInicio.setTime(date1);
            sessoa.setHoraInicio(horaInicio);
            
            Timestamp stamp2 = rs.getTimestamp("hora_fim");
            Date date2 = new Date(stamp2.getTime());
            Calendar horaFim = Calendar.getInstance();
            horaInicio.setTime(date2);
            sessoa.setHoraFim(horaFim);
            
            sessoa.setId(rs.getInt("id"));
            sessoa.setSala(rs.getInt("sala"));
            sessoa.setIts3d(rs.getBoolean("its3d"));
            sessoa.setItsLegendado(rs.getBoolean("itslegendado"));
            FilmeDAO filmeDao = new FilmeDAO();
            Filme filme = filmeDao.obter(rs.getInt("id_filme"));
            sessoa.setFilme(filme);
            sessoa.setPrecoAdulto(rs.getFloat("preco_adulto"));
            sessoa.setPrecoEstudante(rs.getFloat("preco_estudante"));
            sessoa.setPrecoIdoso(rs.getFloat("preco_idoso"));
        }
        this.buscar.close();
        return sessoa;
    }
}
