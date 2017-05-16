/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rutas;

import static Servicios.InspeccionDetServicios.insertInspeccionDet;
import static Servicios.InspeccionDetServicios.queryInspeccionVehDet;
import Util.JsonUtils;
import static spark.Spark.post;
import static spark.Spark.put;

/**
 *
 * @author Prueba
 */
public class InspeccionDetRutas {

    private InspeccionDetRutas() {
    }

    public static void setInspeccionRuta() {
        post("/inspeccion", ((request, response) -> queryInspeccionVehDet(JsonUtils.fromJson(request.body()))), JsonUtils::toJson);
        put("/inspeccion", ((request, response) -> insertInspeccionDet(JsonUtils.fromJson(request.body()))), JsonUtils::toJson);
    }
}
