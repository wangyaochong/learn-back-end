package src.designPattern.templateMethod;

public class MySqlDatabaseExecutor extends AbstractDatabaseExecutor {
    @Override
    void openConnection() {
        System.out.println("mysql open");
    }

    @Override
    String getResultSet() {
        System.out.println("mysql get result");
        return "mysql result";
    }

    @Override
    void closeConnection() {
        System.out.println("mysql close");
    }
}
