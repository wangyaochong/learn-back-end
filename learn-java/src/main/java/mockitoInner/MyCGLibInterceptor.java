package mockitoInner;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class MyCGLibInterceptor implements MethodInterceptor {

    @Override
    public Object intercept(final Object obj, final Method method, final Object[] args, final MethodProxy proxy) throws Throwable {
        final MethodInfo key = new MethodInfo(this, method, args);
//        final MethodInfo key = new MethodInfo();
        final boolean hasMocked = MyMockito.MOCKED_METHODS.containsKey(key);
        if (!hasMocked) {
            // When called for the first time (by MyMockito.when(...)),
            // return a MethodInfo object used as key,
            // so that the later MethodInfo.thenReturn(...) will use this key
            // to insert mock result into the MyMockito.MOCKED_METHODS.
            System.out.println("Initializing the mock for " + key.toString());
            return key;
        } else {
            // Now that MyMockito.MOCKED_METHODS already contains the mock result
            // for this method call, just return the mock result.
            System.out.println("Returns the mock result:");
            return MyMockito.MOCKED_METHODS.get(key);
        }
    }

    public Object getInstance(final Class<?> t) {
        final Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(t);
        enhancer.setCallback(this);
        return enhancer.create();
    }

}
