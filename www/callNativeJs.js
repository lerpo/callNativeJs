var exec = require('cordova/exec');

var callNativeJs = function(){};
callNativeJs.prototype.coolMethod = function(action,param, success, error) {
	var methodUrl = "native-call:#action:#"+action+"#"+param;
    return cordova.exec(success, error, "callNativeJs", "coolMethod", [methodUrl]);
};
window.callNativeJs = new callNativeJs();
