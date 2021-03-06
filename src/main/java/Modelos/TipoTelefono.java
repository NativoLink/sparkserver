package Modelos;
// Generated mar 27, 2017 10:48:16 a.m. by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * TipoTelefono generated by hbm2java
 */
public class TipoTelefono  implements java.io.Serializable {


     private String id;
     private String estadoRegistro;
     private String descripcion;
     private Date fechaInsercion;
     private String usuarioInsercion;
     private Date fechaActualizacion;
     private String usuarioActualizacion;
     private Long trOrigen;

    public TipoTelefono() {
    }

	
    public TipoTelefono(String id, String estadoRegistro, String descripcion, Date fechaInsercion, String usuarioInsercion) {
        this.id = id;
        this.estadoRegistro = estadoRegistro;
        this.descripcion = descripcion;
        this.fechaInsercion = fechaInsercion;
        this.usuarioInsercion = usuarioInsercion;
    }
    public TipoTelefono(String id, String estadoRegistro, String descripcion, Date fechaInsercion, String usuarioInsercion, Date fechaActualizacion, String usuarioActualizacion, Long trOrigen) {
       this.id = id;
       this.estadoRegistro = estadoRegistro;
       this.descripcion = descripcion;
       this.fechaInsercion = fechaInsercion;
       this.usuarioInsercion = usuarioInsercion;
       this.fechaActualizacion = fechaActualizacion;
       this.usuarioActualizacion = usuarioActualizacion;
       this.trOrigen = trOrigen;
    }
   
    public String getId() {
        return this.id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    public String getEstadoRegistro() {
        return this.estadoRegistro;
    }
    
    public void setEstadoRegistro(String estadoRegistro) {
        this.estadoRegistro = estadoRegistro;
    }
    
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
    public Long getTrOrigen() {
        return this.trOrigen;
    }
    
    public void setTrOrigen(Long trOrigen) {
        this.trOrigen = trOrigen;
    }

  
    



}


