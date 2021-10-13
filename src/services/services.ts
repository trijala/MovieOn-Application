import { GET, POST, PUT, DELETE } from "./request";

export const getMovies = GET("/api/v1/movies");
export const getMovieById = GET(({ id }) => `/api/v1/movies/${id}`);
export const getFavorites = GET("/api/v1/favorites");
export const addFavorite = POST("/api/v1/favorites");
export const deleteFavorite = DELETE("/api/v1/favorites");
