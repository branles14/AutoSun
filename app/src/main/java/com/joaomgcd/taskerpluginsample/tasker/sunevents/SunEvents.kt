package com.joaomgcd.taskerpluginsample.tasker.sunevents

import android.app.Activity
import android.content.Context
import android.os.Bundle
import com.joaomgcd.taskerpluginlibrary.config.TaskerPluginConfig
import com.joaomgcd.taskerpluginlibrary.config.TaskerPluginConfigHelperEventNoOutputOrInputOrUpdate
import com.joaomgcd.taskerpluginlibrary.config.TaskerPluginConfigNoInput
import com.joaomgcd.taskerpluginlibrary.extensions.requestQuery
import com.joaomgcd.taskerpluginlibrary.input.TaskerInput

class SunEventHelper(config: TaskerPluginConfig<Unit>) :
    TaskerPluginConfigHelperEventNoOutputOrInputOrUpdate(config) {
    override fun addToStringBlurb(input: TaskerInput<Unit>, blurbBuilder: StringBuilder) {
        blurbBuilder.append("Sun event triggered")
    }
}

open class BaseSunEventActivity : Activity(), TaskerPluginConfigNoInput {
    override val context get() = applicationContext
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        SunEventHelper(this).finishForTasker()
    }
}

class EventAstronomicalDawn : BaseSunEventActivity()
class EventNauticalDawn : BaseSunEventActivity()
class EventCivilDawn : BaseSunEventActivity()
class EventSunrise : BaseSunEventActivity()
class EventSunset : BaseSunEventActivity()
class EventCivilDusk : BaseSunEventActivity()
class EventNauticalDusk : BaseSunEventActivity()
class EventAstronomicalDusk : BaseSunEventActivity()
class EventAngle35 : BaseSunEventActivity()
class EventAngle40 : BaseSunEventActivity()
class EventAngle60 : BaseSunEventActivity()
class EventAngle65 : BaseSunEventActivity()
class EventAngle70 : BaseSunEventActivity()
class EventAngle75 : BaseSunEventActivity()

fun Context.triggerAstronomicalDawnEvent() = EventAstronomicalDawn::class.java.requestQuery(this)
fun Context.triggerNauticalDawnEvent() = EventNauticalDawn::class.java.requestQuery(this)
fun Context.triggerCivilDawnEvent() = EventCivilDawn::class.java.requestQuery(this)
fun Context.triggerSunriseEvent() = EventSunrise::class.java.requestQuery(this)
fun Context.triggerSunsetEvent() = EventSunset::class.java.requestQuery(this)
fun Context.triggerCivilDuskEvent() = EventCivilDusk::class.java.requestQuery(this)
fun Context.triggerNauticalDuskEvent() = EventNauticalDusk::class.java.requestQuery(this)
fun Context.triggerAstronomicalDuskEvent() = EventAstronomicalDusk::class.java.requestQuery(this)
fun Context.triggerAngle35Event() = EventAngle35::class.java.requestQuery(this)
fun Context.triggerAngle40Event() = EventAngle40::class.java.requestQuery(this)
fun Context.triggerAngle60Event() = EventAngle60::class.java.requestQuery(this)
fun Context.triggerAngle65Event() = EventAngle65::class.java.requestQuery(this)
fun Context.triggerAngle70Event() = EventAngle70::class.java.requestQuery(this)
fun Context.triggerAngle75Event() = EventAngle75::class.java.requestQuery(this)
