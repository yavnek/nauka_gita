import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class SuperheroesDownloader {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://mdn.github.io/learning-area/javascript/oojs/json/superheroes.json");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            int responseCode = conn.getResponseCode();

            if (responseCode != 200) {
                System.err.println("Błąd pobierania pliku JSON. Kod HTTP: " + responseCode);
                return;
            }

            String jsonText = "";
            Scanner scanner = new Scanner(url.openStream());
            while (scanner.hasNext()) {
                jsonText += scanner.nextLine();
            }
            scanner.close();

            System.out.println(jsonText);
        } catch (Exception e) {
            System.err.println("Wystąpił błąd: " + e.getMessage());
        }
    }
}

