package composition.application;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import composition.entities.Comment;
import composition.entities.Post;

public class MainPost {

	public static void main(String[] args) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

		Comment c1 = new Comment("Have a nice trip!");
		Comment c2 = new Comment("How that's awesome!");

		Post p1 = new Post(sdf.parse("21/02/2024 12:03:43"), "Traveling to New York",
				"I'm going to visit this wonderful city!", 1329);

		p1.addComment(c1);
		p1.addComment(c2);

		Comment c3 = new Comment("Good night");
		Comment c4 = new Comment("May the Force be with you");

		Post p2 = new Post(sdf.parse("15/12/2023 23:26:12"), "Good night guys", "See you tomorrow", 18);

		p2.addComment(c3);
		p2.addComment(c4);

		System.out.println(p1);
		System.out.println(p2);

	}

}
