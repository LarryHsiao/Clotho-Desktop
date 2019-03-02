package com.silverhetch.clotho.desktop.exectable

import java.awt.Desktop
import java.io.File
import java.io.IOException
import java.net.URI

/**
 * Launch with given file with platform default application.
 */
class FileExecutable(private val uri: String) : CExecutable {
    override fun launch(callback: CExecutable.Callback) {
        if (Desktop.isDesktopSupported()) {
            Thread {
                try {
                    File(URI.create(uri)).also { target ->
                        if (target.isDirectory && target.listFiles().size == 1) {
                            Desktop.getDesktop().open(target.listFiles()[0])
                        } else {
                            Desktop.getDesktop().open(target)
                        }
                    }
                } catch (e: IOException) {
                    callback.onFailed()
                }
            }.start()
        }
    }
}