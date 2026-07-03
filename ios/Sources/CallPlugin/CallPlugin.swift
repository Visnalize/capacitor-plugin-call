import Foundation
import Capacitor

/**
 * Please read the Capacitor iOS Plugin Development Guide
 * here: https://capacitorjs.com/docs/plugins/ios
 */
@objc(CallPlugin)
public class CallPlugin: CAPPlugin, CAPBridgedPlugin {
    public let identifier = "CallPlugin"
    public let jsName = "Call"
    public let pluginMethods: [CAPPluginMethod] = [
        CAPPluginMethod(name: "call", returnType: CAPPluginReturnPromise),
    ]

    @objc func call(_ call: CAPPluginCall) {
        guard var formattedNumber = call.getString("number")
        else {
            call.reject("error-missing-number")
            return
        }
        
        if !formattedNumber.starts(with:"tel:") {
            formattedNumber = "tel:" + formattedNumber
        }
        
        formattedNumber = formattedNumber.replacingOccurrences(of: "#", with: "%23")
        guard let number = URL(string:formattedNumber)
        else {
            call.reject("error-call-failed")
            return
        }
        DispatchQueue.main.async {
            UIApplication.shared.open(number, options: [:]) { success in
                if success {
                    call.resolve()
                } else {
                    call.reject("error-call-failed")
                }
            }
        }
    }
}
