package Servicios;

import Datos.CheckMobileTables;
import Datos.UtilsDB;
import Modelos.CteRepresentanteVen;
import Modelos.JsonResponse;
import Modelos.ObjetosDB;
import Modelos.OperacionSql;
import Modelos.SqlStatement;
import Util.Constantes;
import com.google.gson.JsonObject;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Prueba
 */
public class RepVentaServicios {

    private RepVentaServicios() {
    }

    public static JsonResponse<CteRepresentanteVen> queryRepresentante(JsonObject jsonObject) throws SQLException {

        SqlStatement sqlStatement = new SqlStatement();
        sqlStatement.setOperation(OperacionSql.SqlOperation.SELECT);
        sqlStatement.setTable(CheckMobileTables.CTE_REPRESENTANTE_VEN.TABLE_NAME);
        sqlStatement.setProjection("*");
        String argument = " WHERE " + CheckMobileTables.CTE_REPRESENTANTE_VEN.ESTADO + " = 'A' "
                + CheckMobileTables.CTE_REPRESENTANTE_VEN.ID_EMPRESA + " = " + Constantes.ID_EMPRESA;

        sqlStatement.setOrderBy(CheckMobileTables.CTE_REPRESENTANTE_VEN.ID_REPRESENTANTE);

        List<Object> objects = UtilsDB.executeQuery(sqlStatement, ObjetosDB.CTE_REPRESENTANTE_VEN);

        JsonResponse<CteRepresentanteVen> response = new JsonResponse<>();
        String responseCode = objects.size() > 0 ? Constantes.RESPONSE_CODE_OK : Constantes.RESPONSE_CODE_ERROR;
        response.setResponseCode(responseCode);

        return response;
    }
}
