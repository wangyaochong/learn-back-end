package multiThread.java高并发编程详解.第10章java类加载器;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TestMyClassLoader extends ClassLoader {
    private static Path DefaultClassDir = Paths.get("G:", "classloader1");
    private final Path classDir;

    public TestMyClassLoader() {
        super();
        this.classDir = DefaultClassDir;
    }

    public TestMyClassLoader(String classDir, ClassLoader parent) {
        super(parent);
        this.classDir = Paths.get(classDir);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] classBytes = this.readClassBytes(name);
        if (null == classBytes || classBytes.length == 0) {
            throw new ClassNotFoundException("Can not load the class" + name);
        }
        return this.defineClass(name, classBytes, 0, classBytes.length);
    }

    private byte[] readClassBytes(String name) throws ClassNotFoundException {
        String classPath = name.replace(".", "/");
        Path classFullPath = classDir.resolve(Paths.get(classPath + ".class"));
        if (!classFullPath.toFile().exists()) {
            throw new ClassNotFoundException("class " + name + "not found.");
        }
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            Files.copy(classFullPath, baos);
            return baos.toByteArray();
        } catch (IOException e) {
            throw new ClassNotFoundException("load the class error");
        }
    }

    @Override
    public String toString() {
        return "My ClassLoader";
    }
}
