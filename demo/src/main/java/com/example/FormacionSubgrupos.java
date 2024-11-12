package com.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class FormacionSubgrupos {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> integrantes = obtenerIntegrantes(scanner);
        int cantidadSubgrupos = obtenerCantidadSubgrupos(scanner);

        if (cantidadSubgrupos <= 0 || cantidadSubgrupos > integrantes.size()) {
            System.out.println("Cantidad de subgrupos inválida.");
            return;
        }

        List<List<String>> subgrupos = generarSubgrupos(integrantes, cantidadSubgrupos);

        imprimirSubgrupos(subgrupos);
        scanner.close(); // Cerrar el Scanner para liberar recursos
    }

    private static List<String> obtenerIntegrantes(Scanner scanner) {
        System.out.print("Ingrese la lista de integrantes separados por coma: ");
        String inputIntegrantes = scanner.nextLine();
        List<String> integrantes = new ArrayList<>();
        for (String integrante : inputIntegrantes.split(",")) {
            integrantes.add(integrante.trim());
        }
        return integrantes;
    }

    private static int obtenerCantidadSubgrupos(Scanner scanner) {
        System.out.print("Ingrese la cantidad de subgrupos que desea formar: ");
        return scanner.nextInt();
    }

    private static List<List<String>> generarSubgrupos(List<String> integrantes, int cantidadSubgrupos) {
        Collections.shuffle(integrantes);
        List<List<String>> subgrupos = new ArrayList<>();
        int integrantesPorSubgrupo = integrantes.size() / cantidadSubgrupos;
        int integrantesSobrantes = integrantes.size() % cantidadSubgrupos;

        int indiceInicial = 0;
        for (int i = 0; i < cantidadSubgrupos; i++) {
            int tamanhoSubgrupo = integrantesPorSubgrupo + (i < integrantesSobrantes ? 1 : 0);  // Distribuir los sobrantes
            subgrupos.add(new ArrayList<>(integrantes.subList(indiceInicial, indiceInicial + tamanhoSubgrupo)));
            indiceInicial += tamanhoSubgrupo;
        }
        return subgrupos;
    }

    private static void imprimirSubgrupos(List<List<String>> subgrupos) {
        for (int i = 0; i < subgrupos.size(); i++) {
            System.out.printf("Subgrupo %d: %s%n", i + 1, subgrupos.get(i));
        }
    }
}