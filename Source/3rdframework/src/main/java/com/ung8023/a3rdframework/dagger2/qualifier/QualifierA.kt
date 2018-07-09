package com.ung8023.a3rdframework.dagger2.qualifier

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class QualifierA(val name: String = "")