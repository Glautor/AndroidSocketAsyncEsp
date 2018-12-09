# AndroidSocketAsyncEsp
Aplication created to make a Assynchron Comunication beetwen an Android App and a ESP Server. 

<h3> You can integrate this app with this Auto Balacing Robot </h3>
[Auto Balacing Robot]: https://github.com/Kayannsoarez/Panopticron

<h2> Usability </h2>
<span> To use the App it's only necessary put your IP and the Hostname that you're trying to comunicate with.  </span>

<h2> How to Integrate </h2>
<span> Tha class Connection Override the method onSendMesage(), that is responsable to send the mesage to server.  </span>

<h3 Steps to Adapt the App to your Project </h3>
	- Initialize the Class Conection
	- Put the HostName
	- Put de Port
	- Example
```ruby

   String message = "";
   private static String hostName = "192.168.4.1";
   private static int port = 555;
	Connection conection = new Connection("1", hostName, port);
	connection.onSendMensage();
```

<h4> Dependencies </h4>
[AndroidAsync]: https://github.com/koush/AndroidAsync

<h4> Team </h4>
	- Glauton Santos
	- Kayann Soares
	- Luan Cruz

<h4> Limitations </h4>
<span> If you want to contribe with the project, the App has a problem, always that it send a message, the connection is lost. </span>

License
-------


AndroidSocketAsyncEsp is Copyright © 2018 thoughtbot, inc. It is free software and you can use how you want to.