package com.example.glauton.micro;

        import android.util.Log;

        import com.koushikdutta.async.AsyncServer;
        import com.koushikdutta.async.AsyncSocket;
        import com.koushikdutta.async.ByteBufferList;
        import com.koushikdutta.async.DataEmitter;
        import com.koushikdutta.async.Util;
        import com.koushikdutta.async.callback.CompletedCallback;
        import com.koushikdutta.async.callback.ConnectCallback;
        import com.koushikdutta.async.callback.DataCallback;

        import java.net.InetSocketAddress;

public class Connection {

    String message = null;
    String hostName = null;
    int port = 0;

    public Connection(String message, String hostName, int port){
        this.message = message;
        this.hostName = hostName;
        this.port = port;
    }

    public void onDestroyConnection() {
        AsyncServer.getDefault().connectSocket(
                new InetSocketAddress(hostName,
                        port),
                new ConnectCallback() {
                    @Override
                    public void onConnectCompleted(Exception ex, final AsyncSocket socket) {
                        try {
                            socket.setClosedCallback(new CompletedCallback() {
                                @Override
                                public void onCompleted(Exception ex) {
                                    System.out.println("Successfully closed connection");
                                }
                            });
                            socket.setEndCallback(new CompletedCallback() {
                                @Override
                                public void onCompleted(Exception ex) {
                                    System.out.println("Successfully end connection");
                                }
                            });
                        } catch (Exception exc) {
                            System.out.println("Erro" + exc.getMessage());
                        }
                    }
                });
    }

    //    @Override
    public void onSendMensage()
    {
        AsyncServer.getDefault().connectSocket(
                new InetSocketAddress(hostName,
                        port),
                new ConnectCallback(){
                    @Override
                    public void onConnectCompleted(Exception ex, final AsyncSocket socket) {
                        try {
                            Util.writeAll(socket, message.getBytes(), new CompletedCallback() {
                                @Override
                                public void onCompleted(Exception ex) {
                                    System.out.println("Conectado com sucesso!");
                                    socket.close();
                                }
                            });

                            socket.setDataCallback(new DataCallback() {
                                @Override
                                public void onDataAvailable(DataEmitter emitter, ByteBufferList bb) {
                                    System.out.println(message + new String(bb.getAllByteArray()));
                                    socket.close();
                                }
                            });

                            socket.setClosedCallback(new CompletedCallback() {
                                @Override
                                public void onCompleted(Exception ex) {
                                    System.out.println("Successfully closed connection");
                                    socket.close();
                                }
                            });

                            socket.setEndCallback(new CompletedCallback() {
                                @Override
                                public void onCompleted(Exception ex) {
                                    System.out.println("Successfully end connection");
                                    socket.close();
                                }
                            });
                        }catch (Exception exc){
                            System.out.println("Erro" + exc.getMessage());
                            socket.close();
                        }
                    }
                });
    }
}
