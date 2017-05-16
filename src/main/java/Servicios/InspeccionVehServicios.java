/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Datos.CheckMobileTables;
import Datos.UtilsDB;
import Modelos.InspeccionVehiculo;
import Modelos.JsonResponse;
import Modelos.ObjetosDB;
import Modelos.OperacionSql.SqlOperation;
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
public class InspeccionVehServicios {

    private InspeccionVehServicios() {
    }

    //Queries en la tabla inspeccion_vehiculo
    public static JsonResponse<InspeccionVehiculo> queryInspeccionVeh(JsonObject jsonObject) throws SQLException {

        String id_inspeccion = jsonObject.get(Constantes.JSON_KEY_INSPECCION).getAsString();
        String argumentos;
        if (id_inspeccion == null) {
            argumentos = "WHERE " + CheckMobileTables.INSPECCION_VEHICULO.ID_INSPECCION
                    + " = " + id_inspeccion + " AND " + CheckMobileTables.INSPECCION_VEHICULO.ID_EMPRESA + " = " + Constantes.ID_EMPRESA
                    + " AND " + CheckMobileTables.INSPECCION_VEHICULO.ESTADO + " = 'A'";
        } else {
            argumentos = "WHERE " + CheckMobileTables.INSPECCION_VEHICULO.ID_EMPRESA + " = " + Constantes.ID_EMPRESA
                    + " AND " + CheckMobileTables.INSPECCION_VEHICULO.ESTADO + " = 'A'";
        }
        SqlStatement sqlStatement = new SqlStatement();
        sqlStatement.setOperation(SqlOperation.SELECT);
        sqlStatement.setTable(CheckMobileTables.INSPECCION_VEHICULO.TABLE_NAME);
        sqlStatement.setProjection("*");
        sqlStatement.setArguments(argumentos);
        sqlStatement.setOrderBy(CheckMobileTables.INSPECCION_VEHICULO.ID_INSPECCION);

        List<Object> objects = UtilsDB.executeQuery(sqlStatement, ObjetosDB.INSPECCION_VEHICULO);
        List<InspeccionVehiculo> inspeccion = new ArrayList<>();
        for (Object currentInspeccion : objects) {
            InspeccionVehiculo insp = (InspeccionVehiculo) currentInspeccion;
            inspeccion.add(insp);
        }

        JsonResponse<InspeccionVehiculo> response = new JsonResponse<>();
        response.setData(inspeccion);
        response.setMessage("Successful.");

        return response;

    }
    //Inserts lista de inspecciones de vehiculos 

    public static JsonResponse insertInspeccion(JsonObject jsonObject) {

        Type inspeccionListType = new TypeToken<ArrayList<InspeccionVehiculo>>() {
        }.getType();
        ArrayList<InspeccionVehiculo> inspeccion
                = (ArrayList<InspeccionVehiculo>) JsonUtils.fromJson(jsonObject.get(Constantes.JSON_KEY_INSPECCION).getAsString(), inspeccionListType);

        int registroInsertado = UtilsDB.executeInsert(inspeccion, ObjetosDB.INSPECCION_VEHICULO);

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
