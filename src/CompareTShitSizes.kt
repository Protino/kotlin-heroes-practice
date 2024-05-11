object CompareTShitSizes {
    fun solve() {
        val t = readInt()
        repeat(t) {
            val (a, b) = readStr().split(" ")
            val aSize = a.getTShirtSize()
            val bSize = b.getTShirtSize()
            println(if (aSize < bSize) '<' else if (aSize > bSize) '>' else '=')
        }
    }

    private fun String.getTShirtSize(): Int {
        if (isEmpty()) return 0

        when (last()) {
            'M' -> return 1
            'S' -> return -length
            'L' -> return length * 2
        }
        throw Exception("Invalid TShirt size - $this")
    }
}

/**
 * XXXS < XS
 * XXXL > XL
 * XL > M
 * XXL = XXL
 * XXXXXS < M
 * XL > XXXS
 */