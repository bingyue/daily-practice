package me.bingyue.simplerpc.server;

public class EchoServiceImpl implements EchoService{

	@Override
	public String echo(String ping) {
		return ping==null?" empty input ":ping+" It's ok ";
	}

	
}
