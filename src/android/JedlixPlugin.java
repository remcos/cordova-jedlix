package com.remco.cordova.plugin;

// Cordova-required packages
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;

// Jedlix-required packages
import com.jedlix.sdk.JedlixSDK;
import com.jedlix.sdk.example.authentication.Auth0Authentication;
import com.jedlix.sdk.example.authentication.Authentication;
import com.jedlix.sdk.example.authentication.DefaultAuthentication;
import java.net.URL;

public class JedlixPlugin extends CordovaPlugin {
    
    @Override
    public boolean execute(String action, JSONArray args,
      final CallbackContext callbackContext) {
        // Verify that the user sent a 'connect' action
        if (!action.equals("connect")) {
          callbackContext.error("\"" + action + "\" is not a recognized action.");
          return false;
        }

        /* Custom code */
        var baseURL = "https://demo-smartcharging.jedlix.com";
        var apiKey = "";
        var authentication = {};
        
        JedlixSDK.configure(
            baseURL,
            apiKey,
            authentication
        );

        /* End of custom code */

        PluginResult pluginResult = new PluginResult(PluginResult.Status.OK);
        callbackContext.sendPluginResult(pluginResult);
        return true;
    }
}