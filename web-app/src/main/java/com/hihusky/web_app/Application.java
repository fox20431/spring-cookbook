package com.hihusky.web_app;

import org.apache.catalina.*;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.core.*;
import org.apache.catalina.startup.Tomcat;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import jakarta.servlet.Servlet;

import java.io.File;

public class Application {
	public static void main(String[] args) throws LifecycleException {
		try (AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext()) {
			// create a server
			Server server = new StandardServer();
			/**
			 * os.version : OS Version
			 * os.name : OS Name
			 * os.arch : OS Architecture
			 * java.compiler : Name of the compiler you are using
			 * java.ext.dirs : Extension directory path
			 * java.library.path : Paths to search libraries whenever loading
			 * path.separator : Path separator
			 * file.separator : File separator
			 * user.dir : Current working directory of User
			 * user.name : Account name of User
			 * java.vm.version : JVM implementation version
			 * java.vm.name : JVM implementation name
			 * java.home : Java installation directory
			 * java.runtime.version : JVM version
			 */
			File catalinaHome = new File(System.getProperty("user.dir") + "/catalina-home");
			if (!catalinaHome.exists()) {
				catalinaHome.mkdir();
			}
			server.setCatalinaHome(catalinaHome);

			// create a service
			Service service = new StandardService();

			// create a connector
			Connector connector = new Connector("HTTP/1.1");
			connector.setPort(8080);

			// create an engine
			Engine engine = new StandardEngine();
			// must set default host for engine
			engine.setDefaultHost("host-01");

			// create a host
			Host host = new StandardHost();
			host.setName("host-01");

			// create a context
			Context catContext = new StandardContext();
			catContext.setPath("");
			File docBase = new File(System.getProperty("user.dir") + "/doc-base");
			if (!docBase.exists()) {
				docBase.mkdir();
			}
			catContext.setDocBase(docBase.getAbsolutePath());
			catContext.addLifecycleListener(new Tomcat.FixContextListener());

			DispatcherServlet dispatcher = new DispatcherServlet(context);

			// create servlet
			Wrapper wrapper = new Tomcat.ExistingStandardWrapper(dispatcher);
			wrapper.setName("servlet");
			catContext.addChild(wrapper);
			catContext.addServletMappingDecoded("/", "servlet");

			// build up
			host.addChild(catContext);
			engine.addChild(host);
			service.setContainer(engine);
			service.addConnector(connector);
			server.addService(service);

			// start
			server.start();
			// await
			server.await();
		}
	}
}
