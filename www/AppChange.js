var AppChange = {
	
	//successCallback -> successCallback
    //errorCallback -> errorCallback
	//檢查APP是否存在
    check: function(uri, id, successCallback, errorCallback) {
        cordova.exec(
            successCallback,
            errorCallback,
            "AppChange",
            "check",
            [uri, id]
        );
    },
	//不存在執行安裝
	GOappurl:function(Scheme, successCallback, errorCallback) {
        cordova.exec(
            successCallback,
            errorCallback,
            "AppChange",
            "goAPPurl",
            [Scheme]
        );
    },
	//開啟指定APP
	OPENapp:function(Scheme, mgs, successCallback, errorCallback){
		cordova.exec(
            successCallback,
            errorCallback,
            "AppChange",
            "toAPPopen",
            [Scheme,mgs]
        );		
	},
	//接受傳值
	/*INport:function(successCallback){
		cordova.exec(
            successCallback,
            "AppChange",
            "valuemag",
            []
        );		
	}*/
    
};

module.exports = AppChange;
