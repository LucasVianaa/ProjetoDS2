
package database;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AdministradorDAO {
    private PreparedStatement obter;


    private ConexaoPostgreSQL con;

    public AdministradorDAO() throws SQLException {
        try {
            this.con = new ConexaoPostgreSQL();
            this.obter = con.getConnection().prepareStatement("select * from admin where nome = ? and senha = ?;");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    public boolean autenticar(String login, String senha) throws SQLException {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(AdministradorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
            byte[] messageDigest = md.digest(senha.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            String senhamd5 = number.toString(16);
            while (senhamd5.length() < 32) {
                senhamd5 = "0" + senhamd5;
            }
        
        this.obter.setString(1, login);
        this.obter.setString(2, senhamd5);
        ResultSet rs = this.obter.executeQuery();
        if (rs.next()) {
            this.obter.close();
            return true;
        }else{
            this.obter.close();
            return false;
        }
        

    }

}
