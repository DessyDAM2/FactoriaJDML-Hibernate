package MapeoClases;

import jakarta.persistence.*;

@Entity
@Table(name = "FamiliaProfesionalImplicada", schema = "FactoriaProyectos", catalog = "")
public class FamiliaProfesionalImplicadaEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "AUTO_ID", nullable = false)
    private int autoId;
    @Basic
    @Column(name = "Proyecto_ID", nullable = false)
    private int proyectoId;
    @Basic
    @Column(name = "FAMILIA_PROFESIONAL_ID", nullable = false)
    private int familiaProfesionalId;

    public int getAutoId() {
        return autoId;
    }

    public void setAutoId(int autoId) {
        this.autoId = autoId;
    }

    public int getProyectoId() {
        return proyectoId;
    }

    public void setProyectoId(int proyectoId) {
        this.proyectoId = proyectoId;
    }

    public int getFamiliaProfesionalId() {
        return familiaProfesionalId;
    }

    public void setFamiliaProfesionalId(int familiaProfesionalId) {
        this.familiaProfesionalId = familiaProfesionalId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FamiliaProfesionalImplicadaEntity that = (FamiliaProfesionalImplicadaEntity) o;

        if (autoId != that.autoId) return false;
        if (proyectoId != that.proyectoId) return false;
        if (familiaProfesionalId != that.familiaProfesionalId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = autoId;
        result = 31 * result + proyectoId;
        result = 31 * result + familiaProfesionalId;
        return result;
    }
}
