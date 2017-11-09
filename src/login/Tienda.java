
package login;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Asthg
 */
public class Tienda {
    
    private final SimpleStringProperty Tie_Pais;
    private final SimpleStringProperty Tie_Nombre;
    private final SimpleStringProperty Tie_Ciudad;
    private final SimpleStringProperty Tie_Contacto;
    private final SimpleStringProperty Tie_Id;

    public Tienda(String Tie_Pais, String Tie_Nombre, String Tie_Ciudad, String Tie_Contacto, String Tie_Id )
    {
        this.Tie_Pais =new SimpleStringProperty(Tie_Pais);
        this.Tie_Nombre =new SimpleStringProperty(Tie_Nombre);
        this.Tie_Ciudad =new SimpleStringProperty(Tie_Ciudad);
        this.Tie_Contacto =new SimpleStringProperty(Tie_Contacto);
        this.Tie_Id =new SimpleStringProperty(Tie_Id);
    }

    public String getTie_Pais() {
        return Tie_Pais.get();
    }

    public String getTie_Nombre() {
        return Tie_Nombre.get();
    }

    public String getTie_Ciudad() {
        return Tie_Ciudad.get();
    }

    public String getTie_Contacto() {
        return Tie_Contacto.get();
    }

    public String getTie_Id() {
        return Tie_Id.get();
    }
}
