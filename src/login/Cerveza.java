/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author diego
 */
public class Cerveza {
    private final SimpleStringProperty CNombre;
    private final SimpleStringProperty CCodigo;
    private final SimpleStringProperty CTipo;
    private final SimpleStringProperty CFabricante;
    private final SimpleIntegerProperty CCoste;
    private final SimpleIntegerProperty CAlcohol;
    private final SimpleStringProperty CDescripcion;
    public Cerveza(String CNombre, String CCodigo, String CTipo, String CFabricante, Integer CCoste, Integer CAlcohol, String CDescripcion )
    {
        this.CNombre =new SimpleStringProperty(CNombre);
        this.CCodigo =new SimpleStringProperty(CCodigo);
        this.CTipo =new SimpleStringProperty(CTipo);
        this.CFabricante =new SimpleStringProperty(CFabricante);
        this.CCoste =new SimpleIntegerProperty(CCoste);
        this.CAlcohol =new SimpleIntegerProperty(CAlcohol);
        this.CDescripcion =new SimpleStringProperty(CDescripcion);
        
    
    }

    public String getCNombre() {
        return CNombre.get();
    }

    public String getCCodigo() {
        return CCodigo.get();
    }

    public String getCTipo() {
        return CTipo.get();
    }

    public String getCFabricante() {
        return CFabricante.get();
    }

    public Integer getCCoste() {
        return CCoste.get();
    }

    public Integer getCAlcohol() {
        return CAlcohol.get();
    }

    public String getCDescripcion() {
        return CDescripcion.get();
    }

    
    
    
    
    
}
