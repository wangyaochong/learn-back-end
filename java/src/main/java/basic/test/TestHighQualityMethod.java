package basic.test;

import cn.hutool.core.lang.TypeReference;

import java.lang.reflect.Type;
import java.util.concurrent.Callable;
import java.util.function.Consumer;

public class TestHighQualityMethod {
    static class MethodTemplate {
        public static <T> T execute(Callable<String> parameterCheck, Callable<T> method, Consumer<Throwable> exceptionHandler) {
            try {
                String call = parameterCheck.call();
                if (call != null) {

                } else {
                    return method.call();
                }
            } catch (Exception e) {
                exceptionHandler.accept(e);
            }
            return null;
        }
         public static <T> T execute(Callable<String> parameterCheck, Callable<T> method) {
            try {
                String call = parameterCheck.call();
                if (call != null) {
                    throw new RuntimeException("参数错误");
                } else {
                    return method.call();
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }


    static abstract class MethodWrapper {
        protected String checkParameter() {
            throw new RuntimeException("not implemented");
        }

        protected void execute() {
            throw new RuntimeException("not implemented");
        }

        protected void handleException(Exception e) {
            throw new RuntimeException(e);
        }

        MethodWrapper() {
            try {
                String checkResult = checkParameter();
                if (checkResult != null) {
                    throw new RuntimeException("checkParameter failed," + checkResult);
                }
                execute();
            } catch (Exception e) {
                handleException(e);
            }
        }
    }

    public static void main(String[] args) {

        int paramMethod = 1;
        MethodTemplate.execute(() -> {
            return paramMethod == 0 ? "参数错误" : null;
        }, () -> {
            System.out.println("method execute");
            return null;
        });
    }
}
