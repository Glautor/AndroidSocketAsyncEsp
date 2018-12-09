# AndroidSocketAsyncEsp
Aplication created to make a Assynchron Comunication beetwen an Android App and a ESP Server. 

### Integrate this app with this Auto Balacing Robot
[![Auto Balacing Robot](https://github.com/Kayannsoarez/Panopticron)

### Usability

To use the App it's only necessary put your IP and the Hostname that you're trying to comunicate with.

### How to Use
The class Connection Override the method onSendMesage(), that is responsable to send the mesage to server. 

### Steps to Adapt the App to your Project
* Initialize the Class Conection
* Put the HostName
* Put de Port
### Example
```java

   String message = "";
   private static String hostName = "192.168.4.1";
   private static int port = 555;
	Connection conection = new Connection("1", hostName, port);
	connection.onSendMensage();
```

**Dependencies**
[![AndroidAsync](https://github.com/koush/AndroidAsync)

Team
----------
* Glauton Santos
* Luan Cruz
* Kayann Soares

Limitations
----------
If you want to contribe with the project, the App has a problem, always that it send a message, the connection is lost.

License
----------

AndroidSocketAsyncEsp is Copyright © 2018 thoughtbot, inc. It is free software and you can use how you want to.