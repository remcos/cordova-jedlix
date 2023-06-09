// Empty constructor
function JedlixPlugin() {}

// The function that passes work along to native shells
// Message is a string, duration may be 'long' or 'short'
JedlixPlugin.prototype.show = function(message, duration, successCallback, errorCallback) {
  var options = {};
  options.message = message;
  options.duration = duration;
  cordova.exec(successCallback, errorCallback, 'JedlixPlugin', 'show', [options]);
}

// Installation constructor that binds ToastyPlugin to window
JedlixPlugin.install = function() {
  if (!window.plugins) {
    window.plugins = {};
  }
  window.plugins.jedlixPlugin = new JedlixPlugin();
  return window.plugins.jedlixPlugin;
};
cordova.addConstructor(JedlixPlugin.install);