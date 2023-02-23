import business.DeliveryService;
import presentation.LoginView;
import presentation.*;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        LoginView loginView=new LoginView();
        DeliveryService deliveryService=new DeliveryService();
        deliveryService.createMenuSet();

        Controller controller=new Controller(loginView,deliveryService);
    }
}
