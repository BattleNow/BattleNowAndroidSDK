package com.allen.battlenowsdk.common

open  class ListResponse<T>(
        val count: Int,
        val next: String?,
        val previous: String?,
        val results: List<T>
)