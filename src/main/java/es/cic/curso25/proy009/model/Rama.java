package es.cic.curso25.proy009.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

@Entity
@Table(name = "rama")
public class Rama {

    //Ramas de árbol con hojas

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;

    @Version
    private Long version;


    //Atributos de las ramas con hojas
    @Column(name = "colorHoja")
    private String colorHoja;
    @Column(name = "formaHoja")
    private String formaHoja;
    @Column(name = "tipoCaduca")
    private boolean tipoCaduca;
    @Column(name = "tipoPerenne")
    private boolean tipoPerenne;

    //Getters y Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getColorHoja() {
        return colorHoja;
    }
    public void setColorHoja(String colorHoja) {
        this.colorHoja = colorHoja;
    }
    public String getFormaHoja() {
        return formaHoja;
    }
    public void setFormaHoja(String formaHoja) {
        this.formaHoja = formaHoja;
    }
    public boolean isTipoCaduca() {
        return tipoCaduca;
    }
    public void setTipoCaduca(boolean tipoCaduca) {
        this.tipoCaduca = tipoCaduca;
    }
    public boolean isTipoPerenne() {
        return tipoPerenne;
    }
    public void setTipoPerenne(boolean tipoPerenne) {
        this.tipoPerenne = tipoPerenne;
    }


    //hashCode() y equals()
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
        Rama other = (Rama) obj;
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
        return "Hoja [id=" + id + ", version=" + version + ", colorHoja=" + colorHoja + ", formaHoja=" + formaHoja
                + ", tipoCaduca=" + tipoCaduca + ", tipoPerenne=" + tipoPerenne + "]";
    }



}
