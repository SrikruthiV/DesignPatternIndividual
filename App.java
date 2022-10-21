public class App {

    public static Facade facadeObj = new Facade();
    public static void main(String[] args) {

        if(facadeObj.login()){
            facadeObj.getThePerson().createProductMenu();
            facadeObj.getThePerson().showMenu();
        }
    }
}
