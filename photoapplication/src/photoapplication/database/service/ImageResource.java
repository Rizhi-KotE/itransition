package photoapplication.database.service;

import java.io.InputStream;
import java.net.URL;

public interface ImageResource {

	String save(InputStream stream);

	InputStream load(String name);

	String getUrl(String name);

}
