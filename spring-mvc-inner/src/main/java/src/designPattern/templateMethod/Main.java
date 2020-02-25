package src.designPattern.templateMethod;

public class Main {
    public static void main(String[] args) {
        AbstractDatabaseExecutor mysqlExecutor = new MySqlDatabaseExecutor();
        mysqlExecutor.execute();

        AbstractDatabaseExecutor OracleExecutor = new OracleDatabaseExecutor();
        OracleExecutor.execute();
    }
}
