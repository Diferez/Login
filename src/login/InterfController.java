/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;


import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import javax.swing.JOptionPane;
import oracle.jdbc.OraclePreparedStatement;
import oracle.jdbc.OracleResultSet;

/**
 * FXML Controller class
 *
 * @author diego
 */
public class InterfController implements Initializable {
    ObservableList<String> TienT = FXCollections.observableArrayList();
     ObservableList<String> ProP = FXCollections.observableArrayList();
    ObservableList<String> DepD = FXCollections.observableArrayList();
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
    
    /*
    //////////////////////////////////////
    /////////Pestaña Cliente//////////////
    //////////////////////////////////////
    */
    @FXML
    private TextField TxNomCl;
    @FXML
    private TextField TxApeCl;
    @FXML
    private TextField TxIdCl;
    @FXML
    private TextField TxPaisCl;
    @FXML
    private TextField TxDirCl;
    @FXML
    private TextField TxCorreoCl;
    @FXML
    private Button Btn_CrearCl;
    
    /*Pestaña Depositos*/
    @FXML
    private TextField TxCodD;
    @FXML
    private TextField TxDirD;
    @FXML
    private TextField TxCapD;
    @FXML
    private Button Btn_CrearD;
    @FXML
    private ChoiceBox ChoiceBoxFabD;
    
    
     /*
    /////////////////////
    Pestaña Tienda    ///
    /////////////////////
    */
    @FXML
    private TextField TxPaiT;
    @FXML
    private TextField TxNomT;
    @FXML
    private TextField TxIdT;
    @FXML
    private TextField TxCiuT;
    @FXML
    private TextField TxConT;
    @FXML
    private Button Btn_CrearT;

    /*///////////////////
    Pestaña Pedido//  ///
    /////////////////////
    */
    @FXML
    private TextField TxCodP;
    @FXML
    private ChoiceBox ChoiceBoxIdTienP;
    @FXML
    private ChoiceBox ChoiceBoxNomDP;
    @FXML
    private TextField TxFechaP;
    @FXML
    private Button Btn_CrearP;
    
    
    /*///////////////////
    Pestaña Orden   /////
    /////////////////////
    */
    @FXML
    private ChoiceBox ChoiceBoxNomFabO;
    @FXML
    private TextField TxCodO;
    @FXML
    private ChoiceBox ChoiceBoxProO;
    @FXML
    private Button Btn_CrearO;
    
    
    /*///////////////////
    Pestaña Proveedor  /////
    /////////////////////
    */
    @FXML
    private TextField TxProCodPro;
    @FXML
    private TextField TxDirPro;
    @FXML
    private Button Btn_CrearPro;
    
    /*///////////////////
    Pestaña Materias Primas  /////
    /////////////////////
    */
    @FXML
    private TextField TxPreM;
    @FXML
    private TextField TxNomM;
    @FXML
    private TextField TxCodM;
    @FXML
    private Button Btn_CrearM;
    
    
    /*///////////////////
    Pestaña Ver Cerveza  /////
    /////////////////////
    */
    
    
    
    @FXML
    private TableView<Cerveza> TabCer;

    @FXML
    private TableColumn<Cerveza, String> CNombre;

    @FXML
    private TableColumn<Cerveza, String> CCodigo;

    @FXML
    private TableColumn<Cerveza, String> CTipo;

    @FXML
    private TableColumn<Cerveza, String> CFabricante;

    @FXML
    private TableColumn<Cerveza, Integer> CCoste;

    @FXML
    private TableColumn<Cerveza, Integer> CAlcohol;

    @FXML
    private TableColumn<Cerveza, String> CDescripcion;
    
    @FXML
    private TableColumn<Cerveza, Boolean> CEliminar;
    
    public ObservableList<Cerveza> CerT = FXCollections.observableArrayList();
    
    

