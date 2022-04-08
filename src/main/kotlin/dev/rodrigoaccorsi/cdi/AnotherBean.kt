package dev.rodrigoaccorsi.cdi

import java.lang.annotation.Documented
import javax.inject.Qualifier
import kotlin.annotation.AnnotationRetention.RUNTIME
import kotlin.annotation.AnnotationTarget.*

@Qualifier
@Documented
@Retention(RUNTIME)
@Target(FIELD, VALUE_PARAMETER, TYPE, CLASS)
annotation class AnotherBean()
