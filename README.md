# Conversor de Monedas

Este proyecto es un conversor de monedas interactivo desarrollado en Java. Permite convertir diferentes tipos de monedas a través de una API de tipo de cambio. El programa ofrece un menú interactivo donde el usuario puede elegir entre varias opciones de conversión.

## Características
- Conversión entre las siguientes monedas:
  - Dólar estadounidense (USD) y Pesos argentinos (ARS)
  - Reales brasileños (BRL) y Pesos argentinos (ARS)
  - Pesos chilenos (CLP) y Pesos argentinos (ARS)
  
- Uso de la API [ExchangeRate-API](https://www.exchangerate-api.com/) para obtener los tipos de cambio en tiempo real.
- Interfaz de línea de comandos intuitiva y fácil de usar.

## Estructura del Código
El programa está compuesto por las siguientes partes principales:
- **Menú interactivo**: Permite al usuario seleccionar la operación deseada.
- **Método `convertirMoneda`**: Realiza la consulta a la API, procesa la respuesta y muestra el resultado.
- **Integración con la API**: Utiliza la clase `HttpClient` para realizar solicitudes HTTP y la biblioteca Gson para deserializar la respuesta JSON.

## Ejemplo de Uso
```
*****************************************
¡Sea bienvenido/a al Conversor de Monedas!
1) Dólar =>> Pesos argentinos
2) Pesos argentinos =>> Dolar
3) Reales =>> Pesos argentinos
4) Pesos argentinos =>> Reales
5) Pesos chilenos =>> Pesos argentinos
6) Pesos argentinos =>> Pesos chilenos
7) Salir
*****************************************
Ingrese una opción: 1
Ingrese el valor a convertir: 100
El valor de 100.0 [USD] corresponde al valor final de =>>> 103625.0 [ARS]
```
