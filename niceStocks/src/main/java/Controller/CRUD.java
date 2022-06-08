package Controller;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class CRUD {

    public static void insertInTableUsuario(String userName, String email, String passwd) throws SQLException {
        if (!verifyIfExistsInTable("usuario", "email", email)) {
            Connection con;
            con = Conector.conect();
            String sql = "insert into usuario(user_name, email, passwd) values ('" + userName + "' , '" + email + "', '" + passwd + "');";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.executeUpdate();
            stmt.close();
            con.close();
            JOptionPane.showMessageDialog(null, "Conta criada com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Já existe uma conta com o email: " + email, "Usuario já cadastrado", JOptionPane.ERROR_MESSAGE);
        }

    }

    //insere valores na tabela Carteira
    public static void insertInTableCarteira(String stockName, int qtdStock, Double valorPago) throws SQLException {
        Connection con;
        con = Conector.conect();
        String sql = "insert into carteira(nmTitulo, qtdTitulo, valorPago) values ('" + stockName + "' , " + qtdStock + ", " + valorPago + ");";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.executeUpdate();

        stmt.close();
        con.close();
    }

    //Atualiza os dados da tabela carteira {qtdTitulo, totalPago} somando os valores passados a eles
    public static void updateInTableCarteira(String stockName, int qtdStock, Double valorPago) throws SQLException {
        Connection con;
        con = Conector.conect();

        PreparedStatement stmt = con.prepareStatement("select * from carteira where nmTitulo='" + stockName + "';");
        ResultSet rs = stmt.executeQuery();

        ArrayList<String> qtdTituloBD = new ArrayList();
        ArrayList<String> valorPagoBD = new ArrayList();

        while (rs.next()) {
            //System.out.println("titulo: " + rs.getString("qtdTitulo"));
            qtdTituloBD.add(rs.getString("qtdTitulo"));
            valorPagoBD.add(rs.getString("valorPago"));
        }
        qtdStock += Integer.parseInt(qtdTituloBD.get(0));
        valorPago += Double.parseDouble(valorPagoBD.get(0));

        String sql = "update carteira set qtdTitulo=" + qtdStock + ", valorPago=" + valorPago + " where nmTitulo ='" + stockName + "';";
        stmt = con.prepareStatement(sql);
        stmt.executeUpdate();

        stmt.close();
        con.close();
    }

    //retorna todos os valores da tabela Carteira em um ArrayList
    public static ArrayList<String> returnArrayFromTable() throws SQLException {
        Connection con;
        con = Conector.conect();
        PreparedStatement stmt = con.prepareStatement("select * from carteira;");
        ResultSet rs = stmt.executeQuery();

        ArrayList<String> array = new ArrayList();
        while (rs.next()) {
            System.out.println("titulo: " + rs.getString("nmTitulo"));
            array.add(rs.getString("nmTitulo"));
        }

        con.close();

        return array;
    }

    //verifica se existe o valor passado na tabela
    public static boolean verifyIfExistsInTable(String tableName, String columnName, String tableValue) throws SQLException {
        boolean thereValue;
        Connection con;
        con = Conector.conect();
        PreparedStatement stmt = con.prepareStatement("select * from " + tableName + " where " + columnName + " = '" + tableValue + "';");
        ResultSet rs = stmt.executeQuery();
        thereValue = rs.next();
        stmt.close();
        con.close();
        return thereValue;
    }
}
