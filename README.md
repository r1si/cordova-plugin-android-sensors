# Cordova Android Sensors Plugin

A Cordova plugin to get some Andorid functionality check, here a list of the features:
* Check if your phone is locked or not (screen off)
* Chedk if your phone is in call or not

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
Check if your phone is locked or not (screen off) 

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