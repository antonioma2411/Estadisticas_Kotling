# UD01_Actividad08_Estadisticas

Aplicación de consola en **Kotlin** que trabaja con una lista de 100 números enteros y calcula la **media**, la **moda** y la **desviación típica**.

Actividad 08 de la UD01 (PMDM).

## Requisitos

- IntelliJ IDEA (o cualquier IDE con soporte Kotlin)
- JDK 17 o superior (probado con la JDK que trae IntelliJ)

## Cómo ejecutarlo

1. Abrir la carpeta del proyecto en IntelliJ IDEA.
2. Abrir `src/Main.kt` y ejecutar la función `main()` (icono ▶ junto a `fun main()`).
3. Usar el menú desde la consola de IntelliJ.

## Menú

```
===== ESTADÍSTICAS CON KOTLIN =====
1. Generar 100 números aleatorios
2. Introducir 100 números manualmente
3. Calcular media
4. Calcular moda
5. Calcular desviación típica
6. Calcular todas las estadísticas
0. Salir
```

- **1**: genera 100 números aleatorios entre 1 y 100 y los muestra.
- **2**: pide 100 enteros por teclado (los valores no numéricos se rechazan y no cuentan) y los muestra.
- **3, 4, 5**: calculan cada estadística por separado.
- **6**: calcula las tres seguidas.
- **0**: sale del programa.

Antes de generar o introducir datos, las opciones 3–6 avisan de que la lista está vacía.

## Estructura

```
src/
├── Main.kt       # main(): arranca el menú
├── Menu.kt       # menú, lectura por teclado, generación de la lista, validaciones
└── Calculos.kt   # calcularMedia, calcularModa, calcularDesviacionTipica
```

## Cómo se calcula cada estadística

- **Media**: suma de los valores entre el número de datos (con división en `Double`).
- **Moda**: se cuenta la frecuencia de cada valor y se devuelven los que tienen la frecuencia máxima. Puede haber una moda, varias, o ninguna (lista vacía cuando ningún valor se repite o todos se repiten igual).
- **Desviación típica**: raíz cuadrada de la media de los cuadrados de las diferencias respecto a la media (poblacional), redondeada a 2 decimales.

## Ejemplo de resultados

| Datos | Media | Moda | Desv. típica |
|---|---|---|---|
| Del 1 al 100 | 50.5 | [] (no hay moda) | 28.87 |
| Cinco 7 + del 100 al 194 | 140.0 | [7] | 40.56 |
| 4, 8, 15 ×3 + 91 distintos | – | [4, 8, 15] | – |

## Documentación

Las evidencias, capturas y pruebas están en el PDF `UD01_Act08_NombreApellidos.pdf`.
