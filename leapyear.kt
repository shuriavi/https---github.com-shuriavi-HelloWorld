class Time(internal var hours: Int, internal var minutes: Int, internal var seconds: Int)

fun main(args: Array<String>) {
    //Start time in hours, minutes, then seconds
    val start = Time(12, 34, 55)
    //Stop time in hours, minutes, then seconds
    val stop = Time(8, 12, 40)
    //Difference using start - stop equation
    val diff: Time
	
    diff = difference(start, stop)
    
    //Formatted output of time
    println("TIME DIFFERENCE: ${start.hours} hours, ${start.minutes} minutes, and ${start.seconds} seconds ")
    println("		- ${stop.hours} hours, ${stop.minutes} minutes, and ${stop.seconds} seconds ")
    println("		_____________________________________")
    println("		  ${diff.hours} hours, ${diff.minutes} minutes, and ${diff.seconds} seconds")
    
    val sec = (diff.seconds) + (diff.minutes * 60) + (diff.hours * 60 * 60)
    val min = (diff.seconds / 60) + (diff.minutes) + (diff.hours * 60)
    val hrs = (diff.seconds / 60 / 60) + (diff.minutes / 60) + (diff.hours)
    
    //If hours is greater than zero the outputs stop here.
    when {
        (hrs > 0) -> println("")
    }
    
    //if output is less than zero than it will convert hours to minutes and subtract minutes
    else if (diff.hours < 0){
        println("OR")
        println("")
        val minutes = (diff.hours * 60)
        diff.minutes = diff.minutes + minutes
        //If minutes becomes less than zero it will then convert minutes to seconds than
        //subtract from seconds.
        	if (diff.minutes < 0) {
            	val seconds = (diff.minutes * 60)
                diff.seconds = diff.seconds + seconds
                //If seconds become negative it will output vales are not applicable
        		if (diff.seconds < 0)
                	println("ERROR: Values are not applicable")
                //If seconds are positive it will output seconds
                else
        			println("${diff.seconds} seconds")
            }
            //If minutes are positive it will output minutes and seconds.
            else
        		println("${diff.minutes} minutes, and ${diff.seconds} seconds")
    }

    //This is to handle if minutes are less than zero.
    else if (diff.minutes < 0){
        println("OR")
        println("")
        val seconds = (diff.minutes * 60)
        diff.seconds = diff.seconds + seconds
        //If minutes are less than zero and so are seconds it will output that values are not applicable.
        	if (diff.seconds < 0)
                println("ERROR: Values are not applicable")
            //If seconds are positive it will output seconds
           	else
        		println("${diff.seconds} seconds")
    }

    //This is for no hours but will output minutes and seconds.
    else if (min > 0){
        println("OR")
        println("")
        println("${min} minutes, and ${diff.seconds} seconds")
    }

    //If there are no hours or minutes it will just ouput seconds.
    else if (sec > 0){
        println("OR")
        println("")
        println("${sec} seconds")
    } 
}


//This function calculates the difference between the start and stop. It takes the arguments time start and time stop
//It goes through a loop to determine seconds minutes and hours.
fun difference(start: Time, stop: Time): Time {
    val diff = Time(0, 0, 0)

    if (stop.seconds > start.seconds) {
        --start.minutes
        start.seconds += 60
    }

    diff.seconds = start.seconds - stop.seconds
    if (stop.minutes > start.minutes) {
        --start.hours
        start.minutes += 60
    }

    diff.minutes = start.minutes - stop.minutes
    diff.hours = start.hours - stop.hours

    return diff
}