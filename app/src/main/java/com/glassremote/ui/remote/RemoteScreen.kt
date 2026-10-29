package com.glassremote.ui.remote

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun RemoteScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF0C0E14))
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        // Top Header
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Living Room TV", color = Color.White, fontSize = 20.sp)
            IconButton(
                onClick = { /* ADB Power Toggle: input keyevent 26 */ },
                modifier = Modifier
                    .size(48.dp)
                    .background(Color(0xFF26181B), CircleShape)
            ) {
                Text("⏻", color = Color.Red, fontSize = 18.sp)
            }
        }

        // D-Pad Controller
        Box(
            modifier = Modifier
                .size(240.dp)
                .background(Color(0xFF1E2028), CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Button(
                onClick = { /* ADB input keyevent 19 (UP) */ },
                modifier = Modifier.align(Alignment.TopCenter).padding(top = 8.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
            ) { Text("▲", color = Color.LightGray) }

            Button(
                onClick = { /* ADB input keyevent 20 (DOWN) */ },
                modifier = Modifier.align(Alignment.BottomCenter).padding(bottom = 8.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
            ) { Text("▼", color = Color.LightGray) }

            Button(
                onClick = { /* ADB input keyevent 21 (LEFT) */ },
                modifier = Modifier.align(Alignment.CenterStart).padding(start = 8.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
            ) { Text("◀", color = Color.LightGray) }

            Button(
                onClick = { /* ADB input keyevent 22 (RIGHT) */ },
                modifier = Modifier.align(Alignment.CenterEnd).padding(end = 8.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
            ) { Text("▶", color = Color.LightGray) }

            Button(
                onClick = { /* ADB input keyevent 66 (OK) */ },
                modifier = Modifier
                    .size(80.dp)
                    .background(Color(0xFF2C2F3A), CircleShape),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
            ) { Text("OK", color = Color.White, fontSize = 16.sp) }
        }

        // Navigation Bar (Back / Home)
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(
                onClick = { /* ADB input keyevent 4 (BACK) */ },
                shape = RoundedCornerShape(20.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1E2028))
            ) { Text("Back", color = Color.White) }

            Button(
                onClick = { /* ADB input keyevent 3 (HOME) */ },
                shape = RoundedCornerShape(20.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1E2028))
            ) { Text("Home", color = Color.White) }
        }

        // App Launchers / Quick Actions
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(
                onClick = { /* Launch YouTube */ },
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1E2028))
            ) { Text("YouTube", color = Color.White) }

            Button(
                onClick = { /* Launch Stremio */ },
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1E2028))
            ) { Text("Stremio", color = Color.White) }
        }
    }
}
