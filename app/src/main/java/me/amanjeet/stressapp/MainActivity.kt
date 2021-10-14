package me.amanjeet.stressapp

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import me.amanjeet.stressapp.NativeAllocationReceiver.Companion.ALLOCATION_SIZE
import me.amanjeet.stressapp.NativeAllocationReceiver.Companion.UPDATE_TEXT_INTENT_ACTION

class MainActivity : AppCompatActivity() {

    private val allocationSizeTextView by lazy { findViewById<TextView>(R.id.totalSizeAllocation) }

    private val updateReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            if (allocationSizeTextView != null) {
                allocationSizeTextView.text = intent.getStringExtra(ALLOCATION_SIZE)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        allocationSizeTextView.text = getString(R.string.instruction)
        val intentFilter = IntentFilter()
        intentFilter.addAction(UPDATE_TEXT_INTENT_ACTION)
        registerReceiver(updateReceiver, intentFilter)
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(updateReceiver)
    }
}