import React, {
  FC,
  ChangeEvent,
  useContext,
  useState,
  MouseEventHandler,
} from "react";
import { Movie } from "../api";
import { MoviesContext } from "../Mov-context";
import "./MovieList.css";
import { HeartFilled } from "@ant-design/icons";
import { Card } from "antd";
const { Meta } = Card;

type MovieListprop = {
  onClick: (movie: Movie) => void;
};
export const MovieList: FC<MovieListprop> = function ({
  onClick,
}: MovieListprop) {
  const { movies } = useContext(MoviesContext);

  return (
    <div className="MovieList">
      {movies.map((movie) => (
        <div className="Movie_item" key={movie.id}>
          <div className="item_img">
            <img src={movie.poster} alt={movie.title} />
          </div>
          <div className="Movie_name">
            <div className="name">{movie.title}</div>
            {/*<Card*/}
            {/*  hoverable*/}
            {/*  style={{ width: 300 }}*/}
            {/*  cover={<img alt={movie.title} src={movie.poster} />}*/}
            {/*>*/}
            {/*  <Meta title={movie.title} />*/}

            <button
              className="ant-btn-text"
              type="submit"
              value="add"
              onClick={() => {
                onClick(movie);
              }}
            >
              <HeartFilled style={{ fontSize: 20 }} />
            </button>
          </div>
        </div>
      ))}
    </div>
  );
};
