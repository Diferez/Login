/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;

/**
 *
 * @author diego
 */
public class EliminarCell extends TableCell<Cerveza, Boolean>{
    final Button addButton       = new Button("Del");
    final StackPane paddedButton = new StackPane();
    final DoubleProperty buttonY = new SimpleDoubleProperty();
    EliminarCell(final TableView table){
        paddedButton.setPadding(new Insets(3));
      paddedButton.getChildren().add(addButton);
      
      addButton.setOnMousePressed(new EventHandler<MouseEvent>() {
        @Override public void handle(MouseEvent mouseEvent) {
          buttonY.set(mouseEvent.getScreenY());
        }
      });
      addButton.setOnAction(new EventHandler<ActionEvent>() {
        @Override public void handle(ActionEvent actionEvent) {
           
          String a=table.getSelectionModel().getSelectedItem().toString();
          System.out.print(a);
          //table.getSelectionModel().select(getTableRow().getIndex());
        }
      });
      }
    
    @Override protected void updateItem(Boolean item, boolean empty) {
      super.updateItem(item, empty);
      if (!empty) {
        setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
        setGraphic(paddedButton);
      }
    }
  
      
        
   }
