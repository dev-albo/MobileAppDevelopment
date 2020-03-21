import kotlin.math.pow
import kotlin.random.Random

val week = arrayOf("Monday", "Tuesday", "Wednesday", "Thursday",
                    "Friday", "Saturday","Sunday")

// Basic for loop
println("Printing with for loop")
for(day in week)
    println(day)

// While statement
println("Printing with while loop")
val numberOfDays : Int = week.size
var counter = 0

while(counter < numberOfDays){
    println(week[counter])
    counter++
}

fun randomDay(): String {
    // < than number of days
    var randomDay = Random.Default.nextInt(0, numberOfDays -1)
    return week[randomDay]
}

fun randomDayVersion1(): String {
    // < than number of days
    var randomDay = Random.Default.nextInt(numberOfDays -1)
    return week[randomDay]
}

fun randomDayVersion2(): String {

    return week.random()
}

println("Printing random day with 3 different functions:")
println(randomDay())
println(randomDay())
println(randomDayVersion2())
println(randomDayVersion2())
println(randomDayVersion1())
println(randomDayVersion1())

val foods = arrayOf("flakes", "redworms", "granules", "mosquitoes", "plankton")

fun fishFoodWithIfElse(day: String): String {

    return if(day == week[0]){
                        foods[0]
                }else if(day == week[1]) {
                        foods[1]
                }else if(day == week[2]) {
                        foods[2]
                }else if(day == week[3]) {
                        foods[3]
                }else if(day == week[4]) {
                        foods[4]
                }else if(day == week[5]) {
                        foods[5]
                }else{
                        "Nothing"
                }
}

println("Food of the day: ${fishFoodWithIfElse("Monday")}")
println("Food of the day: ${fishFoodWithIfElse("Tuesday")}")

fun fishFoodWithWhen(day: String): String {

    return when(day){
                    week[0] -> foods[0]
                    week[1] -> foods[1]
                    week[2] -> foods[2]
                    week[3] -> foods[3]
                    week[4] -> foods[4]
                    week[5] -> foods[5]
                    else -> "Nothing"
                }
}

println("Food of the day: ${fishFoodWithWhen(randomDayVersion1())}")
println("Food of the day: ${fishFoodWithWhen("Sunday")}")

fun shouldChangeWater(day: String = "Monday", temperature: Int = 25, dirtyLevel: Int = 15 ) : Boolean{
    // Statement fortissimo
    return when {
            day == "Sunday" -> true
            temperature > 30 || dirtyLevel > 30 -> true
            else -> false
            }
}

println("Should change water? ${shouldChangeWater("Sunday", 20, 20)}")
println("Should change water? ${shouldChangeWater( dirtyLevel = 20, temperature =  20)}")

fun isTooHot(temperature: Int) = temperature > 30
fun isDirty(dirty: Int) = dirty > 30
fun isSunday(day: String) = day == "Sunday"

fun shouldChangeWaterCompact(day: String = "Monday", temperature: Int = 25, dirtyLevel: Int = 15 ) : Boolean{
    // Statement fortissimo
    return when {
        isSunday(day) ->  true
        isTooHot(temperature) ->  true
        isDirty(dirtyLevel) -> true
        else -> false
    }
}

println("Should change water? ${shouldChangeWaterCompact("Sunday", 20, 20)}")
println("Should change water? ${shouldChangeWaterCompact( dirtyLevel = 20, temperature =  20)}")

val decorations = listOf("rock", "pagoda", "plastic plant", "alligator", "flowerpot")

decorations.filter { it.startsWith("p") }

// Function type initialized with a lambda
var waterFilter: (Int) -> Int = {dirty -> dirty / 2 }

val parameter = 4
val result = 2
println("$parameter divided by 2 gives us $result. Check with waterfilter result: ${waterFilter(4)}")

fun updateDirty(dirty: Int, operation: (Int) -> Int): Int{
    return operation(dirty)
}

val up = updateDirty(2) { dirtyLevel -> dirtyLevel + 10}
println(up)

val updated = updateDirty(10) {dirty -> dirty / 2}
println(updated)

val waterFilterUpdateDirty = updateDirty(10, waterFilter)
println(waterFilterUpdateDirty)
println("Verify same behaviour: ${updated == waterFilterUpdateDirty}")


// LAB 1 - PART 2

// protected —> same as private + visible in subclasses too;

// Putting val before parameters automatically initializes them
open class Aquarium(protected open val length: Int = 100, protected open val width: Int = 20, protected open val  height: Int = 40) {

    private var fishNumber: Int = 0

    open var shape: String = "rectangle"

    open var volume: Int = 80
        get() = length*width*height/1000

    init {
        println("Initializing aquarium...")
    }

    init {
        println("Volume of aquarium is: $volume")
    }

    constructor(numberOfFish: Int ) : this(){
        fishNumber = numberOfFish
    }

    fun printSize() = println("Width: $width, length: $length, height: $height and shape is a $shape")
}

var aquarium1 = Aquarium()
aquarium1.printSize()

var aquarium2 = Aquarium(length = 10)
aquarium2.printSize()

var aquarium3 = Aquarium(10)
aquarium3.printSize()

println("Volume: ${aquarium1.volume}")
println("Volume: ${aquarium2.volume}")

class TowerTank (override var height: Int, var diameter: Int):
    Aquarium(height = height, width = diameter, length = diameter){

    override var volume: Int = 0
        get() = (2*java.lang.Math.PI* (diameter.toDouble() / 2).pow(2.0) *height).toInt();

    override var shape = "cylinder"
}

var tower = TowerTank(10, 10)
tower.printSize()
tower.shape



