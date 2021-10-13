import * as React from "react";
import { useState, useContext } from "react";
import "./search.css";
import { Movie2, searchMovies } from "../api";
import { MoviesContext } from "../Mov-context";
import { useHistory } from "react-router-dom";

export const Search = () => {
  const [search, setSearch] = useState("");
  const [searchResults, setSearchResults] = useState<Movie2[]>([]);
  // const { updateMovies } = useContext(MoviesContext);
  const history = useHistory();

  const handleOnSubmit = (event: React.FormEvent) => {
    event.preventDefault();
    if (search) {
      searchMovies(search)
        .then((movies) => {
          setSearchResults(movies);
        })
        .then(() => {
          history.push("/searchResults", {
            searchResults: searchResults,
          });
        });
    }
  };

  return (
    <div>
      <form name="form" onSubmit={(e) => handleOnSubmit(e)} noValidate>
        <input
          type="text"
          name="movie"
          className="search__input"
          placeholder="Search movie "
          value={search}
          onChange={(e) => setSearch(e.target.value)}
        />
      </form>
    </div>
  );
};
