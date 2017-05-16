/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rutas;

import static Servicios.RepVentaServicios.queryRepresentante;
import Util.JsonUtils;
import static spark.Spark.post;

/**
 *
 * @author Prueba
 */

public class RepVentasRutas {

    private RepVentasRutas() {
    }


    public static void setRepVentasRutas() {

        post("/mecanico", ((request, response) -> queryRepresentante(JsonUtils.fromJson(request.body()))), JsonUtils::toJson);

    }
    
}
