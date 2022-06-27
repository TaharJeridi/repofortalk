package it.wakala.talkrepo.ui.widget.viewgroup

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Path
import android.graphics.RectF
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import it.wakala.talkrepo.R

@SuppressLint("Recycle")
class RoundedCornerLayout @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private var path: Path? = null

    private var bottomStartRadius = 0F
    private var bottomEndRadius = 0F
    private var topStartRadius = 0F
    private var topEndRadius = 0F

    init {
        attrs?.let {
            val typedArray = context.obtainStyledAttributes(it, R.styleable.RoundedCornerLayout)
            val radius = typedArray.getDimension(R.styleable.RoundedCornerLayout_radius, 0F)

            if (radius > 0) {
                bottomStartRadius = radius
                bottomEndRadius = radius
                topStartRadius = radius
                topEndRadius = radius
            } else {
                bottomStartRadius = typedArray.getDimension(
                    R.styleable.RoundedCornerLayout_bottomStartRadius,
                    0F
                )
                bottomEndRadius = typedArray.getDimension(
                    R.styleable.RoundedCornerLayout_bottomEndRadius,
                    0F
                )
                topStartRadius = typedArray.getDimension(
                    R.styleable.RoundedCornerLayout_topStartRadius,
                    0F
                )
                topEndRadius = typedArray.getDimension(
                    R.styleable.RoundedCornerLayout_topEndRadius,
                    0F
                )
            }

            typedArray.recycle()
        }
        setWillNotDraw(false)
    }

    /*
     * Lyfecycle method
     */

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        val withF = w * 1F
        val heightF = h * 1F
        val rectF = RectF(0F, 0F, withF, heightF)
        path = Path()
        val roundRadius = FloatArray(8)
        roundRadius[1] = topStartRadius
        roundRadius[0] = roundRadius[1]
        roundRadius[3] = topEndRadius
        roundRadius[2] = roundRadius[3]
        roundRadius[5] = bottomEndRadius
        roundRadius[4] = roundRadius[5]
        roundRadius[7] = bottomStartRadius
        roundRadius[6] = roundRadius[7]
        path?.addRoundRect(rectF, roundRadius, Path.Direction.CW)
        path?.close()
    }

    override fun draw(canvas: Canvas?) {
        canvas?.save()
        path?.let {
            canvas?.clipPath(it)
        }
        super.draw(canvas)
        canvas?.restore()
    }


}