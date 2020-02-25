public class Tamagotchi {

    private String name;
    private boolean gender;
    private int age;
    private boolean dirtyness;
    private boolean hunger;
    private boolean sleepiness;
    private boolean alive;
    private boolean entertainment;
    private int love;
    private Animation picture;
    private static final int limitedAge = 5;
    private static final int pointsLoveDecrease = 5;
    private static final int pointsLoveIncrease = 5;

    public Tamagotchi(String name, boolean gender) {
        this.name = name;
        this.gender = gender;
        age = 0; // 5 possible age: 1- egg -> 5- dead
        dirtyness = false;
        hunger = false;
        sleepiness = false;
        alive = true;
        entertainment = false;
        love = 100;
        picture = new Animation();
    }

    @Override
    public String toString() {
        return "Tamagotchi{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                ", dirtyness=" + dirtyness +
                ", hunger=" + hunger +
                ", sleepiness=" + sleepiness +
                ", alive=" + alive +
                ", entertainment=" + entertainment +
                ", picture=" + picture +
                '}';
    }

    public String getPictureAge(){
        String pic = "";
        switch (age){
            case 0:
                pic = "tamaEgg";
                break;
            case 1:
                pic = "tamaBaby";
                break;
            case 2:
                pic = "tamaChild1";
                break;
            case 3:
                pic = "tamaAdult1";
                break;
            case 4:
                pic = "tamaAdult2";
                break;
            case 5:
                pic = "tamaDead";
                break;

        }
        return pic + ".gif";
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isDirtyness() {
        return dirtyness;
    }

    public void setDirtyness(boolean dirtyness) {
        this.dirtyness = dirtyness;
    }

    public boolean isHunger() {
        return hunger;
    }

    public void setHunger(boolean hunger) {
        this.hunger = hunger;
    }

    public boolean isSleepiness() {
        return sleepiness;
    }

    public void setSleepiness(boolean sleepiness) {
        this.sleepiness = sleepiness;
    }

    public static int getLimitedAge() {
        return limitedAge;
    }

    public Animation getPicture() {
        return picture;
    }

    public void setPicture(String nameAndExtension) {
        this.picture.setPicture(nameAndExtension);
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public boolean isEntertainment() {
        return entertainment;
    }

    public void setEntertainment(boolean entertainment) {
        this.entertainment = entertainment;
    }

    public int getLove() {
        return love;
    }

    public void decreaseLove() {
        this.love = this.love - pointsLoveDecrease;
    }

    public void increaseLove() {
        this.love = this.love + pointsLoveIncrease;
    }
}
