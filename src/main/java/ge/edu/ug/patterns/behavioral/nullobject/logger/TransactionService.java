package ge.edu.ug.patterns.behavioral.nullobject.logger;

// Logging is optional, so the logger may be null and every log call is guarded
// by "if (logger != null)". Each new log statement needs the same check again,
// and one forgotten check means a NullPointerException in the middle of a payment.
public class TransactionService {
    private final Logger logger;

    public TransactionService() {
        this(null);
    }

    public TransactionService(Logger logger) {
        this.logger = logger;
    }

    public void processTransaction(String transactionId) {
        try {
            if (transactionId == null) {
                throw new IllegalArgumentException("Transaction ID cannot be null");
            }
            if (logger != null) {
                logger.warn("Processing transaction: " + transactionId);
            }
            // Process the transaction...
            if (logger != null) {
                logger.warn("Transaction completed: " + transactionId);
            }
        } catch (Exception e) {
            if (logger != null) {
                logger.log(e);
            }
        }
    }
}
