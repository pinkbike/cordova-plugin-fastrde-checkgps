var PluginFunctions = {
    check: function(success, error, options) {
        options = options || {};
        options.alert = false || options.alert;
        cordova.exec(success, error, "CheckGPS", "check", [options.alert]);
    },
    locationPermissionCheck: function(cb) {
        cordova.exec(cb, null, "CheckGPS", 'locationPermissionCheck', []);
    },
};

exports = PluginFunctions;
