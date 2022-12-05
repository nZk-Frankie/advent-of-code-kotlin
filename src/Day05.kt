import java.util.ArrayDeque

private val FILEDAY05 = readInput("Day05")
private val AUXFILE = readInput("Day05Aux")
private var LISTOFSTACK  = ArrayList<ArrayDeque<String>>()

fun main(){
    createStack()
    Part02()
}

private fun createStack(){
   var STACK1 = ArrayDeque<String>()
    STACK1.push("F")
    STACK1.push("D")
    STACK1.push("B")
    STACK1.push("Z")
    STACK1.push("T")
    STACK1.push("J")
    STACK1.push("R")
    STACK1.push("N")
    LISTOFSTACK.add(STACK1)

    var STACK2 = ArrayDeque<String>()
    STACK2.push("R")
    STACK2.push("S")
    STACK2.push("N")
    STACK2.push("J")
    STACK2.push("H")
    LISTOFSTACK.add(STACK2)

    var STACK3 = ArrayDeque<String>()
    STACK3.push("C")
    STACK3.push("R")
    STACK3.push("N")
    STACK3.push("J")
    STACK3.push("G")
    STACK3.push("Z")
    STACK3.push("F")
    STACK3.push("Q")
    LISTOFSTACK.add(STACK3)

    var STACK4 = ArrayDeque<String>()
    STACK4.push("F")
    STACK4.push("V")
    STACK4.push("N")
    STACK4.push("G")
    STACK4.push("R")
    STACK4.push("T")
    STACK4.push("Q")
    LISTOFSTACK.add(STACK4)

    var STACK5 = ArrayDeque<String>()
    STACK5.push("L")
    STACK5.push("T")
    STACK5.push("Q")
    STACK5.push("F")
    LISTOFSTACK.add(STACK5)

    var STACK6 = ArrayDeque<String>()
    STACK6.push("Q")
    STACK6.push("C")
    STACK6.push("W")
    STACK6.push("Z")
    STACK6.push("B")
    STACK6.push("R")
    STACK6.push("G")
    STACK6.push("N")
    LISTOFSTACK.add(STACK6)

    var STACK7 = ArrayDeque<String>()
    STACK7.push("F")
    STACK7.push("C")
    STACK7.push("L")
    STACK7.push("S")
    STACK7.push("N")
    STACK7.push("H")
    STACK7.push("M")
    LISTOFSTACK.add(STACK7)

    var STACK8 = ArrayDeque<String>()
    STACK8.push("D")
    STACK8.push("N")
    STACK8.push("Q")
    STACK8.push("M")
    STACK8.push("T")
    STACK8.push("J")
    LISTOFSTACK.add(STACK8)

    var STACK9 = ArrayDeque<String>()
    STACK9.push("P")
    STACK9.push("G")
    STACK9.push("S")
    LISTOFSTACK.add(STACK9)

}

private fun Part01(){
    for (i in FILEDAY05)
    {
        var wantedString = i.split(" ")
        var amount = wantedString[1].toInt()
        var initialPos = wantedString[3].toInt()
        var finalPos = wantedString[5].toInt()

        println("Moving "+ amount+ " from " +initialPos+ " to " + finalPos)
        println(LISTOFSTACK)

        for (x in 0 until amount step 1)
        {
            if (!LISTOFSTACK.get(initialPos-1).isEmpty()) {
                LISTOFSTACK.get(finalPos - 1).push(LISTOFSTACK.get(initialPos - 1).pop())
            }
            else{
                break
            }
        }
        println(LISTOFSTACK)
        println("\n")

    }
    for (stack in LISTOFSTACK)
    {
        print(stack.peek())
    }

}

private fun Part02()
{
    for(i in FILEDAY05)
    {
        var wantedString = i.split(" ")
        var amount = wantedString[1].toInt()
        var initialPos = wantedString[3].toInt()
        var finalPos = wantedString[5].toInt()
        println("Moving "+ amount+ " from " +initialPos+ " to " + finalPos)
        println(LISTOFSTACK)
        var tempQueue = ArrayDeque<String>()
        if (!tempQueue.isEmpty())
        {
            tempQueue.clear()
        }
        for (x in 0 until amount step 1)
        {
            tempQueue.push(LISTOFSTACK.get(initialPos - 1).pop())
        }
        for (crane in tempQueue)
        {
            LISTOFSTACK.get(finalPos-1).push(tempQueue.pop())
        }
        println(LISTOFSTACK)
        println("\n")
    }
    for (stack in LISTOFSTACK)
    {
        print(stack.peek())
    }
}