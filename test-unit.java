import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class GenreControllerTest {

    @Mock
    private IGenreService genreService;

    @InjectMocks
    private GenreController genreController;

    @Test
    public void testGetAllGenres() {
        // Mocking
        List<Genre> genres = Arrays.asList(new Genre(), new Genre());
        when(genreService.getAll()).thenReturn(genres);

        // Test
        ResponseEntity<List<Genre>> response = genreController.getAllGenres();

        // Verificación
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(genres, response.getBody());
    }

}
