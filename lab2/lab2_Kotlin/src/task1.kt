import java.util.Scanner

    fun maxValue() {
        val scanner = Scanner(System.`in`)

        // Перевірка введених даних для першого числа
        var number1 = 0f
        var validInput1 = false
        while (!validInput1) {
            println("Введіть перше число:")
            if (scanner.hasNextFloat()) {
                number1 = scanner.nextFloat()
                validInput1 = true
            } else {
                println("Некоректне значення. Будь ласка, введіть число.")
                scanner.next() // Очищення буфера вводу
            }
        }

        // Перевірка введених даних для другого числа
        var number2 = 0f
        var validInput2 = false
        while (!validInput2) {
            println("Введіть друге число:")
            if (scanner.hasNextFloat()) {
                number2 = scanner.nextFloat()
                validInput2 = true
            } else {
                println("Некоректне значення. Будь ласка, введіть число.")
                scanner.next() // Очищення буфера вводу
            }
        }

        val sum = number1 + number2
        val product = number1 * number2
        val quotient = if (number2 != 0.0f) number1 / number2 else Float.MAX_VALUE
        val max = maxOf(sum, product, quotient)

        println("Найбільше значення серед суми, добутку та частки: $max")
    }
