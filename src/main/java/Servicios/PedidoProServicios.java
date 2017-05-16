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
import Modelos.PedidoProducto;
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
public class PedidoProServicios {

    private PedidoProServicios() {
    }

    public static JsonResponse<PedidoProducto> queryPedidoDet(JsonObject jsonObject) throws SQLException {

        String id_documento = jsonObject.get(Constantes.JSON_KEY_PEDIDO_ID).getAsString();
        String argumentos;
        if (id_documento == null) {
            argumentos = "WHERE" + CheckMobileTables.PEDIDO_PRODUCTO.ID_DOCUMENTO 
                    + " = " + CheckMobileTables.PEDIDO_ENC.ID_DOCUMENTO 
                    + CheckMobileTables.PEDIDO_PRODUCTO.ID_EMPRESA + " = "
                    + Constantes.JSON_KEY_ID_EMPRESA + " AND " + CheckMobileTables.PEDIDO_PRODUCTO.ESTADO + " = 'A'";

        } else {
            argumentos = "WHERE " + CheckMobileTables.PEDIDO_PRODUCTO.ID_DOCUMENTO + " = " + id_documento
                    + CheckMobileTables.PEDIDO_PRODUCTO.ID_DOCUMENTO 
                    + " = " + CheckMobileTables.PEDIDO_ENC.ID_DOCUMENTO 
                    + " AND " + CheckMobileTables.PEDIDO_PRODUCTO.ID_EMPRESA + "=" + Constantes.JSON_KEY_ID_EMPRESA
                    + " AND " + CheckMobileTables.PEDIDO_PRODUCTO.ESTADO + " = A";
        }
        SqlStatement sqlStatement = new SqlStatement();
        sqlStatement.setOperation(OperacionSql.SqlOperation.SELECT);
        sqlStatement.setTable(CheckMobileTables.PEDIDO_PRODUCTO.TABLE_NAME);
        sqlStatement.setProjection("*");
        sqlStatement.setArguments(argumentos);
        sqlStatement.setOrderBy(CheckMobileTables.PEDIDO_PRODUCTO.ID_DOCUMENTO);

        List<Object> objects = UtilsDB.executeQuery(sqlStatement, ObjetosDB.PEDIDO_PRODUCTO);
        List<PedidoProducto> inspeccion = new ArrayList<>();
        for (Object currentInspeccion : objects) {
            PedidoProducto insp = (PedidoProducto) currentInspeccion;
            inspeccion.add(insp);
        }

        JsonResponse<PedidoProducto> response = new JsonResponse<>();
        response.setData(inspeccion);
        response.setMessage("Successful.");

        return response;

    }

    public static JsonResponse insertPedidoDet(JsonObject jsonObject) {

        Type pedidoListType = new TypeToken<ArrayList<PedidoProducto>>() {
        }.getType();
        ArrayList<PedidoProducto> pedido
                = (ArrayList<PedidoProducto>) JsonUtils.fromJson(jsonObject.get(Constantes.JSON_KEY_PEDIDO_ID).getAsString(), pedidoListType);

        int registroInsertado = UtilsDB.executeInsert(pedido, ObjetosDB.PEDIDO_PRODUCTO);

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
