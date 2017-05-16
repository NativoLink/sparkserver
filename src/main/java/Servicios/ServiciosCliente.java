/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Datos.CheckMobileTables;
import Datos.UtilsDB;
import Modelos.*;
import Util.Constantes;
import Util.JsonUtils;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Prueba
 */
public class ServiciosCliente {

    private ServiciosCliente() {
    }

    //Queries de la tabla cliente
    public static JsonResponse<Cliente> queryCliente(JsonObject jsonObject) throws SQLException {
        String id_cliente= "";
        String argumentos = " " + "WHERE " + CheckMobileTables.CLIENTE.ID_CLIENTE
                + " = " + id_cliente + CheckMobileTables.CLIENTE.ESTADO + " = " + " A"
                + CheckMobileTables.CLIENTE.ID_EMPRESA + " = " + Constantes.ID_EMPRESA;
        SqlStatement sqlStatement = new SqlStatement();
        sqlStatement.setOperation(OperacionSql.SqlOperation.SELECT);
        sqlStatement.setTable(CheckMobileTables.CLIENTE.TABLE_NAME);
        sqlStatement.setProjection("*");
        sqlStatement.setArguments(argumentos);
        sqlStatement.setOrderBy(CheckMobileTables.CLIENTE.ID_CLIENTE);

        List<Object> objetos = UtilsDB.executeQuery(sqlStatement, ObjetosDB.CLIENTE);
        List<Cliente> clientes = new ArrayList<>();
        for (Object currentCliente : objetos) {
            Cliente cte = (Cliente) currentCliente;
            clientes.add(cte);

        }
        //UtilsDB.
        JsonResponse<Cliente> response = new JsonResponse<>();
        response.setData(clientes);
        response.setMessage("Successful.");

        return response;

    }

    /**
     * Inserts a list of clients.
     *
     * @param jsonObject The request body content.
     * @return The numbers of rows inserted.
     */
    public static JsonResponse insertCliente(JsonObject jsonObject) {
        Type type = new TypeToken<ArrayList<Cliente>>() {
        }.getType();
        ArrayList<Cliente> cte = (ArrayList<Cliente>) JsonUtils.fromJson(jsonObject.get(Constantes.JSON_KEY_CLIENT).getAsString(), type);
        int registroInsertado = UtilsDB.executeInsert(cte, ObjetosDB.CLIENTE);
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
