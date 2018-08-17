package org.github.start;


import com.sun.net.httpserver.HttpServer;
import org.github.HelloWorld;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.xml.ws.Endpoint;
import java.net.InetSocketAddress;
import java.util.Properties;

public class StartEJBConsumer {

	public static void main(String[] args) throws Exception {

		Thread.sleep(120000);

		for(int i = 0 ;i<10;i++) {
			Properties properties = new Properties();
			properties.setProperty(Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory");
			properties.setProperty(Context.PROVIDER_URL, "t3://192.168.5.50:7001");
			properties.setProperty(Context.SECURITY_PRINCIPAL, "weblogic");
			properties.setProperty(Context.SECURITY_CREDENTIALS, "caiSHI1216");

			Context context = null;
			HelloWorld hello = null;
			try {
				context = new InitialContext(properties);

				hello = (HelloWorld) context.lookup("HelloWorldBean#org.github.HelloWorld");
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			String response = "<font color='#ff0000'>" + hello.sayHello("wade") + "</font>";
			System.out.println(response);

		}

		Thread.sleep(120000);

	}
}


