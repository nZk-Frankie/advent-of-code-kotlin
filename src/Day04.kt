val FILEDAY04 = readInput("Day04")


fun main(){
    Part02()
}


private fun Part01() {
    var overlapScore = 0
    for(i in FILEDAY04)
    {
        var SPLITTED = i.split(",")
        if (checkWithin(SPLITTED.get(0),SPLITTED.get(1)))
        {
            overlapScore++
        }
    }
    println("Total Overlap: "+ overlapScore)
}

fun checkWithin(s1:String, s2:String):Boolean{
    var S1_SPLIT = s1.split("-")
    var S2_SPLIT = s2.split("-")

    var r1 = S1_SPLIT.get(1).toInt() - S1_SPLIT.get(0).toInt() + 1
    var r2 = S2_SPLIT.get(1).toInt() - S2_SPLIT.get(0).toInt() + 1
    if (r1 >= r2)
    {

        if (Determine(S1_SPLIT.get(0).toInt(),S1_SPLIT.get(1).toInt(),S2_SPLIT.get(0).toInt(),S2_SPLIT.get(1).toInt()))
        {
            println("First is Within")
            return true
        }
    }
    else{
        if (Determine(S2_SPLIT.get(0).toInt(),S2_SPLIT.get(1).toInt(),S1_SPLIT.get(0).toInt(),S1_SPLIT.get(1).toInt()))
        {
            println("Second is Within")
            return true
        }
    }
    println("Not Within")
    return false
}

private fun Determine(M1:Int,M2:Int,m1:Int,m2:Int):Boolean
{
    if (m1>=M1 && M2 >= m2)
    {
        return true
    }
    else
    {
        return false
    }
}


private fun Part02(){
    var overlapScore = 0
    for(i in FILEDAY04)
    {
        var SPLITTED = i.split(",")
        if (checkPartialOverlap(SPLITTED.get(0),SPLITTED.get(1)))
        {
            overlapScore++
        }
    }
    println("Total Partial Overlap: "+ overlapScore)
}


fun checkPartialOverlap(s1:String,s2:String):Boolean
{
    var S1_SPLIT = s1.split("-")
    var S2_SPLIT = s2.split("-")

    var r1 = S1_SPLIT.get(1).toInt() - S1_SPLIT.get(0).toInt() + 1
    var r2 = S2_SPLIT.get(1).toInt() - S2_SPLIT.get(0).toInt() + 1
    if (r1>=r2)
    {
        if ((S2_SPLIT.get(0).toInt() >= S1_SPLIT.get(0).toInt() && S1_SPLIT.get(1).toInt() >= S2_SPLIT.get(0).toInt()) || (S2_SPLIT.get(1).toInt() >= S1_SPLIT.get(0).toInt() && S1_SPLIT.get(1).toInt() >= S2_SPLIT.get(1).toInt()))
        {
            return true
        }
    }
    else{
        if ((S1_SPLIT.get(0).toInt() >= S2_SPLIT.get(0).toInt() && S2_SPLIT.get(1).toInt() >= S1_SPLIT.get(0).toInt()) || (S1_SPLIT.get(1).toInt() >= S2_SPLIT.get(0).toInt() && S2_SPLIT.get(1).toInt() >= S1_SPLIT.get(1).toInt()))
        {
          return true
        }
    }
    return false
}