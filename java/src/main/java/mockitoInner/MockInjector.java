package mockitoInner;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MockInjector {
    private MethodInfo methodInfo = null;


    public void thenReturn(final Object mockResult) {
        MyMockito.MOCKED_METHODS.put(methodInfo, mockResult);
    }


}
