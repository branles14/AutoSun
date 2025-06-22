package com.joaomgcd.taskerpluginsample.tasker.suntimes

import android.content.Context
import com.joaomgcd.taskerpluginlibrary.action.TaskerPluginRunnerAction
import com.joaomgcd.taskerpluginlibrary.input.TaskerInput
import com.joaomgcd.taskerpluginlibrary.runner.TaskerPluginResult
import com.joaomgcd.taskerpluginlibrary.runner.TaskerPluginResultSucess
import java.time.LocalDate
import java.time.ZoneId
import java.time.format.DateTimeFormatter

class SunTimesRunner : TaskerPluginRunnerAction<SunTimesInput, SunTimesOutput>() {
    override fun run(context: Context, input: TaskerInput<SunTimesInput>): TaskerPluginResult<SunTimesOutput> {
        val lat = input.regular.latitude ?: 0.0
        val lon = input.regular.longitude ?: 0.0
        val zone = ZoneId.systemDefault()
        val formatter = DateTimeFormatter.ofPattern(input.regular.format ?: "HH:mm")
        val sunTimes = SunTimesCalculator.calculate(LocalDate.now(zone), lat, lon, zone)
        return TaskerPluginResultSucess(
            SunTimesOutput(
                sunTimes.sunrise?.format(formatter),
                sunTimes.sunset?.format(formatter),
                sunTimes.civilDawn?.format(formatter),
                sunTimes.civilDusk?.format(formatter),
                sunTimes.nauticalDawn?.format(formatter),
                sunTimes.nauticalDusk?.format(formatter),
                sunTimes.astronomicalDawn?.format(formatter),
                sunTimes.astronomicalDusk?.format(formatter)
            )
        )
    }
}
