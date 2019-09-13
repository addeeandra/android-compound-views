package dev.poteto.app.compoundview.views

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import dev.poteto.app.compoundview.R
import kotlinx.android.synthetic.main.view_greeting.view.*

class GreetingView(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr), CompoundView {

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)

    constructor(context: Context) : this(context, null, 0)

    init {
        inflateView()
        initAttributes(context.obtainStyledAttributes(attrs, R.styleable.GreetingView))
    }

    override fun inflateView() {
        LayoutInflater.from(context).inflate(R.layout.view_greeting, this)
    }

    override fun initAttributes(attrs: TypedArray?) {
        attrs?.let { attr ->
            tv_greeting_hello.text = attr.getText(R.styleable.GreetingView_greet_text)
            tv_greeting_name.text = attr.getText(R.styleable.GreetingView_greet_name)
            tv_greeting_explore.text = attr.getText(R.styleable.GreetingView_greet_challenges)
            iv_greeting_background.setImageResource(
                attr.getResourceId(
                    R.styleable.GreetingView_greet_background,
                    R.drawable.img_dummy_2
                )
            )
        }
    }

}