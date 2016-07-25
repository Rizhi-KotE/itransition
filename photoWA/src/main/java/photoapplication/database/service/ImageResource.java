package photoapplication.database.service;

import java.io.IOException;
import java.io.InputStream;

public interface ImageResource {

	String save(Object file) throws IOException;

	InputStream load(String name);

	String getUrl(String name);

}
