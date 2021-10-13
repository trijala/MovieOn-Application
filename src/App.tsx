import React, { useState, useEffect } from "react";
import "./App.css";
import ReactDOM from "react-dom";
import { BrowserRouter as Router, Switch, Route } from "react-router-dom";
import axios from "axios";
import { Header } from "./Components/header";
import { Search } from "./Components/searchbar";
import { Movie } from "./api";

import { MoviesContext } from "./Mov-context";
import { MovieList } from "./Components/MovieList";

import { Favorites } from "./Components/Favorites";

import Home from "./Home";
import Login from "./Login";
import SearchResults from "./SearchResults";

function App() {
  // useEffect(() => {
  //   getMovies({}).then(setMovies);
  // }, []);
  //
  // const [movies, setMovies] = useState<Movie[]>([]);
  // const [favorites, setfavorites] = useState<Movie[]>([]);
  //
  // var addFavouriteMovie = (movie: Movie) => {
  //   var newFavoriteList = [...favorites, movie];
  //   setfavorites(newFavoriteList);
  // };

  return (
    <Router>
      <div className="bg-black h-full">
        <Switch>
          <Route path={"/login"}>
            <Login></Login>
          </Route>
          <Route path={"/favorites"}>
            <Header></Header>
            <Favorites></Favorites>
          </Route>
          <Route path={"/searchResults"}>
            <Header></Header>
            <SearchResults></SearchResults>
          </Route>
          <Route key="Home" exact={false} path={"/"}>
            <Header></Header>
            <Home></Home>
          </Route>
        </Switch>
      </div>
    </Router>
    //   <MoviesContext.Provider value={{ movies, updateMovies: setMovies }}>
    //     <div className="App">
    //       <Header></Header>
    //
    //       <MovieList onClick={addFavouriteMovie}></MovieList>
    //     </div>
    //   </MoviesContext.Provider>
  );
}

export default App;

// class App extends React.Component {
//   render() {
//     const [movies, setMovies] = useState<Movie[]>([]);
//
//     useEffect(() => {
//       getMovies()
//         .then(setMovies)
//         .catch((_) => setMovies([]));
//     }, []);
//     // axios
//     //   .get<any>("http://www.omdbapi.com/?s=star wars&apikey=c6fd20c1", {
//     //   headers: {
//     //     "Content-Type": "application/json"
//     //   }})
//     //   .then(response => {
//     //    const movieList = response.data.Search;
//     //     // console.log((movieList))
//     //     setMovies(movieList);
//     //   });
//     // },[searchval]);
//
//
//     // @ts-ignore
//     return (
//       <MoviesContext.Provider value={{ movies, updateMovies: setMovies }}>
//       <div className="App">
//         <div className={"head"}>
//
//           <Header></Header>
//         </div>
//       </div>
//     );
//   }
// }
//
// export default App;
