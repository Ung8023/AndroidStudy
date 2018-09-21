package com.ung8023.material

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.support.design.widget.TextInputLayout
import android.util.AttributeSet

class NoLabelTextInputLayout : TextInputLayout {
    constructor(context: Context): super(context)

    constructor(context: Context, attributeSet: AttributeSet): super(context, attributeSet)

    constructor(context: Context, attributeSet: AttributeSet, defAttrRes: Int): super(context, attributeSet, defAttrRes)

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        isHintEnabled = true
        super.onLayout(changed, left, top, right, bottom)
        isHintEnabled = false
    }

    override fun draw(canvas: Canvas?) {
        isHintEnabled = true
        super.draw(canvas)
        isHintEnabled = false
    }
}