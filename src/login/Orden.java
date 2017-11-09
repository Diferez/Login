package login;

import javafx.beans.property.SimpleStringProperty;
        
/**
 *
 * @author Asthg
 */

public class Orden {
     private final SimpleStringProperty Ord_Codigo;
    private final SimpleStringProperty Pro_Codigo;
    private final SimpleStringProperty Fab_Nombre;

    public Orden(String ord_Codigo, String pro_Codigo, String fab_Nombre) {
        Ord_Codigo = new SimpleStringProperty(ord_Codigo);
        Pro_Codigo = new SimpleStringProperty(pro_Codigo);
        Fab_Nombre = new SimpleStringProperty(fab_Nombre);
    }

    public String getOrd_Codigo() {
        return Ord_Codigo.get();
    }

    public SimpleStringProperty ord_CodigoProperty() {
        return Ord_Codigo;
    }

    public String getPro_Codigo() {
        return Pro_Codigo.get();
    }

    public SimpleStringProperty pro_CodigoProperty() {
        return Pro_Codigo;
    }

    public String getFab_Nombre() {
        return Fab_Nombre.get();
    }

    public SimpleStringProperty fab_NombreProperty() {
        return Fab_Nombre;
    }
}
