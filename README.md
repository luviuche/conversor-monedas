# 💱 Conversor de Monedas - Challenge Java

Este proyecto es una aplicación de consola interactiva desarrollada en Java que permite realizar conversiones de divisas en tiempo real. Fue construido como parte de un desafío de programación para practicar el consumo de APIs, el manejo de datos JSON y la creación de interfaces interactivas.

## 📋 Requisitos del Ambiente

Para asegurar el correcto funcionamiento, el proyecto requiere contar con los siguientes elementos:
* **Java JDK**: Versión 17 en adelante.
* **Biblioteca Gson**: Versión 2.10.1 en adelante.
* **IDE**: IntelliJ IDEA Community Edition (opcional).
* **Postman**: Para pruebas de la API (opcional).

## 🛠️ Tecnologías Utilizadas

* **Lenguaje**: Java 17+.
* **Gestor de Dependencias**: Maven.
* **API Externa**: [ExchangeRate-API](https://www.exchangerate-api.com/).
* **Librerías**: `com.google.code.gson` para la conversión de JSON a objetos Java.

## 🚀 Funcionalidades

El programa ofrece un menú interactivo con las siguientes opciones de conversión:
1. **Dólar =>> Peso argentino**
2. **Peso argentino =>> Dólar**
3. **Dólar =>> Real brasileño**
4. **Real brasileño =>> Dólar**
5. **Dólar =>> Peso colombiano**
6. **Peso colombiano =>> Dólar**
7. **Salir**

## 💻 Instalación y Configuración

1. **Clonar el repositorio**:
   ```bash
   git clone [https://github.com/tu-usuario/conversor-monedas.git](https://github.com/tu-usuario/conversor-monedas.git)
   
2. **Importar el proyecto**:
   * Abre tu IDE (como IntelliJ IDEA) y selecciona la opción "Open" o "Import".
   * Asegúrate de que se reconozca como un proyecto **Maven** para que el archivo `pom.xml` descargue las dependencias (como **Gson**) automáticamente.

3. **Configurar la Clave de API**:
   * Regístrate en [ExchangeRate-API](https://www.exchangerate-api.com/) para obtener tu clave gratuita.
   * En tu código Java, busca la variable de la URL y reemplaza el texto con tu clave real:
     `String direccion = "https://v6.exchangerate-api.com/v6/TU_CLAVE_API/latest/USD";`

4. **Ejecutar la aplicación**:
   * Corre la clase principal (`ConversorApp.java`).
   * Verás el menú interactivo en la terminal de tu IDE, donde podrás ingresar las opciones y los valores a convertir.

## 🧠 Lógica de Implementación

El proyecto se basa en los siguientes pilares técnicos:

* **Consumo de API**: Uso de `HttpClient` para realizar peticiones de forma moderna y eficiente.
* **Análisis de Datos**: Se implementó la biblioteca **Gson (v2.10.1)** junto con **Records** de Java para mapear la respuesta JSON de forma inmutable.
* **Interfaz de Usuario (CLI)**: Uso de la clase `Scanner` dentro de un bucle `while` para mantener el programa activo hasta que se elija la opción de salida.
* **Modularidad**: El cálculo de la conversión se separó en un método estático para facilitar la lectura y el mantenimiento.

---
**Desarrollado para el Challenge de Programación - Alura Latam.**
**Desarrollado por Luis Viuche.**
