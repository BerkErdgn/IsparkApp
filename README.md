
# IsparkApp
 
This application is a phone application that provides information about the locations, occupancy rates, working hours and charges of the İSPARK car parks of the Istanbul municipality.


## Technologies Used
- Jetpack Compose
- Flow
- Clean Architecture
- Google maps
- Corutines
- Dagger Hilt
- Retrofit
- Navigation
- Room
- LottieFiles



## Screenshots

Splash Screen | Main Screen |Detail Screen|Save Screen|
 --- | --- |  --- | --- | 
![](https://github.com/BerkErdgn/IsparkApp/blob/main/sc/1.png?raw=true)| ![](https://github.com/BerkErdgn/IsparkApp/blob/main/sc/2.png?raw=true) |![](https://github.com/BerkErdgn/IsparkApp/blob/main/sc/3.png?raw=true) |![](https://github.com/BerkErdgn/IsparkApp/blob/main/sc/4.png?raw=true)


## API Usage

- Base Url:
```http
    https://api.ibb.gov.tr/ispark/

```
----
- To get all isparks:
```http
   /Park
```


----
- To get one ispark:
```http
   /ParkDetay
```

| Parameter | Type     | Explanation                |
| :-------- | :------- | :------------------------- |
| `id ` | `string` | to get the details in **that ispark**. | 



## Download  

To download the project

```bash 
  1-Press the green "Code" button at the top right of this page.
  2-Click on Download ZIP
  3-Extract the ZIP and open it to Android Studio.
```
As an alternative

You can directly download the ZIP by clicking the [link here](https://github.com/BerkErdgn/IsparkApp/archive/refs/heads/main.zip).

## Known bug

Apikey is required to use google maps. I deleted my own apikey. If you want to use it, you can put your own apikey in the 'GOOGLE_MAPS_API_KEY' section in "local.properties" and run it.


## Find a bug?

If you found an issue or would like to submit an improvement to this project, please submit an issue using the issues tab above.
Thank you very much.
