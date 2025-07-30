package es.cic.curso25.proy009.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

@Entity
@Table(name = "rama")
public class Rama {

    //Ramas de árbol con hojas y algunas con frutos cuando son árboles frutales

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;

    @Version
    private Long version;

    //Relación varios a uno - cada rama pertenece a un único árbol
    @ManyToOne
    @JoinColumn(name = "arbol_id") //Foreign key - Crea la foreign key en la tabla rama y la vincula con el árbol correspondiente

    private Arbol arbol;


    //Atributos de rama
    @Column(name = "colorHoja")
    private String colorHoja;
    @Column(name = "formaHoja")
    private String formaHoja;
    @Column(name = "frutal")
    private boolean frutal;

    //Getters y Setters
        public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public Long getVersion() {
        return version;
    }


    public void setVersion(Long version) {
        this.version = version;
    }


    public Arbol getArbol() {
        return arbol;
    }


    public void setArbol(Arbol arbol) {
        this.arbol = arbol;
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


    public boolean isFrutal() {
        return frutal;
    }


    public void setFrutal(boolean frutal) {
        this.frutal = frutal;
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
        return "Rama [id=" + id + ", version=" + version + ", colorHoja=" + colorHoja + ", formaHoja=" + formaHoja
                + ", frutal=" + frutal + "]";
    }


}
