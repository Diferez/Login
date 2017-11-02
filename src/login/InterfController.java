/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import oracle.jdbc.OraclePreparedStatement;
import oracle.jdbc.OracleResultSet;

/**
 * FXML Controller class
 *
 * @author diego
 */
public class InterfController implements Initializable {
    
    ObservableList<String> FabC = FXCollections.observableArrayList();
    Connection conn= Conectar.Cone();;
    OraclePreparedStatement pst = null;
    OracleResultSet rs= null;
    
    /*
    /////////////////////
    Pestaña Fabricante///
    /////////////////////
    */
    
    @FXML
    private TextField TxNomFabF;
    
    /*
    //////////////////
    Pestaña Cerveza///
    //////////////////
    */
    @FXML
    private TextField TxNomC;

    @FXML
    private TextField TxTipoC;

    @FXML
    private TextField TxAlcoC;

    @FXML
    private ChoiceBox ChoiceBoxFabC;

    @FXML
    private TextField TxCosteC;

    @FXML
    private TextField TxDescripC;

    @FXML
    private Button Btn_CrearC;
    
    
    
    
    @FXML
    void CrearC(ActionEvent event) {
        
        String sql="";
    }
    
    @FXML
    void CrearF(ActionEvent event) {
        
        String sql="insert into cerv_fabricante(FAB_NOMBRE) values(?)";
        try{
        pst = (OraclePreparedStatement) conn.prepareStatement(sql);
        pst.setString(1, TxNomFabF.getText());
        rs = (OracleResultSet) pst.executeQuery();
        }catch(Exception E){
        JOptionPane.showMessageDialog(null, E);
        }
        
        
        
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Poblarg();
        
    }
    
    public void Poblarg()
    {
        System.out.println("Poblando");
        String sql="select * from cerv_fabricante";
        try{
        pst = (OraclePreparedStatement) conn.prepareStatement(sql);
        rs = (OracleResultSet) pst.executeQuery();
        while (rs.next())
        {
        String Fabnombre=rs.getString("FAB_NOMBRE");
        FabC.add(Fabnombre);
        }
        }catch(Exception E){
        JOptionPane.showMessageDialog(null, E);
        }
        ChoiceBoxFabC.setItems(FabC);
        
    }
    
}
