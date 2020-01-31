package ftc.shift.sample;

public class VariableClass {
    private static int id = 0;
    //private static int id = 100;

    public static String getAvailableId(){
        return String.valueOf(id++);
    }

    public static String getAvailableIdNonIncrement(){
        return String.valueOf(id);
    }
}
