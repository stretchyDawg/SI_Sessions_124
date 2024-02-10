package si.session_activities.mock_practicums.test01.magic_test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Quidditch extends Student {
    private Position position;

    public Quidditch(String name, House house, Position position){
        super(name, house);
        this.position = position;
    }

    public Position getPosition(){
        return this.position;
    }

    // Special Functions:
    public boolean equals(Object obj){
        if(obj instanceof Quidditch){
            Quidditch other = (Quidditch)(obj);
            return (this.position == other.position);
        }
        else{
            return false;
        }
    }

    public String toString(){
        return this.getName() + ", a " + this.getYearString() + " year " + this.position.getPositionString() + " for the " + this.getHouse().getHouseString() + " Quidditch team.";
    }

    //Array Function
    public static Quidditch[] arrayOfPlayers() throws IOException{
        try(FileReader fr = new FileReader("roster.txt"); BufferedReader br = new BufferedReader(fr);){
            String line = br.readLine();
            int length = Integer.parseInt(line);
            Quidditch[] players = new Quidditch[length];

            for(int i = 0; i < players.length; i++){
                line = br.readLine();
                String[] splitLine = line.split("[,]");

                String name = splitLine[0];
                String position = splitLine[1];
                String house = splitLine[2];
                int year = Integer.parseInt(splitLine[3]);

                Position realPosition = Position.BEATER;
                if(position.equals("Beater")){
                    realPosition = Position.BEATER;
                }
                else if(position.equals("Chaser")){
                    realPosition = Position.CHASER;
                }
                else if(position.equals("Keeper")){
                    realPosition = Position.KEEPER;
                }
                else if(position.equals("Seeker")){
                    realPosition = Position.SEEKER;
                }

                House realHouse = House.GRYFFINDOR;
                if(house.equals("Gryffindor")){
                    realHouse = House.GRYFFINDOR;
                }
                else if(house.equals("Hufflepuff")){
                    realHouse = House.HUFFLEPUFF;
                }
                else if(house.equals("Ravenclaw")){
                    realHouse = House.RAVENCLAW;
                }
                else if(house.equals("Slytherin")){
                    realHouse = House.SLYTHERIN;
                }

                Quidditch player = new Quidditch(name, realHouse, realPosition);
                if(year > 1){
                    for(int j = 0; j < (year-1); j++){
                        player.advanceYear();
                    }
                }

                players[i] = player;
            }
            return players;

        }
    }
}
