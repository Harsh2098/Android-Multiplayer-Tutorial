package com.hmproductions.multiplayertutorial;

import com.hmproductions.multiplayertutorial.data.ConnectionData;
import com.hmproductions.multiplayertutorial.utils.Constants;
import com.hmproductions.multiplayertutorial.utils.ServerHeaderInterceptor;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.File;
import java.io.IOException;
import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class TutorialServer {

    public static ArrayList<ConnectionData> connectionDataList = new ArrayList<>();

    static public void main(String args[]) {

        File serverCertificateFile = new File("server/server.crt");
        File serverKeyFile = new File("server/server.key");

        java.security.Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());

        Server server = ServerBuilder
                .forPort(Constants.SERVER_PORT)
                //.addService(new TutorialActionServiceImpl())
                .intercept(new ServerHeaderInterceptor())
                //.useTransportSecurity(serverCertificateFile, serverKeyFile)
                .handshakeTimeout(30, TimeUnit.SECONDS)
                //.addStreamTracerFactory(new StreamTerminationTracer())
                .build();

        try {

            System.out.print("Server started !\n");
            server.start();

            System.out.println(Inet4Address.getLocalHost().getHostAddress());

            server.awaitTermination();

        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }
}
