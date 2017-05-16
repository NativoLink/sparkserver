package Modelos;
// Generated mar 27, 2017 10:48:16 a.m. by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.Date;

/**
 * Vehiculo generated by hbm2java
 */
public class Vehiculo  implements java.io.Serializable {


     private String id;
     private String id_empresa;
     private String chasis;
     private String idTipoVehiculo;
     private String idMarca;
     private String idModelo;
     private String idEstilo;
     private String nota;
     private String color;
     private String colorInterior;
     private String ano;
     private Date fechaCompra;
     private BigDecimal filaAsiento;
     private BigDecimal cantPuerta;
     private String idCombustible;
     private String idTraccion;
     private String cilindraje;
     private BigDecimal millaje;
     private BigDecimal kilometraje;
     private String referencia;
     private String idMoneda;
     private BigDecimal precioCompra;
     private String placa;
     private Boolean llamar;
     private String idCliente;
     private String estado;
     private Date fechaInsercion;
     private String usuarioInsercion;
     private Date fechaActualizacion;
     private String usuarioActualizacion;
     private Long trOrigen;
     private String idTransmision;
     private String origenFab;
     private String origenComp;
     private String condicionVehi;
     private String estadoVeh;
     private BigDecimal carga;
     private Short pasajeros;
     private Short cilindros;
     private String idEntGarantia;
     private Long kmGarantia;
     private String tiempoGarantia;
     private Character garantia;
     private String notasGarantia;
     private String idUso;
     private Short noVelocidades;
     private String vmUbicacion;
     private String idTipoVehDgii;
     private String modeloSegunDgii;

    public Vehiculo() {
    }

	
    public Vehiculo(String id, String idTipoVehiculo, String idMarca, String idModelo, String idEstilo) {
        this.id = id;
        this.idTipoVehiculo = idTipoVehiculo;
        this.idMarca = idMarca;
        this.idModelo = idModelo;
        this.idEstilo = idEstilo;
    }
    public Vehiculo(String id, String idTipoVehiculo, String idMarca, String idModelo, String idEstilo, String nota, String color, String colorInterior, String ano, Date fechaCompra, BigDecimal filaAsiento, BigDecimal cantPuerta, String idCombustible, String idTraccion, String cilindraje, BigDecimal millaje, BigDecimal kilometraje, String referencia, String idMoneda, BigDecimal precioCompra, String placa, Boolean llamar, String idCliente, String estado, Date fechaInsercion, String usuarioInsercion, Date fechaActualizacion, String usuarioActualizacion, Long trOrigen, String idTransmision, String origenFab, String origenComp, String condicionVehi, String estadoVeh, BigDecimal carga, Short pasajeros, Short cilindros, String idEntGarantia, Long kmGarantia, String tiempoGarantia, Character garantia, String notasGarantia, String idUso, Short noVelocidades, String vmUbicacion, String idTipoVehDgii, String modeloSegunDgii) {
       this.id = id;
       this.idTipoVehiculo = idTipoVehiculo;
       this.idMarca = idMarca;
       this.idModelo = idModelo;
       this.idEstilo = idEstilo;
       this.nota = nota;
       this.color = color;
       this.colorInterior = colorInterior;
       this.ano = ano;
       this.fechaCompra = fechaCompra;
       this.filaAsiento = filaAsiento;
       this.cantPuerta = cantPuerta;
       this.idCombustible = idCombustible;
       this.idTraccion = idTraccion;
       this.cilindraje = cilindraje;
       this.millaje = millaje;
       this.kilometraje = kilometraje;
       this.referencia = referencia;
       this.idMoneda = idMoneda;
       this.precioCompra = precioCompra;
       this.placa = placa;
       this.llamar = llamar;
       this.idCliente = idCliente;
       this.estado = estado;
       this.fechaInsercion = fechaInsercion;
       this.usuarioInsercion = usuarioInsercion;
       this.fechaActualizacion = fechaActualizacion;
       this.usuarioActualizacion = usuarioActualizacion;
       this.trOrigen = trOrigen;
       this.idTransmision = idTransmision;
       this.origenFab = origenFab;
       this.origenComp = origenComp;
       this.condicionVehi = condicionVehi;
       this.estadoVeh = estadoVeh;
       this.carga = carga;
       this.pasajeros = pasajeros;
       this.cilindros = cilindros;
       this.idEntGarantia = idEntGarantia;
       this.kmGarantia = kmGarantia;
       this.tiempoGarantia = tiempoGarantia;
       this.garantia = garantia;
       this.notasGarantia = notasGarantia;
       this.idUso = idUso;
       this.noVelocidades = noVelocidades;
       this.vmUbicacion = vmUbicacion;
       this.idTipoVehDgii = idTipoVehDgii;
       this.modeloSegunDgii = modeloSegunDgii;
    }
   
