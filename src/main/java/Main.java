import Util.JsonUtils;
import com.google.gson.Gson;

import static Servicios.EstiloServicios.queryEstilo;
import static spark.Spark.get;
import static spark.Spark.port;

/**
 * Created by NativoLink on 16/5/17.
 */
public class Main {
    public static void main(String[] args) {

        port(8080);
        get("/hello", (req, res) -> {
            res.status(200);
            res.type("application/json");
            return "{\"Name\":\""+req.queryParams("nombre")+"\"}";
        });

        Gson gson = new Gson();
        get("/", (req, res) -> "klk:klk", gson::toJson);


        get("/estilo", (req, res) -> queryEstilo(JsonUtils.fromJson(req.body())), JsonUtils::toJson);
    }
}
