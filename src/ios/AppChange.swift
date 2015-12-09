import Foundation

 @objc(HWPAppChange) class AppChange : CDVPlugin {
    func check(command: CDVInvokedUrlCommand) {
        var message = command.arguments[0] as! String
        
        var pluginResult = CDVPluginResult(status: CDVCommandStatus_OK, messageAsString: "check \(message)")
        commandDelegate!.sendPluginResult(pluginResult, callbackId:command.callbackId)
    }
    func goAPPurl(command: CDVInvokedUrlCommand) {
        var message = command.arguments[0] as! String
        
        var pluginResult = CDVPluginResult(status: CDVCommandStatus_OK, messageAsString: "goAPPurl \(message)")
        commandDelegate!.sendPluginResult(pluginResult, callbackId:command.callbackId)
    }
    func toAPPopen(command: CDVInvokedUrlCommand) {
        var message = command.arguments[0] as! String
        
        var pluginResult = CDVPluginResult(status: CDVCommandStatus_OK, messageAsString: "toAPPopen \(message)")
        commandDelegate!.sendPluginResult(pluginResult, callbackId:command.callbackId)
    }
    func Inport(command: CDVInvokedUrlCommand) {
        var message = command.arguments[0] as! String
        
        var pluginResult = CDVPluginResult(status: CDVCommandStatus_OK, messageAsString: "Inport \(message)")
        commandDelegate!.sendPluginResult(pluginResult, callbackId:command.callbackId)
    }
    
}
