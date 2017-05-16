/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Datos.CheckMobileTables;
import Datos.UtilsDB;
import Modelos.InspeccionVehiculoDetalle;
import Modelos.JsonResponse;
import Modelos.ObjetosDB;
import Modelos.OperacionSql;
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
public class InspeccionDetServicios {

    private InspeccionDetServicios() {
    }

    //Queries tabla Inspeccion_Vehiculo_detalle
    public static JsonResponse<InspeccionVehiculoDetalle> queryInspeccionVehDet(JsonObject jsonObject) throws SQLException {

        String id_inspeccion = jsonObject.get(Constantes.JSON_KEY_INSPECCION).getAsString();
        String argumentos;

        if (id_inspeccion == null) {
            argumentos = "WHERE " + CheckMobileTables.INSPECCION_VEHICULO.ID_INSPECCION
                    + " = " + CheckMobileTables.INSPECCION_VEHICULO_DETALLE.ID_INSPECCION + " AND "
                    + CheckMobileTables.INSPECCION_VEHICULO_DETALLE.ID_EMPRESA + "= " + Constantes.ID_EMPRESA
                    + " AND " + CheckMobileTables.INSPECCION_VEHICULO_DETALLE.ESTADO + " = 'A' ";
        } else {

            argumentos = "WHERE " + CheckMobileTables.INSPECCION_VEHICULO.ID_INSPECCION
                    + " = " + CheckMobileTables.INSPECCION_VEHICULO_DETALLE.ID_INSPECCION + " AND "
                    + CheckMobileTables.INSPECCION_VEHICULO.ID_INSPECCION + "=" + id_inspeccion
                    + CheckMobileTables.INSPECCION_VEHICULO_DETALLE.ID_EMPRESA + "= " + Constantes.ID_EMPRESA
                    + " AND " + CheckMobileTables.INSPECCION_VEHICULO_DETALLE.ESTADO + " = 'A' ";
        }
        SqlStatement sqlStatement = new SqlStatement();
        sqlStatement.setOperation(OperacionSql.SqlOperation.SELECT);
        sqlStatement.setTable(CheckMobileTables.INSPECCION_VEHICULO.TABLE_NAME);
        sqlStatement.setProjection("*");
        sqlStatement.setArguments(argumentos);
        sqlStatement.setOrderBy(CheckMobileTables.INSPECCION_VEHICULO_DETALLE.ID_INSPECCION + " , "
                + CheckMobileTables.INSPECCION_VEHICULO_DETALLE.ID_ELEMENTO_INSPECCION);

        List<Object> objects = UtilsDB.executeQuery(sqlStatement, ObjetosDB.INSPECCION_VEHICULO_DETALLE);
        List<InspeccionVehiculoDetalle> inspeccion = new ArrayList<>();
        
        
        for (Object currentInspeccion : objects) {
            InspeccionVehiculoDetalle insp = (InspeccionVehiculoDetalle) currentInspeccion;
            inspeccion.add(insp);
        }

        JsonResponse<InspeccionVehiculoDetalle> response = new JsonResponse<>();
        response.setData(inspeccion);
        response.setMessage("Successful.");

        return response;

    }

    //Inserts inspecciones de vehiculos
    public static JsonResponse insertInspeccionDet(JsonObject jsonObject) {

        Type inspeccionListType = new TypeToken<ArrayList<InspeccionVehiculoDetalle>>() {
        }.getType();
        ArrayList<InspeccionVehiculoDetalle> inspeccion
                = (ArrayList<InspeccionVehiculoDetalle>) JsonUtils.fromJson(jsonObject.get(Constantes.JSON_KEY_INSPECCION).getAsString(), inspeccionListType);

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
