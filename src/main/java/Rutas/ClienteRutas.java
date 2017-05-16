
package Rutas;

import Util.JsonUtils;
import static spark.Spark.post;
import static spark.Spark.put;
import static Servicios.ClienteServicios.insertCliente;
import static Servicios.ClienteServicios.queryCliente;


/**
 *
 * @author Prueba
 */
public class ClienteRutas {
    
     private ClienteRutas() {}

    /**
     * Sets the client routes.
     */
    public static void setClienteRutas() {
        post("/clientes", ((request, response) -> queryCliente(JsonUtils.fromJson(request.body()))), JsonUtils::toJson);
        put("/clientes", ((request, response) -> insertCliente(JsonUtils.fromJson(request.body()))), JsonUtils::toJson);
              
    }
    
}
