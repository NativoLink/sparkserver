
package Rutas;


import static Servicios.PedidoProServicios.insertPedidoDet;
import static Servicios.PedidoProServicios.queryPedidoDet;
import Util.JsonUtils;
import static spark.Spark.post;
import static spark.Spark.put;

/**
 *
 * @author Prueba
 */
public class PedidoDetRutas {
    

public class PedidoEncRutas {
    
    
}
    public static void setPedidoDetRutas() {
        post("/pedidoEnc", ((request, response) -> queryPedidoDet(JsonUtils.fromJson(request.body()))), JsonUtils::toJson);
        put("/pedidoEnc", ((request, response) -> insertPedidoDet(JsonUtils.fromJson(request.body()))), JsonUtils::toJson);
    }

}
