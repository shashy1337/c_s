package com.example.carrotshop.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnticipateOvershootInterpolator
import android.view.animation.BounceInterpolator
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.example.carrotshop.R


class RocketAnimFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val buttonStart : Button = view.findViewById(R.id.buttonStartAnimation)
        val buttonReturnZero : Button = view.findViewById(R.id.buttonReturnToZeroAnimation)
        val rocket = view.findViewById<ImageView>(R.id.rocket)
        startRocketAnimation(buttonStart, rocket, buttonReturnZero)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_rocket_anim, container, false)
    }

    private fun startRocketAnimation
                (buttonStart : Button, rocket : ImageView, buttonReturnZero : Button){

        buttonStart.setOnClickListener {
            rocket.animate()
                .setDuration(5000)
                .setInterpolator(AnticipateOvershootInterpolator())
                .rotation(30f)
                .translationY(-1500f)
                .translationX(500f)
                .start()
        }
        buttonReturnZero.setOnClickListener {
            if (rocket.translationY != 0f){
                rocket.animate()
                    .setDuration(5000)
                    .setInterpolator(BounceInterpolator())
                    .rotation(0f)
                    .translationY(0f)
                    .translationX(0f)
                    .start()
            } else {
                rocket.translationY = 0f
            }

        }
    }


//    private fun animationUpdate(): Animator.AnimatorListener {
//
//        val animationUpdateCallback : Animator.AnimatorListener = object : Animator.AnimatorListener{
//            override fun onAnimationStart(p0: Animator?) {
//                Toast.makeText(context, "LetsStart!", Toast.LENGTH_SHORT)
//                    .show()
//            }
//
//            override fun onAnimationEnd(p0: Animator?) {
//                Toast.makeText(context, "AllLoaded!", Toast.LENGTH_SHORT)
//                    .show()
//            }
//
//            override fun onAnimationCancel(p0: Animator?) {
//                TODO("Not yet implemented")
//            }
//
//            override fun onAnimationRepeat(p0: Animator?) {
//                TODO("Not yet implemented")
//            }
//
//        }
//        return animationUpdateCallback
//    }

}

