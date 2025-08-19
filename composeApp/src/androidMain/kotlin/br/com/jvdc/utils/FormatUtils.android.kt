package br.com.jvdc.utils

import java.util.Locale

actual fun Double.formatRating(): String =
    String.format(Locale.getDefault(), "%.1f", this)