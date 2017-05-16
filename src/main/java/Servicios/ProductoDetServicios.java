/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Datos.CheckMobileTables;
import Datos.UtilsDB;
import Modelos.JsonResponse;
import Modelos.ObjetosDB;
import Modelos.OperacionSql;
import Modelos.ProductoPrecio;
import Modelos.SqlStatement;
import Util.Constantes;
import Util.JsonUtils;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Prueba
 */
public class ProductoDetServicios {

    private ProductoDetServicios() {
    }

    public static JsonResponse<ProductoPrecio> queryProductoDet(JsonObject jsonObject) throws SQLException {

        String id_servicio = jsonObject.get(Constantes.JSON_KEY_PRODUCTO_ID).getAsString();
        String argumentos;
        if (id_servicio == null) {

            argumentos = "WHERE " + CheckMobileTables.PRODUCTO_PRECIO.ID_SERVICIO + " = "
                    + CheckMobileTables.PRODUCTO_SERVICIOS.ID_SERVICIO + " AND " + CheckMobileTables.PRODUCTO_PRECIO.ESTADO + " = 'A'"
                    + "AND" + CheckMobileTables.PRODUCTO_PRECIO.ID_EMPRESA + " = " + CheckMobileTables.PRODUCTO_SERVICIOS.ID_EMPRESA;

        } else {
            argumentos = "WHERE " + "WHERE " + CheckMobileTables.PRODUCTO_PRECIO.ID_SERVICIO + " = "
                    + CheckMobileTables.PRODUCTO_SERVICIOS.ID_SERVICIO + " AND " + CheckMobileTables.PRODUCTO_PRECIO.ESTADO + " = 'A'"
                    + "AND" + CheckMobileTables.PRODUCTO_PRECIO.ID_EMPRESA + " = " + CheckMobileTables.PRODUCTO_SERVICIOS.ID_EMPRESA
                    + CheckMobileTables.PRODUCTO_PRECIO.ID_SERVICIO + "=" + id_servicio;

        }

        SqlStatement sqlStatement = new SqlStatement();
        sqlStatement.setOperation(OperacionSql.SqlOperation.SELECT);
        sqlStatement.setTable(CheckMobileTables.PRODUCTO_PRECIO.TABLE_NAME);
        sqlStatement.setProjection("*");
        sqlStatement.setArguments(argumentos);
        sqlStatement.setOrderBy(CheckMobileTables.PRODUCTO_PRECIO.ID_SERVICIO);

        List<Object> objects = UtilsDB.executeQuery(sqlStatement, ObjetosDB.PRODUCTO_PRECIO);
        List<ProductoPrecio> producto_precio = new ArrayList<>();
        for (Object currentInspeccion : objects) {
            ProductoPrecio insp = (ProductoPrecio) currentInspeccion;
            producto_precio.add(insp);
        }

        JsonResponse<ProductoPrecio> response = new JsonResponse<>();
        response.setData(producto_precio);
        response.setMessage("Successful.");

        return response;

    }

    public static JsonResponse insertProductoDet(JsonObject jsonObject) {

        Type pedidoListType = new TypeToken<ArrayList<ProductoPrecio>>() {
        }.getType();
        ArrayList<ProductoPrecio> producto_servicio
                = (ArrayList<ProductoPrecio>) JsonUtils.fromJson(jsonObject.get(Constantes.JSON_KEY_PRODUCTO_ID).getAsString(), pedidoListType);

        int registroInsertado = UtilsDB.executeInsert(producto_servicio, ObjetosDB.PRODUCTO_SERVICIOS);

        String codigoServidor = registroInsertado > 0 ? Constantes.RESPONSE_CODE_OK : Constantes.RESPONSE_CODE_OK;

        JsonResponse respuesta = new JsonResponse<>();
        respuesta.setRows(registroInsertado);

        if (codigoServidor.equals(Constantes.RESPONSE_CODE_OK)) {
            respuesta.setMessage("Listo.");
        } else {
            respuesta.setResponseCode(codigoServidor);
            respuesta.setMessage("Ha ocurrido un error");
        }
        return respuesta;
    }
}
