package login;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Asthg
 */
public class Cliente {
    private final SimpleStringProperty CliNombres;
    private final SimpleStringProperty CliApellidos;
    private final SimpleStringProperty CliId;
    private final SimpleStringProperty CliDir;
    private final SimpleStringProperty CliPais;
    private final SimpleStringProperty CliEmail;
    
    public Cliente(String CliNombres, String CliApellidos, String CliId, String CliDir, String CliPais, String CliEmail )
    {
        this.CliNombres =new SimpleStringProperty(CliNombres);
        this.CliApellidos =new SimpleStringProperty(CliApellidos);
        this.CliId =new SimpleStringProperty(CliId);
        this.CliDir =new SimpleStringProperty(CliDir);
        this.CliPais =new SimpleStringProperty(CliPais);
        this.CliEmail =new SimpleStringProperty(CliEmail);
    }

    public String getCliNombres() {
        return CliNombres.get();
    }

    public String getCliApellidos() {
        return CliApellidos.get();
    }

    public String getCliId() {
        return CliId.get();
    }

    public String getCliDir() {
        return CliDir.get();
    }

    public String getCliEmail() {
        return CliEmail.get();
    }

    public String getCliPais() {
        return CliPais.get();
    }
}
