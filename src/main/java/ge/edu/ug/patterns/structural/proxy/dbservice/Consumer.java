package ge.edu.ug.patterns.structural.proxy.dbservice;

public class Consumer {
    DbService service;

    public Consumer(DbService service) {
        this.service = service;
    }

    public void saveData(String data) {
        service.saveData(data);
    }
}
