import React from 'react';
import ReactDOM from 'react-dom';
import App from './App';
import Results from './Results'
import './css/App.css';
import './css/grails.css';
import './css/main.css';
import {BrowserRouter, Router} from "react-router-dom";
import { Route } from "react-router-dom";

const Routing = () => (
    <BrowserRouter>
        <div className="sans-serif">
            <Route path="/" component={App} />
            <Route path="/results/:gene" component={Results} />
        </div>
    </BrowserRouter>
);

ReactDOM.render(
  <Routing />,
  document.getElementById('root')
);
