import kotlin.system.exitProcess

fun main(args: Array<String>)
{
    println("Добро пожаловать на вокзал!")
    println()
    //city array
    val cities = arrayOf("Котлас",
        "Санкт-Петербург",
        "Москва",
        "Бийск",
        "Барнаул",
        "Казань",
        "Норильск",
        "Астрахань",
        "Вычегда",
        "Архангельск",
        "Владивосток",
        "Кумертау",
        "Уфа",
        "Выборг",
        "Петропавловск-Камчатский",
        "Саратов"
    )

    while (true) {
        //generate 2 indexes
        val cityA = (0..cities.size - 1).random()
        var cityB = (0..cities.size - 1).random()
        while (cityA == cityB) //make them different
        {
            cityB = (0..cities.size - 1).random()
        }
        //train name
        val trainNum = (1..999).random()
        //output city names
        println("Скорый поезд $trainNum скоро отправится из города ${cities[cityA]} в город ${cities[cityB]}.")

        //generate passengers
        val passengers = (5..201).random()
        //output number of passengers
        println("На скорый поезд $trainNum купили $passengers билет${rusNumEnding(passengers)}.")

        //generate cars
        val carNum = calcCars(passengers)
        //output number of cars
        println("В скором поезде $trainNum есть $carNum вагон${rusNumEnding(carNum)}.")

        //restart?
        println("Скорый $trainNum поезд уехал. Пустить ещё один? Если нет, введите EXIT")

        when(readln().uppercase())
        {
            "EXIT" ->
            {
                println("Вокзал закрывается")
                exitProcess(0)
            }
            else -> println("Ну, ладно.")
        }
    }
}
//get russian ending for a number
fun rusNumEnding(input: Int):String
{
    if (input%100 in (11..14)) return "ов"
    when (input%10)
    {
        1 -> return ""
        in (2..4) -> return "а"
        in (5..9) -> return "ов"
        0 -> return "ов"
        else -> return ""
    }
}
//столько вагонов (вместительность каждого вагона определяется рандомно и находится в диапазоне от 5 до 25),
//сколько хватит для перевозки всех пассажиров. То есть вы прибавляете к поезду по одному вагону рандомной
//вместительности до тех пор, пока не усадите в них всех пассажиров, купивших билеты
fun calcCars(inputPassengers: Int):Int
{
    var output = 1
    var processedPassengers = 0

    while (processedPassengers < inputPassengers)
    {
        //gen the size of a curr car
        val currCarsize = (5..25).random()
        //put passengers in the car
        processedPassengers += currCarsize
        //switch to the next car
        output++
    }

    return output
}

