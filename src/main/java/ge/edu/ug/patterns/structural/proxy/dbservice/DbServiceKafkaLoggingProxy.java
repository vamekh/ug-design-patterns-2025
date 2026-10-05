package ge.edu.ug.patterns.structural.proxy.dbservice;

// Logging Proxy: logs, then delegates to the wrapped service (another proxy or DbService)
public class DbServiceKafkaLoggingProxy implements IDbService {

    private final IDbService service;

    public DbServiceKafkaLoggingProxy(IDbService service) {
        this.service = service;
    }

    @Override
    public void saveData(String data) {
        System.out.println("logging info to kafka");
        service.saveData(data);
    }
}
