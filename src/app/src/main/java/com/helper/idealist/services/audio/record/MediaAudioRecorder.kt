package com.helper.idealist.services.audio.record

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import android.media.AudioFormat
import android.media.AudioRecord
import android.media.MediaRecorder
import androidx.compose.runtime.Composable
import androidx.core.app.ActivityCompat
import com.helper.idealist.services.Service

class MediaAudioRecorder(
    context : Context,
    private val sampleRate: Int = 44100,
    private val channelConfig : Int = AudioFormat.CHANNEL_IN_MONO,
    private val audioFormat : Int = AudioFormat.ENCODING_PCM_16BIT
) : Service(context) {

    private var recorder : AudioRecord? = null

    override val permissions = arrayOf(
        Manifest.permission.RECORD_AUDIO
    )

    @Composable
    override fun initService() {
        super.initService()

        fun onPermissionsGranted() {
            // Permissions should be granted already
            try {
                recorder = AudioRecord(
                    MediaRecorder.AudioSource.MIC,
                    sampleRate,
                    channelConfig,
                    audioFormat,
                    AudioRecord.getMinBufferSize(
                        sampleRate,
                        channelConfig,
                        audioFormat
                    )
                )
            } catch (e: SecurityException) {
                e.printStackTrace()
            } catch (e: IllegalArgumentException) {
                e.printStackTrace()
            }

        }

        checkPermissions {
            onPermissionsGranted()
        }
    }

    fun startRecording() {
        recorder?.startRecording()
    }

    fun stopRecording() {
        recorder?.stop()
    }

    fun release() {
        recorder?.release()
    }

    fun getRecorder() : AudioRecord? {
        return recorder
    }

    fun getAudioData() : ByteArray {
        val audioData = ByteArray(44100)
        recorder?.read(audioData, 0, audioData.size)
        return audioData
    }

}