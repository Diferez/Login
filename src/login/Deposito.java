
package login;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Asthg
 */

public class Deposito {
    private final SimpleStringProperty Dep_Codigo;
    private final SimpleStringProperty Dep_Ubicacion;
    private final SimpleIntegerProperty Dep_Capacidad;
    private final SimpleStringProperty Fab_Nombre;
    

    
    public Deposito(String Dep_Codigo, String Dep_Ubicacion, Integer Dep_Capacidad, String Fab_Nombre)
    {
        this.Dep_Codigo =new SimpleStringProperty(Dep_Codigo);
        this.Dep_Ubicacion =new SimpleStringProperty(Dep_Ubicacion);
        this.Dep_Capacidad =new SimpleIntegerProperty(Dep_Capacidad);
        this.Fab_Nombre =new SimpleStringProperty(Fab_Nombre);
    }

    public String getDep_Codigo() {
        return Dep_Codigo.get();
    }

    public String getDep_Ubicacion() {
        return Dep_Ubicacion.get();
    }

    public Integer getDep_Capacidad() {
        return Dep_Capacidad.get();
    }

    public String getFab_Nombre() {
        return Fab_Nombre.get();
    }
}
