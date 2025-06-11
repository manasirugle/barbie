package exception;

public class SetText {

    public static void main(String[] args) {

//        try{
//           throw  new CustomException ("this is a custom exception");
//        }
//        catch(CustomException ex){
//            System.out.println("Found you");
//            System.out.println(ex.getMessage());
//        }

        String nameFromFunction = getName();
        System.out.println("Name from database : " + nameFromFunction);

    }

    public static String getName() {
        try {
            String name = getNameFromDatabase();
            return name;
        } catch (Exception ex) {
            System.out.println("Exception occurred while calling function");
        } finally {
            return "Mita";
        }
    }

    public static String getNameFromDatabase() {
        try {
            throw new CustomException("this is a custom exception");
        } catch (Exception ex) {
            System.out.println("Custom Exception occurred");
        }
        return "Manasi";
    }

}
