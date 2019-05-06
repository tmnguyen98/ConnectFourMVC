package mvc;

public class ConnectFourTestDrive {
    public static void main(String[] args) {
        ModelInterface model = new ConnectFourModel();
        ControllerInterface controller = new ConnectFourController(model);
    }
    
}