    public String getId() {
        return this.id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    public String getIdTipoVehiculo() {
        return this.idTipoVehiculo;
    }
    
    public void setIdTipoVehiculo(String idTipoVehiculo) {
        this.idTipoVehiculo = idTipoVehiculo;
    }
    public String getIdMarca() {
        return this.idMarca;
    }
    
    public void setIdMarca(String idMarca) {
        this.idMarca = idMarca;
    }
    public String getIdModelo() {
        return this.idModelo;
    }
    
    public void setIdModelo(String idModelo) {
        this.idModelo = idModelo;
    }
    public String getIdEstilo() {
        return this.idEstilo;
    }
    
    public void setIdEstilo(String idEstilo) {
        this.idEstilo = idEstilo;
    }
    public String getNota() {
        return this.nota;
    }
    
    public void setNota(String nota) {
        this.nota = nota;
    }
    public String getColor() {
        return this.color;
    }
    
    public void setColor(String color) {
        this.color = color;
    }
    public String getColorInterior() {
        return this.colorInterior;
    }
    
    public void setColorInterior(String colorInterior) {
        this.colorInterior = colorInterior;
    }
    public String getAno() {
        return this.ano;
    }
    
    public void setAno(String ano) {
        this.ano = ano;
    }
    public Date getFechaCompra() {
        return this.fechaCompra;
    }
    
    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }
    public BigDecimal getFilaAsiento() {
        return this.filaAsiento;
    }
    
    public void setFilaAsiento(BigDecimal filaAsiento) {
        this.filaAsiento = filaAsiento;
    }
    public BigDecimal getCantPuerta() {
        return this.cantPuerta;
    }
    
    public void setCantPuerta(BigDecimal cantPuerta) {
        this.cantPuerta = cantPuerta;
    }
    public String getIdCombustible() {
        return this.idCombustible;
    }
    
    public void setIdCombustible(String idCombustible) {
        this.idCombustible = idCombustible;
    }
    public String getIdTraccion() {
        return this.idTraccion;
    }
    
    public void setIdTraccion(String idTraccion) {
        this.idTraccion = idTraccion;
    }
    public String getCilindraje() {
        return this.cilindraje;
    }
    
    public void setCilindraje(String cilindraje) {
        this.cilindraje = cilindraje;
    }
    public BigDecimal getMillaje() {
        return this.millaje;
    }
    
    public void setMillaje(BigDecimal millaje) {
        this.millaje = millaje;
    }
    public BigDecimal getKilometraje() {
        return this.kilometraje;
    }
    
