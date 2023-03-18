package MapeoClases;

import jakarta.persistence.*;

@Entity
@Table(name = "FamiliaProfesional", schema = "FactoriaProyectos", catalog = "")
public class FamiliaProfesionalEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "AUTO_ID", nullable = false)
    private int autoId;
    @Basic
    @Column(name = "FAMILIA_PROFESIONAL_ID", nullable = false)
    private int familiaProfesionalId;
    @Basic
    @Column(name = "Nombre_Familia", nullable = false, length = 60)
    private String nombreFamilia;
    @ManyToOne
    @JoinColumn(name = "FAMILIA_PROFESIONAL_ID", referencedColumnName = "FAMILIA_PROFESIONAL_ID", nullable = false,updatable = false, insertable = false)
    private FamiliaProfesionalImplicadaEntity familiaProfesionalImplicadaByFamiliaProfesionalId;
    @ManyToOne
    @JoinColumn(name = "FAMILIA_PROFESIONAL_ID", referencedColumnName = "Familia_Profesional", nullable = false,updatable = false, insertable = false)
    private UsuarioEntity usuarioByFamiliaProfesionalId;

    public int getAutoId() {
        return autoId;
    }

    public void setAutoId(int autoId) {
        this.autoId = autoId;
    }

    public int getFamiliaProfesionalId() {
        return familiaProfesionalId;
    }

    public void setFamiliaProfesionalId(int familiaProfesionalId) {
        this.familiaProfesionalId = familiaProfesionalId;
    }

    public String getNombreFamilia() {
        return nombreFamilia;
    }

    public void setNombreFamilia(String nombreFamilia) {
        this.nombreFamilia = nombreFamilia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FamiliaProfesionalEntity that = (FamiliaProfesionalEntity) o;

        if (autoId != that.autoId) return false;
        if (familiaProfesionalId != that.familiaProfesionalId) return false;
        if (nombreFamilia != null ? !nombreFamilia.equals(that.nombreFamilia) : that.nombreFamilia != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = autoId;
        result = 31 * result + familiaProfesionalId;
        result = 31 * result + (nombreFamilia != null ? nombreFamilia.hashCode() : 0);
        return result;
    }

    public FamiliaProfesionalImplicadaEntity getFamiliaProfesionalImplicadaByFamiliaProfesionalId() {
        return familiaProfesionalImplicadaByFamiliaProfesionalId;
    }

    public void setFamiliaProfesionalImplicadaByFamiliaProfesionalId(FamiliaProfesionalImplicadaEntity familiaProfesionalImplicadaByFamiliaProfesionalId) {
        this.familiaProfesionalImplicadaByFamiliaProfesionalId = familiaProfesionalImplicadaByFamiliaProfesionalId;
    }

    public UsuarioEntity getUsuarioByFamiliaProfesionalId() {
        return usuarioByFamiliaProfesionalId;
    }

    public void setUsuarioByFamiliaProfesionalId(UsuarioEntity usuarioByFamiliaProfesionalId) {
        this.usuarioByFamiliaProfesionalId = usuarioByFamiliaProfesionalId;
    }
}
