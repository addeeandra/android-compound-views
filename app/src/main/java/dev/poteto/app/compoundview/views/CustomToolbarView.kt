package dev.poteto.app.compoundview.views

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.FrameLayout
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import dev.poteto.app.compoundview.R
import kotlinx.android.synthetic.main.view_toolbar_center.view.*

class CustomToolbarView(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr), CompoundView {

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)

    constructor(context: Context) : this(context, null, 0)

    companion object {
        private const val GRAVITY_LEFT = 0
        private const val GRAVITY_CENTER = 1
        private const val GRAVITY_RIGHT = 2
    }

    init {
        inflateView()
        initAttributes(context.obtainStyledAttributes(attrs, R.styleable.CustomToolbarView))
    }

    override fun inflateView() {
        LayoutInflater.from(context).inflate(R.layout.view_toolbar_center, this)
    }

    override fun initAttributes(attrs: TypedArray?) {
        val lParams = tv_toolbar_title.layoutParams as Toolbar.LayoutParams

        when (attrs?.getInt(R.styleable.CustomToolbarView_title_position, 1)) {
            GRAVITY_LEFT -> lParams.gravity = GravityCompat.START
            GRAVITY_CENTER -> lParams.gravity = Gravity.CENTER
            GRAVITY_RIGHT -> lParams.gravity = GravityCompat.END
            else -> {
            }
        }

        tv_toolbar_title.layoutParams = lParams
        tv_toolbar_title.text = attrs?.getText(R.styleable.CustomToolbarView_title)
    }

}