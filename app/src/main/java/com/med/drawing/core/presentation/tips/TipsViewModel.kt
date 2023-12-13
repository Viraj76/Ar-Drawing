package com.med.drawing.core.presentation.tips

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

/**
 * @author Android Devs Academy (Ahmed Guedmioui)
 */
@HiltViewModel
class TipsViewModel @Inject constructor() : ViewModel() {

    private val _tipsState = MutableStateFlow(TipsState())
    val tipsState = _tipsState.asStateFlow()


    fun onEvent(tipsUiEvent: TipsUiEvent) {
        when (tipsUiEvent) {
            TipsUiEvent.NextTip -> {
                _tipsState.update {
                    it.copy(tipNum = tipsState.value.tipNum + 1)
                }
            }
        }
    }
}


























