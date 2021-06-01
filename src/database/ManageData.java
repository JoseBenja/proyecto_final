package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Interaction;

public class ManageData {  
    private String message;
    
    private ObservableList<Interaction> list = FXCollections.observableArrayList();
    
    public static void AddDevice(Connection conn, Interaction interaction) {
        PreparedStatement pst = null;
        
        int visible = 0;
        int status = 0;
        
        if (interaction.isVisible() == true) {
            visible = 1;
        }
        
        if (interaction.isStatus() == true) {
            status = 1;
        }
        
        String sql = "INSERT INTO DISPOSITIVO (tipo, email, nombre, visible_, estatus)"
                + " VALUES('" + interaction.getTypeDevice() + "', '" + interaction.getMail() + "', '" + interaction.getNameDevice() + "', " + visible + ", " + status + ")";
        
        try {
            pst = conn.prepareStatement(sql);
            pst.execute();
            pst.close(); 
        } catch (SQLException ex) {
            Logger.getLogger(ManageData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void ModifyDevice(Connection conn, Interaction interaction) {
        PreparedStatement pst = null;
        
        int visible = 0;
        int status = 0;
        
        if (interaction.isVisible() == true) {
            visible = 1;
        }
        
        if (interaction.isStatus() == true) {
            status = 1;
        }
        
        String sql = "UPDATE DISPOSITIVO SET email = " + interaction.getMail() + ", nombre = " + interaction.getNameDevice() + ", visible_ = " + visible + ", estatus =  " + status
                + " WHERE id_Disp = " + interaction.getIdDevice();
        
        try {
            pst = conn.prepareStatement(sql);
            pst.execute();
            pst.close(); 
        } catch (SQLException ex) {
            Logger.getLogger(ManageData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void DeleteDevice(Connection conn, int id) {
        
    }
    
    public ObservableList searchTable(Connection conn) {
        PreparedStatement pst = null;

        String sql = "SELECT * FROM DISPOSITIVO";

        try {
            ResultSet rs = conn.createStatement().executeQuery(sql);

            while (rs.next()) {
                System.out.println("Hola");
                boolean visible = false;
                boolean status = false;

                if (rs.getInt("visible_") == 1) {
                    visible = true;
                }

                if (rs.getInt("estatus") == 1) {
                    status = true;
                }

                list.add(new Interaction(rs.getInt("id_Disp"), rs.getString("tipo"), rs.getString("email"), rs.getString("nombre"), visible, status));
            }
            rs.close();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex);
        }
                
        return list;
    }
}
