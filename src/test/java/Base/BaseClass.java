package Base;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BaseClass {

	public Properties pro;

	public BaseClass() throws Exception {

		 pro = new Properties();
		 FileInputStream fs = new FileInputStream(System.getProperty("user.dir") + "src/test/java/configuration/config.properties");
		 try {
			pro.load(fs);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
