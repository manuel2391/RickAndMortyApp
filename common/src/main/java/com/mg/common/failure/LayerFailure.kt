package com.mg.common.failure

sealed class LayerFailure : Throwable() {
    /*** Extend this class for data specific failures. i.e. server side or database side failures. */
    abstract class DataFailure : LayerFailure()

    /*** Extend this class for feature specific failures. */
    abstract class FeatureFailure : LayerFailure()
}