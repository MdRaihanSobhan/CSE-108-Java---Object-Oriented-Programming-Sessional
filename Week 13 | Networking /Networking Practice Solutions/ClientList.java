import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ClientList implements Serializable {
    private List<String> clientList;
    private String from;
    private String to;

    ClientList(){
        clientList=new ArrayList<>();
    }

    public List<String> getClientList() {
        return clientList;
    }

    public void setClientList(List<String> clientList) {
        this.clientList = clientList;
    }

}
