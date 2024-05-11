fun solve(k: Int) {
    val chars = readStr()
    val charMap = hashMapOf<Int, Int>()
    for (c in chars) {
        val key = c.code
        charMap[key] = charMap.getOrDefault(key, 0) + 1
    }

    var pairCount = 0
    charMap.keys.forEach { a ->
        val b = if (a < 97) a + 32 else a - 32
        val countA = charMap.getOrDefault(a, 0)
        val countB = charMap.getOrDefault(b, 0)
        if (countA > 0 && countB > 0) {
            val newPairs = minOf(countA, countB)
            charMap[a] = countA - newPairs
            charMap[b] = countB - newPairs
            pairCount += newPairs
        }
    }

    var operations = k
    charMap.values.forEach { a ->
        val newPairs = a / 2
        val pairsToUse = minOf(operations, newPairs)
        pairCount += pairsToUse
        operations -= pairsToUse
        if (operations <= 0) {
            println(pairCount)
            return
        }
    }
    println(pairCount)
}


fun main() {
    val t = readInt()
    repeat(t) {
        val (n, k) = readStrings()
        solve(k.toInt())
    }
}

fun readStr() = readln() // string line
fun readInt() = readStr().toInt() // single int
fun readStrings() = readStr().split(" ") // list of strings
fun readInts() = readStrings().map { it.toInt() } // list of ints