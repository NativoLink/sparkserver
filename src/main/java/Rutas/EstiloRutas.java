/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rutas;

import static Servicios.EstiloServicios.insertEstilo;
import static Servicios.EstiloServicios.queryEstilo;
import Util.JsonUtils;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;
import static spark.Spark.get;
import static spark.Spark.post;
import static spark.Spark.put;

/**
 *
 * @author Prueba
 */
public class EstiloRutas {

    private EstiloRutas() {
    }

    public static void setEstiloRutas() {
       // get("/estilo", "application/json", ((request, response) -> request.body()));
        //Spark.get("/estilo/", "application/json", ((request, response) -> insertEstilo(JsonUtils.fromJson(request.body()))), null);
       // get("/estilo/", (request, response) -> {
    //return "Hello: ";
//});
       get ("/estilo" , ((req, res) -> queryEstilo(JsonUtils.fromJson(req.body()))), JsonUtils::toJson);
       get ("/estilo" , ((req, res) -> res.raw()));
        //post("/estilo", "application/json", ((request, response) -> queryEstilo(JsonUtils.fromJson(request.body()))), JsonUtils::toJson);
       // put("/estilo", ((request, response) -> insertEstilo(JsonUtils.fromJson(request.body()))), JsonUtils::toJson);
      }
    
    

}
