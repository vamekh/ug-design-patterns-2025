package ge.edu.ug.patterns.structural.proxy.dbservice;

// Client: depends on IDbService, does not know how many proxies are in front of DbService
public class Consumer {
    IDbService service;

    public Consumer(IDbService service) {
        this.service = service;
    }

    public void saveData(String data) {
        service.saveData(data);
    }
}
