package com.example.cartapresentacion

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// 🎨 Colores cute
private val BgPink     = Color(0xFFFFE6EE) // rosa bonito de fondo
private val NameFuchsia= Color(0xFFFF1493) // fucsia fuerte para el nombre
private val SubtitleLav= Color(0xFF7E57C2) // morado para el subtítulo
private val IconPink    = Color(0xFFE91E63) // rosado para iconos
private val AvatarRing  = Color(0xFFFF9EC4) // aro del avatar

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { BusinessCardApp() }
    }
}

@Composable
fun BusinessCardApp() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = BgPink
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(Modifier.height(24.dp))
            NameSection()
            Spacer(Modifier.height(24.dp))
            ContactSection()
        }
    }
}

@Composable
fun NameSection() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        // 👇 Muestra tu imagen de drawable/ternurincarta.jpg en forma circular
        Image(
            painter = painterResource(id = R.drawable.ternurincarta),
            contentDescription = null,
            modifier = Modifier
                .size(110.dp)
                .clip(CircleShape)
                .border(3.dp, AvatarRing, CircleShape),
            contentScale = ContentScale.Crop
        )

        Spacer(Modifier.height(14.dp))

        Text(
            text = stringResource(R.string.full_name),
            fontSize = 40.sp,
            fontWeight = FontWeight.Black,
            color = NameFuchsia,
            textAlign = TextAlign.Center
        )

        Spacer(Modifier.height(6.dp))

        Text(
            text = stringResource(R.string.title),
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold,
            color = SubtitleLav,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun ContactSection() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ContactRow(Icons.Filled.Phone, stringResource(R.string.phone), "Teléfono")
        ContactRow(Icons.Filled.Share, stringResource(R.string.social), "Red social")
        ContactRow(Icons.Filled.Email, stringResource(R.string.email), "Correo")
    }
}

@Composable
private fun ContactRow(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    text: String,
    iconDesc: String
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(vertical = 6.dp)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = iconDesc,
            tint = IconPink,
            modifier = Modifier.size(22.dp)
        )
        Spacer(Modifier.width(12.dp))
        Text(text = text, fontSize = 16.sp, color = Color(0xFF2D2D2D))
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewBusinessCard() {
    BusinessCardApp()
}
