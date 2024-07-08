import javax.management.StringValueExp;
import java.util.ArrayList;
import java.util.List;

public class Country {

    public String name;
    public List<Player> playerList = new ArrayList();


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    public static List<Country> setCountryList(List<Player> playerList) throws Exception {
        List<Country> countryList = new ArrayList();

        for (Player player : playerList) {
            boolean doesExixt = false;
            for (Country country : countryList) {
                if (country.name.equalsIgnoreCase(player.getCountry())) {
                    doesExixt = true;
                    country.playerList.add(player);
                }
            }

            // if player's country isn't found in present countryList
            if (!doesExixt) {
                Country country = new Country();
                country.setName(player.getCountry());
                country.playerList.add(player);
                countryList.add(country);
            }
        }

        return countryList;
    }
}
