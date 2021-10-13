import React from "react";
import "./Header.css";
import { Search } from "./searchbar";
import "../styles/tailwind.css";

import { Link } from "react-router-dom";
import { FireFilled, UserOutlined } from "@ant-design/icons";
import { Popover } from "antd";

export const Header = () => {
  return (
    <div className="p-6 bg-green-400 flex flex-row justify-between">
      <Link to={"/"}>
        <h1 className="font-sans font-semibold text-4xl text-gray-900">
          MOVIES ONE
        </h1>
      </Link>
      <div className="flex flex-row mx-8">
        <Search></Search>
        <Link to={"/favorites"}>
          <div className="pl-4">
            <FireFilled style={{ fontSize: 40 }} />
          </div>
        </Link>
        <Link to={"/Login"}>
          <div className="pl-4">
            <UserOutlined className="Login" style={{ fontSize: 40 }} />
          </div>
        </Link>
      </div>
    </div>
  );
};
