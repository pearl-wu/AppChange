var AppChange = {
    
	//檢查APP是否存在
    check: function(uriScheme, qno, successCallback, errorCallback) {
        cordova.exec(
            successCallback,	//successCallback
            errorCallback,		//errorCallback
            "AppChange",
            "check",
            [uriScheme,qno]
        );
    },
	//不存在執行安裝
	GOapprul:function(uriScheme, successCallback, errorCallback) {
        cordova.exec(
            successCallback,
            errorCallback,
            "AppChange",
            "goAPPurl",
            [uriScheme]
        );
    },
	//開啟指定APP
	OPENapp:function(uriScheme, successCallback, errorCallback){
	cordova.exec(
            successCallback,
            errorCallback,
            "AppChange",
            "toAPPopen",
            [uriScheme]
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