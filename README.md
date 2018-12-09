# AndroidSocketAsyncEsp
This Aplication was made to be a simple way to to make an Asynchron Comunication beetwen an Android App and a ESP Server with the possibily to send a message to the server. 

You can integrate this app with this Auto Balacing Robot: https://github.com/Kayannsoarez/Panopticron

### Documentation Valid to `Master`

### Usability

To use the App it's only necessary put the `port` and the `hostName` that you're trying to comunicate with.

### How to Use
The class Connection override the method onSendMesage(), that is responsable to send the mesage to server. 

### Steps to Adapt the App to your Project
* Initialize the class Conection
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

### Aplication's Imagem
![alt text](https://uploaddeimagens.com.br/images/001/770/564/full/print_tela.jpg?1544388008)

Dependencies
----------
AndroidAsync: https://github.com/koush/AndroidAsync

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