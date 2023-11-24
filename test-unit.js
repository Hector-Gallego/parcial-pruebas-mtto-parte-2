const { getAllGenres, getGenreById, createGenre, updateGenre, deleteGenre } = require('./GenreController');
const GenreService = require('./GenreService');

jest.mock('./GenreService');

describe('GenreController', () => {
    test('getAllGenres', () => {
        // Mocking
        const genres = [new Genre(), new Genre()];
        GenreService.prototype.getAll.mockReturnValue(genres);

        // Test
        const response = getAllGenres();

        // Verificación
        expect(response.status).toBe(200);
        expect(response.body).toEqual(genres);
    });

});
