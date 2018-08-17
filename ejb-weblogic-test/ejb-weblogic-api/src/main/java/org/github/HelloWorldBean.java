package org.github;

import javax.ejb.Remote;
import javax.ejb.Stateless;

@Stateless(mappedName = "HelloWorldBean")  
@Remote({HelloWorld.class})
public class HelloWorldBean implements HelloWorld{

	@Override
	public String sayHello(String name) {

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		String result = "org.github.HelloWorldBean.sayHello(String name)："+name;
		System.out.println(result);

		return result;
	}

}
