package com.med.drawing.main.presentaion.tips

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import androidx.cardview.widget.CardView
import androidx.lifecycle.lifecycleScope
import com.med.drawing.R
import com.med.drawing.main.presentaion.get_started.GetStartedActivity
import com.med.drawing.databinding.ActivityTipsBinding
import com.med.drawing.util.AppAnimation
import com.med.drawing.util.LanguageChanger
import com.med.drawing.util.ads.InterManager
import com.med.drawing.util.ads.NativeManager
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * @author Ahmed Guedmioui
 */
@AndroidEntryPoint
class TipsActivity : AppCompatActivity() {

    private val tipsViewModel: TipsViewModel by viewModels()
    private lateinit var tipsState: TipsState

    private lateinit var binding: ActivityTipsBinding

    @Inject
    lateinit var prefs: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        val languageCode = prefs.getString("language", "en") ?: "en"
        LanguageChanger.changeAppLanguage(languageCode, this)
        binding = ActivityTipsBinding.inflate(layoutInflater)
        val view: View = binding.root
        setContentView(view)

        lifecycleScope.launch {
            tipsViewModel.tipsState.collect { tipsState = it }
        }

        NativeManager.loadNative(
            findViewById(R.id.native_frame),
            findViewById(R.id.native_temp),
            this, true
        )

        nextTip()
        binding.nextStart.setOnClickListener {
            tipsViewModel.onEvent(TipsUiEvent.NextTip)
            nextTip()
        }

    }

    private fun nextTip() {

        changeDotsColor()
        when (tipsState.tipNum) {
            1 -> {
                binding.tipTitle.text = getString(R.string.tip_title_1)
                binding.tipDesc.text = getString(R.string.tip_desc_1)
                binding.tipImage.setImageDrawable(
                    AppCompatResources.getDrawable(this, R.drawable.tip_image_1)
                )
                binding.nextStart.text = getString(R.string.next)
            }

            2 -> {
                AppAnimation().startLeftwardScaleAnimation(binding.tipParent)

                binding.tipTitle.text = getString(R.string.tip_title_2)
                binding.tipDesc.text = getString(R.string.tip_desc_2)
                binding.tipImage.setImageDrawable(
                    AppCompatResources.getDrawable(this, R.drawable.tip_image_2)
                )
                binding.nextStart.text = getString(R.string.next)
            }

            3 -> {
                AppAnimation().startLeftwardScaleAnimation(binding.tipParent)

                binding.tipTitle.text = getString(R.string.tip_title_3)
                binding.tipDesc.text = getString(R.string.tip_desc_3)
                binding.tipImage.setImageDrawable(
                    AppCompatResources.getDrawable(this, R.drawable.tip_image_3)
                )
                binding.nextStart.text = getString(R.string.next)
            }

            4 -> {
                AppAnimation().startLeftwardScaleAnimation(binding.tipParent)

                binding.tipTitle.text = getString(R.string.tip_title_4)
                binding.tipDesc.text = getString(R.string.tip_desc_4)
                binding.tipImage.setImageDrawable(
                    AppCompatResources.getDrawable(this, R.drawable.tip_image_4)
                )
                binding.nextStart.text = getString(R.string.start)
            }

            5 -> {

                InterManager.showInterstitial(this, object : InterManager.OnAdClosedListener {
                    override fun onAdClosed() {
                        prefs.edit().putBoolean("tipsShown", true).apply()
                        startActivity(Intent(this@TipsActivity, GetStartedActivity::class.java))
                        finish()
                    }
                })
            }
        }
    }

    private fun changeDotsColor() {

        findViewById<CardView>(R.id.dot_1).setCardBackgroundColor(getColor(R.color.primary_2))
        findViewById<CardView>(R.id.dot_2).setCardBackgroundColor(getColor(R.color.primary_2))
        findViewById<CardView>(R.id.dot_3).setCardBackgroundColor(getColor(R.color.primary_2))
        findViewById<CardView>(R.id.dot_4).setCardBackgroundColor(getColor(R.color.primary_2))

        when (tipsState.tipNum) {
            1 -> {
                findViewById<CardView>(R.id.dot_1).setCardBackgroundColor(getColor(R.color.primary_3))
            }

            2 -> {
                findViewById<CardView>(R.id.dot_2).setCardBackgroundColor(getColor(R.color.primary_3))
            }

            3 -> {
                findViewById<CardView>(R.id.dot_3).setCardBackgroundColor(getColor(R.color.primary_3))
            }

            4, 5 -> {
                findViewById<CardView>(R.id.dot_4).setCardBackgroundColor(getColor(R.color.primary_3))
            }
        }
    }
}















