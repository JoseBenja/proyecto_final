package model;

//Clase padre
import database.Conection;
import java.io.*;
import java.util.ArrayList;
import database.ManageData;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Interaction {

    private int idDevice;
    private String typeDevice;
    private String mail;
    private String nameDevice;
    private boolean visible;
    private boolean status;

    public Interaction(int idDevice, String typeDevice, String mail, String nameDevice, boolean visible, boolean status) {
        this.idDevice = idDevice;
        this.typeDevice = typeDevice;
        this.mail = mail;
        this.nameDevice = nameDevice;
        this.visible = visible;
        this.status = status;
    }

    public int getIdDevice() {
        return idDevice;
    }

    public void setIdDevice(int idDevice) {
        this.idDevice = idDevice;
    }

    public String getTypeDevice() {
        return typeDevice;
    }

    public void setTypeDevice(String typeDevice) {
        this.typeDevice = typeDevice;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getNameDevice() {
        return nameDevice;
    }

    public void setNameDevice(String nameDevice) {
        this.nameDevice = nameDevice;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    ArrayList<String> ListDevice;
    ArrayList<String> ShowDevice;
    ArrayList<String> RestDevice;

    public void NewDevice() {
        Conection conection = new Conection(); 
        
        Connection conn = conection.getConnection();

        ManageData.AddDevice(conn, this);

        /*try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Interaction.class.getName()).log(Level.SEVERE, null, ex);
        }*/

    }

    public void SearchDevice(String typeDevice, String typeAction) {

    }

    public ArrayList SearchForTable() {
        ListDevice = new ArrayList<>();
        ShowDevice = new ArrayList<>();

        String line = "";

        //Se realiza la busqueda de los dispositivos
        try {
            BufferedReader almacen = new BufferedReader(new FileReader(new File("devices.csv")));

            //Se llena un ArrayList con la informacion del archivo
            while (line != null) {
                line = almacen.readLine();
                ListDevice.add(line);
            }

            almacen.close();

            //Se evalua el tipo de dispositivo que exista en relacion al que se desea editar
            for (int i = 0; i < (ListDevice.size() - 1); i++) {
                ShowDevice.add(ListDevice.get(i));
            }

        } catch (IOException e) {
            System.out.println("El archivo no existe");
        }
        return ShowDevice;
    }

    public void ModifyDevice() {
        if (!this.getNameDevice().isEmpty() && !this.getMail().isEmpty()) {
            Conection conection = new Conection(); 
        
            Connection conn = conection.getConnection();
            ManageData.ModifyDevice(conn, this);
        } else {
            System.out.println("El nombre o email estan vacios");
        }
    }

    public void DeleteDevice() {

    }
}
