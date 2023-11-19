package com.mrossello.compose_signature_library.views

interface SignedListener {
    fun onStartSigning()
    fun onSigning()
    fun onSigned()
    fun onClear()
}
