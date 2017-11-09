
package login;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Asthg
 */

public class Pedido {
    private final SimpleStringProperty Ped_Codigo;
    private final SimpleStringProperty Ped_Fecha;
    private final SimpleStringProperty Tie_Id;
    private final SimpleStringProperty Dep_Codigo;

    public Pedido(String ped_Codigo, String ped_Fecha, String tie_Id, String dep_Codigo) {
        Ped_Codigo = new SimpleStringProperty(ped_Codigo);
        Ped_Fecha = new SimpleStringProperty(ped_Fecha);
        Tie_Id = new SimpleStringProperty(tie_Id);
        Dep_Codigo = new SimpleStringProperty(dep_Codigo);
    }

    public String getPed_Codigo() {
        return Ped_Codigo.get();
    }

    public SimpleStringProperty ped_CodigoProperty() {
        return Ped_Codigo;
    }

    public String getPed_Fecha() {
        return Ped_Fecha.get();
    }

    public SimpleStringProperty ped_FechaProperty() {
        return Ped_Fecha;
    }

    public String getTie_Id() {
        return Tie_Id.get();
    }

    public SimpleStringProperty tie_IdProperty() {
        return Tie_Id;
    }

    public String getDep_Codigo() {
        return Dep_Codigo.get();
    }

    public SimpleStringProperty dep_CodigoProperty() {
        return Dep_Codigo;
    }
    
}
