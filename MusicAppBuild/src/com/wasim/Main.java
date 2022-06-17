package com.wasim;
import java.util.*;

public class Main {

    private static ArrayList<Album>albums = new ArrayList<>();

    public static void main(String[] args){

        Album album  = new Album("Album1", "AC/DC");

        album.addSong("TnT", 5.0);
        album.addSong("Medicine of Life ", 4.5);
        album.addSong("White House", 3.0);
        album.addSong("Black Hole", 4.5);
        album.addSong("What is life ", 5.0);
        albums.add(album);

        album = new Album("Album2", "Arijit Singh");
        album.addSong("Hey how are you ", 3.6);
        album.addSong("How are you ", 4.6);
        album.addSong("Life is a race ", 5.2);

        albums.add(album);

        LinkedList<Song> PlayList_1 = new LinkedList<>();
        albums.get(0).addToPlayList("TnT", PlayList_1);
        albums.get(0).addToPlayList("Medicine of Life", PlayList_1);
        albums.get(1).addToPlayList("Hey how are you", PlayList_1);
        albums.get(1).addToPlayList("Life is a race", PlayList_1);

        play(PlayList_1);
    }


    public static void play(LinkedList<Song>PlayList){
        Scanner sc = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> listIterator = PlayList.listIterator() ;

        if(PlayList.size() == 0){
            System.out.println("There is no songs in PlayList");
        }else{
            System.out.println("Now playing " + listIterator.next().toString());
            PrintManu();
        }

        while(!quit){
            int action = sc.nextInt();
            sc.nextLine();

            switch(action){
                case 0 :
                    System.out.println("PlayList complete ");
                    quit = true;
                    break;

                case 1:
                    if(!forward){
                        if(listIterator.hasNext()){
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if(listIterator.hasNext()){
                        System.out.println("Now playing " + listIterator.next().toString());
                    }else{
                        System.out.println("No songs are available , reached to the ends of the list ");
                        forward = false;
                    }
                    break;

                case 2 :
                    if(forward){
                        if(listIterator.hasPrevious()){
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if(listIterator.hasPrevious()){
                        System.out.println("Now playing " + listIterator.previous().toString());
                    }else{
                        System.out.println("We are the first songs ");
                        forward = false;
                    }
                    break;

                case 3:
                    if(forward){
                        if(listIterator.hasPrevious()){
                            System.out.println("Now Playing : " + listIterator.previous().toString());
                            forward = false;
                        }else{
                            System.out.println("We are at the start at the List ");
                        }
                    }else{
                       if(listIterator.hasNext()){
                           System.out.println("Now playing : " + listIterator.next().toString());
                           forward = true;
                       }else{
                           System.out.println("We have reached to the end of the list ");
                       }
                    }
                    break;

                case 4:
                    printList(PlayList);
                    break;

                case 5:
                    PrintManu();
                    break;

                case 6:
                    if(PlayList.size() > 0){
                         listIterator.remove();
                         if(listIterator.hasNext()){
                             System.out.println("Now playing " + listIterator.next().toString());
                         }
                         else{
                             if(listIterator.hasPrevious());
                             System.out.println("now playing " + listIterator.previous().toString());

                         }
                    }


            }

        }
    }


    private static void PrintManu(){
        System.out.println("Available Option \n  Press");
        System.out.println(" 0 - > to quit \n "+
                            " 1 - > to play Next Song \n" +
                             " 2 -> to play Previous Song \n" +
                             " 3 -> to replay the current song \n " +
                             " 4 -> List of all songs  \n" +
                              " 5 -> print all available options  \n" +
                              " 6 -> delete current songs ");
    }
    private static void printList(LinkedList<Song>PlayList){
        Iterator<Song> iterator =  PlayList.iterator();
        System.out.println(" ----------------------------  ");

        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        System.out.println(" ----------------------------- ");
    }

}
