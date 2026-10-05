package ge.edu.ug.patterns.structural.proxy.dbservice;

// Protection Proxy: forwards the call only when the caller's token is valid
public class TokenProxy implements IDbService {
    private static final String VALID_TOKEN = "secret-token";

    private final IDbService service;
    private final String token;

    public TokenProxy(IDbService service, String token) {
        this.service = service;
        this.token = token;
    }

    @Override
    public void saveData(String data) {
        if (!VALID_TOKEN.equals(token)) {
            throw new SecurityException("Invalid token");
        }
        service.saveData(data);
    }
}
