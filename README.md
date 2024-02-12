# Taller 3 : MICROFRAMEWORKS WEB

En este taller, se trabajó   la arquitectura del microframework web denominado SparkWeb, la cual permite la construcción sencilla de aplicaciones web utilizando funciones lambda en Java. A diferencia de otros frameworks como Spark o Spring, el objetivo es construir un servidor web desde cero, sin depender de frameworks externos, utilizando únicamente la API básica de Java.

En el transcurso de este taller, se desarrolló  un servidor web que proporcionará funcionalidades similares a las ofrecidas por Spark. Se enfocó  la implementación de servicios web tipo GET y POST mediante el uso de funciones lambda. Además, se permite  la entrega de archivos estáticos, incluyendo páginas HTML, CSS, JavaScript e imágenes.

Una de las características clave que se implementó es la capacidad de configurar el directorio desde el cual se leerán los archivos estáticos, proporcionando flexibilidad en la organización de los recursos web. 

Es importante destacar que en este taller se centrara en la construcción del servidor web sin hacer uso de frameworks externos como Spark o Spring. Se utilizó únicamente la API básica de Java para crear un microframework web que cumpla con los requisitos mencionados.

## Empezando

- El proyecto contiene la clase que maneja solicitudes HTTP y envía respuestas correspondientes, y contiene un mapa de rutas HTTP y manipuladores asociados.: [HttpServer](https://github.com/MPulidoM/Taller3_AREP/blob/main/Taller3Arep/src/main/java/org/example/HttpServer.java).
  
- La clase mySpark define rutas HTTP y manipuladores asociados, y es una clase de ejemplo que ilustra cómo utilizar la clase HttpServer para definir rutas HTTP personalizadas.:  [mySpark](https://github.com/MPulidoM/Taller3_AREP/blob/main/Taller3Arep/src/main/java/org/example/mySpark.java).
  
- La interfaz ServerStr representa una función de manejo de rutas HTTP, y permite a los desarrolladores definir fácilmente funciones de manejo de rutas HTTP personalizadas. : [ServerStr](https://github.com/MPulidoM/Taller3_AREP/blob/main/Taller3Arep/src/main/java/org/example/ServerStr.java)
  
- Se tiene en recursos los archivos con los cuales se haran las pruebas correspondiente a este laboratorio : [files](https://github.com/MPulidoM/Taller3_AREP/tree/main/Taller3Arep/src/main/resources/files).
  
- Por últmo en el tema de la docuemntación a detalle de los metodos usados se pueden encontrar [doc](https://github.com/MPulidoM/Taller3_AREP/tree/main/Taller3Arep/Doc).

### Requisitos previos

[Maven](https://maven.apache.org/) : Con esta herramienta se creo la estructura del proyecto y se manejan las dependencias que se necesitan

[Git](https://git-scm.com/) : Se basa en un sistema de control de versiones distribuido, donde cada desarrollador tiene una copia completa del historial del proyecto.

Para asegurar una correcta instalación de Maven, es crucial confirmar que la versión del JDK de Java sea compatible. Si el JDK no está actualizado, la instalación de las versiones actuales de Maven podría fallar, generando problemas durante el uso de la herramienta.
```
java -version 
```

### Instalando
Para poder ver el funcionamiento de este taller , en si instalar este programa, debe clonar el repositorio en su maquina local. Para esto utilice el siguiente comando y ejecutelo.

```
$ git clone https://github.com/MPulidoM/Taller3_AREP.git
```
Para poder ver la aplicación web , se debe inicar en el IDE de preferencia en mi caso fue IntelliJ IDEA y se debe correr la clase  [mySpark](https://github.com/MPulidoM/Taller3_AREP/blob/main/Taller3Arep/src/main/java/org/example/mySpark.java).Lo siguiente es abrir el navegador , en el caso de este taller se trabajo más que todo en Google, y poner las siguientes opciones:  
```
http://localhost:35000/files/KitConnor.js

http://localhost:35000/files/KitConnor.css

http://localhost:35000/files/KitConnor.html

http://localhost:35000/files/funciona.jpg

http://localhost:35000/files/Prueba.txt

http://localhost:35000/action/arep

http://localhost:35000/action/Junior

```
## Arquitectura
Este proyecto implementa un servidor HTTP básico utilizando Java. La arquitectura del proyecto se basa en las siguientes clases y conceptos:

1. HttpServer: Esta clase es responsable de manejar las solicitudes HTTP entrantes y de enviar las respuestas HTTP correspondientes. Contiene un mapa de rutas HTTP y sus respectivos manipuladores asociados. También es responsable de iniciar el servidor HTTP y de manejar las excepciones que puedan ocurrir durante el procesamiento de las solicitudes HTTP.
2. ServerStr: Esta interfaz funcional representa una función de manejo de rutas HTTP. La función de manejo de rutas HTTP es una función que toma un parámetro de tipo String y devuelve una respuesta en formato de cadena. Esta interfaz permite a los desarrolladores definir fácilmente funciones de manejo de rutas HTTP personalizadas.
3. mySpark: Esta clase define el comportamiento del servidor HTTP, es decir, las rutas HTTP y sus manipuladores asociados. En este caso, se han definido dos rutas:

   - /arep: Esta ruta maneja las solicitudes HTTP entrantes en la ruta "/arep". La función de manejo de rutas HTTP asociada a esta ruta devuelve una página HTML con un encabezado que dice "Saludos desde AREP, Arquitectura empresarial!" y un párrafo que contiene el parámetro de la consulta HTTP, si se proporciona.
   - /Junior: Esta ruta maneja las solicitudes HTTP entrantes en la ruta "/Junior". La función de manejo de rutas HTTP asociada a esta ruta devuelve una página HTML con un encabezado que dice "Junior Alberto Pulido Dice Hola!" y un párrafo que contiene el parámetro de la consulta HTTP, si se proporciona.

El servidor HTTP está diseñado para ser extensible y fácil de mantener, ya que se puede agregar nuevas rutas HTTP y sus manipuladores asociados al mapa de rutas HTTP sin modificar el código existente.

El siguiente código implementa un servidor HTTP básico utilizando métodos funcionales de Java para manejar el enrutamiento HTTP. Los servidores HTTP están diseñados para ser extensibles y fáciles de mantener, ya que se pueden agregar nuevas rutas HTTP y sus controladores asociados al mapa de rutas HTTP sin cambiar el código existente. La clase HttpServer es el servidor HTTP principal responsable de manejar las solicitudes HTTP entrantes y entregar las respuestas HTTP adecuadas. La interfaz ServerStr representa una función de controlador de ruta HTTP y permite a los desarrolladores definir fácilmente funciones de controlador de ruta HTTP personalizadas. Las clases mySpark definen el comportamiento del servidor HTTP, es decir, las rutas HTTP y sus controladores asociados. Este ejemplo define dos rutas: "/arep" y "/Junior", cada una con su propia funcionalidad de manejo de rutas HTTP. Diseñado para ser robusto y fácil de usar, HTTP Server proporciona una base sólida para crear aplicaciones web en Java. La arquitectura del servidor HTTP está diseñada para ser extensible y fácil de mantener, ya que se pueden agregar nuevas rutas HTTP y sus controladores asociados al mapa de rutas HTTP sin cambiar el código existente. En resumen, el código proporcionado implementa un servidor HTTP básico en Java que es fácil de usar, escalar y mantener. Diseñada para ser robusta, escalable y fácil de mantener, la arquitectura del servidor HTTP proporciona una base sólida para crear aplicaciones web en Java.

## Pruebas Realizadas

--> WINDOWS
- Archivos :
JS:

![image](https://github.com/MPulidoM/Taller3_AREP/assets/118181543/16479eea-9603-4db0-a669-defcc7d27cfd)

CSS:

![image](https://github.com/MPulidoM/Taller3_AREP/assets/118181543/c9668415-fd38-43b4-b327-cd2824b710c6)

HTML:

![image](https://github.com/MPulidoM/Taller3_AREP/assets/118181543/99a0d3d3-35b8-4498-b283-bef06fcacad2)

JPG:

![image](https://github.com/MPulidoM/Taller3_AREP/assets/118181543/a55fcdb0-f3f5-4268-92af-afff1decbd1d)

TXT:

![image](https://github.com/MPulidoM/Taller3_AREP/assets/118181543/97e5d358-a7d3-41f2-b9cb-707d7a20d5d4)

- PAGINAS:

![image](https://github.com/MPulidoM/Taller3_AREP/assets/118181543/48e64030-6f05-455e-bc93-eb0570c3bf5a)

![image](https://github.com/MPulidoM/Taller3_AREP/assets/118181543/e85e9ae1-a7ce-42e9-9a35-5ccf2bb1c8c1)

- CON PARAMETROS:

![image](https://github.com/MPulidoM/Taller3_AREP/assets/118181543/183fd8ae-b451-46bc-b59e-76cb674ab373)

![image](https://github.com/MPulidoM/Taller3_AREP/assets/118181543/dfd51657-15a1-4b3e-b831-87ac839cf082)


--> LINUX(Maquina Virtual Ubuntu)
- Archivos :
JS:

![image](https://github.com/MPulidoM/Taller3_AREP/assets/118181543/2221d661-1bf4-431b-9371-165bd43c9057)

CSS:

![image](https://github.com/MPulidoM/Taller3_AREP/assets/118181543/9e0ffb2a-2cae-42af-b411-a21e9ee7b635)

HTML:

![image](https://github.com/MPulidoM/Taller3_AREP/assets/118181543/6966cc8c-324b-40f1-8a3e-d69efb38446c)


JPG:

![image](https://github.com/MPulidoM/Taller3_AREP/assets/118181543/6e2a964f-2da6-4a79-a374-f60a7f13d3e8)

TXT:

![image](https://github.com/MPulidoM/Taller3_AREP/assets/118181543/204858cb-c019-450b-8a62-312837055473)


- PAGINAS:

![image](https://github.com/MPulidoM/Taller3_AREP/assets/118181543/95cfc349-aa3c-41ff-abcf-8eae15d5aeb0)

![image](https://github.com/MPulidoM/Taller3_AREP/assets/118181543/31a98025-170e-45e0-953c-12b99cad264b)


- CON PARAMETROS:

![image](https://github.com/MPulidoM/Taller3_AREP/assets/118181543/c7feea98-5c56-49d6-80b3-eeacf9337cfe)

![image](https://github.com/MPulidoM/Taller3_AREP/assets/118181543/b9760bf7-3d9f-4099-ae26-2a90a248cc30)



## Construido con

* [Maven](https://maven.apache.org/) - Gestión de dependencias
* [Java](https://www.java.com/es/) - Lenguaje Utilizado
* [GitHub](https://git-scm.com/) - Control de Versiones



## Autores

* **Mariana Pulido Moreno** - *Arep 101* - [MPulidoM](https://github.com/MPulidoM)
