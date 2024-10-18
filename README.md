# Productor-Consumidor  

Este proyecto implementa el patrón de diseño Productor-Consumidor utilizando multihilos en Java. El programa ilustra cómo los productores generan recursos y los consumidores los consumen de un buffer compartido, demostrando la sincronización y el control de concurrencia.  

## Tabla de Contenidos  
- [Introducción](#introducción)  
- [Tecnologías Utilizadas](#tecnologías-utilizadas)  
- [Estructura del Proyecto](#estructura-del-proyecto)  
- [Clases Principales](#clases-principales)  


## Introducción  
El problema del productor-consumidor es un clásico en la programación concurrente que muestra cómo múltiples hilos pueden interactuar de manera eficiente sin interferencias indebidas. Este proyecto utiliza semáforos para gestionar el acceso a un buffer compartido.  

## Tecnologías Utilizadas  
- **Java**: Lenguaje de programación utilizado para implementar el proyecto.  
- **IDE**: IntelliJ IDEA / Eclipse / cualquier IDE compatible con Java.  

## Estructura del Proyecto  
- `src/`: Carpeta que contiene el código fuente en Java.  
- `README.md`: Este archivo, que contiene la documentación del proyecto.  

## Clases Principales  
1. **Buffer**: Clase responsable de manejar la producción y consumo de recursos.  
   - Métodos:  
     - `producir(Recurso recurso)`: Permite a un productor agregar un recurso al buffer.  
     - `consumir()`: Permite a un consumidor extraer un recurso del buffer.  

2. **Recurso**: Representa el recurso que será producido y consumido.  
   - Atributos:  
     - `id`: Identificador único del recurso.  

3. **Productor**: Clase que representa un hilo productor.  
   - Método principal:  
     - `run()`: Contiene la lógica para instanciar recursos y producirlos en el buffer.  

4. **Persona**: Clase que representa un hilo consumidor.  
   - Método principal:  
     - `run()`: Contiene la lógica para consumir recursos del buffer.  

5. **Main**: Clase que contiene el método `main`, donde se inician los hilos y se configura el buffer.  
