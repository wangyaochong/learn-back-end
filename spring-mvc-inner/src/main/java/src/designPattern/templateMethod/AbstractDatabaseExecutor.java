package src.designPattern.templateMethod;

public abstract class AbstractDatabaseExecutor {
    abstract void openConnection();

    abstract String getResultSet();

    abstract void closeConnection();

    public final void execute() {
        openConnection();
        getResultSet();
        closeConnection();
    }

}
