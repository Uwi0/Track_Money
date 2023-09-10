package com.kakapo.ui

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.ui.tooling.preview.Preview

@Preview(
    showBackground = true,
    name = "phone",
    device = "spec:shape=Normal,width=360,height=724,unit=dp,dpi=480"
)
@Preview(
    showBackground = true,
    uiMode = UI_MODE_NIGHT_YES,
    name = "phone",
    device = "spec:shape=Normal,width=360,height=724,unit=dp,dpi=480"
)
annotation class DevicePreview
