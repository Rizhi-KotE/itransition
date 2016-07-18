package photoapplication.dao.interfaces;

import java.io.InputStream;

import org.apache.tomcat.util.net.URL;

public interface ImageResource {
	
	void save(String name, InputStream stream);
	InputStream load(String name);
	URL getUrl(String name);
	
}
