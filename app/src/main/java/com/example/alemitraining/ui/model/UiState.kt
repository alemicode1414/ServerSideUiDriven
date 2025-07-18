package com.example.alemitraining.ui.model

sealed interface UiState<out T> {
    data object Loading : UiState<Nothing>
    class Success<T>(val data: T) : UiState<T>
    class Failure(val panjereException: Throwable) : UiState<Nothing>

    fun getErrorMessage(): String? {
        return (this as? Failure)?.panjereException?.message
    }

    fun getDataOrNull(): T? = (this as? Success)?.data
}

inline fun <T> UiState<T>?.doOnSuccess(func: (T) -> Unit): UiState<T>? {
    if (this is UiState.Success<T>) {
        func.invoke(data)
    }
    return this
}

inline fun UiState<*>?.doOnError(func: (Throwable) -> Unit): UiState<*>? {
    if (this is UiState.Failure) {
        func.invoke(panjereException)
    }
    return this
}

inline fun UiState<*>?.doOnLoading(func: () -> Unit): UiState<*>? {
    if (this is UiState.Loading) {
        func.invoke()
    }
    return this
}

val UiState<*>?.isLoading: Boolean
    get() = this is UiState.Loading

val UiState<*>?.isFailure: Boolean
    get() = this is UiState.Failure

val UiState<*>?.isSuccess: Boolean
    get() = this is UiState.Success