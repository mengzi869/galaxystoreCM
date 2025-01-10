package com.clean888.cleansuper.cleaner.ui.lifecycle

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.view.View
import android.view.animation.LinearInterpolator
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import kotlin.Lazy
import kotlin.LazyThreadSafetyMode.NONE
import kotlin.jvm.functions.Function0

class BAGG(private val target: View, lifecycle: Lifecycle?) : LifecycleEventObserver {

    private val mAnimator: Lazy<AnimatorSet> = lazy(NONE) { createSceneBreathingAnimation(target) }

    init {
        lifecycle?.addObserver(this)
    }

    private fun createSceneBreathingAnimation(view: View): AnimatorSet {
        val scaleXAnimator = ObjectAnimator.ofFloat(view, "scaleX", 1.0f, 0.8f, 1.0f).apply {
            repeatMode = ObjectAnimator.REVERSE
            repeatCount = ObjectAnimator.INFINITE
        }

        val scaleYAnimator = ObjectAnimator.ofFloat(view, "scaleY", 1.0f, 0.8f, 1.0f).apply {
            repeatMode = ObjectAnimator.REVERSE
            repeatCount = ObjectAnimator.INFINITE
        }

        return AnimatorSet().apply {
            duration = 1000L
            interpolator = LinearInterpolator()
            playTogether(scaleXAnimator, scaleYAnimator)
        }
    }

    private val mAnimatorInstance: AnimatorSet
        get() = mAnimator.value

    fun onDestroy() {
        mAnimatorInstance.removeAllListeners()
        mAnimatorInstance.cancel()
    }

    fun onPause() {
        mAnimatorInstance.pause()
    }

    fun onResume() {
        mAnimatorInstance.resume()
    }

    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
        when (event) {
            Lifecycle.Event.ON_DESTROY -> {
                source.lifecycle.removeObserver(this)
                onDestroy()
            }
            Lifecycle.Event.ON_RESUME -> onResume()
            Lifecycle.Event.ON_PAUSE -> onPause()
            else -> {}
        }
    }

    fun start() {
        mAnimatorInstance.start()
    }
}