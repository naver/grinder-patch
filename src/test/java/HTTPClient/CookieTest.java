package HTTPClient;


import org.junit.Before;
import org.junit.Test;

import java.net.ProtocolException;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CookieTest {
    RoRequest request;

    @Before
    public void before() {
        request = mock(RoRequest.class);
        HTTPConnection connection = mock(HTTPConnection.class);
        when(connection.getHost()).thenReturn("helloworld.com");
        when(request.getConnection()).thenReturn(connection);
        when(request.getRequestURI()).thenReturn("http://helloworld.com");
    }

    @Test
    public void testCookiePatch() throws ProtocolException {
        final Cookie[] cookies = TestableCookie.doParse("csrftoken=84686b4fe5885713e89a08028d9a06df; Max-Age=31449600; Path=/, sessionid=9ad74e282ddf0fc000c6a55097f27ce9; expires=Thu, 05-Dec-2013 07:18:12 GMT; Max-Age=28800; Path=/;, secure", request);
        assertThat(cookies[cookies.length - 1].isSecure()).isTrue();
    }
}
