# Weather App : Android MVVM Architecture (Kotlin + ViewModel + Coroutines + Kotlin Flow + Ktor)

MVVM Architecture :
Model — View — ViewModel (MVVM) is the  software architecture pattern that overcomes all drawbacks of MVP and MVC design patterns. MVVM suggests separating the data presentation logic(Views or UI) from the core business logic part of the application.

Coroutines + Kotlin Flow :
In coroutines, a flow is a type that can emit multiple values sequentially, as opposed to suspend functions that return only a single value. For example, you can use a flow to receive live updates from a database.

Ktor:
Ktor is a client-server framework that helps us build applications in Kotlin. It is a modern asynchronous framework backed by Kotlin coroutines. Ktor can be compared to network library such as OkHttp and Retrofit. We can use Ktor to make HTTP network requests to an API to get the response back to an application.

Navigation & UI :
NavController manages app navigation within a NavHost . Apps will generally obtain a controller directly from a host, or by using one of the utility methods on the Navigation class rather than create a controller directly. Navigation flows and destinations are determined by the navigation graph owned by the controller.

Safe Args :
Navigation allows you to attach data to a navigation operation by defining arguments for a destination. For example, a user profile destination might take a user ID argument to determine which user to display.

### Weather API
Used weather api [Open Weather Map API](https://openweathermap.org/api) for collecting weather information.

### Project Setup
Clone the project and open it using Android Studio [https://github.com/jeelan-512/WeatherSampleApp.git].

Select "develop" branch to view the code.

### Screen Shots

<img src="https://user-images.githubusercontent.com/31059243/206970070-f9e33bba-3625-43da-adc6-098f3d33ee78.png" width="250" height="446" />

<img src="https://user-images.githubusercontent.com/31059243/206970166-02453a73-06ea-4afc-bc3f-be1f7e90df6f.png" width="250" height="446" />
