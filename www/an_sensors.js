var exec = require('cordova/exec');

exports.isDeviceLock = function(success, error) {
	exec(success, error, "an_sensors", "isDeviceLock");
};
exports.isCallActive = function(success, error) {
	exec(success, error, "an_sensors", "isCallActive");
};
