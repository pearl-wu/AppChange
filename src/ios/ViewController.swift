import UIKit

class ViewController: UIViewController {

   @IBOutlet weak var txtScheme: UITextField!
   @IBOutlet weak var txtPath: UITextField!
   @IBOutlet weak var txtQuery: UITextField!

   override func viewDidLoad() {
     super.viewDidLoad()

     NSNotificationCenter.defaultCenter().addObserver(
       self,
      selector: "displayLaunchDetails",
      name: UIApplicationDidBecomeActiveNotification,
      object: nil)
   }

   func displayLaunchDetails() {
   var appDelegate =
       UIApplication.sharedApplication().delegate as AppDelegate
      if appDelegate.scheme != nil {
         let button2Alert: UIAlertView = UIAlertView(title: "Title", message: appDelegate.scheme,
                        delegate: self, cancelButtonTitle: "Ok", otherButtonTitles: nil)
         button2Alert.show()
      }
    }

    deinit {
      NSNotificationCenter.defaultCenter().removeObserver(
       self,
       name: UIApplicationDidBecomeActiveNotification,
       object: nil)
    }

    override func didReceiveMemoryWarning() {
      super.didReceiveMemoryWarning()
      // Dispose of any resources that can be recreated.
    }
}
