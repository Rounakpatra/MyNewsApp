# News App

## Overview

This is a **News App** built using **Kotlin** and **Jetpack Compose** for the UI, adhering to **Clean Architecture** principles. The app fetches news data from an API using **Retrofit** and allows users to bookmark their favorite news articles. Bookmarked articles are stored in a **Room Database** for efficient future access. Dependency injection is handled with **Dagger**.

## 📸 Screenshots

### 🔹 Home Screen with Search & News List
<img src="WhatsApp Image 2025-04-17 at 10.22.06 PM.jpeg" width="300"/>

### 🔹 Bookmarks Section
<img src="WhatsApp Image 2025-04-17 at 10.22.05 PM.jpeg" width="300"/>

### 🔹 Article Details Screen
<img src="WhatsApp Image 2025-04-17 at 10.22.06 PM (1).jpeg" width="300"/>

## Features

- Fetches the latest news using Retrofit.
- Displays news in a modern UI using Jetpack Compose.
- Allows users to bookmark news articles.
- Bookmarked articles are stored in Room DB for offline access.
- Clean Architecture pattern for better separation of concerns and testability.
- Dagger is used for dependency injection.

## Architecture

This project follows Clean Architecture principles, which divides the project into layers:

1. **Domain Layer**: Contains the business logic and use cases.
2. **Data Layer**: Responsible for handling data operations, such as network calls and database transactions.
3. **Presentation Layer**: The UI and user interaction layer, built using Jetpack Compose.

## Libraries Used

- **Kotlin**: The main programming language.
- **Jetpack Compose**: For building declarative UIs.
- **Retrofit**: For making network API calls.
- **Room**: For local data storage and caching.
- **Dagger**: For dependency injection.
- **Coroutines**: For asynchronous programming.
- **LiveData/StateFlow**: For observing data in the UI.


