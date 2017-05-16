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
import Modelos.Vehiculo;
import Util.Constantes;
import Util.JsonUtils;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VehiculoServicios {

    private VehiculoServicios() {
    }

    //Queries de la tabla vehiculo
    public static JsonResponse<Vehiculo> queryVehiculo(JsonObject jsonObject) throws SQLException {
        String id_vehiculo = jsonObject.get(Constantes.JSON_KEY_VEHICULO).getAsString();
        String argumentos;
        
        if(id_vehiculo == null){
            argumentos = " WHERE "+ CheckMobileTables.VEHICULO.ESTADO + " = " + " 'A'"
                + CheckMobileTables.VEHICULO.ID_EMPRESA + " = " + Constantes.ID_EMPRESA;
        }
        else
        {
            argumentos = "WHERE " + CheckMobileTables.VEHICULO.ID_VEHICULO + " = " 
                    + id_vehiculo + " AND " + CheckMobileTables.VEHICULO.ESTADO + " = " + " 'A'"
                + CheckMobileTables.VEHICULO.ID_EMPRESA + " = " + Constantes.ID_EMPRESA;
        }
                
        SqlStatement sqlStatement = new SqlStatement();
        sqlStatement.setOperation(OperacionSql.SqlOperation.SELECT);
        sqlStatement.setTable(CheckMobileTables.VEHICULO.TABLE_NAME);
        sqlStatement.setProjection("*");
        sqlStatement.setArguments(argumentos);
        sqlStatement.setOrderBy(CheckMobileTables.VEHICULO.ID_VEHICULO);

        List<Object> objetos = UtilsDB.executeQuery(sqlStatement, ObjetosDB.VEHICULO);
        List<Vehiculo> veh = new ArrayList<>();
        for (Object currentCliente : objetos) {
            Vehiculo cte = (Vehiculo) currentCliente;
            veh.add(cte);

        }
        //UtilsDB.
        JsonResponse<Vehiculo> response = new JsonResponse<>();
        response.setData(veh);
        response.setMessage("Successful.");

        return response;

    }

    /**
     * Inserts lista de vehiculos.
     *
     * @param jsonObject The request body content.
     * @return The numbers of rows inserted.
     */
    public static JsonResponse insertVehiculo(JsonObject jsonObject) {
        Type type = new TypeToken<ArrayList<Vehiculo>>() {
        }.getType();
        ArrayList<Vehiculo> veh = (ArrayList<Vehiculo>) JsonUtils.fromJson(jsonObject.get(Constantes.JSON_KEY_VEHICULO).getAsString(), type);
        int registroInsertado = UtilsDB.executeInsert(veh, ObjetosDB.VEHICULO);
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
