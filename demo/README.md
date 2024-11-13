
#Formación de grupos.



``` javascript
public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    List<String> integrantes = obtenerIntegrantes(scanner);
    
    // Verificar que la lista de integrantes no esté vacía
    if (integrantes.isEmpty()) {
        System.out.println("La lista de integrantes no puede estar vacía.");
        return;
    }

    int cantidadSubgrupos = obtenerCantidadSubgrupos(scanner, integrantes.size());

    if (cantidadSubgrupos <= 0 || cantidadSubgrupos > integrantes.size()) {
        System.out.println("Cantidad de subgrupos inválida.");
        return;
    }

    List<List<String>> subgrupos = generarSubgrupos(integrantes, cantidadSubgrupos);

    imprimirSubgrupos(subgrupos);
    scanner.close(); // Cerrar el Scanner para liberar recursos
}

```
** Se crea un Scanner con el nombre de Scanner, lueego creamos una lista de tipo string, llamada integrantes, la cual esta llamando el metodo obtenerIntegrantes, la cual tiene como función el ingreso por consola de los integrantes aleatoreamente  **