package chebirdou.en.dotscreen.test.game;

/**
 * Created by Assia HACHICHI on 20/06/2022
 */
public class Player {
    private int index;
    private String name;
    private int score;
    private int image ;

    public Player(int index, String name, int score, int image){
        this.index = index;
        this.name = name;
        this.score = score;
        this.image = image;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public int getIndex() {
        return index;
    }
}
