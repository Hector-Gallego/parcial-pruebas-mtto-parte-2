use PHPUnit\Framework\TestCase;
use Mockery\MockInterface;
use Mockery;

class GenreControllerTest extends TestCase {

    /** @var IGenreService|MockInterface */
    private $genreService;

    /** @var GenreController */
    private $genreController;

    public function setUp(): void {
        $this->genreService = Mockery::mock(IGenreService::class);
        $this->genreController = new GenreController($this->genreService);
    }

    public function testGetAllGenres() {
        // Mocking
        $genres = [new Genre(), new Genre()];
        $this->genreService->shouldReceive('getAll')->andReturn($genres);

        // Test
        $response = $this->genreController->getAllGenres();

        // Verificación
        $this->assertEquals(200, $response->getStatusCode());
        $this->assertEquals($genres, $response->getBody());
    }

    // Otros métodos de prueba

    protected function tearDown(): void {
        Mockery::close();
    }
}
