import java.lang.Exception
import java.lang.IllegalArgumentException
import java.lang.Math.abs

fun main(){
    var score = 0
    val InputFile = readInput("Day02");
    fun Part01():Unit{
        for(i in InputFile){
            var splitted = i.toCharArray()
            score += DetermineWinner(splitted[0],ConvertString(splitted[2]))
            println(score)
            println("==============================")
        }

    }
    fun Part02():Unit{
        var shapeScore = 0
        var gameScore = 0
        for(i in InputFile)
        {
            var splitted = i.toCharArray()
            if (splitted[2] == 'Y')
            {
                shapeScore = splitted[0].toInt() - 64
                gameScore = gameScore + 3 + shapeScore

                println("Draw Game")
                println("Shape Score: "+ shapeScore)
                println("Game Score: "+ gameScore)
            }
            if (splitted[2] == 'X')
            {
                var temp = (splitted[0].toInt() - 64) - 1
                if (temp == 0)
                {
                    shapeScore = 3
                }
                else
                {
                    shapeScore = temp
                }
                gameScore += 0 +shapeScore
                println("Lose Game")
                println("Shape Score: "+ shapeScore)
                println("Game Score: "+ gameScore)
            }
            if (splitted[2] == 'Z')
            {
                var temp = (splitted[0].toInt() - 64) + 1
                if (temp == 4)
                {
                    shapeScore = 1
                }
                else
                {
                    shapeScore =temp
                }
                gameScore += 6 + shapeScore
                println("Win Game")
                println("Shape Score: "+ shapeScore)
                println("Game Score: "+ gameScore)
            }
            println("===================================")

        }
    }

    Part02()
}

fun ConvertString(p2:Char):Char{
    if(p2.equals('X')){
        return 'A'}
    else if(p2.equals('Y')){
        return 'B'}
    else if (p2.equals('Z')) {
        return 'C'
    }
    else
    {
        throw IllegalArgumentException("WOW")
    }

    return 'I'
}
fun DetermineWinner(p1:Char, p2:Char):Int{
    var thisRoundScore = 0
    println("Enemy: "+p1)
    println("You: "+p2)
    //A AND X ARE ROCKS
    //B AND Y ARE PAPERS
    //C AND Z ARE SCISSORS
    if(p2.toInt() > p1.toInt())
    {
        if (p2 - p1 == 2) {
            println("You Lose")
            thisRoundScore += 0
        }
        else
        {
            println("You Win")
            thisRoundScore += 6
        }

    }
    else if (p2.equals(p1))
    {
        thisRoundScore +=3
        println("You Draw")
    }
    else if (p2.toInt() < p1.toInt() )
    {
        if(p1 - p2 == 2)
        {
            println("You Win")
            thisRoundScore += 6
        }
        else
        {
            thisRoundScore +=0
            println("You Lose")
        }
    }

    var shapescore = p2.toInt() - 64
    println("This Round Score = "+thisRoundScore)
    println("Your Shape Score = "+shapescore)
    thisRoundScore += shapescore

    return thisRoundScore
}
