
package Servicios;

import Datos.CheckMobileTables;
import Datos.UtilsDB;
import Modelos.JsonResponse;
import Modelos.ObjetosDB;
import Modelos.OperacionSql;
import Modelos.SqlStatement;
import Modelos.VehiculoMarca;
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
public class MarcaServicios {
 
      private MarcaServicios() {
    }

    //Queries de la tabla marca
    public static JsonResponse<VehiculoMarca> queryMarca(JsonObject jsonObject) throws SQLException {
        String argumentos = " WHERE "+ CheckMobileTables.VEHICULO_MARCA.ESTADO + " = " + " A"
                + CheckMobileTables.VEHICULO.ID_EMPRESA + " = " + Constantes.ID_EMPRESA;
        SqlStatement sqlStatement = new SqlStatement();
        sqlStatement.setOperation(OperacionSql.SqlOperation.SELECT);
        sqlStatement.setTable(CheckMobileTables.VEHICULO_MARCA.TABLE_NAME);
        sqlStatement.setProjection("*");
        sqlStatement.setArguments(argumentos);
        sqlStatement.setOrderBy(CheckMobileTables.VEHICULO_MARCA.ID_MARCA);

        List<Object> objetos = UtilsDB.executeQuery(sqlStatement, ObjetosDB.VEHICULO_MARCA);
        List<VehiculoMarca> veh = new ArrayList<>();
        for (Object currentCliente : objetos) {
            VehiculoMarca cte = (VehiculoMarca) currentCliente;
            veh.add(cte);

        }
        //UtilsDB.
        JsonResponse<VehiculoMarca> response = new JsonResponse<>();
        response.setData(veh);
        response.setMessage("Successful.");

        return response;

    }

    /**
     * Inserts una lista de marcas.
     *
     * @param jsonObject The request body content.
     * @return The numbers of rows inserted.
     */
    public static JsonResponse insertMarca(JsonObject jsonObject) {
        Type type = new TypeToken<ArrayList<VehiculoMarca>>() {
        }.getType();
        ArrayList<VehiculoMarca> veh = (ArrayList<VehiculoMarca>) JsonUtils.fromJson(jsonObject.get(Constantes.JSON_KEY_MARCA).getAsString(), type);
        int registroInsertado = UtilsDB.executeInsert(veh, ObjetosDB.VEHICULO_MARCA);
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
