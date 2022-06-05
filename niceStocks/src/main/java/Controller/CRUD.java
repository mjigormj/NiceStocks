package Controller;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



public class CRUD {
    //String tableName, String columnName
    //String sql = "select " +columnName+ " from " +tableName+ ";";
    public static ArrayList<String> returnArrayFromTable() throws SQLException {
        Connection con;
        con = Conector.conect();
        
        PreparedStatement stmt = con.prepareStatement("select * from titulo;");
        ResultSet rs = stmt.executeQuery();
        
        ArrayList<String> array = new ArrayList<String>();
        while(rs.next()){
            System.out.println("titulo: " + rs.getString("titulo"));
            array.add(rs.getString("titulo"));
        }
        
        con.close();
        
        return array;
    }
    
    public static void main(String[] args) throws SQLException {
        ArrayList<String> a = returnArrayFromTable();
        System.out.println("\n" + a);
    }

}
