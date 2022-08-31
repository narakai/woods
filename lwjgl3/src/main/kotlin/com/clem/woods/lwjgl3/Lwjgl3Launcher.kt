@file:JvmName("Lwjgl3Launcher")

package com.clem.woods.lwjgl3

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration
import com.clem.woods.Woods

/** Launches the desktop (LWJGL3) application. */
fun main() {
    Lwjgl3Application(Woods(), Lwjgl3ApplicationConfiguration().apply {
        setTitle("woods")
        setWindowedMode(640, 480)
        setWindowIcon(*(arrayOf(128, 64, 32, 16).map { "libgdx$it.png" }.toTypedArray()))
        useVsync(false)
    })
}
