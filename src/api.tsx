const movieApiBaseUrl = "https://api.themoviedb.org/3";
// const movieApiBaseUrl = "http://www.omdbapi.com/?s=star wars";
const posterBaseUrl = "https://image.tmdb.org/t/p/w300";
const API_KEY = "de2ce901ec120769d784410335f67638";

export function getMovies(): Promise<Movie[]> {
  return fetch(
    `${movieApiBaseUrl}/movie/popular?api_key=${API_KEY}&language=en-US&page=1}`
  )
    .then((res) => res.json())
    .then((response) => mapResult(response.results))
    .catch((_) => {
      return [];
    });
}
export function searchMovies(search: string): Promise<Movie2[]> {
  return fetch(
    `${movieApiBaseUrl}/search/movie?&api_key=${API_KEY}&language=en-US&page=1&query=${search}}`
  )
    .then((res) => res.json())
    .then((response) => mapResult2(response.results))
    .catch((_) => {
      return [];
    });
}

function mapResult(res: any[]): Movie[] {
  return res.map((movie) => {
    const { id, title, vote_average, description, poster, release_date } =
      movie;

    return {
      id,
      title,
      date: release_date,
      rating: vote_average,
      description,
      poster,
    };
  });
}

export interface Movie {
  id: number;
  date: string;
  title: string;
  rating: number;
  description: string;
  poster: string;
}

function mapResult2(res: any[]): Movie2[] {
  return res.map((movie) => {
    const { id, title, vote_average, overview, poster_path, release_date } =
      movie;

    return {
      id,
      title,
      date: release_date,
      rating: vote_average,
      resume: overview,
      picture: poster_path ? `${posterBaseUrl}${poster_path}` : undefined,
    };
  });
}

export interface Movie2 {
  id: number;
  date: string;
  title: string;
  rating: number;
  resume: string;
  picture?: string;
}
