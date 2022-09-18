package com.mg.common.api

data class Paging(
    val count: Int,
    val pages: Int,
    val next: String?,
    val prev: String?
)