    //--------------CREAR CERVEZA---------------//
    @FXML
    void CrearC(ActionEvent event) {
        
        String sql="INSERT INTO CERV_CERVEZA(CER_GRADO,CER_PRECIO,CER_DESCRIP,FAB_NOMBRE,CER_TIPO,CER_CODIGO,CER_NOMBRE)VALUES(?,?,?,?,?,?,?)";
        try{
        pst = (OraclePreparedStatement) conn.prepareStatement(sql);
        
        //Enviar la informacion de Cerveza a la base de datos
        pst.setString(1, TxAlcoC.getText());
        pst.setString(2, TxCosteC.getText());
        pst.setString(3, TxDescripC.getText());
        pst.setString(4, ChoiceBoxFabC.getValue().toString());
        pst.setString(5, TxTipoC.getText());
        
        String temp=ChoiceBoxFabC.getValue().toString().substring(0,2)+TxTipoC.getText().substring(0,2)+TxNomC.getText().substring(0,2);
        pst.setString(6, temp);
        
        pst.setString(7, TxNomC.getText());
        
        rs = (OracleResultSet) pst.executeQuery();
        
        JOptionPane.showMessageDialog(null, "¡Enhorabuena! Una nueva cerveza para disfrutar.");
        
        //Limpiar textboxes
        TxAlcoC.clear();
        TxCosteC.clear();
        TxDescripC.clear();
        TxTipoC.clear();
         
        }catch(Exception E){
        JOptionPane.showMessageDialog(null, E);
        }
    }
    
    
    //--------------CREAR CLIENTE---------------//
    @FXML
    void CrearCl(ActionEvent event) {
        String sql="INSERT INTO CERV_CLIENTE(CLI_NOMBRE,CLI_APELLIDO,CLI_ID,CLI_PAIS,CLI_DIR,CLI_EMAIL) VALUES(?,?,?,?,?,?)";
        try{
        pst = (OraclePreparedStatement) conn.prepareStatement(sql);
        
        //Enviar la informacion a la base de datos
        pst.setString(1, TxNomCl.getText());
        pst.setString(2, TxApeCl.getText());
        pst.setString(3, TxIdCl.getText());
        pst.setString(4, TxPaisCl.getText());
        pst.setString(5, TxDirCl.getText());
        pst.setString(6, TxCorreoCl.getText());    
        rs = (OracleResultSet) pst.executeQuery();
        
        JOptionPane.showMessageDialog(null, "¡Enhorabuena! El usuario ha sido creado exitosamente");
        
        //Limpiar textbox una vez creado un usuario
        TxNomCl.clear();
        TxApeCl.clear();
        TxIdCl.clear();
        TxPaisCl.clear();
        TxDirCl.clear();
        TxCorreoCl.clear();
        
        
        }catch(Exception E){
        JOptionPane.showMessageDialog(null, E);
        
        }

    }
    
    
    //--------------CREAR FABRICA---------------//
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
        TxNomFabF.clear();
        Poblarg();
        
    }
    
    
    //--------------CREAR DEPOSITO---------------//
    @FXML
    void CrearD(ActionEvent event) {
        String sql="insert into CERV_DEPOSITO (DEP_CODIGO, DEP_UBICACION, DEP_CAPACIDAD, FAB_NOMBRE) values (?, ?, ?, ?)";
        try{
        pst = (OraclePreparedStatement) conn.prepareStatement(sql);
        
        //Enviar la informacion a la base de datos
        pst.setString(1, TxCodD.getText());
        pst.setString(2, TxDirD.getText());
        pst.setString(3, TxCapD.getText());
        pst.setString(4, ChoiceBoxFabD.getValue().toString());

        rs = (OracleResultSet) pst.executeQuery();
        
        JOptionPane.showMessageDialog(null, "¡Enhorabuena! El depósito ha sido creado exitosamente.");
       
        //Limpiar textbox una vez creado un usuario
        TxCodD.clear();
        TxDirD.clear();
        TxCapD.clear();
     
        Poblarg();
        
        }catch(Exception E){
        JOptionPane.showMessageDialog(null, E);
        
        }
        
    }
    
    //--------------CREAR TIENDA---------------//
    @FXML
    void CrearT(ActionEvent event) {
        String sql="INSERT INTO CERV_TIENDA(TIE_PAIS, TIE_NOMBRE, TIE_CIUDAD, TIE_ID, TIE_CONTACTO) VALUES(?,?,?,?,?)";
        try{
        pst = (OraclePreparedStatement) conn.prepareStatement(sql);
        
        //Enviar la informacion a la base de datos
        pst.setString(1, TxPaiT.getText());
        pst.setString(2, TxNomT.getText());
        pst.setString(3, TxCiuT.getText());
        pst.setString(4, TxIdT.getText());
        pst.setString(5, TxConT.getText());
        
        rs = (OracleResultSet) pst.executeQuery();
        
        JOptionPane.showMessageDialog(null, "¡Enhorabuena! La tienda ha sido registrada exitosamente.");
        
        //Limpiar textfields
        TxNomT.clear();
        TxIdT.clear();
        TxCiuT.clear();
        TxConT.clear();
        TxPaiT.clear();
        
        Poblarg();
        
        }catch(Exception E){
        JOptionPane.showMessageDialog(null, E);
        } 
    }
    //--------------CREAR PEDIDO---------------//
    @FXML
    void CrearP(ActionEvent event) { 
        String sql = "insert into CERV_PEDIDO (PED_CODIGO, PED_FECHA, TIE_ID, DEP_CODIGO) values (?, to_date(?, 'DD-MM-YYYY'), ?, ?)";
        
        try{
        pst = (OraclePreparedStatement) conn.prepareStatement(sql);
        
        //Enviar la informacion a la base de datos
        pst.setString(1, TxCodP.getText());
        pst.setString(2, TxFechaP.getText());
        pst.setString(3, ChoiceBoxIdTienP.getValue().toString());
        pst.setString(4, ChoiceBoxNomDP.getValue().toString());
        
        rs = (OracleResultSet) pst.executeQuery();
        
        JOptionPane.showMessageDialog(null, "¡Enhorabuena! El pedido se ha enviado con éxito.");
        
        //Limpiar textfields
        TxCodP.clear();
        TxFechaP.clear();
        
        }catch(Exception E){
        JOptionPane.showMessageDialog(null, E);
        } 
        
    }
    //--------------CREAR ORDEN----------------//
    @FXML
    void CrearO(ActionEvent event) { 
        String sql = "insert into CERV_ORDEN (ORD_CODIGO, PRO_CODIGO, FAB_NOMBRE) values (?, ?, ?)";
        
         try{
        pst = (OraclePreparedStatement) conn.prepareStatement(sql);
        
        //Enviar la informacion a la base de datos
        pst.setString(1, TxCodO.getText());
        pst.setString(2, ChoiceBoxProO.getValue().toString());
        pst.setString(3, ChoiceBoxNomFabO.getValue().toString());
        
        rs = (OracleResultSet) pst.executeQuery();
        
        JOptionPane.showMessageDialog(null, "¡Enhorabuena! La orden se ha registrado con éxito.");
        
        //Limpiar textfields
        TxCodO.clear();
        
        }catch(Exception E){
        JOptionPane.showMessageDialog(null, E);
        }         
    }
    
    
    //--------------CREAR PROVEEDOR---------------//
    @FXML
    void CrearPro(ActionEvent event) {
        String sql = "Insert into CERV_PROVEEDOR (PRO_CODIGO, PRO_DIRECCION) values (?, ?)";
        
        try{
        pst = (OraclePreparedStatement) conn.prepareStatement(sql);
        
        //Enviar la informacion a la base de datos
        pst.setString(1, TxProCodPro.getText());
        pst.setString(2, TxDirPro.getText());
        
        rs = (OracleResultSet) pst.executeQuery();
        
        JOptionPane.showMessageDialog(null, "¡Enhorabuena! Un nuevo proveedor ha sido registrado.");
        
        //Limpiar textfields
        TxProCodPro.clear();
        TxDirPro.clear();
      
        }catch(Exception E){
        JOptionPane.showMessageDialog(null, E);
        } 
    }
    
     //--------------CREAR MATERIAS PRIMAS---------------//
    @FXML
    void CrearM(ActionEvent event) {
        String sql = "Insert into CERV_MATERIAS_PRIMAS (MAT_CODIGO, MAT_PRECIO, MAT_NOMBRE) values (?, ?, ?)";
        
        try{
        pst = (OraclePreparedStatement) conn.prepareStatement(sql);
        
        //Enviar la informacion a la base de datos
        pst.setString(1, TxCodM.getText());
        pst.setString(2, TxPreM.getText());
        pst.setString(3, TxNomM.getText());

        
        rs = (OracleResultSet) pst.executeQuery();
        
        JOptionPane.showMessageDialog(null, "¡Enhorabuena! Las materias primas han sido registradas.");
        
        //Limpiar textfields
        TxCodM.clear();
        TxPreM.clear();
        TxNomM.clear();
      
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
        Tablas();
        
    }
    
    public void Poblarg()
    {
        ObservableList<String> FabCtemp = FXCollections.observableArrayList();
        String sql="select * from cerv_fabricante";
        try{
        pst = (OraclePreparedStatement) conn.prepareStatement(sql);
        rs = (OracleResultSet) pst.executeQuery();
        while (rs.next())
        {
        String Fabnombre=rs.getString("FAB_NOMBRE");
        FabCtemp.add(Fabnombre);
        }
        }catch(Exception E){
        JOptionPane.showMessageDialog(null, E);
        }
        FabC=FabCtemp;
        ChoiceBoxFabC.setItems(FabC);
        ChoiceBoxFabD.setItems(FabC);
        
        ChoiceBoxNomFabO.setItems(FabC);     
        
        
ObservableList<String> Tientemp = FXCollections.observableArrayList();
        sql="select * from cerv_tienda";
        try{
        pst = (OraclePreparedStatement) conn.prepareStatement(sql);
        rs = (OracleResultSet) pst.executeQuery();
        while (rs.next())
        {
        String Fabnombre=rs.getString("TIE_ID");
        Tientemp.add(Fabnombre);
        }
        }catch(Exception E){
        JOptionPane.showMessageDialog(null, E);
        }
        TienT=Tientemp;
        ChoiceBoxIdTienP.setItems(TienT);
        
        ObservableList<String> Deptemp = FXCollections.observableArrayList();
        sql="select * from cerv_deposito";
        try{
        pst = (OraclePreparedStatement) conn.prepareStatement(sql);
        rs = (OracleResultSet) pst.executeQuery();
        while (rs.next())
        {
        String Fabnombre=rs.getString("DEP_CODIGO");
        Deptemp.add(Fabnombre);
        }
        }catch(Exception E){
        JOptionPane.showMessageDialog(null, E);
        }
        DepD=Deptemp;
        ChoiceBoxNomDP.setItems(DepD);
        
        ObservableList<String> Protemp = FXCollections.observableArrayList();
            sql="select * from cerv_proveedor";
            try{
            pst = (OraclePreparedStatement) conn.prepareStatement(sql);
            rs = (OracleResultSet) pst.executeQuery();
            while (rs.next())
            {
            String Fabnombre=rs.getString("PRO_CODIGO");
            Protemp.add(Fabnombre);
            }
            }catch(Exception E){
            JOptionPane.showMessageDialog(null, E);
            }
            ProP=Protemp;
            ChoiceBoxProO.setItems(ProP);
    }
    
    public void Tablas()
    {
    CNombre.setCellValueFactory(new PropertyValueFactory<Cerveza,String>("CNombre"));
    CCodigo.setCellValueFactory(new PropertyValueFactory<Cerveza,String>("CCodigo"));
    CTipo.setCellValueFactory(new PropertyValueFactory<Cerveza,String>("CTipo"));
    CFabricante.setCellValueFactory(new PropertyValueFactory<Cerveza,String>("CFabricante"));
    CCoste.setCellValueFactory(new PropertyValueFactory<Cerveza,Integer>("CCoste"));
    CAlcohol.setCellValueFactory(new PropertyValueFactory<Cerveza,Integer>("CAlcohol"));
    CDescripcion.setCellValueFactory(new PropertyValueFactory<Cerveza,String>("CDescripcion"));
    CEliminar.setSortable(false);
    
    CEliminar.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Cerveza, Boolean>, ObservableValue<Boolean>>() {
      @Override public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<Cerveza, Boolean> features) {
        return new SimpleBooleanProperty(features.getValue() != null);
      }
    });
    
