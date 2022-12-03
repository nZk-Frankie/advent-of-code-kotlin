val FILE = readInput("Day03")

fun main()
{
    Part02()
}

fun Part01(){
    var score = 9
    var TotalScore = 0
    for (i in FILE)
    {
        var len = i.length - 1
        var firstHalf = i.slice(0..len/2)
        var secondHalf = i.slice((len/2)+1..len)
        for(x in 0 until firstHalf.length step 1)
        {
            if(secondHalf.contains(firstHalf.get(x)))
            {
                println("Letter: "+ firstHalf.get(x) + " at POS: " + x +" and Line: "+ i)
                score = calculateScore(firstHalf.get(x))
                TotalScore += score
                println("Score This Round:= "+score)
                println("Score Total := "+TotalScore)
                break
            }
        }
    }
}
fun calculateScore(char:Char):Int{
    var score = 0
    if(char.toInt()>96)
    {
        score = 1 +  char.toInt() - 'a'.toInt()
    }
    else
    {
        score =  27 + char.toInt() - 'A'.toInt()
    }

    return score
}
fun Part02(){

    var score = 0
    var priorityScore = 0
    for (i in 0  until FILE.size step 3)
    {
        var fString = FILE.get(i)
        var sString = FILE.get(i+1)
        var tString = FILE.get(i+2)
        for(char in fString)
        {
            if(sString.contains(char) && tString.contains(char))
            {
                score = calculateScore(char)
                priorityScore += score
                println("Badge Found: "+ char)
                println("Score This Round: "+ score)
                println("Total Priority Score: "+priorityScore)
                println("=======================================")
                break
            }
        }
    }
}

