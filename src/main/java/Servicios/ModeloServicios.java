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
import Modelos.SqlStatement;
import Modelos.VehiculoModelo;
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
public class ModeloServicios {

    private ModeloServicios() {
    }

    //Queries de la tabla modelo
    public static JsonResponse<VehiculoModelo> queryModelo(JsonObject jsonObject) throws SQLException {

        String id_marca = jsonObject.get(Constantes.JSON_KEY_MARCA).getAsString();
        String argumentos;

        if (id_marca == null) {
            argumentos = " WHERE " + CheckMobileTables.VEHICULO_MODELO.ESTADO + " = " + " A"
                    + CheckMobileTables.VEHICULO_MODELO.ID_EMPRESA + " = " + Constantes.ID_EMPRESA;
        } else {
            argumentos = " WHERE " + CheckMobileTables.VEHICULO_MODELO.ID_MARCA + " = " + id_marca + CheckMobileTables.VEHICULO_MODELO.ESTADO + " = " + " A"
                    + CheckMobileTables.VEHICULO_MODELO.ID_EMPRESA + " = " + Constantes.ID_EMPRESA;
        }

        SqlStatement sqlStatement = new SqlStatement();
        sqlStatement.setOperation(OperacionSql.SqlOperation.SELECT);
        sqlStatement.setTable(CheckMobileTables.VEHICULO_MODELO.TABLE_NAME);
        sqlStatement.setProjection("*");
        sqlStatement.setArguments(argumentos);
        sqlStatement.setOrderBy(CheckMobileTables.VEHICULO_MODELO.ID_MODELO);

        List<Object> objetos = UtilsDB.executeQuery(sqlStatement, ObjetosDB.VEHICULO_MODELO);
        List<VehiculoModelo> veh = new ArrayList<>();
        for (Object currentCliente : objetos) {
            VehiculoModelo cte = (VehiculoModelo) currentCliente;
            veh.add(cte);

        }
        //UtilsDB.
        JsonResponse<VehiculoModelo> response = new JsonResponse<>();
        response.setData(veh);
        response.setMessage("Successful.");

        return response;

    }

    /**
     * Inserts a list of modelos.
     *
     * @param jsonObject The request body content.
     * @return The numbers of rows inserted.
     */
    public static JsonResponse insertModelo(JsonObject jsonObject) {
        Type type = new TypeToken<ArrayList<VehiculoModelo>>() {
        }.getType();
        ArrayList<VehiculoModelo> veh = (ArrayList<VehiculoModelo>) JsonUtils.fromJson(jsonObject.get(Constantes.JSON_KEY_MODELO).getAsString(), type);
        int registroInsertado = UtilsDB.executeInsert(veh, ObjetosDB.VEHICULO_MODELO);
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
