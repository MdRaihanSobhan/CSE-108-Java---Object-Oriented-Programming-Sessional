
import util.NetworkUtil;

import java.util.Scanner;

public class Client {

    public Client(String serverAddress, int serverPort) {

        try {
            System.out.print("Enter name of the client: ");
            Scanner scanner = new Scanner(System.in);
            String clientName = scanner.nextLine();
            boolean isconnected=false;
            while(!isconnected) {
                System.out.println("1. Connect\n" +
                        "2. GetList\n" +
                        "3. SendOne\n" +
                        "4. Broadcast");
                int option=Integer.parseInt(scanner.nextLine());
                if(option==1){
                    NetworkUtil networkUtil = new NetworkUtil(serverAddress, serverPort);
                    networkUtil.write(clientName);
                    new ReadThreadClient(networkUtil);
                    new WriteThreadClient(networkUtil, clientName);
                    isconnected=true;
                }
                else{
                    continue;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }



    }


    public static void main(String args[]) {
        String serverAddress = "127.0.0.1";
        int serverPort = 33333;
        Client client = new Client(serverAddress, serverPort);
    }
}


