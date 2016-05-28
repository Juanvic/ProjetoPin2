package br.unifor.ads.AssistantPatient;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException
    {
        System.out.println( "Hello World!" );
        Connection con = new ConnectionFactory().getConnection();
        System.out.println("Conexão aberta!");
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT medico FROM medicos");
        while (rs.next()) {
        	String lastName = rs.getString("medico");
        	System.out.println(lastName);
        }

        con.close();

    }
}
