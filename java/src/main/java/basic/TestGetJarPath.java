package basic;

import org.junit.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

public class TestGetJarPath {

    @Test
    public void test() throws URISyntaxException {
        System.out.println(getPath());
        System.out.println(getPath2());
        System.out.println(getJarDir(TestGetJarPath.class));
    }

    public String getPath() throws URISyntaxException {
        String path = this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI().getPath();
        if (System.getProperty("os.name").contains("dows")) {
            path = path.substring(1, path.length());
        }
        if (path.contains("jar")) {
            path = path.substring(0, path.lastIndexOf("."));
            return path.substring(0, path.lastIndexOf("/"));
        }
        return path.replace("target/classes/", "");
    }

    public String getPath2() throws URISyntaxException {
        String path = this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI().getPath();
        File jarFile = new File(path);
        String path1 = jarFile.getParentFile().getPath();
        return path1;
    }

    public static File getJarDir(Class aclass) {
        URL url;
        String extURL;      //  url.toExternalForm();

        // get an url
        try {
            url = aclass.getProtectionDomain().getCodeSource().getLocation();
            // url is in one of two forms
            //        ./build/classes/   NetBeans test
            //        jardir/JarName.jar  froma jar
        } catch (SecurityException ex) {
            url = aclass.getResource(aclass.getSimpleName() + ".class");
            // url is in one of two forms, both ending "/com/physpics/tools/ui/PropNode.class"
            //          file:/U:/Fred/java/Tools/UI/build/classes
            //          jar:file:/U:/Fred/java/Tools/UI/dist/UI.jar!
        }

        // convert to external form
        extURL = url.toExternalForm();

        // prune for various cases
        if (extURL.endsWith(".jar"))   // from getCodeSource
            extURL = extURL.substring(0, extURL.lastIndexOf("/"));
        else {  // from getResource
            String suffix = "/" + (aclass.getName()).replace(".", "/") + ".class";
            extURL = extURL.replace(suffix, "");
            if (extURL.startsWith("jar:") && extURL.endsWith(".jar!")) {
                extURL = extURL.substring(4, extURL.lastIndexOf("/"));
            }
        }

        // convert back to url
        try {
            url = new URL(extURL);
        } catch (MalformedURLException mux) {
            // leave url unchanged; probably does not happen
        }

        // convert url to File
        try {
            return new File(url.toURI());
        } catch (URISyntaxException ex) {
            return new File(url.getPath());
        }
    }

    public static String getJarPath() {
        return null;
    }
}
