package HTTPClient;

import java.net.ProtocolException;
import java.util.Date;

public abstract class TestableCookie extends Cookie {

    public TestableCookie(String name, String value, String domain, String path, Date expires, boolean secure) {
        super(name, value, domain, path, expires, secure);
    }

    public static Cookie[] doParse(String set_cookie, RoRequest req) throws ProtocolException {
        return Cookie.parse(set_cookie, req);
    }
}
