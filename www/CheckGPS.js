var exec = require('cordova/exec');

exports.check = function(success, error) {
	exec(success, error, "CheckGPS", "check");
};

exports.locationServiceCheck = function(success, error) {
	exports.check(success, error);
};

exports.locationPermissionCheck = function(success, error) {
	exec(success, error, "CheckGPS", 'locationPermissionCheck');
};

exports.locationPermissionAsk = function(cb) {
	exec(cb, null, "CheckGPS", 'locationPermissionAsk');
};
