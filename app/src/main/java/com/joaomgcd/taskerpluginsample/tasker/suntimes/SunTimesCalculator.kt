package com.joaomgcd.taskerpluginsample.tasker.suntimes

import java.time.LocalDate
import java.time.ZoneId
import java.time.ZonedDateTime
import kotlin.math.*

object SunTimesCalculator {
    private fun calculateEvent(
        date: LocalDate,
        lat: Double,
        lon: Double,
        zenith: Double,
        isSunrise: Boolean,
        zone: ZoneId
    ): ZonedDateTime? {
        val N = date.dayOfYear
        val lngHour = lon / 15.0
        val t = N + ((if (isSunrise) 6 else 18) - lngHour) / 24.0
        var M = (0.9856 * t) - 3.289
        var L = M + (1.916 * sin(Math.toRadians(M))) + (0.020 * sin(Math.toRadians(2 * M))) + 282.634
        L = (L + 360) % 360
        var RA = Math.toDegrees(atan(0.91764 * tan(Math.toRadians(L))))
        RA = (RA + 360) % 360
        val Lquadrant = floor(L / 90.0) * 90.0
        val RAquadrant = floor(RA / 90.0) * 90.0
        RA += Lquadrant - RAquadrant
        RA /= 15.0
        val sinDec = 0.39782 * sin(Math.toRadians(L))
        val cosDec = cos(asin(sinDec))
        val cosH = (cos(Math.toRadians(zenith)) - (sinDec * sin(Math.toRadians(lat)))) /
            (cosDec * cos(Math.toRadians(lat)))
        if (cosH > 1 || cosH < -1) return null
        var H = if (isSunrise) 360 - Math.toDegrees(acos(cosH)) else Math.toDegrees(acos(cosH))
        H /= 15.0
        val T = H + RA - (0.06571 * t) - 6.622
        var UT = T - lngHour
        UT = (UT + 24) % 24
        val seconds = (UT * 3600).toLong()
        val utc = date.atStartOfDay(ZoneId.of("UTC")).plusSeconds(seconds)
        return utc.withZoneSameInstant(zone)
    }

    fun calculate(date: LocalDate, lat: Double, lon: Double, zone: ZoneId) = SunTimes(
        sunrise = calculateEvent(date, lat, lon, 90.833, true, zone),
        sunset = calculateEvent(date, lat, lon, 90.833, false, zone),
        civilDawn = calculateEvent(date, lat, lon, 96.0, true, zone),
        civilDusk = calculateEvent(date, lat, lon, 96.0, false, zone),
        nauticalDawn = calculateEvent(date, lat, lon, 102.0, true, zone),
        nauticalDusk = calculateEvent(date, lat, lon, 102.0, false, zone),
        astronomicalDawn = calculateEvent(date, lat, lon, 108.0, true, zone),
        astronomicalDusk = calculateEvent(date, lat, lon, 108.0, false, zone)
    )
}

data class SunTimes(
    val sunrise: ZonedDateTime?,
    val sunset: ZonedDateTime?,
    val civilDawn: ZonedDateTime?,
    val civilDusk: ZonedDateTime?,
    val nauticalDawn: ZonedDateTime?,
    val nauticalDusk: ZonedDateTime?,
    val astronomicalDawn: ZonedDateTime?,
    val astronomicalDusk: ZonedDateTime?
)
