package com.endava.server;

import com.endava.dto.RestRequest;
import com.endava.engine.RuleEngine;
import org.apache.commons.io.IOUtils;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.List;

/**
 * Created by astoica on 5/23/2015.
 */
@Service
public class RestServer {

    private final static org.slf4j.Logger logger = LoggerFactory.getLogger(RestServer.class);

    @Autowired
    RuleEngine ruleEngine;

    public void startServer(Integer port) throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);

        try {
            while (true) {
                Socket socket = serverSocket.accept();
                try {
                    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    String s = in.readLine();
                    String[] splitString = s.split("\\s+");

                    String method = splitString[0];
                    String path = splitString[1];
                    RestRequest restRequest = new RestRequest(method, path, port);

                    String response = ruleEngine.runRule(restRequest);

                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                    out.println(response);
                } finally {
                    socket.close();
                }
            }
        }
        finally {
            serverSocket.close();
        }
    }
}
