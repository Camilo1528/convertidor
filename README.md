<<<<<<< HEAD
# convertidor
=======
Conversor de Monedas
Este proyecto consiste en construir un Conversor de Monedas utilizando Java, la biblioteca Gson y la API de tasas de cambio. A lo largo del desarrollo, se abordaron conceptos fundamentales de Java y se interactuó con APIs para obtener datos de cambio de divisas en tiempo real.

Requisitos Previos
Antes de ejecutar el proyecto, asegúrate de tener instalado lo siguiente:

Java JDK: Versión 11 o superior (Descargar JDK)
Biblioteca Gson: Versión 2.10.1 o superior (Maven Central Gson)
Postman (opcional para pruebas de la API): Descargar Postman
IDE IntelliJ IDEA (opcional): Descargar IntelliJ IDEA
Fases del Proyecto
1. Configuración del Entorno
   Configura el entorno de desarrollo instalando las herramientas mencionadas anteriormente.
   Asegúrate de que Java esté correctamente configurado y disponible en tu variable de entorno PATH.
2. Conociendo la API
   Se utilizó la ExchangeRate-API para obtener datos de cambio de divisas.

Documentación de la API
Clave de API utilizada para este proyecto: 78bb6dc79186f41d1191df90.
3. Importando la Biblioteca Gson en IntelliJ
   Abre el proyecto en IntelliJ IDEA.
   Ve a File > Project Structure > Dependencies.
   Haz clic en el botón +, selecciona Library y busca "Gson".
   Selecciona la versión 2.10.1 o superior y haz clic en OK.
4. Construcción del Cliente HTTP
   Se utilizó la clase HttpClient para conectarse con la API. Esta clase permite realizar solicitudes HTTP de manera eficiente.

5. Construcción de la Solicitud
   La clase HttpRequest se usó para personalizar las solicitudes enviadas a la API. Esto incluye configurar la URL, el método HTTP y otros parámetros necesarios.

6. Gestión de la Respuesta
   Con la interfaz HttpResponse, se procesaron las respuestas de la API. La respuesta, en formato JSON, fue descompuesta y analizada para extraer los datos relevantes.

7. Análisis del JSON
   Utilizamos la biblioteca Gson para analizar las respuestas JSON y mapearlas a objetos Java. Se usaron clases como JsonObject y JsonParser para manipular los datos de forma eficiente.

8. Filtrando las Monedas
   El proyecto admite la conversión entre las siguientes monedas:

ARS - Peso argentino
BOB - Boliviano boliviano
BRL - Real brasileño
CLP - Peso chileno
COP - Peso colombiano
USD - Dólar estadounidense
El filtrado se realiza utilizando los códigos de moneda proporcionados por la API.

9. Interacción con el Usuario
   Se implementó una interfaz de texto que permite al usuario:

Seleccionar las monedas de origen y destino.
Ingresar la cantidad a convertir.
Ver el resultado de la conversión en tiempo real.
10. README
    Este archivo README describe las características del proyecto, los pasos para configurarlo y ejecutarlo, así como información adicional para entender su funcionamiento.

Ejecución del Proyecto
Pasos para Ejecutar
Clona este repositorio en tu máquina local:
bash
Copiar código
git clone <URL_DEL_REPOSITORIO>
Importa el proyecto en IntelliJ IDEA.
Asegúrate de que todas las dependencias estén instaladas ejecutando:
bash
Copiar código
mvn clean install
Ejecuta el proyecto con el comando:
bash
Copiar código
mvn javafx:run
Prueba de API con Postman
Si deseas explorar la API de tasas de cambio antes de ejecutar el proyecto, utiliza Postman:

Configura la solicitud como GET.
Usa esta URL:
bash
Copiar código
https://v6.exchangerate-api.com/v6/78bb6dc79186f41d1191df90/latest/USD
Observa el formato JSON de la respuesta.
Características Adicionales (Opcional)
Para enriquecer el proyecto, puedes agregar:

Historial de Conversiones: Guarda las conversiones realizadas para su posterior consulta.
Soporte para Más Monedas: Amplía la lista de monedas disponibles para conversión.
Registros con Marca de Tiempo: Registra cada conversión con información de fecha y hora usando la biblioteca java.time.
Licencia
Este proyecto se desarrolló como parte del desafío del programa ONE (Oracle Next Education). Su uso está permitido con fines educativos.
>>>>>>> 0d46bb1 (subir el proyecto)
