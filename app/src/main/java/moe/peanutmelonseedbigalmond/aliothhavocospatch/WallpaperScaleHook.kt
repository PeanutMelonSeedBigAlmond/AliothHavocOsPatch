package moe.peanutmelonseedbigalmond.aliothhavocospatch

import android.content.res.XModuleResources
import android.content.res.XResources
import android.os.Build
import androidx.annotation.RequiresApi
import de.robv.android.xposed.IXposedHookZygoteInit
import moe.peanutmelonseedbigalmond.aliothhavocospatch.utils.Utils

class WallpaperScaleHook : IXposedHookZygoteInit {
    @RequiresApi(Build.VERSION_CODES.Q)
    override fun initZygote(startupParam: IXposedHookZygoteInit.StartupParam) {
        res = XModuleResources.createInstance(startupParam.modulePath, null)
        kotlin.runCatching {
            XResources.setSystemWideReplacement(
                "android",
                "dimen",
                "config_wallpaperMaxScale",
                res.fwd(R.dimen.max_wallpaper_scale)
            )
        }.onSuccess {
            Utils.Log.i("替换系统资源成功：config_wallpaperMaxScale")
        }.onFailure {
            Utils.Log.e(it.toString())
        }
    }

    companion object {
        lateinit var res: XModuleResources
    }
}