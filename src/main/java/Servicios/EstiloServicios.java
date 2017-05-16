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
import Modelos.VehiculoEstilo;
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
public class EstiloServicios {

    private EstiloServicios() {
    }

    //Queries de la tabla estilo
    public static JsonResponse<VehiculoEstilo> queryEstilo(JsonObject jsonObject) throws SQLException {
        String id_modelo = jsonObject.get(Constantes.JSON_KEY_MODELO).getAsString();
        String argumentos;

        if (id_modelo == null) {
            argumentos = " WHERE " + CheckMobileTables.VEHICULO_ESTILO.ESTADO + " = " + " 'A'"
                    + CheckMobileTables.VEHICULO_ESTILO.ID_EMPRESA + " = " + Constantes.ID_EMPRESA;
        }
        else{
            argumentos = " WHERE " + CheckMobileTables.VEHICULO_ESTILO.ID_MODELO + "=" + id_modelo
                    + CheckMobileTables.VEHICULO_ESTILO.ESTADO + " = " + "  'A'" + "AND" 
                    + CheckMobileTables.VEHICULO_ESTILO.ID_EMPRESA + " = " + Constantes.ID_EMPRESA;;
        }
        

        SqlStatement sqlStatement = new SqlStatement();
        sqlStatement.setOperation(OperacionSql.SqlOperation.SELECT);
        sqlStatement.setTable(CheckMobileTables.VEHICULO_ESTILO.TABLE_NAME);
        sqlStatement.setProjection("*");
        sqlStatement.setArguments(argumentos);
        sqlStatement.setOrderBy(CheckMobileTables.VEHICULO_ESTILO.ID_ESTILO);

        List<Object> objetos = UtilsDB.executeQuery(sqlStatement, ObjetosDB.VEHICULO_ESTILO);
        List<VehiculoEstilo> veh = new ArrayList<>();
        for (Object currentCliente : objetos) {
            VehiculoEstilo cte = (VehiculoEstilo) currentCliente;
            veh.add(cte);

        }
        //UtilsDB.
        JsonResponse<VehiculoEstilo> response = new JsonResponse<>();
        response.setData(veh);
        response.setMessage("Successful.");

        return response;

    }

    /**
     * Inserts lista de estilos
     *
     * @param jsonObject The request body content.
     * @return The numbers of rows inserted.
     */
    public static JsonResponse insertEstilo(JsonObject jsonObject) {
        Type type = new TypeToken<ArrayList<VehiculoEstilo>>() {
        }.getType();
        ArrayList<VehiculoEstilo> veh = (ArrayList<VehiculoEstilo>) JsonUtils.fromJson(jsonObject.get(Constantes.JSON_KEY_ESTILO).getAsString(), type);
        int registroInsertado = UtilsDB.executeInsert(veh, ObjetosDB.VEHICULO_ESTILO);
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
