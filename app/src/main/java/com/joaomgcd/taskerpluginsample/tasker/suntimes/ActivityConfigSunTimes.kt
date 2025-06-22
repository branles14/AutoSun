package com.joaomgcd.taskerpluginsample.tasker.suntimes

import android.view.LayoutInflater
import com.joaomgcd.taskerpluginlibrary.config.TaskerPluginConfig
import com.joaomgcd.taskerpluginlibrary.config.TaskerPluginConfigHelper
import com.joaomgcd.taskerpluginlibrary.input.TaskerInput
import com.joaomgcd.taskerpluginsample.databinding.ActivityConfigGetsuntimesBinding
import com.joaomgcd.taskerpluginsample.tasker.ActivityConfigTasker

class SunTimesHelper(config: TaskerPluginConfig<SunTimesInput>) :
    TaskerPluginConfigHelper<SunTimesInput, SunTimesOutput, SunTimesRunner>(config) {
    override val runnerClass = SunTimesRunner::class.java
    override val inputClass = SunTimesInput::class.java
    override val outputClass = SunTimesOutput::class.java
}

class ActivityConfigSunTimes :
    ActivityConfigTasker<SunTimesInput, SunTimesOutput, SunTimesRunner, SunTimesHelper, ActivityConfigGetsuntimesBinding>() {
    override fun getNewHelper(config: TaskerPluginConfig<SunTimesInput>) = SunTimesHelper(config)

    override fun assignFromInput(input: TaskerInput<SunTimesInput>) {
        input.regular.run {
            binding?.editTextLat?.setText(latitude?.toString() ?: "")
            binding?.editTextLon?.setText(longitude?.toString() ?: "")
            binding?.editTextFormat?.setText(format ?: "")
        }
    }

    override val inputForTasker get() = TaskerInput(
        SunTimesInput(
            binding?.editTextLat?.text?.toString()?.toDoubleOrNull(),
            binding?.editTextLon?.text?.toString()?.toDoubleOrNull(),
            binding?.editTextFormat?.text?.toString()
        )
    )

    override fun inflateBinding(layoutInflater: LayoutInflater) =
        ActivityConfigGetsuntimesBinding.inflate(layoutInflater)
}
