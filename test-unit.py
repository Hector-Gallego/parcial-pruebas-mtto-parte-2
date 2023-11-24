import unittest
from unittest.mock import patch
from genre_controller import GenreController

class GenreControllerTest(unittest.TestCase):

    @patch('genre_controller.GenreService')
    def setUp(self, MockGenreService):
        self.genre_service = MockGenreService.return_value
        self.genre_controller = GenreController(self.genre_service)

    def test_get_all_genres(self):
        # Mocking
        genres = [Genre(), Genre()]
        self.genre_service.get_all.return_value = genres

        # Test
        response = self.genre_controller.get_all_genres()

        # Verificación
        self.assertEqual(response.status, 200)
        self.assertEqual(response.body, genres)

    # Otros métodos de prueba

if __name__ == '__main__':
    unittest.main()
