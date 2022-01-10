package moe.peanutmelonseedbigalmond.aliothhavocospatch

import android.content.res.Resources
import de.robv.android.xposed.IXposedHookLoadPackage
import de.robv.android.xposed.IXposedHookZygoteInit
import de.robv.android.xposed.callbacks.XC_LoadPackage
import android.content.res.XResources;
import android.util.TypedValue
import moe.peanutmelonseedbigalmond.aliothhavocospatch.utils.Utils
import moe.peanutmelonseedbigalmond.aliothhavocospatch.utils.hookBeforeMethod

class MainHook : IXposedHookLoadPackage{
    private val targetApplication = "com.android.systemui"
    override fun handleLoadPackage(lpparam: XC_LoadPackage.LoadPackageParam) {
        if (lpparam.packageName != targetApplication) return

        val classLoader = lpparam.classLoader
        "com.android.systemui.statusbar.phone.Ticker".hookBeforeMethod(
            "setAppIconColor",
            "android.graphics.drawable.Drawable",
            classLoader = classLoader,
        ) {
            if (it.args[0] == null) {
                it.result = null // 返回值为void
            }
        }
    }
}