package Modelos;
// Generated mar 27, 2017 10:48:16 a.m. by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Personal generated by hbm2java
 */
public class Personal  implements java.io.Serializable {


     private String id;
     private String nombres;
     private String apellidos;
     private Date fechaNacimiento;
     private String lugarNac;
     private String estadoCivil;
     private long documentoIdentidad;
     private String sexo;
     private String telefono;
     private String direccionEmail;
     private String telefonoMovil;
     private String estado;
     private Date fechaInsercion;
     private String usuarioInsercion;
     private Date fechaActualizacion;
     private String usuarioActualizacion;
     private String usuario;
     private String idUbicacion;
     private Long trOrigen;
     private String pais;
     private String ciudad;
     private String municipio;
     private String sector;
     private String calle;
     private String edificio;

    public Personal() {
    }

	
    public Personal(String id, String nombres, String apellidos, String estadoCivil, long documentoIdentidad, String sexo, String estado, Date fechaInsercion, String usuarioInsercion) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.estadoCivil = estadoCivil;
        this.documentoIdentidad = documentoIdentidad;
        this.sexo = sexo;
        this.estado = estado;
        this.fechaInsercion = fechaInsercion;
        this.usuarioInsercion = usuarioInsercion;
    }
    public Personal(String id, String nombres, String apellidos, Date fechaNacimiento, String lugarNac, String estadoCivil, long documentoIdentidad, String sexo, String telefono, String direccionEmail, String telefonoMovil, String estado, Date fechaInsercion, String usuarioInsercion, Date fechaActualizacion, String usuarioActualizacion, String usuario, String idUbicacion, Long trOrigen, String pais, String ciudad, String municipio, String sector, String calle, String edificio) {
       this.id = id;
       this.nombres = nombres;
       this.apellidos = apellidos;
       this.fechaNacimiento = fechaNacimiento;
       this.lugarNac = lugarNac;
       this.estadoCivil = estadoCivil;
       this.documentoIdentidad = documentoIdentidad;
       this.sexo = sexo;
       this.telefono = telefono;
       this.direccionEmail = direccionEmail;
       this.telefonoMovil = telefonoMovil;
       this.estado = estado;
       this.fechaInsercion = fechaInsercion;
       this.usuarioInsercion = usuarioInsercion;
       this.fechaActualizacion = fechaActualizacion;
       this.usuarioActualizacion = usuarioActualizacion;
       this.usuario = usuario;
       this.idUbicacion = idUbicacion;
       this.trOrigen = trOrigen;
       this.pais = pais;
       this.ciudad = ciudad;
       this.municipio = municipio;
       this.sector = sector;
       this.calle = calle;
       this.edificio = edificio;
    }
   
    public String getId() {
        return this.id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    public String getNombres() {
        return this.nombres;
    }
    
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
    public String getApellidos() {
        return this.apellidos;
    }
    
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public Date getFechaNacimiento() {
        return this.fechaNacimiento;
    }
    
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    public String getLugarNac() {
        return this.lugarNac;
    }
    
    public void setLugarNac(String lugarNac) {
        this.lugarNac = lugarNac;
    }
    public String getEstadoCivil() {
        return this.estadoCivil;
    }
    
    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }
    public long getDocumentoIdentidad() {
        return this.documentoIdentidad;
    }
    
    public void setDocumentoIdentidad(long documentoIdentidad) {
        this.documentoIdentidad = documentoIdentidad;
    }
    public String getSexo() {
        return this.sexo;
    }
    
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    public String getTelefono() {
        return this.telefono;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getDireccionEmail() {
        return this.direccionEmail;
    }
    
    public void setDireccionEmail(String direccionEmail) {
        this.direccionEmail = direccionEmail;
    }
    public String getTelefonoMovil() {
        return this.telefonoMovil;
    }
    
    public void setTelefonoMovil(String telefonoMovil) {
        this.telefonoMovil = telefonoMovil;
    }
    public String getEstado() {
        return this.estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public Date getFechaInsercion() {
        return this.fechaInsercion;
    }
    
    public void setFechaInsercion(Date fechaInsercion) {
        this.fechaInsercion = fechaInsercion;
    }
    public String getUsuarioInsercion() {
        return this.usuarioInsercion;
    }
    
    public void setUsuarioInsercion(String usuarioInsercion) {
        this.usuarioInsercion = usuarioInsercion;
    }
    public Date getFechaActualizacion() {
        return this.fechaActualizacion;
    }
    
    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }
    public String getUsuarioActualizacion() {
        return this.usuarioActualizacion;
    }
    
    public void setUsuarioActualizacion(String usuarioActualizacion) {
        this.usuarioActualizacion = usuarioActualizacion;
    }
    public String getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public String getIdUbicacion() {
        return this.idUbicacion;
    }
    
    public void setIdUbicacion(String idUbicacion) {
        this.idUbicacion = idUbicacion;
    }
    public Long getTrOrigen() {
        return this.trOrigen;
    }
    
    public void setTrOrigen(Long trOrigen) {
        this.trOrigen = trOrigen;
    }
    public String getPais() {
        return this.pais;
    }
    
    public void setPais(String pais) {
        this.pais = pais;
    }
    public String getCiudad() {
        return this.ciudad;
    }
    
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    public String getMunicipio() {
        return this.municipio;
    }
    
    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }
    public String getSector() {
        return this.sector;
    }
    
    public void setSector(String sector) {
        this.sector = sector;
    }
    public String getCalle() {
        return this.calle;
    }
    
    public void setCalle(String calle) {
        this.calle = calle;
    }
    public String getEdificio() {
        return this.edificio;
    }
    
    public void setEdificio(String edificio) {
        this.edificio = edificio;
    }




}

