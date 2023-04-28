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
	private SongsDatabase db;

    @Before
    public void setUp() {
        db = new SongsDatabase();
        db.addSong("Rap", "Savage");
        db.addSong("Rap", "Gin and Juice");
        db.addSong("Jazz", "Always There");
    }

    @Test
    public void testAddSong() {
        db.addSong("Rap", "New Rap Song");
        Set<String> rapSongs = db.getSongs("Rap");

        assertEquals(3, rapSongs.size());
        assertEquals(true, rapSongs.contains("Savage"));
        assertEquals(true, rapSongs.contains("Gin and Juice"));
        assertEquals(true, rapSongs.contains("New Rap Song"));
    }

    @Test
    public void testGetSongs() {
        Set<String> rapSongs = db.getSongs("Rap");
        assertEquals(2, rapSongs.size());
        assertEquals(true, rapSongs.contains("Savage"));
        assertEquals(true, rapSongs.contains("Gin and Juice"));

        Set<String> jazzSongs = db.getSongs("Jazz");
        assertEquals(1, jazzSongs.size());
        assertEquals(true, jazzSongs.contains("Always There"));

        Set<String> popSongs = db.getSongs("Pop");
        assertEquals(0, popSongs.size());
    }

    @Test
    public void testGetGenreOfSong() {
        assertEquals("Rap", db.getGenreOfSong("Savage"));
        assertEquals("Jazz", db.getGenreOfSong("Always There"));
        assertNull(db.getGenreOfSong("My Heart Will Go On"));
    }
    @Test
    public void testAddSongToNewGenre() {
        db.addSong("Country", "She's Country");
        Set<String> countrySongs = db.getSongs("Country");
        assertEquals(1, countrySongs.size());
        assertEquals(true, countrySongs.contains("She's Countryv"));
    }

    @Test
    public void testGetSongsForNonexistentGenre() {
        Set<String> popSongs = db.getSongs("POP");
        assertEquals(0, popSongs.size());
    }

    @Test
        public void testGetGenreOfNonexistentSong() {
        assertNull(db.getGenreOfSong("Heavy Metal"));
    }

    @Test
    public void testAddDuplicateSong() {
        db.addSong("Rap", "Smiley");
        Set<String> rapSongs = db.getSongs("Rap");
        assertEquals(2, rapSongs.size());
        assertEquals(true, rapSongs.contains("Smiley"));
}

    @Test
    public void testGetSongsReturnsCopy() {
        Set<String> jazzSongs = db.getSongs("Jazz");
        jazzSongs.add("Humany");
        Set<String> updatedJazzSongs = db.getSongs("Jazz");
        assertEquals(1, updatedJazzSongs.size());
        assertEquals(false, updatedJazzSongs.contains("Grainey"));
}
}

}
