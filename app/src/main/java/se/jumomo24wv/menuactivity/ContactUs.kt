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
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(24.dp)
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileCard(name: String, description: String, email: String, instagramId: String) {
    val context = LocalContext.current
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                imageVector = Icons.Default.Person,
                contentDescription = "$name's Profile Picture",
                modifier = Modifier
                    .size(100.dp)
                    .padding(bottom = 8.dp)
            )
            Text(
                text = name,
                style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = description,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(horizontal = 8.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
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
                    icon = R.drawable.ic_instagram, // Assumes you have an instagram icon in res/drawable
                    contentDescription = "Visit $name's Instagram"
                ) {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://instagram.com/_u/$instagramId"))
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
                modifier = Modifier.size(28.dp),
                tint = tintColor
            )
            is Int -> Image(
                painter = painterResource(id = icon), 
                contentDescription = contentDescription, 
                modifier = Modifier.size(28.dp),
                colorFilter = ColorFilter.tint(tintColor)
            )
        }
    }
}