    public void setKilometraje(BigDecimal kilometraje) {
        this.kilometraje = kilometraje;
    }
    public String getReferencia() {
        return this.referencia;
    }
    
    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }
    public String getIdMoneda() {
        return this.idMoneda;
    }
    
    public void setIdMoneda(String idMoneda) {
        this.idMoneda = idMoneda;
    }
    public BigDecimal getPrecioCompra() {
        return this.precioCompra;
    }
    
    public void setPrecioCompra(BigDecimal precioCompra) {
        this.precioCompra = precioCompra;
    }
    public String getPlaca() {
        return this.placa;
    }
    
    public void setPlaca(String placa) {
        this.placa = placa;
    }
    public Boolean getLlamar() {
        return this.llamar;
    }
    
    public void setLlamar(Boolean llamar) {
        this.llamar = llamar;
    }
    public String getIdCliente() {
        return this.idCliente;
    }
    
    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
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
    public Long getTrOrigen() {
        return this.trOrigen;
    }
    
    public void setTrOrigen(Long trOrigen) {
        this.trOrigen = trOrigen;
    }
    public String getIdTransmision() {
        return this.idTransmision;
    }
    
    public void setIdTransmision(String idTransmision) {
        this.idTransmision = idTransmision;
    }
    public String getOrigenFab() {
        return this.origenFab;
    }
    
    public void setOrigenFab(String origenFab) {
        this.origenFab = origenFab;
    }
    public String getOrigenComp() {
        return this.origenComp;
    }
    
    public void setOrigenComp(String origenComp) {
        this.origenComp = origenComp;
    }
    public String getCondicionVehi() {
        return this.condicionVehi;
    }
    
    public void setCondicionVehi(String condicionVehi) {
        this.condicionVehi = condicionVehi;
    }
    public String getEstadoVeh() {
        return this.estadoVeh;
    }
    
    public void setEstadoVeh(String estadoVeh) {
        this.estadoVeh = estadoVeh;
    }
    public BigDecimal getCarga() {
        return this.carga;
    }
    
    public void setCarga(BigDecimal carga) {
        this.carga = carga;
    }
    public Short getPasajeros() {
        return this.pasajeros;
    }
    
    public void setPasajeros(Short pasajeros) {
        this.pasajeros = pasajeros;
    }
    public Short getCilindros() {
        return this.cilindros;
    }
    
    public void setCilindros(Short cilindros) {
        this.cilindros = cilindros;
    }
    public String getIdEntGarantia() {
        return this.idEntGarantia;
    }
    
    public void setIdEntGarantia(String idEntGarantia) {
        this.idEntGarantia = idEntGarantia;
    }
    public Long getKmGarantia() {
        return this.kmGarantia;
    }
    
    public void setKmGarantia(Long kmGarantia) {
        this.kmGarantia = kmGarantia;
    }
    public String getTiempoGarantia() {
        return this.tiempoGarantia;
    }
    
    public void setTiempoGarantia(String tiempoGarantia) {
        this.tiempoGarantia = tiempoGarantia;
    }
    public Character getGarantia() {
        return this.garantia;
    }
    
    public void setGarantia(Character garantia) {
        this.garantia = garantia;
    }
    public String getNotasGarantia() {
        return this.notasGarantia;
    }
    
    public void setNotasGarantia(String notasGarantia) {
        this.notasGarantia = notasGarantia;
    }
    public String getIdUso() {
        return this.idUso;
    }
    
    public void setIdUso(String idUso) {
        this.idUso = idUso;
    }
    public Short getNoVelocidades() {
        return this.noVelocidades;
    }
    
    public void setNoVelocidades(Short noVelocidades) {
        this.noVelocidades = noVelocidades;
    }
    public String getVmUbicacion() {
        return this.vmUbicacion;
    }
    
    public void setVmUbicacion(String vmUbicacion) {
        this.vmUbicacion = vmUbicacion;
    }
    public String getIdTipoVehDgii() {
        return this.idTipoVehDgii;
    }
    
    public void setIdTipoVehDgii(String idTipoVehDgii) {
        this.idTipoVehDgii = idTipoVehDgii;
    }
    public String getModeloSegunDgii() {
        return this.modeloSegunDgii;
    }
    
    public void setModeloSegunDgii(String modeloSegunDgii) {
        this.modeloSegunDgii = modeloSegunDgii;
    }

    /**
     * @return the id_empresa
     */
    public String getId_empresa() {
        return id_empresa;
    }

    /**
     * @param id_empresa the id_empresa to set
     */
    public void setId_empresa(String id_empresa) {
        this.id_empresa = id_empresa;
    }

    /**
     * @return the chasis
     */
    public String getChasis() {
        return chasis;
    }

    /**
     * @param chasis the chasis to set
     */
    public void setChasis(String chasis) {
        this.chasis = chasis;
    }




}


