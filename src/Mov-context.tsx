import React from "react";
import { Movie } from "./api";

export const MoviesContext = React.createContext<{
  movies: Movie[];
  updateMovies: any;
}>({
  movies: [],
  updateMovies: Function,
});