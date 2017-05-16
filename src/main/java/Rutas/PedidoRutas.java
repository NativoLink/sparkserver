
package Rutas;

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
public class PedidoRutas {
      private PedidoRutas() {
    }

    public static JsonResponse<PedidoEnc> queryPedido(JsonObject jsonObject) throws SQLException {

        String id_documento = "";
        String argumentos = "WHERE " + CheckMobileTables.PEDIDO_ENC.ID_DOCUMENTO + "=" + id_documento;
        SqlStatement sqlStatement = new SqlStatement();
        sqlStatement.setOperation(OperacionSql.SqlOperation.SELECT);
        sqlStatement.setTable(CheckMobileTables.PEDIDO_ENC.TABLE_NAME);
        sqlStatement.setProjection("*");
        sqlStatement.setArguments(argumentos);
        sqlStatement.setOrderBy(CheckMobileTables.PEDIDO_ENC.ID_DOCUMENTO);
             
        List<Object> objects = UtilsDB.executeQuery(sqlStatement, ObjetosDB.INSPECCION_VEHICULO_DETALLE);
        List<PedidoEnc> inspeccion = new ArrayList<>();
        for (Object currentInspeccion : objects) {
            PedidoEnc insp = (PedidoEnc) currentInspeccion;
            inspeccion.add(insp);
        }

        JsonResponse<PedidoEnc> response = new JsonResponse<>();
        response.setData(inspeccion);
        response.setMessage("Successful.");

        return response;

    }

    public static JsonResponse insertInspeccionDet(JsonObject jsonObject) {

        Type inspeccionListType = new TypeToken<ArrayList<PedidoEnc>>() {
        }.getType();
        ArrayList<PedidoEnc> inspeccion
                = (ArrayList<PedidoEnc>) JsonUtils.fromJson(jsonObject.get(Constantes.JSON_KEY_INSPECCION).getAsString(), inspeccionListType);

        int registroInsertado = UtilsDB.executeInsert(inspeccion, ObjetosDB.INSPECCION_VEHICULO_DETALLE);

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
