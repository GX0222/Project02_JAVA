window.onload = function (){
	var start = $("#start");
	var msgDiv = $("#msgDiv");
	var msg = $("#msg");
	var send = $("#send");
	var log = $("#log");
	
	start.css("display", "block");
	msgDiv.css("display", "none");
	
	start.on("click", function (){
		console.log("connect...");
		connect();
	})
	
	function connect(){
		MyWebSocket = new WebSocket("ws://10.0.104.99:8080/bweb2/myserver");
		
		MyWebSocket.onerror = function (event){console.log("error")};
		MyWebSocket.onopen = function (event){
			console.log("open ok");
			start.css("display", "none");
			msgDiv.css("display", "block");
		};
		
		MyWebSocket.onclose = function (event){
			console.log("close");
			start.css("display", "block");
			msgDiv.css("display", "none");
		};
		
		send.on("click", function(){
			var message = {
				message : msg.val()
			};
			
			MyWebSocket.send(JSON.stringify(message));
		});
		
		//接收
		MyWebSocket.onmessage = function (event){
			//event.data
			var msgObj = JSON.parse(event.data);
			log.html(log.html() + msgObj.message + "<br>");
		};
	}
}