//    CEliminar.setCellFactory(new Callback<TableColumn<Cerveza, Boolean>, TableCell<Cerveza, Boolean>>() {
//      @Override public TableCell<Cerveza, Boolean> call(TableColumn<Cerveza, Boolean> personBooleanTableColumn) {
//        return new EliminarCell(stage, table);
//        
//      }
//    });
    
    
    
    
    CrearCervezas();
    TabCer.setItems(CerT);
    
    
    }
    
    
    public void CrearCervezas()
    {
    ObservableList<Cerveza> Cervtemp = FXCollections.observableArrayList();
        String sql="select * from cerv_cerveza";
        try{
        pst = (OraclePreparedStatement) conn.prepareStatement(sql);
        rs = (OracleResultSet) pst.executeQuery();
        while (rs.next())
        {
        String Nombre=rs.getString("CER_NOMBRE");
        String Codigo=rs.getString("CER_CODIGO");
        String Tipo=rs.getString("CER_TIPO");
        String Fabricante=rs.getString("FAB_NOMBRE");
        String Descripcion=rs.getString("CER_DESCRIP");
        Integer Grado=rs.getInt("CER_GRADO");
        Integer Precio=rs.getInt("CER_PRECIO");
        
        Cerveza a=new Cerveza(Nombre,Codigo,Tipo,Fabricante,Precio,Grado,Descripcion);
        Cervtemp.add(a);
        }
        }catch(Exception E){
        JOptionPane.showMessageDialog(null, E);
        }
        CerT=Cervtemp;
    }
    
}
