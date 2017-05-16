
package Rutas;


import static Servicios.VehiculoServicios.insertVehiculo;
import static Servicios.VehiculoServicios.queryVehiculo;
import Util.JsonUtils;
import static spark.Spark.post;
import static spark.Spark.put;

/**
 *
 * @author Prueba
 */
public class VehiculoRutas {
  
    private VehiculoRutas() {}

  
    /**
     * Sets the client routes.
     */
    public static void setVehiculoRutas() {
        post("/vehiculo", ((request, response) -> queryVehiculo(JsonUtils.fromJson(request.body()))), JsonUtils::toJson);
        put("/vehiculo", ((request, response) -> insertVehiculo (JsonUtils.fromJson(request.body()))), JsonUtils::toJson);
    }
    
       
}
