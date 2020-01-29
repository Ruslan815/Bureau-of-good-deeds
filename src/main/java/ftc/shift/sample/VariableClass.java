package ftc.shift.sample;

public class VariableClass {
    private static int id = 0;

    public static String getAvailableId(){
        return String.valueOf(++id);
    }
}
