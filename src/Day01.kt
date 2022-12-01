fun main() {
    val totalSnacks = ArrayList<Int>()

    fun PartOne():Unit{
        val input = readInput("Day01")
        var sum=0;
        var largest = 0;
        for (i in input.indices){
            if (!input[i].isEmpty())
            {
                sum += Integer.parseInt(input[i])
                totalSnacks.add(sum)
            }
            else {
                if (sum > largest)
                {
                    largest = sum
                }
                sum = 0;
            }
        }
        println(largest)
    }

    fun partTwo():Unit{
        totalSnacks.sortDescending()
        var totalTopThree = totalSnacks[0]+totalSnacks[1]+totalSnacks[2]
        println(totalTopThree)
    }

    PartOne()
    partTwo()
}
