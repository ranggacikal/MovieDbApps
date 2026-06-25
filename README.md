# MovieDB

Android application built with **Jetpack Compose**, **Clean Architecture**, **Hilt**, **Room**, and **TMDB API**.

This project demonstrates a modern Android development approach using a scalable architecture, reactive UI, dependency injection, local persistence, and unit testing.

---

## Features

### Home Screen

* Popular Movies
* Now Playing Movies
* Top Rated Movies
* Error Handling
* Loading State

### Movie Detail Screen

* Movie Information
* Movie Reviews
* Share Movie
* Add to Favorite
* Remove from Favorite

### Favorite Screen

* View Favorite Movies
* Persist Favorite Movies using Room Database
* Remove Favorite Movie
* Open Movie Detail from Favorite List

## Tech Stack

### UI

* Jetpack Compose
* Material 3
* Navigation Compose
* Coil

### Architecture

* Clean Architecture
* MVVM
* StateFlow
* UiState Pattern

### Dependency Injection

* Hilt

### Networking

* Retrofit
* OkHttp
* Gson

### Local Storage

* Room Database

### Async Programming

* Kotlin Coroutines
* Flow

### Testing

* JUnit4
* MockK
* Coroutines Test

---

## API

Data is provided by The Movie Database (TMDB).

You need your own API key.

Create a `local.properties` file:

```properties
TMDB_API_KEY=YOUR_API_KEY
```

Then expose it through Gradle BuildConfig.

---

## Screens

### Home

* Popular Movies
* Now Playing Movies
* Top Rated Movies

### Detail

* Movie Information
* Reviews
* Share Action
* Favorite Action

### Favorite

* Local Favorite Movies

---

## Unit Tests

The project contains unit tests for:

* HomeViewModel
* DetailViewModel
* FavoriteViewModel
* UseCases

Testing libraries:

```gradle
testImplementation("junit:junit:4.13.2")
testImplementation("io.mockk:mockk:1.14.5")
testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test")
```

Run tests:

```bash
./gradlew test
```

---

## Future Improvements

* Search Movies
* Pagination
* Offline First Strategy
* Dark Mode Support
* Compose UI Testing
* Multi Module Architecture
* CI/CD Pipeline
* Firebase Crashlytics
* Firebase Analytics

## License

This project is created for learning purposes and portfolio demonstration.
