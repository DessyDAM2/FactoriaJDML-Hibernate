package MapeoClases;

import jakarta.persistence.*;

@Entity
@Table(name = "Usuario", schema = "FactoriaProyectos", catalog = "")
public class UsuarioEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "AUTO_ID", nullable = false)
    private int autoId;
    @Basic
    @Column(name = "ID_Centro", nullable = false)
    private int idCentro;
    @Basic
    @Column(name = "ID_USUARIO", nullable = false)
    private int idUsuario;
    @Basic
    @Column(name = "NombreUsuario", nullable = false, length = 30)
    private String nombreUsuario;
    @Basic
    @Column(name = "Nombre", nullable = false, length = 20)
    private String nombre;
    @Basic
    @Column(name = "Apellidos", nullable = false, length = 50)
    private String apellidos;
    @Basic
    @Column(name = "Contraseña", nullable = false, length = 30)
    private String contraseña;
    @Basic
    @Column(name = "Rol", nullable = true, length = 15)
    private String rol;
    @Basic
    @Column(name = "Puntuacion", nullable = true, precision = 0)
    private Double puntuacion;
    @Basic
    @Column(name = "Familia_Profesional", nullable = false)
    private int familiaProfesional;
    @Basic
    @Column(name = "Email", nullable = true, length = 40)
    private String email;
    @Basic
    @Column(name = "Telefono", nullable = true)
    private Integer telefono;
    @ManyToOne
    @JoinColumn(name = "ID_USUARIO", referencedColumnName = "Escritor", nullable = false,updatable = false, insertable = false)
    private ComentariosEntity comentariosByIdUsuario;
    @ManyToOne
    @JoinColumn(name = "ID_USUARIO", referencedColumnName = "id_Usuario", nullable = false,updatable = false, insertable = false)
    private ParticipantesEntity participantesByIdUsuario;
    @ManyToOne
    @JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID_USUARIO", nullable = false,updatable = false, insertable = false)
    private ProyectosFavEntity proyectosFavByIdUsuario;

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

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Double getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(Double puntuacion) {
        this.puntuacion = puntuacion;
    }

    public int getFamiliaProfesional() {
        return familiaProfesional;
    }

    public void setFamiliaProfesional(int familiaProfesional) {
        this.familiaProfesional = familiaProfesional;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsuarioEntity that = (UsuarioEntity) o;

        if (autoId != that.autoId) return false;
        if (idCentro != that.idCentro) return false;
        if (idUsuario != that.idUsuario) return false;
        if (familiaProfesional != that.familiaProfesional) return false;
        if (nombreUsuario != null ? !nombreUsuario.equals(that.nombreUsuario) : that.nombreUsuario != null)
            return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;
        if (apellidos != null ? !apellidos.equals(that.apellidos) : that.apellidos != null) return false;
        if (contraseña != null ? !contraseña.equals(that.contraseña) : that.contraseña != null) return false;
        if (rol != null ? !rol.equals(that.rol) : that.rol != null) return false;
        if (puntuacion != null ? !puntuacion.equals(that.puntuacion) : that.puntuacion != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (telefono != null ? !telefono.equals(that.telefono) : that.telefono != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = autoId;
        result = 31 * result + idCentro;
        result = 31 * result + idUsuario;
        result = 31 * result + (nombreUsuario != null ? nombreUsuario.hashCode() : 0);
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (apellidos != null ? apellidos.hashCode() : 0);
        result = 31 * result + (contraseña != null ? contraseña.hashCode() : 0);
        result = 31 * result + (rol != null ? rol.hashCode() : 0);
        result = 31 * result + (puntuacion != null ? puntuacion.hashCode() : 0);
        result = 31 * result + familiaProfesional;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (telefono != null ? telefono.hashCode() : 0);
        return result;
    }

    public ComentariosEntity getComentariosByIdUsuario() {
        return comentariosByIdUsuario;
    }

    public void setComentariosByIdUsuario(ComentariosEntity comentariosByIdUsuario) {
        this.comentariosByIdUsuario = comentariosByIdUsuario;
    }

    public ParticipantesEntity getParticipantesByIdUsuario() {
        return participantesByIdUsuario;
    }

    public void setParticipantesByIdUsuario(ParticipantesEntity participantesByIdUsuario) {
        this.participantesByIdUsuario = participantesByIdUsuario;
    }

    public ProyectosFavEntity getProyectosFavByIdUsuario() {
        return proyectosFavByIdUsuario;
    }

    public void setProyectosFavByIdUsuario(ProyectosFavEntity proyectosFavByIdUsuario) {
        this.proyectosFavByIdUsuario = proyectosFavByIdUsuario;
    }
}
