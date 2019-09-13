package dev.poteto.app.compoundview.views

import android.content.res.TypedArray

interface CompoundView {

    fun inflateView()

    fun initAttributes(attrs: TypedArray?)

}