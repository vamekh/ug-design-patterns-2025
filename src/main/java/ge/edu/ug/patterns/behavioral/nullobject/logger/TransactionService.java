package ge.edu.ug.patterns.behavioral.nullobject.logger;

// Client: always has a Logger, so it can call it without null checks
public class TransactionService {
    private final Logger logger;

    public TransactionService() {
        this(null);
    }

    public TransactionService(Logger logger) {
        this.logger = logger != null ? logger : LoggerNullObject.getInstance();
    }

    public void processTransaction(String transactionId) {
        try {
            if (transactionId == null) {
                throw new IllegalArgumentException("Transaction ID cannot be null");
            }
            logger.warn("Processing transaction: " + transactionId);
            // Process the transaction...
            logger.warn("Transaction completed: " + transactionId);
        } catch (Exception e) {
            logger.log(e);
        }
    }
}
