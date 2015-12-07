import Foundation  
  
class AppChange : CDVPlugin{

  func check(command: CDVInvokedUrlCommand){
    var msg = command.arguments[1] as! String
    var pluginResult = CDVPluginResult(status: CDVCommandStatus_OK, messageAsString: msg)
    commandDelegate!.sendPluginResult(pluginResult, callbackId: command.callbackId)
  }

}
