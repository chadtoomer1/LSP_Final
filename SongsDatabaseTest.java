package howard.edu.lsp.finals.problem;
import org.junit.Test;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import static org.junit.Assert.*;

import static org.junit.jupiter.api.Assertions.*;


class SongsDatabaseTest {
	@Test
    public void testSongsDatabase() {
		SongsDatabase db = new SongsDatabase();
		
	    db.addSong("Rap", "Savage");
	    db.addSong("Rap", "Gin and Juice");
	    db.addSong("Jazz", "Always There");
	    db.addSong("Rap", "Smiley");
	    db.addSong("Rap", "Manute bol");
	    db.addSong("Jazz", "Fly me through the moon");

	    Set<String> rapSongs = db.getSongs("Rap");
	    assertTrue(rapSongs.contains("Savage"));
	    assertTrue(rapSongs.contains("Gin and Juice"));
	    assertFalse(rapSongs.contains("Always There"));
	    assertEquals("Rap", db.getGenreOfSong("Savage"));
	    assertEquals("Jazz", db.getGenreOfSong("Always There"));
	    assertNull(db.getGenreOfSong("Hotel California"));
	    System.out.println(db.getGenreOfSong("Savage")); // prints "Rap"
	    System.out.println(db.getGenreOfSong("Always There")); // prints "Jazz"
	    assertTrue(rapSongs.contains("Smiley"));
	    assertTrue(rapSongs.contains("Manute bol"));
	    assertFalse(rapSongs.contains("Fall away"));
	    assertEquals("Rap", db.getGenreOfSong("Smiley"));
	    assertEquals("Jazz", db.getGenreOfSong("Fly me through the moon"));
	    assertNull(db.getGenreOfSong("Highway to hell"));

}

}
