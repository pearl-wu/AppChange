
#AppChange

```javascript
<script type="text/javascript">
     app.initialize();	
</script>
```


```javascript
var app = {		// Application Constructor
  initialize: function() {
    document.addEventListener('deviceready', this.receivedEvent, false);
  },
  receivedEvent: function() {	// Update DOM on a Received Event
  			......
	}
};
```

```javascript
AppChange.INport(
  Scheme,
  function(){},		// Success callback
  function(mag){}	// Error callback
);

AppChange.check(
		Scheme 1,
		Scheme 2,
		function(data){},	// Success callback
		function(data){}	// Error callback   
);

AppChange.GOapprul(
	Scheme,
	function(){},	// Success callback
	function(){}	// Error callback
);

AppChange.OPENapp(
  Scheme,
	parameter,
  function(){},			// Success callback
  function(data){}	// Error callback
);
```

