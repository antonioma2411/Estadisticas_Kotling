import kotlin.math.pow
import kotlin.math.round
import kotlin.math.sqrt

// Objeto singleton con las funciones estadísticas.
// Al ser un "object" no hace falta crear una instancia: se usa como Calculos.calcularMedia(...)
object Calculos {

    // Media aritmética: suma de todos los valores dividida entre la cantidad de datos.
    // Se convierte la suma a Double antes de dividir para no perder los decimales
    // (si dividiéramos Int entre Int, Kotlin haría una división entera).
    fun calcularMedia(numeros: List<Int>): Double {
        val media = numeros.sum().toDouble() / numeros.size

        return media
    }

    // Moda: valor(es) que más veces se repite(n).
    // Devuelve una lista porque puede haber varias modas.
    // Si no hay moda (nadie se repite, o todos se repiten lo mismo) devuelve una lista vacía.
    fun calcularModa(numeros: List<Int>): List<Int> {
        // groupingBy + eachCount crea un mapa {valor -> veces que aparece}
        val frecuencias = numeros.groupingBy { it }.eachCount()

        // Frecuencia más alta. Si la lista estuviera vacía, maxOrNull() da null
        // y el "?: return" sale de la función devolviendo una lista vacía.
        val maxRepeticiones = frecuencias.values.maxOrNull() ?: return emptyList()

        // Si el máximo es 1 (nadie se repite) o todos tienen la misma frecuencia, no hay moda
        if (maxRepeticiones == 1 || frecuencias.values.distinct().size == 1) {
            return emptyList()
        }

        // Nos quedamos solo con los valores cuya frecuencia coincide con la máxima.
        // Si hay empate, salen varios (varias modas).
        return frecuencias.filterValues { it == maxRepeticiones }.keys.toList()
    }

    // Desviación típica poblacional. Pasos:
    // 1) media  2) diferencia de cada número con la media  3) elevar al cuadrado
    // 4) media de esos cuadrados (varianza)  5) raíz cuadrada
    fun calcularDesviacionTipica(numeros: List<Int>): Double {

        var media = calcularMedia(numeros)   // Paso 1
        var res = 0.0                        // Acumulador de las diferencias al cuadrado
        var desviacionTipica = 0.0

        // Pasos 2 y 3: (número - media)^2 acumulado en res
        for (i in numeros) {
            res = (i - media).pow(2) + res
        }

        // Pasos 4 y 5: varianza = res / n, y raíz cuadrada para obtener la desviación
        desviacionTipica = sqrt(res / numeros.size)

        // Redondeo a 2 decimales para que el resultado sea más legible
        desviacionTipica = round(desviacionTipica * 100.0) / 100.0

        return desviacionTipica
    }

}
