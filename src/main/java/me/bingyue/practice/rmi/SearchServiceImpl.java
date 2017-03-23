package me.bingyue.practice.rmi;

import java.rmi.RemoteException;

public class SearchServiceImpl implements SearchService{

	/**
	 * 抛出RemoteException
	 * @throws RemoteException
	 */
	public SearchServiceImpl() throws RemoteException {
		super();
		}
	
	@Override
	public User findUser(String id) throws RemoteException {
		/**
		 * 模拟查找返回数据
		 */
		User user=new User(id,"Tom","18岁");
		return user;
	}

}
