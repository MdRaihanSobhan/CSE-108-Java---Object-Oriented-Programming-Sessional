

import util.NetworkUtil;

import java.io.IOException;
import java.util.Scanner;

public class WriteThreadClient implements Runnable {

    private Thread thr;
    private NetworkUtil networkUtil;
    String name;

    public WriteThreadClient(NetworkUtil networkUtil, String name) {
        this.networkUtil = networkUtil;
        this.name = name;
        this.thr = new Thread(this);
        thr.start();
    }

    public void run() {
        try {
            Scanner input = new Scanner(System.in);
            while (true) {
                System.out.println("1. Connect\n" +
                        "2. GetList\n" +
                        "3. SendOne\n" +
                        "4. Broadcast");
                int opt=Integer.parseInt(input.nextLine());
                if(opt==2){

                }
                else if(opt==3){
                    String from = name;
                    networkUtil.write(new ClientList());
                    System.out.println("Whom u want to send msg(Enter Name):");
                    String to=input.nextLine();
                    //
                    System.out.print("Enter the message: ");
                    String text = input.nextLine();
                    Message message = new Message();
                    message.setFrom(from);
                    message.setTo(to);
                    message.setText(text);
                    networkUtil.write(message);
                }
                else if(opt==4){
                    System.out.print("Enter the message: ");
                    String text = input.nextLine();
                    Message message = new Message();
                    message.setFrom(name);
                    message.setTo("All");
                    message.setText(text);
                    message.setBroadcast(true);
                    networkUtil.write(message);
                }
                else continue;
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                networkUtil.closeConnection();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}



