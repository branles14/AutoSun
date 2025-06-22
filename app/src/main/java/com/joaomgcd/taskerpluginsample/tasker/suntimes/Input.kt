package com.joaomgcd.taskerpluginsample.tasker.suntimes

import com.joaomgcd.taskerpluginlibrary.input.TaskerInputField
import com.joaomgcd.taskerpluginlibrary.input.TaskerInputRoot
import com.joaomgcd.taskerpluginsample.R

@TaskerInputRoot
class SunTimesInput @JvmOverloads constructor(
    @field:TaskerInputField("lat", labelResIdName = "latitude") var latitude: Double? = null,
    @field:TaskerInputField("lon", labelResIdName = "longitude") var longitude: Double? = null,
    @field:TaskerInputField("format", labelResIdName = "format") var format: String? = "HH:mm"
)
