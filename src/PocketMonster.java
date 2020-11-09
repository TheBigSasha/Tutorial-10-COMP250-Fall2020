import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Random;

public class PocketMonster /*implements Comparable<PocketMonster>*/{
    private static Random rand = new Random();
    private String name;
    private int hp;
    private int damage;
    private boolean isShiny;
    private Type type;

    public PocketMonster(String name, int hp, int damage, boolean isShiny, Type type) {
        this.name = name;
        this.hp = hp;
        this.damage = damage;
        this.isShiny = isShiny;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public boolean isShiny() {
        return isShiny;
    }

    public void setShiny(boolean shiny) {
        isShiny = shiny;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    /**
     * Used for randomization purposes, and testing!
     * Returns a randomized pocketmonster
     * @return a random pocketmonster
     */
    public static PocketMonster createPocketMonster(){
        int HP = rand.nextInt(100) + 5;
        int DMG = rand.nextInt(20) + 5;
        String name = generateName();
        boolean isShiny = rand.nextBoolean();
        int typePick = rand.nextInt(Type.values().length);
        Type type = Type.values()[typePick];
        return new PocketMonster(name, HP, DMG, isShiny, type);
    }

    private static String generateName(){
        try{
            return getNameFromInternet();
        }catch(IOException ex){
            return nextStringOffline();
        }
    }

    private static String nextStringOffline() {
        if (rand == null) {
            rand = new Random(System.nanoTime());
        }
        char[] output = new char[rand.nextInt(15) + 3];
        for (int i = 0; i < output.length; i++) {
            output[i] = (char) rand.nextInt(490);
        }
        return new String(output);
    }

    private static String getNameFromInternet() throws IOException {
        return queryAPI("http://names.drycodes.com/1", true);
    }

    private static String queryAPI(String URLspec, boolean isSingular) throws IOException {
      /*  Runnable r = () -> {queryAPIsync(URLspec, isSingular);};
        Thread t1 = new Thread(r);
        t1.start();*/       //Async system is unnecessarily complex and not needed here
        return queryAPIsync(URLspec, isSingular);
    }

    private static String queryAPIsync(String URLspec, boolean isSingular) throws IOException {

            URL names = new URL(URLspec);
            // Get the input stream through URL Connection
            URLConnection con = names.openConnection();
            InputStream is = con.getInputStream();


            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            String line = null;
            if ((line = br.readLine()) != null) {
                String name = line;
                if (isSingular) name = line.split("_")[0];
                name = name.replace("\"", "");
                name = name.replace("[", "");
                name = name.replace("]", "");
                name = name.replace("_", " ");
                return name;
            }
        throw new IOException("Oops! Query failed! Cant't help being a gemeni");
    }
}

enum Type{
    FIRE, WATER, FLYING, ELECTRIC
}