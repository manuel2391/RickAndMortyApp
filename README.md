
# Rick and Morty App

Example of Android Compose App using Clean Architecture with MVI




## Requirements

 - To run this app you need [Android Studio Arctic Fox](https://developer.android.com/studio) and JDK 11 installed on your computer.
 

## App ScreenShots

<image src="readme/Screenshot_1.png" width="180"></image> <image src="readme/Screenshot_2.png" width="180"/> <image src="readme/Screenshot_3.png" width="180"/>


## Modules

This project is broken down into five modules:

1. `app`: The presentation module. It contains the screens implementation.

2. `domain`: A pure Kotlin module holding the business logic of the app. Use cases, models and abstract definitions of data sources reside in this module. It acts like a bridge between the `app` and the `data` module.

3. `data`: As its name suggests, this module is in charge of the data handling. It provides concrete implementations for data sources.

4. `common`: The purpose of this module is to group useful things that can be shared among projects. It holds non-android implementations.

5. `common-ui`: This module has the same purpose as the previous one, but it holds only android stuff – e.g. custom views.
## Dependencies

- [Jetpack Compose Toolkit](https://developer.android.com/jetpack/compose): To build native UI with less code.
- [Navigation component](https://developer.android.com/jetpack/compose/navigation): To handle the navigation among screens.
- [Coil](https://coil-kt.github.io/coil/compose/): To load images.
- [Hilt](https://d.android.com/hilt): For dependency injection.
- [Kotlin Coroutines](https://developer.android.com/kotlin/coroutines?gclid=Cj0KCQjwrJOMBhCZARIsAGEd4VHHTIZn0IQaxOlwjCXPBpoyuWflxN5mVvGkt9XsoGj8gJU4VnEnJdQaAoYwEALw_wcB&gclsrc=aw.ds): To handle async tasks.
- [Retrofit](): To handle the communication between the app and [RickAndMortyAPI](https://rickandmortyapi.com/) APIs.