package me.amanjeet.stressapp

import android.app.Application
import android.util.Log
import tart.AppLaunch
import tart.PreLaunchState

class MyApp : Application() {

    init {
        System.loadLibrary("stress")
    }

    override fun onCreate() {
        super.onCreate()
        AppLaunch.onAppLaunchListeners += { appLaunch ->
            val startType = when (appLaunch.preLaunchState) {
                PreLaunchState.NO_PROCESS -> "cold start"
                PreLaunchState.NO_PROCESS_FIRST_LAUNCH_AFTER_INSTALL -> "cold start"
                PreLaunchState.NO_PROCESS_FIRST_LAUNCH_AFTER_UPGRADE -> "cold start"
                PreLaunchState.PROCESS_WAS_LAUNCHING_IN_BACKGROUND -> "warm start"
                PreLaunchState.NO_ACTIVITY_NO_SAVED_STATE -> "warm start"
                PreLaunchState.NO_ACTIVITY_BUT_SAVED_STATE -> "warm start"
                PreLaunchState.ACTIVITY_WAS_STOPPED -> "hot start"
            }
            val durationMillis = appLaunch.duration.uptimeMillis
            Log.d("MyApp", "$startType launch: $durationMillis ms")
        }
    }

    override fun onTrimMemory(level: Int) {
        super.onTrimMemory(level)
        when (level) {
            TRIM_MEMORY_BACKGROUND -> {
                Log.d("MyApp", "Memory Level $level")
            }
            TRIM_MEMORY_COMPLETE -> {
                Log.d("MyApp", "Memory Level $level")
            }
            TRIM_MEMORY_MODERATE -> {
                Log.d("MyApp", "Memory Level $level")
            }
            TRIM_MEMORY_RUNNING_CRITICAL -> {
                Log.d("MyApp", "Memory Level $level")
            }
            TRIM_MEMORY_RUNNING_LOW -> {
                Log.d("MyApp", "Memory Level $level")
            }
            TRIM_MEMORY_RUNNING_MODERATE -> {
                Log.d("MyApp", "Memory Level $level")
            }
            TRIM_MEMORY_UI_HIDDEN -> {
                Log.d("MyApp", "Memory Level $level")
            }
        }
    }
}