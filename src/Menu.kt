// Objeto que gestiona toda la interacción con el usuario por consola:
// menú, lectura de datos y llamadas a las funciones de cálculo.
object Menu {

    // Imprime las opciones del menú en pantalla.
    fun pintarMenu() {
        println("===== ESTADÍSTICAS CON KOTLIN =====\n" +
                "1. Generar 100 números aleatorios\n" +
                "2. Introducir 100 números manualmente\n" +
                "3. Calcular media\n" +
                "4. Calcular moda\n" +
                "5. Calcular desviación típica\n" +
                "6. Calcular todas las estadísticas\n" +
                "0. Salir\n" +
                "Seleccione una opción:")
    }

    // Bucle principal: repite el menú hasta que el usuario escribe "0".
    fun menuPrincipal() {
        var lista = mutableListOf<Int>()   // Lista de datos; empieza vacía
        var opcion = ""

        do {
            pintarMenu()
            opcion = readln()   // Se lee como texto para poder validar cualquier entrada

            when (opcion) {
                "0" -> {
                    println("Saliendo del programa...")
                }

                // Opción 1: 100 números aleatorios entre 1 y 100
                "1" -> {
                    lista = listaAleatoria()
                    println("Lista generada correctamente.")

                    mostrarLista(lista)
                }

                // Opción 2: el usuario escribe los 100 números a mano
                "2" -> {
                    lista = listaManual()
                    println("Lista generada correctamente.")
                    mostrarLista(lista)
                }

                // Opción 3: media (solo si hay datos)
                "3" -> {
                    var media = 0.0
                    if (lista.isNotEmpty()) {
                        media = Calculos.calcularMedia(lista)
                        println("La media de la lista es: $media")
                    } else {
                        println("La lista esta vacia, la media no se puede calcular")
                    }
                }

                // Opción 4: moda (solo si hay datos)
                "4" -> {
                    if (lista.isNotEmpty()) {
                        val moda = Calculos.calcularModa(lista)
                        println("La/s moda/s de esta lista es: $moda")
                    } else {
                        println("La lista esta vacia, la moda no se puede calcular")
                    }
                }

                // Opción 5: desviación típica (solo si hay datos)
                "5" -> {
                    if (lista.isNotEmpty()) {
                        val desviacion = Calculos.calcularDesviacionTipica(lista)
                        println("La desviación típica de esta lista es: $desviacion")
                    } else {
                        println("La lista esta vacia, la desviacion tipica no se puede calcular")
                    }
                }

                // Opción 6: las tres estadísticas seguidas
                "6" -> {
                    if (lista.isNotEmpty()) {
                        val media = Calculos.calcularMedia(lista)
                        println("La media de la lista es: $media")
                        val moda = Calculos.calcularModa(lista)
                        println("La/s moda/s de esta lista es: $moda")
                        val desviacion = Calculos.calcularDesviacionTipica(lista)
                        println("La desviación típica de esta lista es: $desviacion")
                    } else {
                        println("La lista esta vacia, no se pueden mostrar las estadisticas")
                    }
                }

                // Cualquier otra cosa: opción no válida y se vuelve a mostrar el menú
                else -> println("No es una opcion valida")
            }

        } while (!opcion.equals("0"))
    }

    // Genera una lista de 100 enteros aleatorios entre 1 y 100 (ambos incluidos).
    // MutableList(100) { ... } ejecuta el bloque 100 veces, una por cada posición.
    fun listaAleatoria(): MutableList<Int> {
        var lista = MutableList(100) { (1..100).random() }

        return lista
    }

    // Pide números por teclado hasta tener exactamente 100.
    // Si el usuario escribe algo que no es un entero, se avisa y NO se cuenta:
    // el contador solo sube cuando el número es válido.
    fun listaManual(): MutableList<Int> {
        var lista = mutableListOf<Int>()
        var numTXT = ""
        var num = 0

        while (lista.size <= 99) {
            println("Numeros en la lista: ${lista.size} /100 \n" +
                    "Introduzca un numero entero en la lista")

            numTXT = readln()
            try {
                num = Integer.parseInt(numTXT)   // Lanza NumberFormatException si no es entero
                lista.add(num)
            } catch (e: NumberFormatException) {
                println("ERROR! $numTXT no es un valor valido, tiene que ser un numero entero")
            }
        }

        return lista
    }

    // Muestra la lista completa por pantalla.
    fun mostrarLista(lista: MutableList<Int>) {

        println("La lista esta compuesta por estos numeros:")
        println(lista)
    }

}
