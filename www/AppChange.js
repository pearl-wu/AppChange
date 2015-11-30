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
            [Scheme,id]
        );
    },
	//不存在執行安裝
	GOapprul:function(Scheme, successCallback, errorCallback) {
        cordova.exec(
            successCallback,
            errorCallback,
            "AppChange",
            "goAPPurl",
            [Scheme]
        );
    },
	//開啟指定APP
	OPENapp:function(Scheme, successCallback, errorCallback){
		cordova.exec(
            successCallback,
            errorCallback,
            "AppChange",
            "toAPPopen",
            [Scheme]
        );		
	},
	//接受傳值
	INport:function(Scheme, successCallback, errorCallback){
		cordova.exec(
            successCallback,
            errorCallback,
            "AppChange",
            "Inport",
            []
        );		
	}
    
};

module.exports = AppChange;