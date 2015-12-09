import Foundation  
  
class check : CDVPlugin {
  func check(command: CDVInvokedUrlCommand) {
    var message = command.arguments[0] as String
    var pluginResult = CDVPluginResult(status: CDVCommandStatus_OK, messageAsString: message)
    commandDelegate.sendPluginResult(pluginResult, callbackId:command.callbackId)
  }
}
