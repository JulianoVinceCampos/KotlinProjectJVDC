package br.com.jvdc.utils

import platform.Foundation.NSNumber
import platform.Foundation.NSNumberFormatter

actual fun Double.formatRating(): String {
    val formatter = NSNumberFormatter()
    formatter.minimumFractionDigits = 1u
    formatter.maximumFractionDigits = 1u
    formatter.numberStyle = 1u
    return formatter.stringFromNumber(NSNumber(this)) ?: ""
}