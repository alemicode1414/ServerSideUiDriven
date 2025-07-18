package com.example.alemitraining.util

suspend inline fun <T> safeApiCall(
    crossinline call: suspend () -> T
): Result<T> = runCatching {
    Result.success(call())
}.getOrElse { exception ->
    Result.failure(exception)
}