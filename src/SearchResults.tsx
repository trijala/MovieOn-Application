import React from "react";
import { useLocation } from "react-router-dom";
import { Movie2 } from "./api";
import { HeartFilled } from "@ant-design/icons";
import { Tooltip, Button } from "antd";
import { addFavorite } from "./services/services";

interface CustomizedState {
  searchResults: Movie2[];
}

function SearchResults() {
  const location = useLocation();
  const state = location.state as CustomizedState;
  const { searchResults } = state;

  return (
    <div className="flex flex-wrap justify-around">
      {searchResults.map((movie) => (
        <div
          className="relative border-2 h-full w-325px m-4 cursor-pointer transition-all ease-in-out duration-300"
          key={movie.id}
        >
          <div className="flex relative overflow-y-hidden">
            <img
              className=" transition-all ease-in duration-200 hover:opacity-30 scale-100"
              src={movie.picture}
              alt={movie.title}
            />
            <div className="top-0 opacity-0 p-2 absolute text-white bg-black transition-all ease-in duration-300 hover:opacity-100 overflow-y-scroll">
              {movie.resume}
            </div>
          </div>
          <div className="flex items-center w-325px p-4 bg-green-500 justify-between">
            <div className="text-black overflow-x-scroll">{movie.title}</div>
            <Button className="ant-btn-text" value="add">
              <HeartFilled style={{ fontSize: 20, color: "black" }} />
            </Button>
          </div>
        </div>
      ))}
    </div>
  );
}

export default SearchResults;
