package dev.poteto.app.compoundview.views

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.FrameLayout
import dev.poteto.app.compoundview.R
import kotlinx.android.synthetic.main.view_poster.view.*

class PosterView(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr), CompoundView {

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)

    constructor(context: Context) : this(context, null, 0)

    init {
        inflateView()
        initAttributes(context.obtainStyledAttributes(attrs, R.styleable.PosterView))
    }

    override fun inflateView() {
        LayoutInflater.from(context).inflate(R.layout.view_poster, this)
    }

    // check if attributes available or not
    override fun initAttributes(attrs: TypedArray?) {
        attrs?.getDrawable(R.styleable.PosterView_src)?.let { iv_poster_image.setImageDrawable(it) }
        attrs?.getText(R.styleable.PosterView_title)?.let { tv_poster_title.text = it }
        attrs?.getText(R.styleable.PosterView_subtitle)?.let { tv_poster_subtitle.text = it }
        attrs?.getText(R.styleable.PosterView_content)?.let { tv_poster_description.text = it }

        val containerLayoutParams = ll_poster_container.layoutParams
        val imageLayoutParams = iv_poster_image.layoutParams

        when (attrs?.getInt(R.styleable.PosterView_size, 0)) {
            0 -> {
                containerLayoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT
                imageLayoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT
            }
            1 -> {
                containerLayoutParams.width =
                    context.resources.getDimension(R.dimen.poster_land_width).toInt()

                imageLayoutParams.width =
                    context.resources.getDimension(R.dimen.poster_land_width).toInt()

                imageLayoutParams.height =
                    context.resources.getDimension(R.dimen.poster_land_height).toInt()
            }
            2 -> {
                containerLayoutParams.width =
                    context.resources.getDimension(R.dimen.poster_port_width).toInt()

                imageLayoutParams.width =
                    context.resources.getDimension(R.dimen.poster_port_width).toInt()

                imageLayoutParams.height =
                    context.resources.getDimension(R.dimen.poster_port_height).toInt()
            }
            else -> {
            }
        }

        ll_poster_container.layoutParams = containerLayoutParams
        iv_poster_image.layoutParams = imageLayoutParams
    }

}