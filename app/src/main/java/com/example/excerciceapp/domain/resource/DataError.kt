package com.example.excerciceapp.domain.resource

sealed interface DataError: Error {
    enum class Network: DataError{
        REQUEST_TIMEOUT,
        NO_INTERNET,
        SERVER_ERROR,
        SERIALIZATION,
        BAD_REQUEST,
        UNKNOWN
    }
}