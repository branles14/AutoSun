package com.joaomgcd.taskerpluginsample.tasker.suntimes

import com.joaomgcd.taskerpluginlibrary.output.TaskerOutputObject
import com.joaomgcd.taskerpluginlibrary.output.TaskerOutputVariable
import com.joaomgcd.taskerpluginsample.R

@TaskerOutputObject
class SunTimesOutput(
    @get:TaskerOutputVariable(V_SUNRISE, labelResIdName = "sunrise") var sunrise: String?,
    @get:TaskerOutputVariable(V_SUNSET, labelResIdName = "sunset") var sunset: String?,
    @get:TaskerOutputVariable(V_CIVIL_DAWN, labelResIdName = "civil_dawn") var civilDawn: String?,
    @get:TaskerOutputVariable(V_CIVIL_DUSK, labelResIdName = "civil_dusk") var civilDusk: String?,
    @get:TaskerOutputVariable(V_NAUTICAL_DAWN, labelResIdName = "nautical_dawn") var nauticalDawn: String?,
    @get:TaskerOutputVariable(V_NAUTICAL_DUSK, labelResIdName = "nautical_dusk") var nauticalDusk: String?,
    @get:TaskerOutputVariable(V_ASTRONOMICAL_DAWN, labelResIdName = "astronomical_dawn") var astronomicalDawn: String?,
    @get:TaskerOutputVariable(V_ASTRONOMICAL_DUSK, labelResIdName = "astronomical_dusk") var astronomicalDusk: String?
) {
    companion object {
        const val V_SUNRISE = "sunrise"
        const val V_SUNSET = "sunset"
        const val V_CIVIL_DAWN = "civil_dawn"
        const val V_CIVIL_DUSK = "civil_dusk"
        const val V_NAUTICAL_DAWN = "nautical_dawn"
        const val V_NAUTICAL_DUSK = "nautical_dusk"
        const val V_ASTRONOMICAL_DAWN = "astronomical_dawn"
        const val V_ASTRONOMICAL_DUSK = "astronomical_dusk"
    }
}
