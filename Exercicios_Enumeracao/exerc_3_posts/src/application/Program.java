package application;

import java.text.SimpleDateFormat;

import entites.Comment;
import entites.Post;

public class Program {

    public static void main(String[] args) throws Exception {
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        // Adicionando comentários 
        Comment c1 = new Comment("Have a nice trip!");
        Comment c2 = new Comment("Wow that's awesome!");

        // Criando o post
        Post p1 = new Post(sdf.parse("29/01/2022 13:05:44"),
                "Traveling to New Zealand",
                "I'm going to visit this wonderful country!",
                12);

        // Associando os comentários ao post                
        p1.addComment(c1);
        p1.addComment(c2);

        // +++++ NOVO POST +++++

        // Adicionando comentários 
        Comment c3 = new Comment("Good night!");
        Comment c4 = new Comment("May the Force be with you");

        // Criando o post
        Post p2 = new Post(sdf.parse("30/01/2022 23:14:19"),
                "Good night guys",
                "See you tomorrow",
                5);

        // Associando os comentários ao post                
        p2.addComment(c3);
        p2.addComment(c4);

        System.out.println(p1);
        System.out.println(p2);
    }
}
