import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner lectura = new Scanner(System.in);
        int numElegido = 0;

        while (numElegido != 7) {
            System.out.println("*****************************************");
            System.out.println("¡Sea bienvenido/a al Conversor de Monedas!");
            System.out.println("1) Dólar =>> Pesos argentinos");
            System.out.println("2) Pesos argentinos =>> Dólar");
            System.out.println("3) Reales =>> Pesos argentinos");
            System.out.println("4) Pesos argentinos =>> Reales");
            System.out.println("5) Pesos chilenos =>> Pesos argentinos");
            System.out.println("6) Pesos argentinos =>> Pesos chilenos");
            System.out.println("7) Salir");
            System.out.println("*****************************************");
            System.out.println("Ingrese una opción");
            numElegido = lectura.nextInt();

            switch (numElegido) {
                case 1 -> convertirMoneda("USD", "ARS", lectura);
                case 2 -> convertirMoneda("ARS", "USD", lectura);
                case 3 -> convertirMoneda("BRL", "ARS", lectura);
                case 4 -> convertirMoneda("ARS", "BRL", lectura);
                case 5 -> convertirMoneda("CLP", "ARS", lectura);
                case 6 -> convertirMoneda("ARS", "CLP", lectura);
                case 7 -> System.out.println("¡Gracias por usar el conversor! Adiós.");
                default -> System.out.println("Por favor, elija una opción válida.");
            }
        }
    }

    private static void convertirMoneda(String monedaInicial, String monedaFinal, Scanner lectura) throws IOException, InterruptedException {
        System.out.println("Ingrese el valor a convertir");
        double monedaCant = lectura.nextDouble();

        String direccion = "https://v6.exchangerate-api.com/v6/2689b54c0c2ce08c6fa9271a/pair/" +
                monedaInicial + "/" + monedaFinal + "/" + monedaCant;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direccion))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();

        Gson gson = new Gson();
        Moneda miMoneda = gson.fromJson(json, Moneda.class);
        System.out.println("El valor de " +
                monedaCant + " [" + monedaInicial + "] " +
                "corresponde al valor final de =>>> " +
                miMoneda.getConversion_result() + " [" +
                monedaFinal + "]");
    }
}
