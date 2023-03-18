package MapeoClases;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "Participantes", schema = "FactoriaProyectos", catalog = "")
public class ParticipantesEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "AUTO_ID", nullable = false)
    private int autoId;
    @Basic
    @Column(name = "Proyecto_id", nullable = false)
    private int proyectoId;
    @Basic
    @Column(name = "id_Usuario", nullable = false)
    private int idUsuario;
    @Basic
    @Column(name = "Cordinador", nullable = true, length = 20)
    private String cordinador;
    @Basic
    @Column(name = "Fec_Ini", nullable = true)
    private Date fecIni;
    @Basic
    @Column(name = "Fec_Fin", nullable = true)
    private Date fecFin;

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

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getCordinador() {
        return cordinador;
    }

    public void setCordinador(String cordinador) {
        this.cordinador = cordinador;
    }

    public Date getFecIni() {
        return fecIni;
    }

    public void setFecIni(Date fecIni) {
        this.fecIni = fecIni;
    }

    public Date getFecFin() {
        return fecFin;
    }

    public void setFecFin(Date fecFin) {
        this.fecFin = fecFin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ParticipantesEntity that = (ParticipantesEntity) o;

        if (autoId != that.autoId) return false;
        if (proyectoId != that.proyectoId) return false;
        if (idUsuario != that.idUsuario) return false;
        if (cordinador != null ? !cordinador.equals(that.cordinador) : that.cordinador != null) return false;
        if (fecIni != null ? !fecIni.equals(that.fecIni) : that.fecIni != null) return false;
        if (fecFin != null ? !fecFin.equals(that.fecFin) : that.fecFin != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = autoId;
        result = 31 * result + proyectoId;
        result = 31 * result + idUsuario;
        result = 31 * result + (cordinador != null ? cordinador.hashCode() : 0);
        result = 31 * result + (fecIni != null ? fecIni.hashCode() : 0);
        result = 31 * result + (fecFin != null ? fecFin.hashCode() : 0);
        return result;
    }
}
