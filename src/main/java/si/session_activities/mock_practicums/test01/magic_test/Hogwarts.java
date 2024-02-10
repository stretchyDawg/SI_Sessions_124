package si.session_activities.mock_practicums.test01.magic_test;

import java.io.IOException;

public class Hogwarts {
    public static void main(String[] args) throws IOException{
        Student harry = new Student("Harry Potter", House.GRYFFINDOR);
        harry.advanceYear();
        System.out.println(harry);

        Quidditch roger = new Quidditch("Roger Davies", House.RAVENCLAW, Position.CHASER);
        for(int i = 0; i < 5; i++){
            roger.advanceYear();
        }
        System.out.println(roger);

        Quidditch[] players = Quidditch.arrayOfPlayers();
        for(int i = 0; i < players.length; i++){
            System.out.println(players[i]);
        }
    }
}
