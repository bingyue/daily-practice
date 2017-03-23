package me.bingyue.practice.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface SearchService extends Remote {

	public User findUser(String id) throws RemoteException;;
}
