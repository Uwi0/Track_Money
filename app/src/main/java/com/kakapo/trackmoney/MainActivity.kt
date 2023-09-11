package com.kakapo.trackmoney

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.kakapo.designsystem.theme.AppTheme
import com.kakapo.trackmoney.ui.TrackMoneyApp
import com.kakapo.transaction.transaction.navigation.TRANSACTION_ROUTE
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                TrackMoneyApp(startDestination = TRANSACTION_ROUTE)
            }
        }
    }
}
