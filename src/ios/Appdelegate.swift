import UIKit

@UIApplicationMain
class AppDelegate: UIResponder, UIApplicationDelegate {

    var window: UIWindow?
    var first: COBezierDemoViewController?

    func application(application: UIApplication, didFinishLaunchingWithOptions launchOptions: [NSObject: AnyObject]?) -> Bool {

        if let firstViewController = self.window?.rootViewController as? COBezierDemoViewController {
            self.first = firstViewController
        }

        return true
    }

    func application(application: UIApplication, handleOpenURL url: NSURL) -> Bool {
        first?.fileurl(url)
    }
}
