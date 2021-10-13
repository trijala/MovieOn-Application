import React, { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import { getMovies } from "./services/services";

function Login() {
  const [name, setName] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  useEffect(() => {});

  return (
    <div className="">
      <Link to="/">
        <h1 className="flex flex-row text-black p-6 font-bold text-3xl bg-green-500 justify-center mb-4">
          MOVIES ON
        </h1>
      </Link>

      <div className="flex flex-col w-2/5 border-2 rounded-md m-auto p-6 mt-14 justify-between">
        <h2 className="font-bold text-xl text-white"> Sign In</h2>

        <form className="justify-evenly">
          <h5 className="text-white">UserName</h5>
          <input
            className="flex border-2 border-blue-300 rounded-md w-4/5"
            type="text"
            value={name}
            onChange={(e) => setName(e.target.value)}
          />
          <h5 className="text-white">E-mail</h5>
          <input
            className="flex border-2 border-blue-300 rounded-md w-4/5"
            type="text"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
          />

          <h5 className="text-white">Password</h5>
          <input
            className="flex border-2 border-blue-300 rounded-md w-4/5"
            type="password"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
          />
          <div className="flex flex-row">
            <button
              className="flex bg-blue-400 rounded-md p-2 mt-2"
              type="submit"
            >
              Sign In
            </button>
            <button
              type="submit"
              className="text-sm pl-4 text-blue-500 underline"
            >
              Create your Account
            </button>
          </div>
        </form>
      </div>
    </div>
  );
}

export default Login;
