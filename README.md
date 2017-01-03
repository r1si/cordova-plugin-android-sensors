# Cordova Android Sensors Plugin

A Cordova plugin to get some Andorid functionality check, here a list of the features:
* Check if your phone is locked or not (screen off)
* Check if your phone is in call or not
* Detect your device data activity


## Installation

Cordova: 
```
cordova plugin add cordova-android-sensors
```

Phonegap:
```
phonegap plugin add cordova-android-sensors
```

## Usage

### isDeviceLock
Check if your phone is locked or not (screen off).  
It returns true or false

```
an_sensors.isDeviceLock(function(res) {
    if(res == "true"){
        console.log("phone is locked");
    }else{
        console.log("phone isn't locked");
    }
}, function() {
    console.error('An error occoured while do the command');
});
```

### isCallActive
Check if your phone is in calling or not  
It returns true or false

```
an_sensors.isCallActive(function(res) {
    if(res == "true"){
        console.log("phone is calling");
    }else{
        console.log("phone isn't calling");
    }
}, function() {
    console.error('An error occoured while do the command');
});
```

### getDeviceNetwokActivity
Function that get the current device network activity  
It return an int number with this value:
* 0 = DATA_ACTIVITY_NONE - Data connection activity: No traffic.  
* 1 = DATA_ACTIVITY_IN - Data connection activity: Currently receiving IP PPP traffic.  
* 2 = DATA_ACTIVITY_OUT - Data connection activity: Currently sending IP PPP traffic.  
* 3 = DATA_ACTIVITY_INOUT - Data connection activity: Currently both sending and receiving IP PPP traffic.  
* 4 = DATA_ACTIVITY_DORMANT - Data connection is active, but physical link is down  

```
an_sensors.getDeviceNetwokActivity(function(res) {
        alert(res); // debug value
    },function(res) {
        console.error("Error form plugin");
    });
```