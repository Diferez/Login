/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import com.sun.javaws.Main;
import java.io.IOException;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Insets;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import oracle.jdbc.OraclePreparedStatement;
import oracle.jdbc.OracleResultSet;

/**
 *
 * @author diego
 */
public class Login extends Application {
    Connection conn= null;
    OraclePreparedStatement pst = null;
    OracleResultSet rs= null;
    
 @Override
    public void start(Stage primaryStage) {
        conn= Conectar.Cone();
        primaryStage.setTitle("Cerveza inc");
        
        
        GridPane grid= new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25,25,25,25));
        
        Button btn = new Button("Loguear");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 4);
        
        final Text actiontarget = new Text();
        grid.add(actiontarget, 1, 6);
        
        
        
        Scene scene= new Scene(grid, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
        
        Text scenetitle = new Text("Cerveza Inc");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);
        
        Label userName = new Label("Usuario:");
        grid.add(userName, 0, 1);
        
        TextField userTextField = new TextField();
        grid.add(userTextField, 1, 1);
        
        Label pw = new Label("Contraseña:");
        grid.add(pw, 0, 2);
        
        PasswordField pwBox = new PasswordField();
        grid.add(pwBox, 1, 2);
        
        
        
        
        
        
        //grid.setGridLinesVisible(true);
        
       btn.setOnAction(new EventHandler<ActionEvent>() {
 
        @Override
        public void handle(ActionEvent e) {
            
            
            actiontarget.setFill(Color.FIREBRICK);
            actiontarget.setText("Sign in button pressed");
            
            
            
           
            try{
                String sql ="select * from cerv_usuarios where usu_nombre=? and usu_pw=?";
                pst = (OraclePreparedStatement) conn.prepareStatement(sql);
                
                pst.setString(1, userTextField.getText());
                
                pst.setString(2, pwBox.getText());
                
                rs = (OracleResultSet) pst.executeQuery(); 
                
                
                if(rs.next())
                {
                    
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("Interf.fxml"));
                    
                    Parent root = loader.load();
                    Scene scene = new Scene(root);
                    primaryStage.setScene(scene);
                    primaryStage.show();
                }else{
                JOptionPane.showMessageDialog(null, "Invalid User");
                }
                
                
            }catch(Exception E)
            {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, E);
                JOptionPane.showMessageDialog(null, E);
            }
            
            
            
            
            
            //primaryStage.close();
            
            
        }
});
        
        
    }

  
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}

