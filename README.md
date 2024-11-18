#Formación de grupos.

```javascript
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

** Se crea un Scanner con el nombre de Scanner, luego creamos una lista de tipo string, llamada integrantes, la cual esta llamando el método obtenerIntegrantes, la cual tiene como función el ingreso por consola de los integrantes aleatoriamente **

```javascript
private static List<String> obtenerIntegrantes(Scanner scanner) {
    System.out.print("Ingrese la lista de integrantes separados por coma: ");
    String inputIntegrantes = scanner.nextLine(); // Leer la línea completa
    List<String> integrantes = new ArrayList<>();
    for (String integrante : inputIntegrantes.split(",")) {
        integrantes.add(integrante.trim()); // Separar por comas y eliminar espacios extras
    }
    return integrantes;
}
```

** Se pide el ingreso de los nombres de los integrantes, los cuales piden un split para separar en este caso con comas, también se utiliza el trim para quitar los espacios en blanco que puedan estar antes o después de los nombres**
``` javascript  
private static int obtenerCantidadSubgrupos(Scanner scanner) {
    System.out.print("Ingrese la cantidad de subgrupos que desea formar: ");
    return scanner.nextInt(); // Leer un número entero
}
```
**Este método obtiene la cantidad de subgrupos que el usuario desea formar, en la lectura del Sccaner devuelve el número entero ingresado en consola para la creación de los subgrupos en la cantidad que el usuario desea
**
``` javascript 

private static List<List<String>> generarSubgrupos(List<String> integrantes, int cantidadSubgrupos) {
    Collections.shuffle(integrantes); // Barajar la lista de integrantes de manera aleatoria
    List<List<String>> subgrupos = new ArrayList<>(); // Lista para almacenar los subgrupos
    
    // Calcular cuántos integrantes habrá en cada subgrupo
    int integrantesPorSubgrupo = integrantes.size() / cantidadSubgrupos;
    int integrantesSobrantes = integrantes.size() % cantidadSubgrupos; // Los sobrantes que no caben de manera uniforme

    int indiceInicial = 0;
    for (int i = 0; i < cantidadSubgrupos; i++) {
        // Si hay sobrantes, agregamos 1 integrante extra a los primeros subgrupos
        int tamanhoSubgrupo = integrantesPorSubgrupo + (i < integrantesSobrantes ? 1 : 0);
        
        // Crear el subgrupo con los integrantes correspondientes
        subgrupos.add(new ArrayList<>(integrantes.subList(indiceInicial, indiceInicial + tamanhoSubgrupo)));
        indiceInicial += tamanhoSubgrupo; // Actualizar el índice para el siguiente subgrupo
    }

    return subgrupos;
}
``` 

** Este método realiza la distribución aleatoria de los integrantes en los subgrupos, Collections.shuffle() baraja la lista de integrantes de manera aleatoria, luego se calcula la cantidad de integrantes de cada subgrupo usando una división entera (integrantes.size() / cantidadSubgrupos) y el resto de esa división (integrantes.size() % cantidadSubgrupos).
se crean subgrupos en el método list()**

```javascript	
private static void imprimirSubgrupos(List<List<String>> subgrupos) {
    for (int i = 0; i < subgrupos.size(); i++) {
        System.out.printf("Subgrupo %d: %s%n", i + 1, subgrupos.get(i)); // Imprime cada subgrupo
    }
}

```
**
Harrison Rengifo, Christian Sierra, Brahian Angel...
**
