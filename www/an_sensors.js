var exec = require('cordova/exec');

exports.isDeviceLock = function(success, error) {
	exec(success, error, "Hello", "isDeviceLock");
};
exports.isCallActive = function(success, error) {
	exec(success, error, "Hello", "isCallActive");
};