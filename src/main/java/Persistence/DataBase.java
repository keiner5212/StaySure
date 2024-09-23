package Persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import javax.swing.JOptionPane;

import Core.Environ;
import Core.EnvironVariables;
import Core.Entities.Callback;
import Core.Entities.Table;

public class DataBase {
    private static Connection con = null;

    public DataBase() {
        if (con != null) {
            System.out.println("Connection not established");
            return;
        }

        Environ environ = new Environ();

        String user = environ.getProperty(EnvironVariables.DB_USER);
        String password = environ.getProperty(EnvironVariables.DB_PASSWORD);
        String host = environ.getProperty(EnvironVariables.DB_HOST);
        String port = environ.getProperty(EnvironVariables.DB_PORT);
        String database = environ.getProperty(EnvironVariables.DB_NAME);

        try {
            System.out.println(
                    "Connecting to database " + database + " ...");
            String url = "jdbc:postgresql://" + host + ":" + port + "/" + database;
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(url, user, password);
            System.out.println("Connection established");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean SaveEntity(String query,Table data) {

        if (con == null) {
            System.out.println("Connection not established");
            return false;
        }

        List<Object> params = data.toJPA();

        try (PreparedStatement pstmt1 = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            for (int i = 0; i < params.size(); i++) {
                pstmt1.setObject(i + 1, params.get(i));
            }
            pstmt1.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public static void SelectEntities(String query, Callback callback) {
        if (con == null) {
            System.out.println("Connection not established");
        }

        try (PreparedStatement pstmt1 = con.prepareStatement(query)) {
            ResultSet rs = pstmt1.executeQuery();

            while (rs.next()) {
                callback.setResultSet(rs);
                callback.run();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Database error", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}