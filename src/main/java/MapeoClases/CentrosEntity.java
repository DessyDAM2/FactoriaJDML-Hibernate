package MapeoClases;

import jakarta.persistence.*;

@Entity
@Table(name = "Centros", schema = "FactoriaProyectos", catalog = "")
public class CentrosEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "AUTO_ID", nullable = false)
    private int autoId;
    @Basic
    @Column(name = "ID_CENTRO", nullable = false)
    private int idCentro;
    @Basic
    @Column(name = "Nombre", nullable = true, length = 20)
    private String nombre;
    @Basic
    @Column(name = "Web", nullable = true, length = 50)
    private String web;
    @Basic
    @Column(name = "Contacto", nullable = true, length = 20)
    private String contacto;
    @Basic
    @Column(name = "Activo", nullable = true)
    private Byte activo;
    @ManyToOne
    @JoinColumn(name = "ID_CENTRO", referencedColumnName = "ID_Centro", nullable = false,updatable = false, insertable = false)
    private CentrosDeProyectoEntity centrosDeProyectoByIdCentro;
    @ManyToOne
    @JoinColumn(name = "ID_CENTRO", referencedColumnName = "ID_Centro", nullable = false,updatable = false, insertable = false)
    private UsuarioEntity usuarioByIdCentro;

    public int getAutoId() {
        return autoId;
    }

    public void setAutoId(int autoId) {
        this.autoId = autoId;
    }

    public int getIdCentro() {
        return idCentro;
    }

    public void setIdCentro(int idCentro) {
        this.idCentro = idCentro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public Byte getActivo() {
        return activo;
    }

    public void setActivo(Byte activo) {
        this.activo = activo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CentrosEntity that = (CentrosEntity) o;

        if (autoId != that.autoId) return false;
        if (idCentro != that.idCentro) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;
        if (web != null ? !web.equals(that.web) : that.web != null) return false;
        if (contacto != null ? !contacto.equals(that.contacto) : that.contacto != null) return false;
        if (activo != null ? !activo.equals(that.activo) : that.activo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = autoId;
        result = 31 * result + idCentro;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (web != null ? web.hashCode() : 0);
        result = 31 * result + (contacto != null ? contacto.hashCode() : 0);
        result = 31 * result + (activo != null ? activo.hashCode() : 0);
        return result;
    }

    public CentrosDeProyectoEntity getCentrosDeProyectoByIdCentro() {
        return centrosDeProyectoByIdCentro;
    }

    public void setCentrosDeProyectoByIdCentro(CentrosDeProyectoEntity centrosDeProyectoByIdCentro) {
        this.centrosDeProyectoByIdCentro = centrosDeProyectoByIdCentro;
    }

    public UsuarioEntity getUsuarioByIdCentro() {
        return usuarioByIdCentro;
    }

    public void setUsuarioByIdCentro(UsuarioEntity usuarioByIdCentro) {
        this.usuarioByIdCentro = usuarioByIdCentro;
    }
}
