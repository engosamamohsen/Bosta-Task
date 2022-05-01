
# Bosta Task

The app is composed of 2 screens, first is the profile screen, it has the user name and address 
pinned at the top and then it lists all of this user’s albums. You can get user albums by requesting 
the albums endpoint and passing user id as a parameter.
When you press on any album it navigates to the second screen which is an album details screen. 
You request the photos endpoint and pass album id as a parameter, then list the images in an 
instagram-like grid. Also there should be a search bar that you can filter within the album by the 
image title, when you start typing the screen should show only images that are related to this 
search query.

**Retrofit** is a REST Client library (Helper Library) used in Android and Java to create an HTTP request and also to process the 
HTTP response from a REST API. It was created by Square, you can also use retrofit to receive data structures other than JSON, 
for example SimpleXML and Jackson. Before we continue, let’s briefly define REST Client and REST API in our context.

**Hilt** Hilt is a dependency injection library for Android that reduces the boilerplate of doing manual dependency injection in your project.

**Coroutines** A coroutine is a concurrency design pattern that you can use on Android to simplify code that executes asynchronously.

**MVVM** Keeping your Android codebase maintainable as your codebase grows can be a challenge. In this article, Toptal Freelance Android Developer Abhishek Tyagi shows how to combine MVVM with Clean Architecture.

For more references : 
- **Kotlin** - https://kotlinlang.org/
- **Retrofit** - https://www.raywenderlich.com/6994782-android-networking-with-kotlin-tutorial-getting-started
- **MVVM** - https://www.toptal.com/android/android-apps-mvvm-with-clean-architecture
- **Hilt** - https://developer.android.com/training/dependency-injection/hilt-android
- **Coroutines** - https://developer.android.com/kotlin/coroutines

# User List Screen
![users](https://user-images.githubusercontent.com/75907211/166128389-fed9aaa6-6721-4f47-9ff4-dd11aae78beb.jpeg)

# Albums Screen
![albums](https://user-images.githubusercontent.com/75907211/166128408-5299f69d-a9ad-4ff2-84fc-4cd392c0253a.jpeg)

# Colors Screen
![colors](https://user-images.githubusercontent.com/75907211/166128421-917f2cf1-e1f1-442a-a686-7d14af80eb73.jpeg)

# Bonus Points
Open any image in a separate image viewer with zooming and sharing functionality implemented

![bonus](https://user-images.githubusercontent.com/75907211/166128370-33d7c089-5c1f-4654-bab7-bc9403b02f70.jpeg)

