package tw.com.bais.appchange;

import java.net.URISyntaxException;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.widget.Toast;

public class AppChange extends CordovaPlugin {
	    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
	        if(action.equals("check")) {
	            String uri = args.getString(0);  
	            String id = args.getString(1);
	            checkAvailability(uri, id, callbackContext);
	            return true;
	        }
	        
	        if(action.equals("Inport")) {
		   Intent intent = this.cordova.getActivity().getIntent();
	           String mmg = intent.getDataString();
	           Bundle bundle = intent.getExtras();
	        	if(bundle.isEmpty()){
	        		Toast.makeText(cordova.getActivity().getApplicationContext(), bundle.getString("data"), Toast.LENGTH_LONG).show();
	        	}else if( mmg.isEmpty() ){
	        		Toast.makeText(cordova.getActivity().getApplicationContext(), mmg, Toast.LENGTH_LONG).show();
	            	callbackContext.success(mmg);
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
	
	    private boolean OPENapp(String sc, String par, CallbackContext callbackContext){
		if(sc.matches("^[a-z0-9-]://")){
			Intent i;
			try {
				i = Intent.parseUri(sc+par, Intent.URI_INTENT_SCHEME);
				i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				this.cordova.getActivity().startActivity(i);
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				callbackContext.error("- Open APP ERROR!! -");
			}      
		  return true;
		}else{
	        Context ctx = this.cordova.getActivity().getApplicationContext();
	        PackageManager pm = ctx.getPackageManager();
	        PackageInfo info = pm.getPackageArchiveInfo(sc, PackageManager.GET_ACTIVITIES);	        
	        try  {  
	        	Intent intent = new Intent();
	        	if (intent != null) {
	        	  intent = pm.getLaunchIntentForPackage(sc);
	        	  intent.addCategory(Intent.CATEGORY_LAUNCHER);
	        	  intent.putExtra("data", par);
	        	  this.cordova.getActivity().startActivity(intent);
	        	}else{
	        		Toast.makeText(cordova.getActivity().getApplicationContext(), "啟動失敗", Toast.LENGTH_LONG).show();
	        	}
	        }catch (ActivityNotFoundException e)  {
	        	      e.printStackTrace();
	        }
		  return true;
		}
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
	     }
		

			
	     private void checkAvailability(String uri, String id, CallbackContext callbackContext) {
		if(appInstalled(id)){
			//Toast.makeText(cordova.getActivity().getApplicationContext(), uri, Toast.LENGTH_LONG).show();
            		callbackContext.success(uri);				
		}else{
			//Toast.makeText(cordova.getActivity().getApplicationContext(), id, Toast.LENGTH_LONG).show();	
        		callbackContext.error(id);				
		}
	    }
	    public boolean appInstalled(String uri) {
	        Context ctx = this.cordova.getActivity().getApplicationContext();
	        PackageManager pm = ctx.getPackageManager();
	        boolean app_installed = false;
	        try {
	            pm.getPackageInfo(uri, PackageManager.GET_ACTIVITIES);
	            app_installed = true;
	        }
	        catch(PackageManager.NameNotFoundException e) {
	            app_installed = false;
	        }
	        return app_installed;
	    }
}
