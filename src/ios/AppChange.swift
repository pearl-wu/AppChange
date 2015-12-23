import Foundation

 @objc(HWPAppChange) class AppChange : CDVPlugin {
    func check(command: CDVInvokedUrlCommand) {
       let id = command.arguments[0] as? String ?? ""
        let URLs = command.arguments[1] as? String ?? ""
        let callsheme:NSURL = NSURL(string: id)!
            if(UIApplication.sharedApplication().canOpenURL(callsheme)){
                let pluginYES = CDVPluginResult(status: CDVCommandStatus_OK, messageAsString: id)
                commandDelegate!.sendPluginResult(pluginYES, callbackId:command.callbackId)
            }else{
                let pluginNO = CDVPluginResult(status: CDVCommandStatus_ERROR, messageAsString: URLs)
                commandDelegate!.sendPluginResult(pluginNO, callbackId:command.callbackId)
            }
    }
    func goAPPurl(command: CDVInvokedUrlCommand) {
        let id = command.arguments[0] as? String ?? ""
        if(id != ""){
            let urls:NSURL = NSURL(string: "itms-apps://itunes.apple.com/app/id\(id)")!
            UIApplication.sharedApplication().openURL(urls)
        }else{
            let pluginNO = CDVPluginResult(status: CDVCommandStatus_ERROR, messageAsString: "INSTALL APP ERROR!!")
            commandDelegate!.sendPluginResult(pluginNO , callbackId: command.callbackId)
        }
    }
    func toAPPopen(command: CDVInvokedUrlCommand) {
        let sheme = command.arguments[0] as? String ?? "OPEN APP ERROR!!"
        let uris:NSURL = NSURL(string: sheme)!
        if(UIApplication.sharedApplication().canOpenURL(uris)){
            UIApplication.sharedApplication().openURL(uris)
        }else{
            let pluginNO = CDVPluginResult(status: CDVCommandStatus_ERROR, messageAsString: "OPEN APP ERROR!!")
            commandDelegate!.sendPluginResult(pluginNO , callbackId: command.callbackId)
        }
    }
    func application(application: UIApplication, handleOpenURL url: NSURL) -> Bool {
        return true;
    }

}
