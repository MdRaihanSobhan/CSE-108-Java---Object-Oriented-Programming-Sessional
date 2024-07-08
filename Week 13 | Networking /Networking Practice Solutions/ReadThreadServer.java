
import util.NetworkUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReadThreadServer implements Runnable {
    private Thread thr;
    private NetworkUtil networkUtil;
    public HashMap<String, NetworkUtil> clientMap;


    public ReadThreadServer(HashMap<String, NetworkUtil> map, NetworkUtil networkUtil) {
        this.clientMap = map;
        this.networkUtil = networkUtil;
        this.thr = new Thread(this);
        thr.start();
    }

    public void run() {
        try {
            while (true) {
                Object o = networkUtil.read();
                if (o instanceof Message) {
                    Message obj = (Message) o;
                    if(!obj.isItBroadcast()){
                        String to = obj.getTo();
                        NetworkUtil nu = clientMap.get(to);
                        if (nu != null) {
                            nu.write(obj);
                        }
                    }
                    else{
                        for(Map.Entry<String,NetworkUtil> i: clientMap.entrySet()){
                            if(!i.getKey().equals(obj.getFrom())){
                                i.getValue().write(obj);
                            }
                        }
                    }
                }
                else if(o instanceof ClientList){

                }
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



