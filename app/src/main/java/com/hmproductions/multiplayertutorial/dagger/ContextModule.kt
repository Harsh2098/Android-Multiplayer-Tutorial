package com.hmproductions.multiplayertutorial.dagger

import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class ContextModule(private val context: Context) {

    @Provides
    @TutorialApplicationScope
    fun context() = context
}
