import React from 'react';
import { BrowserRouter, Route, Switch } from 'react-router-dom';

import App from '../App';
import Results from './Results';

const Router = () => (
    <BrowserRouter>
        <Switch>
            <Route path="/" component={App} exact />
            <Route path="/results/:gene" component={Results} />
        </Switch>
    </BrowserRouter>
);

export default Router;