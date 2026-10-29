package com.glassremote.data.playback

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow

data class TvMediaInfo(
    val title: String,
    val packageName: String,
    val isPlaying: Boolean
)

class TvPlaybackWatcher(private val executeAdb: suspend (String) -> String) {

    fun pollPlayback() = flow {
        while (true) {
            val dumpsys = executeAdb("dumpsys media_session")
            val mediaInfo = parseDumpsys(dumpsys)
            emit(mediaInfo)
            delay(2500)
        }
    }

    private fun parseDumpsys(output: String): TvMediaInfo {
        val isPlaying = output.contains("state=PlaybackState {state=3")
        val pkg = Regex("package=([a-zA-Z0-9_.]+)").find(output)?.groupValues?.get(1) ?: "TV App"
        val desc = Regex("description=(.*?)(?:, playbackState|\\n)").find(output)?.groupValues?.get(1) ?: "Media on TV"
        return TvMediaInfo(title = desc, packageName = pkg, isPlaying = isPlaying)
    }
}
