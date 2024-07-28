Mini-Weather App
=====================================
Easily app to get weather data of any city in the world by just typing it's name!

# preview

![FIRST!](Screenshot_1722132008.png)
![SECOND!](Screenshot_1722132049.png)
![THIRD!](Screenshot_1722132129.png)

# Libraries and technologies used

### UI Layer

- view binding : instead of inflating views manually view binding will take care of that.

### Logic Layer

- MVVM & LiveData : Separate logic code from views and save the state in case the screen
  configuration changes.
- Coroutines : do some code in the background.
- Dagger-Hilt : for data injection.

### Data Layer

- Retrofit/OkHttp : to call an Api to get the current and live weather data for any city in the
  world.