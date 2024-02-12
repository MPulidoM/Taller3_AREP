package org.example;

import java.net.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.io.*;
import java.util.Map;

/**
 * Clase que implementa un servidor HTTP básico.
 */

public class HttpServer {
    /**
     * Directorio raíz predeterminado donde se buscan los archivos solicitados por los clientes.
     */
    public static File file;

    /**
     * Servidor HTTP.
     */
    public static ServerSocket serverSocket;

    /**
     * Mapa de rutas HTTP y sus respectivos manipuladores asociados.
     */
    public static Map<String, ServerStr> service = new HashMap<>();

    /**
     * Flujo de salida para enviar respuestas HTTP a los clientes.
     */
    public static PrintWriter out;

    /**
     * Instancia única del servidor HTTP.
     */
    private static HttpServer instance = new HttpServer();

    /**
     * Directorio raíz del servidor HTTP.
     */
    private static String filesDirectory;

    /**
     * Tipo de contenido predeterminado para las respuestas HTTP.
     */
    private static String type = "text/html";

    /**
     * Constructor privado para garantizar que solo se cree una instancia única del servidor HTTP.
     */
    private HttpServer() {
    }
    /**
     * Obtiene la instancia única del servidor HTTP.
     *
     * @return Instancia única del servidor HTTP.
     */
    public static HttpServer getInstance() {
        return instance;
    }

    /**
     * Inicia el servidor HTTP y escucha en el puerto 35000.
     *
     * @throws IOException Excepción de entrada/salida.
     * @throws URISyntaxException Excepción de sintaxis de URI.
     */
    public void start() throws IOException, URISyntaxException {
        ServerSocket ServerSocket = null;
        try {
            serverSocket = new ServerSocket(35000);
        } catch (IOException e) {
            System.err.println("Could not listen on port: 35000.");
            System.exit(1);
        }

        boolean running = true;
        while (running) {
            Socket clientSocket = null;
            try {
                System.out.println("Listo para recibir ...");
                clientSocket = serverSocket.accept();
            } catch (IOException e) {
                System.err.println("Accept failed.");
                System.exit(1);
            }

            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            clientSocket.getInputStream()));
            String inputLine, outputLine = "";

            boolean firstLine = true;
            String uriStr = "";

            while ((inputLine = in.readLine()) != null) {
                if (firstLine) {
                    uriStr = inputLine.split(" ")[1];
                    firstLine = false;
                }
                System.out.println("Received: " + inputLine);
                if (!in.ready()) {
                    break;
                }
            }

            URI fileuri = new URI(uriStr);
            String path = fileuri.getPath();
            System.out.println("Path: " + path);

            String query = fileuri.getQuery();
            System.out.println("Query: " + query);
            String param = "";

            if (query != null) {
                String signo1 = "&";
                String[] queryParametro = query.split(signo1);
                for (String queryPart : queryParametro) {
                    String signo2 = "=";
                    String[] keyValue = queryPart.split(signo2);
                    int keyValueL = keyValue.length;
                    if (keyValueL == 2) {
                        String p = "param";
                        Boolean bandera = keyValue[0].equals(p);
                        if (bandera) {
                            param = keyValue[1];
                            break;
                        }
                    }
                }
            }
            out.println(outputLine);

            try {
                if (path.startsWith("/action")) {
                    String webURI = path.replace("/action", "");
                    if (service.containsKey(webURI)) {
                        outputLine = service.get(webURI).handle(param);
                    }
                } else if (path.startsWith("/files")) {
                    UpdateDirectorys("target/classes");
                    outputLine = httpClientHtml(path, clientSocket);
                } else {
                    UpdateDirectorys("target/classes");
                    outputLine = httpClientHtml(path, clientSocket);
                }
            } catch (IOException e) {
                outputLine = httpError();
            }
            out.println(outputLine);

            out.close();
            in.close();
            clientSocket.close();
        }
        ServerSocket.close();
    }

    /**
     * Maneja las solicitudes HTTP del cliente.
     *
     * @param path Ruta del archivo solicitado.
     * @param clientSocket Socket del cliente.
     * @return Mensaje HTTP con el contenido del archivo solicitado.
     * @throws IOException Si ocurre algún error al leer el archivo o escribir en el socket.
     */
    public static String httpClientHtml(String path, Socket clientSocket) throws IOException {
        return httpClientHtml(path, clientSocket, true);
    }
    /**
     * Maneja las solicitudes HTTP del cliente.
     *
     * @param path Ruta del archivo solicitado.
     * @param clientSocket Socket del cliente.
     * @param returnError Indica si se debe devolver un mensaje de error en caso de que el archivo no exista.
     * @return Mensaje HTTP con el contenido del archivo solicitado.
     */
    public static String httpClientHtml(String path, Socket clientSocket, boolean returnError) {
        String content_type = "";

        String extension = path.substring(path.lastIndexOf(".") + 1);

        switch (extension) {
            case "html":
                content_type = "text/html";
                break;
            case "js":
                content_type = "application/javascript";
                break;
            case "css":
                content_type = "text/css";
                break;
            case "jpg":
                content_type = "image/jpg";
                break;
            default:
                // Manejar el caso en que la extensión no sea ninguna de las anteriores
        }

        String outputLine = "HTTP/1.1 200 OK\r\n"
                + "Content-Type: " + content_type + "\r\n"
                + "\r\n";

        Path file = Paths.get(filesDirectory + path);
        System.out.println(file);

        Charset charset = Charset.forName("UTF-8");

        try {
            if (Files.isRegularFile(file)) {
                if (content_type.equals("image/jpg")) {
                    byte[] imageData = Files.readAllBytes(file);
                    OutputStream output = clientSocket.getOutputStream();
                    output.write(outputLine.getBytes());
                    output.write(imageData);
                    output.flush();
                    output.close();
                } else {
                    BufferedReader reader = Files.newBufferedReader(file, charset);
                    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream(), charset));
                    writer.write(outputLine);
                    String line;
                    while ((line = reader.readLine()) != null) {
                        System.out.println(line);
                        writer.write(line);
                        writer.newLine();
                    }
                    writer.flush();
                    writer.close();
                }
            } else {
                if (returnError) {
                    outputLine = httpError();
                }
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
            outputLine = httpError();
        }

        return outputLine;
    }


    /**
     * Establece el directorio raíz del servidor HTTP.
     *
     * @param directory Directorio raíz del servidor HTTP.
     */
    public static void UpdateDirectorys(String directory) {
        filesDirectory = directory;
    }

    /**
     * Agrega una nueva ruta HTTP y su manipulador asociado al mapa de rutas HTTP.
     *
     * @param r Ruta HTTP.
     * @param s Manipulador asociado a la ruta HTTP.
     */
    public static void get(String r, ServerStr s) {
        service.put(r, s);
    }

    private static String httpError() {
        return "HTTP/1.1 404 Not Found\r\n"
                + "Content-Type:text/html\r\n"
                + "\r\n"
                + "<!DOCTYPE html>\n"
                + "<html>\n"
                + "    <head>\n"
                + "        <title>Requested File Not found</title>\n"
                + "        <meta charset=\"UTF-8\">\n"
                + "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
                + "    </head>\n"
                + "    <body>\n"
                + "        <h1>Error, file not found</h1>\n"
                + "    </body>\n";
    }
}
