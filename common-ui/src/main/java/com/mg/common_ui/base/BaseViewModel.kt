package com.mg.common_ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

abstract class BaseViewModel<VS : ViewState,
        VA : ViewAction,
        VE : ViewEvent>(initialState: VS) : ViewModel() {

    private val actions = Channel<VA>(Channel.UNLIMITED)

    private val _state = MutableStateFlow(initialState)
    val state: StateFlow<VS>
        get() = _state

    private val _events: Channel<VE> = Channel()
    val events = _events.receiveAsFlow()

    protected val currentState: VS
        get() = _state.value

    init {
        handleActions()
    }

    abstract suspend fun onActionReceived(action: VA)

    private fun handleActions() {
        viewModelScope.launch {
            actions.consumeAsFlow()
                .collect {
                    onActionReceived(it)
                }
        }
    }

    /**
     * Set new Ui State.
     */
    protected fun updateState(reduce: VS.() -> VS) {
        _state.update(reduce)
    }

    /**
     * Sends user actions to be processed by the view model.
     */
    fun sendAction(action: VA) {
        viewModelScope.launch { actions.send(action) }
    }

    /**
     * Sends one shot events. Useful for showing error messages or performing screen navigation.
     */
    protected fun sendEvent(event: VE) {
        viewModelScope.launch { _events.send(event) }
    }

    override fun onCleared() {
        super.onCleared()
        _events.close()
    }
}