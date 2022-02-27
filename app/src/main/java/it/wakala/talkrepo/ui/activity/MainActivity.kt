package it.wakala.talkrepo.ui.activity

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import it.wakala.talkrepo.base.ABaseActivity

class MainActivity : ABaseActivity() {

    @Preview
    @Composable
    override fun BuildLayout() {
        return Text("Wakala dev")
    }

}