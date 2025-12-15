package se.jumomo24wv.menuactivity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import se.jumomo24wv.menuactivity.ui.theme.MenuActivityTheme

class ContactUs : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MenuActivityTheme {
                ContactUsScreen()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContactUsScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Contact Us") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(PADDING_SCREEN.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(SPACING_LARGE.dp)
        ) {
            item {
                ProfileCard(
                    name = "Mohamed Lutfi Mohamed",
                    description = "Lead Developer with a passion for creating beautiful and functional Android apps. Focused on UI/UX and app performance.",
                    email = "Mohamelotfii@gmail.com",
                    instagramId = "mohamed_lutfe"
                )
            }
            item {
                ProfileCard(
                    name = "Zakaria Diab",
                    description = "Backend Developer ensuring robust and scalable server-side logic. Expert in database management and API integration.",
                    email = "Zkariadiab308@gmail.com",
                    instagramId = "zkaria_7"
                )
            }
        }
    }
}

@Composable
fun ProfileCard(name: String, description: String, email: String, instagramId: String) {
    val context = LocalContext.current

    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = CARD_ELEVATION.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
    ) {
        Column(
            modifier = Modifier.padding(PADDING_CARD.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                imageVector = Icons.Default.Person,
                contentDescription = "$name's Profile Picture",
                modifier = Modifier
                    .size(PROFILE_IMAGE_SIZE.dp)
                    .padding(bottom = PADDING_SMALL.dp)
            )

            Text(
                text = name,
                style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold)
            )

            Spacer(modifier = Modifier.height(PADDING_SMALL.dp))

            Text(
                text = description,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(horizontal = PADDING_SMALL.dp)
            )

            Spacer(modifier = Modifier.height(PADDING_CARD.dp))

            Row(
                horizontalArrangement = Arrangement.spacedBy(PADDING_CARD.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                ContactIcon(
                    icon = Icons.Default.Email,
                    contentDescription = "Send an email to $name"
                ) {
                    val intent = Intent(Intent.ACTION_SENDTO).apply {
                        data = Uri.parse("mailto:$email")
                    }
                    context.startActivity(intent)
                }

                ContactIcon(
                    icon = R.drawable.ic_instagram,
                    contentDescription = "Visit $name's Instagram"
                ) {
                    val intent = Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("http://instagram.com/_u/$instagramId")
                    )
                    context.startActivity(intent)
                }
            }
        }
    }
}

@Composable
fun ContactIcon(icon: Any, contentDescription: String, onClick: () -> Unit) {
    val tintColor = MaterialTheme.colorScheme.onSurfaceVariant

    IconButton(onClick = onClick) {
        when (icon) {
            is ImageVector -> Icon(
                imageVector = icon,
                contentDescription = contentDescription,
                modifier = Modifier.size(ICON_SIZE.dp),
                tint = tintColor
            )

            is Int -> Image(
                painter = painterResource(id = icon),
                contentDescription = contentDescription,
                modifier = Modifier.size(ICON_SIZE.dp),
                colorFilter = ColorFilter.tint(tintColor)
            )
        }
    }
}

/* -------- Constants (only numbers) -------- */

private const val PADDING_SCREEN = 16
private const val PADDING_CARD = 16
private const val PADDING_SMALL = 8
private const val SPACING_LARGE = 24

private const val PROFILE_IMAGE_SIZE = 100
private const val ICON_SIZE = 28
private const val CARD_ELEVATION = 4
