package me.amanjeet.stressapp

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Bundle

class NativeAllocationReceiver: BroadcastReceiver() {

    private external fun allocateMemory(numberOfObjects: Int): Int

    companion object {
        private const val KEY_NUMBER_OF_OBJECTS = "NUMBER_OF_OBJECTS"
        internal const val ALLOCATION_SIZE = "ALLOCATION_SIZE"
        internal const val UPDATE_TEXT_INTENT_ACTION = "me.amanjeet.stressapp.UPDATE_TEXT"
    }

    override fun onReceive(context: Context, intent: Intent) {
        val numberOfObjects = intent.extras?.getInt(KEY_NUMBER_OF_OBJECTS)
        val sizeOfAllocationInBytes = allocateMemory(numberOfObjects ?: 0)
        val broadcastIntent = Intent().apply {
            action = UPDATE_TEXT_INTENT_ACTION
            putExtra(ALLOCATION_SIZE, "$sizeOfAllocationInBytes Bytes of allocation")
        }
        context.sendBroadcast(broadcastIntent)
    }
}