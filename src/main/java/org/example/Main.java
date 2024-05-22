package org.example;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Main {
    private static Hello getStub() throws MalformedURLException {
        Hello result;
        String bindName = "hello";
        try {
            result = (Hello) Naming.lookup(bindName);
        } catch (NotBoundException | RemoteException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
    public static void main(String[] args) {
        try {
            Hello stub = getStub();
            System.out.println(stub.sayHello("taherr"));
        } catch (MalformedURLException | RemoteException e) {
            throw new RuntimeException(e.getMessage());
        }


    }
}