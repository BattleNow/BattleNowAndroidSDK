package com.allen.battlenowsdk.common

class ListContext(
        val count: Int,
        val hasPrev: Boolean,
        val hasNext: Boolean

) {
    constructor(response: ListResponse<*>) : this(
            count = response.count,
            hasPrev = response.previous?.let { true } ?: false,
            hasNext = response.next?.let { true } ?: false
    )
}