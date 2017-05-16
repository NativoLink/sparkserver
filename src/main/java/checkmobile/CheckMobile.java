package checkmobile;

import static Rutas.ClienteRutas.setClienteRutas;
import static Rutas.EstiloRutas.setEstiloRutas;
import static Rutas.InspeccionDetRutas.setInspeccionRuta;
import static Rutas.InspeccionRutas.setInspeccionEncRuta;
import static Rutas.MarcaRutas.setMarcaRutas;
import static Rutas.ModeloRutas.setModeloRutas;
import static Rutas.PedidoDetRutas.setPedidoDetRutas;
import static Rutas.PedidoEncRutas.setPedidoEncRutas;
import static Rutas.ProductoPrecioRutas.setProductoPrecioRutas;
import static Rutas.ProductoServicioRutas.setProductoServiciosRutas;
import static Rutas.RepVentasRutas.setRepVentasRutas;
import static Rutas.TablaDgiiRutas.setTablaDgiiRutas;
import static Rutas.UsuarioAdminRutas.setUsuarioAdminRutas;
import static Rutas.VehiculoRutas.setVehiculoRutas;
import Util.Utils;
import Util.*;
import com.google.gson.JsonObject;
import spark.Request;
import spark.Spark;
import static spark.Spark.*;

/**
 *
 * @author Prueba
 */
public class CheckMobile {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Utils.log("Cargando...");
        boolean setUpStatus = Utils.setUpConfigParameters();

        if (!setUpStatus) {
            System.out.println("No se pudo ejecutar la configuracion.");
            return;
        }

        Utils.log("Setting up database connection...");

        if (setConnection()) {
            Utils.log("Setting up API filters...");

           // setBefore();
            //setAfter();
//            Spark.staticFileLocation("/checkmobile");

            Utils.log("Setting up API routes...");
            setRoutes();

            exception(Exception.class, (exception, request, response) -> {
            });

            Utils.log("API up and running.");
        } else {
            Utils.log("Connection with the database could not be established.");
        }
    }

    private static boolean setConnection() {
        return conexion.getConnection() != null;
    }

    /**
     * Sets the before filter.
     */
    private static void setBefore() {
        before((request, response) -> {
            boolean authenticated = authenticateRequest(request);

            if (!authenticated) {
                halt(401, "Accesso denegado");
            }
        });
    }

    private static void setAfter() {
        after((request, response) -> response.type(Constantes.JSON));
    }

    private static boolean authenticateRequest(Request request) {
        String uniqueId = "ANDROIDJAVAORACLE";
        String value = "";
        JsonObject jsonObject = JsonUtils.fromJson(request.body());
        String encryptedValue = jsonObject.get(Constantes.JSON_KEY_API_KEY).getAsString();

        try {
            value = Encryption.decrypt(encryptedValue);
        } catch (Exception e) {
        }

        return value.equals(uniqueId);
    }

    //cargando las rutas
    private static void setRoutes() {
        setClienteRutas();
        setEstiloRutas();
        setInspeccionRuta();
        setInspeccionEncRuta();
        setMarcaRutas();
        setModeloRutas();
        setPedidoDetRutas();
        setPedidoEncRutas();
        setProductoPrecioRutas();
        setProductoServiciosRutas();
        setRepVentasRutas();
        setTablaDgiiRutas();
        setUsuarioAdminRutas();
        setVehiculoRutas();

    }
}
