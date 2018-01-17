package com.teng.zhihu.ui

import android.animation.Animator
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.FragmentActivity
import android.view.View
import com.teng.zhihu.R
import kotlinx.android.synthetic.main.activity_splash.*
import java.util.*

class SplashActivity : FragmentActivity() {

    private var splashArray : IntArray = intArrayOf(
            R.drawable.splash0,
            R.drawable.splash1,
            R.drawable.splash2,
            R.drawable.splash3,
            R.drawable.splash4,
            R.drawable.splash5,
            R.drawable.splash6,
            R.drawable.splash7,
            R.drawable.splash8,
            R.drawable.splash9,
            R.drawable.splash10,
            R.drawable.splash11,
            R.drawable.splash12,
            R.drawable.splash13,
            R.drawable.splash14,
            R.drawable.splash15,
            R.drawable.splash16
    )

    private val animatorDuration : Long = 2000
    private val scaleEnd : Float = 1.13f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        mSplashImage.setImageResource(splashArray[Random().nextInt(splashArray.size - 1)])
        animateImage()
    }

    private fun animateImage(){
        val animatorX : ObjectAnimator = ObjectAnimator.ofFloat(mSplashImage, View.SCALE_X, scaleEnd)
        val animatorY : ObjectAnimator = ObjectAnimator.ofFloat(mSplashImage, View.SCALE_Y, scaleEnd)

        val set = AnimatorSet()
        set.setDuration(animatorDuration).play(animatorX).with(animatorY)
        set.start()

        set.addListener(object : Animator.AnimatorListener{
            override fun onAnimationEnd(animator: Animator) {
                go2MainActivity()
            }

            override fun onAnimationRepeat(p0: Animator?) {
                TODO("not implemented")
            }

            override fun onAnimationStart(p0: Animator?) {
                TODO("not implemented")
            }

            override fun onAnimationCancel(p0: Animator?) {
                TODO("not implemented")
            }
        })
    }

    private fun go2MainActivity(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        this.finish()
    }

}
