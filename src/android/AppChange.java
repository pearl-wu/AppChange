package tw.com.bais.appchange;

import java.net.URISyntaxException;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;

public class AppChange extends CordovaPlugin {
    @SuppressLint({ "NewApi", "InlinedApi" }) @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if(action.equals("check")) {
            String uri = args.getString(0);
            if(uri != ""){
            	//callbackContext.success(uri);
            	checkAvailability(uri, callbackContext);
            }
           /*Context ctx = this.cordova.getActivity().getApplicationContext();
            try {
             	Intent ii = Intent.parseUri(uri, Intent.URI_INTENT_SCHEME);
                 ComponentName component = ii.resolveActivity(ctx.getPackageManager());
                 	//Toast.makeText(cordova.getActivity().getApplicationContext(), component.toShortString(), Toast.LENGTH_LONG).show();
                 if(component != null){
                 	callbackContext.success(uri);
                 	Toast.makeText(cordova.getActivity().getApplicationContext(), component.getPackageName(), Toast.LENGTH_LONG).show();
                 }else{
                 	 callbackContext.error("未");
                 }
             }catch(URISyntaxException e) {}*/
            return true;
        }
        
        if(action.equals("Inport")) {
        	Intent intent = this.cordova.getActivity().getIntent();
        	String scheme = intent.getScheme();
        	if( scheme != null ){
            	callbackContext.success(scheme);        		
        	}
            return true;
        }
        
        
        if(action.equals("goAPPurl")) {
     	   String url = args.getString(0);  
     	   this.goAppUrl(url);
        } 
       
	    if(action.equals("toAPPopen")) {
	 	   	String mag = args.getString(0);
	 	   	Intent i;
			try {
				i = Intent.parseUri(mag, Intent.URI_INTENT_SCHEME);
				i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				this.cordova.getActivity().startActivity(i);
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				callbackContext.error("- Open APP ERROR!! -");
			}      
	        return true;
	    }       
        return false;
    }


		private void goAppUrl(String message){ 
			Intent it = new Intent(Intent.ACTION_VIEW); 
			it.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		
			try {
				it.setData(Uri.parse("market://details?id="+message));
				
			}catch(android.content.ActivityNotFoundException anfe){
				it.setData(Uri.parse("https://play.google.com/store/apps/details?"+message));
			}
		    this.cordova.startActivityForResult(this, it, 0); 
		    /*
		      UripackageURI = Uri.parse("package: your.app.id");
			  Intent intent =new Intent(Intent.ACTION_DELETE);
		    */
		}
	

		
	/*public boolean appInstalled(String uri) {
        Context ctx = this.cordova.getActivity().getApplicationContext();
        final PackageManager pm = ctx.getPackageManager();
        boolean app_installed = false;
        try {
            pm.getPackageInfo(uri, PackageManager.GET_ACTIVITIES);
            app_installed = true;
        }
        catch(PackageManager.NameNotFoundException e) {
            app_installed = false;
        }
        return app_installed;
    }*/



	private void checkAvailability(String uri, CallbackContext callbackContext) {
		Context ctx = this.cordova.getActivity().getApplicationContext();
    	final PackageManager pm = ctx.getPackageManager();
    	try {
    		PackageInfo pi = pm.getPackageInfo(uri, PackageManager.GET_ACTIVITIES);
    		//callbackContext.success(pi.toString());
           /* if(pi != null){
            	//存在URI
             	callbackContext.success(pi.sharedUserLabel);
             	Toast.makeText(cordova.getActivity().getApplicationContext(), pi.sharedUserLabel, Toast.LENGTH_LONG).show();
             }else{
            	//不存在ID
             	callbackContext.error(pi.packageName);
             	Toast.makeText(cordova.getActivity().getApplicationContext(), pi.packageName, Toast.LENGTH_LONG).show();
             }*/
        }catch(PackageManager.NameNotFoundException e) {}
    }
	
}
