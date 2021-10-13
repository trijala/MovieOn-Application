import React, { useEffect, useState } from "react";
import { Header } from "./Components/header";
import { Movie } from "./api";
import { addFavorite, getMovies } from "./services/services";
import { MovieList } from "./Components/MovieList";
import { HeartFilled } from "@ant-design/icons";
import * as events from "events";

function Home() {
  const [movies, setMovies] = useState<Movie[]>([]);
  useEffect(() => {
    getMovies({}).then(setMovies);
  }, []);

  const handleOnClick = (e: React.MouseEvent<HTMLButtonElement>, mId: any) => {
    addFavorite({
      body: JSON.stringify({
        favId: 1,
        isFavorite: true,
        movieId: mId,
        userId: 1,
      }),
    }).then(alert("Added to favorites!!"));
  };

  // const [favorites, setfavorites] = useState<Movie[]>([]);
  //
  // var addFavouriteMovie = (movie: Movie) => {
  //   var newFavoriteList = [...favorites, movie];
  //   setfavorites(newFavoriteList);
  // };
  return (
    <div className="flex flex-wrap justify-around">
      {movies.map((movie) => (
        <div
          className="relative border-2 h-full w-325px m-4 cursor-pointer transition-all ease-in-out duration-300"
          key={movie.id}
        >
          <div className="flex relative  overflow-y-hidden">
            <img
              className=" transition-all ease-in duration-200 hover:opacity-30 scale-100"
              src={movie.poster}
              alt={movie.title}
            />
            <div className="top-0 opacity-0 p-2 absolute text-white bg-black transition-all ease-in duration-300 hover:opacity-100">
              {movie.description}
            </div>
          </div>
          <div className="flex items-center w-325px p-4 bg-green-500 justify-between">
            <div className="text-black overflow-x-scroll">{movie.title}</div>

            <button
              className="ant-btn-text"
              value="add"
              onClick={(e) => handleOnClick(e, movie.id)}
            >
              <HeartFilled style={{ fontSize: 20, color: "black" }} />
            </button>
          </div>
        </div>
      ))}
    </div>
  );
}

export default Home;
