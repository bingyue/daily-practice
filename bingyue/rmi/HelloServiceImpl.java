package bingyue.rmi;

import java.rmi.RemoteException;

public class HelloServiceImpl implements HelloService{

	/**
	 * 抛出RemoteException
	 * @throws RemoteException
	 */
	public HelloServiceImpl() throws RemoteException {
		super();
		}
	
	@Override
	public String sayHello(String name) throws RemoteException {
		
		return "Hello!"+name;
	}

}
