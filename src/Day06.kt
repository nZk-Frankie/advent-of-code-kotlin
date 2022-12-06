import java.util.LinkedList
import java.util.Queue

private val FILE06 = readInput("Day06")
var score = 0
var t = false

fun main()
{
    println(Part01(4))
    println(Part01(14))
}

private fun Part01(Offset:Int):Int
{
    for (i in FILE06) {
        //queue the first three elements
        for (x in 0 until i.length - Offset step 1)
        {
            var str = i.substring(x,x+Offset)
            println("Substring: " + str)
            if (checkExistence(str))
            {
                score = x + Offset
                return score
            }
        }

    }
    return 0
}

fun checkExistence(sub:String):Boolean{
    for(character in sub)
    {
        if (sub.count{it == character }>1)
        {
            return false
        }
    }
    return true
}