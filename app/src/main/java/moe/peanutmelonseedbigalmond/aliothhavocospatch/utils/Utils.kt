package moe.peanutmelonseedbigalmond.aliothhavocospatch.utils

import android.content.Context
import android.widget.Toast
import de.robv.android.xposed.XposedBridge

object Utils {
    object Log {
        fun i(msg: String) {
            XposedBridge.log("[AliothHavocOsPatch] [INFO]: $msg")
        }

        fun e(msg: String){
            XposedBridge.log("[AliothHavocOsPatch] [ERROR]: $msg")
        }
    }

    object Tip {
        fun show(context: Context, msg: String) {
            Toast.makeText(context, "[AliothHavocOsPatch]: $msg", Toast.LENGTH_SHORT).show()
        }
    }
}