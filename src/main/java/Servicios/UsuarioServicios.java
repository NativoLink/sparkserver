/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Datos.CheckMobileTables;
import Util.Constantes;
import com.google.gson.JsonObject;
import Modelos.*;
import Datos.UtilsDB;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Prueba
 */
public class UsuarioServicios {

    private UsuarioServicios() {
    }

    public static JsonResponse<Personal> queryUsuarioadmin(JsonObject jsonObject) throws SQLException {
        String user = jsonObject.get(Constantes.JSON_USARIO_ADMIN).getAsString();
        String password = jsonObject.get(Constantes.JSON_CLAVE_USUARIO_ADMIN).getAsString();

        SqlStatement sqlStatement = new SqlStatement();
        sqlStatement.setOperation(OperacionSql.SqlOperation.SELECT);
        sqlStatement.setTable(CheckMobileTables.CLIENTE.TABLE_NAME);
        sqlStatement.setProjection("*");
        String argument = " WHERE " + CheckMobileTables.PERSONAL.USUARIO + " = \'" + user + "\'"
                + " AND " + CheckMobileTables.PERSONAL.CLAVE + " = \'" + password + "\'"
                + "AND " + CheckMobileTables.PERSONAL.ID_EMPRESA + " = " + Constantes.ID_EMPRESA;
        sqlStatement.setArguments(argument);
        sqlStatement.setOrderBy(CheckMobileTables.PERSONAL.ID_USUARIO);

        List<Object> objects = UtilsDB.executeQuery(sqlStatement, ObjetosDB.PERSONAL);

        JsonResponse<Personal> response = new JsonResponse<>();
        String responseCode = objects.size() > 0 ? Constantes.RESPONSE_CODE_OK : Constantes.RESPONSE_CODE_ERROR;
        response.setResponseCode(responseCode);

        return response;
    }
}
