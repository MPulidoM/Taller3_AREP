# Taller 3 : MICROFRAMEWORKS WEB

En este taller, se trabajó   la arquitectura del microframework web denominado SparkWeb, la cual permite la construcción sencilla de aplicaciones web utilizando funciones lambda en Java. A diferencia de otros frameworks como Spark o Spring, el objetivo es construir un servidor web desde cero, sin depender de frameworks externos, utilizando únicamente la API básica de Java.

En el transcurso de este taller, se desarrolló  un servidor web que proporcionará funcionalidades similares a las ofrecidas por Spark. Se enfocó  la implementación de servicios web tipo GET y POST mediante el uso de funciones lambda. Además, se permite  la entrega de archivos estáticos, incluyendo páginas HTML, CSS, JavaScript e imágenes.

Una de las características clave que se implementó es la capacidad de configurar el directorio desde el cual se leerán los archivos estáticos, proporcionando flexibilidad en la organización de los recursos web. 

Es importante destacar que en este taller se centrara en la construcción del servidor web sin hacer uso de frameworks externos como Spark o Spring. Se utilizó únicamente la API básica de Java para crear un microframework web que cumpla con los requisitos mencionados.

## Empezando

- El proyecto contiene una solo clase que sera utilizada para probar lo pedido en este taller  que es : [HttpServer](https://github.com/MPulidoM/Taller2_AREP/blob/main/Taller2_AREP/src/main/java/edu/escuelaing/arem/ASE/app/HttpServer.java).
  
- En el tema de pruebas lo encontramos en la carpeta destinada a los Test, la clase es la siguiente :  [HttpServerTest](https://github.com/MPulidoM/Taller2_AREP/blob/main/Taller2_AREP/src/test/java/edu/escuelaing/arem/ASE/app/HttpServerTest.java).
- También se cuenta con la carpeta de recursos donde estaran los archivos que se probraran en la aplicación web : [resource](https://github.com/MPulidoM/Taller2_AREP/tree/main/Taller2_AREP/src/main/resource)
  
- Por últmo en el tema de la docuemntación a detalle de los metodos usados se pueden encontrar [doc](https://github.com/MPulidoM/Taller2_AREP/tree/main/Taller2_AREP/doc).

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
$ git clone https://github.com/MPulidoM/Taller2_AREP.git
```
Para poder ver la aplicación web , se debe inicar en el IDE Utilizado el  [HttpServer](https://github.com/MPulidoM/Taller2_AREP/blob/main/Taller2_AREP/src/main/java/edu/escuelaing/arem/ASE/app/HttpServer.java).. Lo siguiente es abrir el navegador , en el caso de este taller se trabajo más que todo en Google, y poner en el siguiente 
```
localhost:35000
```
## Arquitectura



## Pruebas Realizadas

--> Al seleccionar el archivo en el primer botón  consiguiente debes darle al botón el cuál se encuentra por consiguiente para viasulizarlo(En ocasiones debes dar doble clik):     

## Construido con

* [Maven](https://maven.apache.org/) - Gestión de dependencias
* [Java](https://www.java.com/es/) - Lenguaje Utilizado
* [GitHub](https://git-scm.com/) - Control de Versiones



## Autores

* **Mariana Pulido Moreno** - *Arep 101* - [MPulidoM](https://github.com/MPulidoM)
