package me.amanjeet.stressapp

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class NativeAllocationReceiver: BroadcastReceiver() {

    private external fun allocateMemory(numberOfObjects: Int)

    companion object {
        private const val KEY_NUMBER_OF_OBJECTS = "NUMBER_OF_OBJECTS"
    }

    override fun onReceive(context: Context, intent: Intent) {
        val numberOfObjects = intent.extras?.getInt(KEY_NUMBER_OF_OBJECTS)
        allocateMemory(numberOfObjects ?: 0)
    }

}