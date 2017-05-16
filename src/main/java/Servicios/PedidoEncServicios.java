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
import Modelos.PedidoEnc;
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
public class PedidoEncServicios {

    private PedidoEncServicios() {
    }

    //Queries de la tabla pedido_enc
    public static JsonResponse<PedidoEnc> queryPedidoEnc(JsonObject jsonObject) throws SQLException {

        String id_documento = jsonObject.get(Constantes.JSON_KEY_PEDIDO_ID).getAsString();
        String argumentos;
        if (id_documento == null) {
            argumentos = " WHERE " + CheckMobileTables.PEDIDO_ENC.ESTADO + " = 'A'" + " AND "
                    + CheckMobileTables.PEDIDO_ENC.ID_EMPRESA + " = " + Constantes.ID_EMPRESA;
        } else {
            argumentos = " WHERE " + CheckMobileTables.PEDIDO_ENC.ID_DOCUMENTO + "=" + id_documento + CheckMobileTables.PEDIDO_ENC.ESTADO + " = 'A'" + " AND "
                    + CheckMobileTables.PEDIDO_ENC.ID_EMPRESA + " = " + Constantes.ID_EMPRESA;

        }

        SqlStatement sqlStatement = new SqlStatement();
        sqlStatement.setOperation(OperacionSql.SqlOperation.SELECT);
        sqlStatement.setTable(CheckMobileTables.PEDIDO_ENC.TABLE_NAME);
        sqlStatement.setProjection("*");
        sqlStatement.setArguments(argumentos);
        sqlStatement.setOrderBy(CheckMobileTables.PEDIDO_ENC.ID_DOCUMENTO);

        List<Object> objects = UtilsDB.executeQuery(sqlStatement, ObjetosDB.PEDIDO_ENC);
        List<PedidoEnc> pedidos = new ArrayList<>();
        for (Object currentInspeccion : objects) {
            PedidoEnc insp = (PedidoEnc) currentInspeccion;
            pedidos.add(insp);
        }

        JsonResponse<PedidoEnc> response = new JsonResponse<>();
        response.setData(pedidos);
        response.setMessage("Successful.");

        return response;

    }

    //Inserts de lista de pedido
    public static JsonResponse insertPedidoEnc(JsonObject jsonObject) {

        Type pedidoListType = new TypeToken<ArrayList<PedidoEnc>>() {
        }.getType();
        ArrayList<PedidoEnc> pedido
                = (ArrayList<PedidoEnc>) JsonUtils.fromJson(jsonObject.get(Constantes.JSON_KEY_PEDIDO_ID).getAsString(), pedidoListType);

        int registroInsertado = UtilsDB.executeInsert(pedido, ObjetosDB.PEDIDO_ENC);

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
