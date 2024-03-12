import kotlin.math.sqrt

fun inequality() {
    val coefficients = listOf(
        Triple(1.0, 1.0, 5.0),
        Triple(1.0, -4.0, 4.0),
        Triple(2.0, -4.0, 4.0),
        Triple(3.0, -4.0, 4.0),
        Triple(1.0, -5.0, 6.0),
        Triple(2.0, -5.0, 6.0),
        Triple(5.0, -5.0, 6.0)
    )

    coefficients.forEachIndexed { index, (a, b, c) ->
        println("Результат для випадку ${index + 1}:")
        val discriminant = b * b - 4 * a * c
        if (discriminant < 0 || a == 0.0) {
            println("Нерівність не має розв'язків")
        } else if (discriminant == 0.0) {
            val x = -b / (2 * a)
            if (a * x * x - b * x + c >= 0) {
                println("Розв'язок: x є розв'язком нерівності для всіх x")
            } else {
                println("Нерівність не має розв'язків")
            }
        } else {
            val x1 = (-b - sqrt(discriminant)) / (2 * a)
            val x2 = (-b + sqrt(discriminant)) / (2 * a)

            val roots = listOf(x1, x2).sorted()
            val intervals = mutableListOf<Pair<Double, Double>>()

            if (a * roots[0] * roots[0] - b * roots[0] + c >= 0) {
                intervals.add(Pair(Double.NEGATIVE_INFINITY, roots[0]))
            }

            for (i in 0 until roots.size - 1) {
                if (a * roots[i + 1] * roots[i + 1] - b * roots[i + 1] + c >= 0) {
                    intervals.add(Pair(roots[i], roots[i + 1]))
                }
            }

            if (a * roots[1] * roots[1] - b * roots[1] + c >= 0) {
                intervals.add(Pair(roots[1], Double.POSITIVE_INFINITY))
            }

            if (intervals.isEmpty()) {
                println("Нерівність не має розв'язків")
            } else {
                println("Розв'язок:")
                intervals.forEach { println("[${it.first}; ${it.second}]") }
            }
        }
        println() // Друкуємо порожній рядок для читабельності
    }
}
