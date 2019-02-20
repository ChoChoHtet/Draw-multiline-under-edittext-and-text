package com.android.paintcode

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.text.Layout
import android.view.Gravity
import android.widget.EditText

class LineEdittext(context: Context) : EditText(context) {
    private val paint = Paint()
    var startY = 0f
    val rect = Rect()
    override fun onDraw(canvas: Canvas) {
        /**
         * for edit text
         */
        minLines=15
        paint.color = Color.BLACK
        paint.style=Paint.Style.FILL_AND_STROKE
        paint.strokeWidth = 3f
        //canvas.drawRGB(200, 235, 100)
        val width = width
        val height = height
        val lineHeight = lineHeight

        var totalCount = height / lineHeight
        if (lineCount > totalCount)
            totalCount = lineCount
        setBackgroundColor(resources.getColor(R.color.transparent))
        var baseLine = getLineBounds(0, rect)//first line


        for (i in 1 until totalCount){
            canvas.drawLine((rect.left).toFloat(), (baseLine + 10).toFloat(), (rect.right).toFloat(), (baseLine + 10).toFloat(), paint)
            baseLine+=lineHeight+20
        }
        /**
         * note pad
         */
        /*//horizontal line (0f,50f),(width,50f)
        for (i in 1 until 25){
            canvas.drawLine(0f, startY + 50, width.toFloat(), startY + 50, paint)
            startY+=70
        }
        //vertical line
         canvas.drawLine(80f, 0f, 80f, height.toFloat(), paint)
         paint.strokeWidth = 4f
         */


        super.onDraw(canvas)
    }

}