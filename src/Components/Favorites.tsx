import * as React from "react";
import { useState, useContext, useEffect } from "react";
import "./favorites.css";
import { Movie } from "../api";
import {
  deleteFavorite,
  getFavorites,
  getMovieById,
  getMovies,
} from "../services/services";

export const Favorites = () => {
  const [favorites, setFavorites] = useState<Movie[]>([]);
  useEffect(() => {
    getFavorites({
      params: {
        userId: 1,
      },
    }).then(setFavorites);
  }, []);
  const handleOnClick = (e: React.MouseEvent<HTMLButtonElement>, mId: any) => {
    e.preventDefault();
    deleteFavorite({
      params: {
        movieId: mId,
      },
    }).then(alert("Deleted from Favorites"));
  };

  // useEffect(() => {
  //   handleOnClick(e, mId);
  // }, [handleOnClick(e: React.MouseEvent<HTMLButtonElement>,mId: any)]);

  return (
    <div className="flex flex-col-reverse justify-around">
      {favorites.map((movie) => (
        <div
          className="relative w-325px m-4 cursor-pointer transition-all ease-in-out duration-500"
          key={movie.id}
        >
          <div className="flex overflow-y-hidden">
            <img
              style={{ width: 325, transition: "ease-in" }}
              src={movie.poster}
              alt={movie.title}
            />
            <h3 className="text-white float-right w-3/5 pl-6 pt-4">
              {movie.description}
            </h3>
          </div>
          <div className="flex items-center w-325px p-4 bg-green-500 justify-between">
            <div className="text-black ">{movie.title}</div>
            <button
              className="ant-btn-text"
              value="add"
              onClick={(e) => handleOnClick(e, movie.id)}
            >
              Remove
            </button>
          </div>
        </div>
      ))}
    </div>
  );
};
