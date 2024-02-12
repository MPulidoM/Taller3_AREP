package org.example;
import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Clase que define un servidor HTTP simple con dos rutas:
 * 1. /arep: Devuelve una página HTML con un encabezado que dice "Saludos desde AREP, Arquitectura empresarial!" y un párrafo  que contiene el parámetro de la consulta HTTP, si se proporciona.
 * 2. /Junior: Devuelve una página HTML con un encabezado que dice "Junior Alberto Pulido Dice Hola!" y un párrafo  que contiene el parámetro de la consulta HTTP, si se proporciona.
 */

public class mySpark {
    /**
     * Método principal que inicia el servidor HTTP.
     * @param args Argumentos de línea de comandos.
     * @throws IOException Excepción de entrada/salida.
     * @throws URISyntaxException Excepción de sintaxis de URI.
     */
        public static void main(String[] args) throws IOException, URISyntaxException {
            // Definición de la ruta /arep
            HttpServer.get("/arep", (param) -> {
                String resp = "HTTP/1.1 200 OK\r\n"
                        + "Content-Type:text/html\r\n"
                        + "\r\n"
                        + "<h1> Saludos desde AREP , Arquitectura empresarial! </h1>";

                if (param != "") {
                    resp += "<p> The parameter of your query was: " + param + "</p>";
                }

                return resp;
            });
            // Definición de la ruta /Junior
            HttpServer.get("/Junior", (param) -> {
                String resp = "HTTP/1.1 200 OK\r\n"
                        + "Content-Type:text/html\r\n"
                        + "\r\n"
                        + "<h1> Junior Alberto Pulido Dice Hola ! </h1>";


                if (param != "") {
                    resp += "<p> The parameter of your query was: " + param + "</p>";
                }

                return resp;
            });


            // Inicio del servidor HTTP
            HttpServer.getInstance().start();
        }
    }

