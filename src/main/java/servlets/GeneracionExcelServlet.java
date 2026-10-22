package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "GeneracionServletExcel", urlPatterns = {"/GeneracionServletExcel"})
public class GeneracionExcelServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment;filename=excelEjemplo.xls");
        // Utilizar apache poi para un uso más profesional de excel

        response.setHeader("Pragma", "no-cache"); // Esto es para que no guarde el caché de la respuesta que generaremos
        response.setHeader("Cache-Control", "no-store");
        response.setDateHeader("Expires", -1);

        try (PrintWriter out = response.getWriter()) {
            out.println("\tValores");
            out.println("\t1");
            out.println("\t2");
            out.println("Total\t=SUM(B2:B3)"); // Esto depende del idioma de las funciones

        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}

/* Los cabeceros de respuesta se usan para indicar al navegador web como debe de comportarse ante una respuesta
del servidor.
Ejemplos: Generar hojas de excel, PDF's. Audio, Video, etc, en lugar de solo responder con texto.

Para indicar respuestas se utilizan los tipos MIME (Multipurpose Internet Mail Extensions)

Los tipos Mime son un conjunto de especificaciones con el objetivo de intercambiar archivos a traves de internet
como puede ser texto, audio, video entre otros tipos.

Ejemplos comunes entre los tipos MIME:
application/msword              Microsoft Word document
application/pdf                 Acrobat (.pdf) file
application/vnd.ms.excel        Excel spreadsheet
application/vnd.ms-powerpoint   Powerpoint presentation
application/zip                 Zip archive
audio/x-wax                     Microsoft sound file
text/css                        HTML Cascading Style Sheet
text/html                       HTML document
text/xml                        XML document
image/gif                       GIF Image
image/jpeg                      JPEG Image
image/png                       PNG Image
video/mpeg                      MPEG Video Clip
video/quicktime                 QuickTime Video Clip

Api de servlets al utilizar cabeceros de respuesta

response.setHeader                                      (String nombreCabecero, String valor Cabecero)
setDateHeader y setIntHeader                            estos ponen unn cabecero, si ya existe lo reemplaza
response.addHeader, addDateHeader y addIntHeader        Estos agregan nuevos valores en lugar de reemplazarlos

Metodos más comunes para establecer los valores de los headers:

setContentType (se utiliza la tabla MIME para definir su valor)
setContentLength
addCoockie
sendRedirect

Cabeceros de respuesta más Comunes

Cache-Control y Pragma: Se usan para el control de caché
Content-Encoding: Indica la codificación del documento
Content-Length : Indica el número de bytes en la respuesta
Conent-Type: Indica el tipo MIME a responder
Expires: Indica el tiempo en que el documento se considera expirado
Last-Modified: Indica el tiempo en que el doocumento fue modificado
Refresh: Indica los segundos en que el navegador recarga la página
Set-Coockie: Agrega un coockie al navegador
WWW-Authenticate: Indica el tipo de autenticación

*/
