package ge.edu.ug.patterns.structural.proxy.dbservice;

// Logging Proxy: logs, then delegates to the wrapped service (another proxy or DbService)
public class DbServiceConsoleLoggingProxy implements IDbService {

    private final IDbService service;

    public DbServiceConsoleLoggingProxy(IDbService service) {
        this.service = service;
    }

    @Override
    public void saveData(String data) {
        System.out.println("logging info to console logging system");
        service.saveData(data);
    }
}
