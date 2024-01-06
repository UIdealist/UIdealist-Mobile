package com.helper.idealist.services

import android.content.Context
import android.content.pm.PackageManager
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat

open class Service(
        protected val context : Context
    ) {

    protected data class Permission(
        val name: String,
        var granted: Boolean
    )

    protected open val permissions = arrayOf<String>()

    private val permissionsObjs = arrayOf<Permission>()

    protected open val allPermissionsGranted
        get() = permissionsObjs.all { it.granted }

    @Composable
    open fun initService() {
        permissions.forEach {
            permissionsObjs.plus(
                Permission(
                    name = it,
                    granted = false
                )
            )
        }
    }

    @Composable
    protected fun checkPermissions(
        onPermissionsGranted: () -> Unit
    ) {

        @Composable
        fun requestPermission (permission : Permission) {
            val launcher = rememberLauncherForActivityResult(
                ActivityResultContracts.RequestPermission()
            ) { isGranted: Boolean ->
                permission.granted = isGranted

                if (allPermissionsGranted) {
                    onPermissionsGranted()
                }
            }
            launcher.launch(permission.name)
        }

        val context = LocalContext.current
        permissionsObjs.forEach {
            when (PackageManager.PERMISSION_GRANTED) {
                ContextCompat.checkSelfPermission(
                    context, it.name
                ) -> {
                    it.granted = true
                }
                else -> {
                    it.granted = false
                    requestPermission(permission = it)
                }
            }
        }
    }
}