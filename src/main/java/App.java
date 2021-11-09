import model.User;
import repository.UserRepository;

public class App {

    public static void main(String[] args) {
        UserRepository userRepository=new UserRepository();
        User user =new User(1,"Ana Popescu","email","adress");
        userRepository.delete("Ana Popescu");

    }
}
