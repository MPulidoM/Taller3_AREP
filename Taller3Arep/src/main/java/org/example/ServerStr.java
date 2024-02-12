package org.example;

/**
 * Interfaz funcional que representa una función de manejo de rutas HTTP.
 *
 * La función de manejo de rutas HTTP es una función que toma un parámetro de tipo String
 * y devuelve una respuesta en formato de cadena.
 */
public interface ServerStr {
    /**
     * Maneja la ruta HTTP y devuelve una respuesta en formato de cadena.
     *
     * @param string el parámetro de la ruta HTTP.
     * @return la respuesta en formato de cadena.
     */
    public String handle(String string);
}
