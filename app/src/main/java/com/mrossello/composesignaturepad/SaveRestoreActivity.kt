package com.mrossello.composesignaturepad

import android.graphics.Bitmap
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.mrossello.compose_signature_library.BuildConfig
import com.mrossello.compose_signature_library.SignaturePadAdapter
import com.mrossello.compose_signature_library.SignaturePadView

class SaveRestoreActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {

                    var mutableBitmap: Bitmap? by remember { mutableStateOf(null) }
                    Column {

                        var signaturePadAdapter: SignaturePadAdapter? = null

                        Box(
                            modifier = Modifier
                                .height(200.dp)
                                .fillMaxWidth()
                                .border(
                                    width = 2.dp,
                                    color = Color.Red,
                                )
                        ) {

                            SignaturePadView(
                                onReady = {
                                    signaturePadAdapter = it
                                },
                                onStartSigning = {
                                    if (BuildConfig.DEBUG) {
                                        Log.d("ComposeActivity", "onStartSigning")
                                    }
                                },
                                onSigning = {
                                    if (BuildConfig.DEBUG) {
                                        Log.d("ComposeActivity", "onStartSigning")
                                    }
                                },
                                onSigned = {
                                    if (BuildConfig.DEBUG) {
                                        Log.d("ComposeActivity", "onSigned")
                                    }
                                },
                                onClear = {
                                    if (BuildConfig.DEBUG) {
                                        Log.d(
                                            "ComposeActivity",
                                            "onClear isEmpty:" + signaturePadAdapter?.isEmpty
                                        )
                                    }
                                },
                            )
                        }
                        Row {
                            Button(onClick = {
                                mutableBitmap = signaturePadAdapter?.getTransparentSignatureBitmap()
                                signaturePadAdapter?.clear()
                            }) {
                                Text("Save")
                            }

                            Button(onClick = {
                                mutableBitmap?.let { signaturePadAdapter?.setSignatureBitmap(it) }
                            }) {
                                Text("Restore")
                            }
                        }

                        Text(text = "Signature data: " + mutableBitmap)
                    }
                }
            }
        }
    }
}