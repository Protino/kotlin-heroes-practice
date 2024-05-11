object SpyDetected {
    fun solve() {
        val t = readInt()
        repeat(t) {
            readInt()
            val arr = readInts()
            val first = arr[0]
            var second: Int? = null
            var firstCount = 0
            var secondCount = 0
            var firstIndex = 0
            var secondIndex = 0
            arr.forEachIndexed { index, i ->
                if (i == first) {
                    firstCount++
                    firstIndex = index
                } else {
                    second = i
                    secondIndex = index
                }
                if (second != null && i == second) {
                    secondCount++
                }
                if (second != null && (firstCount >= 2 || secondCount >= 2)) {
                    println(if (firstCount == 1) firstIndex + 1 else secondIndex + 1)
                    return@repeat
                }
            }
        }
    }
}