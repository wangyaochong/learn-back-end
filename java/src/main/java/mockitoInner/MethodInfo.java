package mockitoInner;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Method;
import java.util.Arrays;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MethodInfo {
    private MyCGLibInterceptor interceptor = null;
    private Method method = null;
    private Object[] args = null;

    @Override
    public String toString() {
        return "{interceptor: " + interceptor + ", Method: " + method + ", args: " + Arrays.toString(args) + "}";
    }

    @Override
    public boolean equals(final Object other) {
        if (other instanceof MethodInfo) {
            final MethodInfo otherMethodInfo = (MethodInfo) other;
            return interceptor.equals(otherMethodInfo.interceptor) && method.equals(otherMethodInfo.method) && Arrays.equals(args, otherMethodInfo.args);
        }

        return false;
    }

    @Override
    public int hashCode() {
        return interceptor.hashCode() + method.hashCode() + Arrays.hashCode(args);
    }

}
