package es.cic.curso25.proy009.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

@Entity
@Table(name = "arbol")
public class Arbol {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;

    @Version
    private Long version;

    //Atributos Árbol
    private String nombreComun;
    private String tipoTronco;
    private double altura;
    private double anchura;

    //Getters y Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNombreComun() {
        return nombreComun;
    }
    public void setNombreComun(String nombreComun) {
        this.nombreComun = nombreComun;
    }
    public String getTipoTronco() {
        return tipoTronco;
    }
    public void setTipoTronco(String tipoTronco) {
        this.tipoTronco = tipoTronco;
    }
    public double getAltura() {
        return altura;
    }
    public void setAltura(double altura) {
        this.altura = altura;
    }
    public double getAnchura() {
        return anchura;
    }
    public void setAnchura(double anchura) {
        this.anchura = anchura;
    }

    //hashCode() equals()
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Arbol other = (Arbol) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    //Método toString()
    @Override
    public String toString() {
        return "Arbol [id=" + id + ", version=" + version + ", nombreComun=" + nombreComun + ", tipoTronco="
                + tipoTronco + ", altura=" + altura + ", anchura=" + anchura + "]";
    }

    

}
