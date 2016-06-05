package com.xu.callNativeJs;

import android.content.Intent;
import android.util.Log;
import android.app.Activity;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import com.xu.callNativeJs.NotdisturbActivity;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;



/**
 * This class echoes a string called from JavaScript.
 */
public class callNativeJs extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("coolMethod")) {
            String message = args.getString(0);
            this.coolMethod(message, callbackContext);
            return true;
        }
        return false;
    }

    private void coolMethod(String message, CallbackContext callbackContext) {
        if (message != null && message.length() > 0)
        {
            Log.w("TAG", "coolMethod: "+message,null);
            String[] array = message.split("#");
            String method =  array[2];
            String param  =  array[3];

            if(method.equals("jumpTONotdisturb")){
                this.jumpPage(message);
            }
            callbackContext.success(message);
        } else {
            callbackContext.error("Expected one non-empty string argument.");
        }
    }

   private void jumpPage(String message){
       Intent intent = new Intent(cordova.getActivity(), NotdisturbActivity.class);
       this.cordova.startActivityForResult((CordovaPlugin)this,intent,0);

   }

   //获取结果返回
   public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK && data != null) {
//            this.callbackContext.success(data); //callbackContext 要定义一个全局的变量
        }
    }
}
