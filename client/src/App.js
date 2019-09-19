import React, { Component } from 'react';
import { SERVER_URL} from './config';
import 'whatwg-fetch';
import Autosuggest from 'react-autosuggest';
import axios from 'axios';
import { debounce } from 'throttle-debounce'
import './css/style.css'
import {Link, Redirect} from 'react-router-dom';


class App extends Component {

  constructor() {
    super();

    this.state = {
        value: '',
        suggestions: [],
        toResults: false
    }
    this.handleChange = this.handleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  UNSAFE_componentWillMount() {
      this.onSuggestionsFetchRequested = debounce(
          500,
          this.onSuggestionsFetchRequested
      )
  }

  renderSuggestion = suggestion => {
      return (
          <div className="result">
              <div>{suggestion.geneName}</div>
          </div>
      )
  }

  onChange = (event, { newValue }) => {
      this.setState({value:newValue})
  }

  onSuggestionsFetchRequested = ({ value }) => {
      axios.post(`${SERVER_URL}gene/suggestion?value=${value}&max=25`)
          .then((data) => {
              this.setState( { suggestions:data.data})
          })
  }

  onSuggestionsClearRequested = () => {
      this.setState({ suggestions: [] })
  }

  handleChange(event) {
      this.setState({value: event.target.value});
  }
  handleSubmit(event) {
      alert('Gene name submitted: ' + this.state.value);
      this.setState({toResults:true});
      event.preventDefault();
  }

  render() {
      if ( this.state.toResults === true ) {
          return <Redirect to='/results' />;

      }
      const { value, suggestions } = this.state

      const inputProps = {
          placeholder: 'Gene name',
          value,
          onChange: this.onChange
      }

      return (
          <div className="container App">
              <div className="panel panel-default">
                  <div className="panel-heading">
                      <h1>Search for a Gene</h1>
                  </div>
                  <div className="panel-body">
                      <form onSubmit={this.handleSubmit}>
                          <Autosuggest
                              suggestions={suggestions}
                              onSuggestionsFetchRequested={this.onSuggestionsFetchRequested}
                              onSuggestionsClearRequested={this.onSuggestionsClearRequested}
                              getSuggestionValue={suggestion => suggestion.geneName}
                              renderSuggestion={this.renderSuggestion}
                              inputProps={inputProps}
                              value={this.state.value}
                              onChange={this.handleChange}
                          />
                          <Link to={`/results/${this.state.value}`}>
                              <button className="btn btn-primary">Search</button>
                          </Link>
                      </form>
                  </div>
              </div>
          </div>
      );
  }
}

export default App;
