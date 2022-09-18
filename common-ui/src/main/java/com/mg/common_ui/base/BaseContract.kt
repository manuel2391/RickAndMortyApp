package com.mg.common_ui.base

interface ViewAction

interface ViewEvent

interface ViewState

/**
 * IDLE usually used for initial state
 * LOADING when for example we are loading the screen to fetch data
 * REFRESHING used for example when we have data and we want to refresh
 * UPLOADING used for example when we are pushing, submitting or uploading data
 * EMPTY used for when we are loading data and there are not results
 * CONTENT used when we want to display content/data
 * ERROR used for general error, like we could not pull the main data or we want to display an error screen
 * PARTIAL_ERROR used when we want to display a partial error and we do not want to loss the content
 */
enum class LoadState {
    IDLE,
    LOADING,
    REFRESHING,
    UPLOADING,
    EMPTY,
    CONTENT,
    ERROR,
    PARTIAL_ERROR
}