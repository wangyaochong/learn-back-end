package classLoader;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class ClassLoaderDemo2URLClassLoader {
    public static void main(String[] args) throws MalformedURLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        File file = new File("D:/");
        URL url = file.toURI().toURL();
        URLClassLoader urlClassLoader = new URLClassLoader(new URL[]{url});
        System.out.println("默认是系统类加载器:" + urlClassLoader.getParent());
        Class<?> aClass = urlClassLoader.loadClass("classLoader.Demo");
        System.out.println(aClass.newInstance());

    }
}
