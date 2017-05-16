
package Util;

/**
 *
 * @author Prueba
 */
public class Constantes {

    // Parametros de base de datos
    public static String USUARIO_DB = "";
    public static String CLAVE_DB = "";
    public static String IP_SERVIDOR = "";
    public static String PUERTO_DB = "";
    public static String SERVICIO_DB = "";
    public static String URL_DB = "jdbc:oracle:thin:@%s:%s:%s";
    public static final String USUARIO_PROPIEDAD = "user";
    public static final String CLAVE_PROPIEDAD = "password";
    public static final String ID_EMPRESA = "";
    
    // tipos de respuestas
    public static final String JSON = "application/getJsonTransformer";

    // codigos de respuestas
    public static final String RESPONSE_CODE_OK = "200";
    public static final String RESPONSE_CODE_ERROR = "500";

    // formato de fecha
    public static final String DATE_SHORT_FORMAT = "dd/MM/yyyy";
    public static final String DATE_LONG_FORMAT = "dd/MM/yyyy HH:mm:ss";
    public static final int SHORT_DATE_FORMAT = 1;
    public static final int LONG_DATE_FORMAT = 2;

    // claves Json
    public static final String JSON_KEY_INSPECCION = "inspecciones";
    public static final String JSON_KEY_CLIENT = "clients";
    public static final String JSON_KEY_VEHICULO = "vehiculo";
    public static final String JSON_KEY_MARCA = "marca";
    public static final String JSON_KEY_MODELO = "modelo";
    public static final String JSON_KEY_ESTILO = "estilo";
    public static final String JSON_KEY_API_KEY = "api_key";
    public static final String JSON_KEY_ID_EMPRESA = "api_key";
    public static final String JSON_KEY_PRODUCTO_ID = "api_key";
    public static final String JSON_KEY_TYPE = "type";
    public static final String JSON_KEY_PEDIDO_ID = "api_key";
    public static final String JSON_KEY_ASESOR = "id_asesor";
    public static final String JSON_KEY_TABLE_NAME = "table_name";
    public static final String JSON_KEY_RESPONSE_CODE = "responseCode";
    public static final String JSON_USARIO_ADMIN = "admin_user";
    public static final String JSON_CLAVE_USUARIO_ADMIN = "admin_password";
    public static final String JSON_KEY_DOC_IDENTIDAD = "äpi_key";

    public static final int ROWS_PER_RESPONSE = 500;
}
