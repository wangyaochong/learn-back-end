package src.designPattern.templateMethod;

public class OracleDatabaseExecutor extends AbstractDatabaseExecutor {
    @Override
    void openConnection() {
        System.out.println("Oracle open");
    }

    @Override
    String getResultSet() {
        System.out.println("Oracle get result");
        return "Oracle result";
    }

    @Override
    void closeConnection() {
        System.out.println("Oracle close");
    }
}
