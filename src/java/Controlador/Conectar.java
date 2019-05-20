package Controlador;

import java.sql.*;

public class Conectar
{
    private Connection connection;
    private Statement statement;
    private ResultSet rset;
    
    public Conectar()
    {
        try 
        {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (ClassNotFoundException e) 
        {
        }
        
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/foodle","foodleAdmin","foodleAdmin");
            statement = connection.createStatement();
        } catch (SQLException e) {   }
    }
    
    public Connection getConn()
    {
        return connection;
    }
    
    public void ejecutar(String sql) throws SQLException
    {
        rset=statement.executeQuery(sql);
    }
    public ResultSet getRset()
    {
        return rset;
    }
    
}
