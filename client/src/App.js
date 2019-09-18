import React, { Component } from 'react';
import { SERVER_URL} from './config';
import 'whatwg-fetch';

class App extends Component {

  constructor() {
    super();

    this.state = {
      genes: []
    }
  }

  componentDidMount() {
    fetch(SERVER_URL + '/gene')
      .then(res => res.json())
      .then((data) => {
          this.setState({genes:data})
          console.log(this.state.genes)
      })
      .catch(console.log)

  }

  render() {
      return (
          <div className="container">
              <div className="panel panel-default">
                  <div className="panel-heading">
                      <h3 className="panel-title">
                          Gene Variants
                      </h3>
                  </div>
                  <div className="panel-body">
                      <table className="table table-stripe">
                          <thead>
                          <tr>
                              <th>Gene</th>
                              <th>Nucleotide Change</th>
                              <th>Protein Change</th>
                              <th>Other Mappings</th>
                              <th>Alias</th>
                              <th>Transcripts</th>
                              <th>Region</th>
                              <th>Reported Classification</th>
                              <th>Inferred Classification</th>
                              <th>Source</th>
                              <th>Last Evaluated</th>
                              <th>Last Updated</th>
                              <th>URL</th>
                              <th>Submitter Comment</th>
                              <th>Assembly</th>
                              <th>CHR</th>
                              <th>Genomic Start</th>
                              <th>Genomic Stop</th>
                              <th>Ref</th>
                              <th>Alt</th>
                              <th>Accession</th>
                              <th>Reported Ref</th>
                              <th>Reported Alt</th>
                          </tr>
                          </thead>
                          <tbody>
                          {this.state.genes.map(gene =>
                              <tr key={gene.id}>
                                  <td>{gene.geneName}</td>
                                  <td>{gene.nucleotideChange}</td>
                                  <td>{gene.proteinChange}</td>
                                  <td>{gene.otherMappings}</td>
                                  <td>{gene.alias}</td>
                                  <td>{gene.transcripts}</td>
                                  <td>{gene.region}</td>
                                  <td>{gene.reportedClassification}</td>
                                  <td>{gene.inferredClassification}</td>
                                  <td>{gene.source}</td>
                                  <td>{gene.lastEvaluated}</td>
                                  <td>{gene.lastUpdated}</td>
                                  <td>{gene.url}</td>
                                  <td>{gene.submitterComment}</td>
                                  <td>{gene.assembly}</td>
                                  <td>{gene.chr}</td>
                                  <td>{gene.genomicStart}</td>
                                  <td>{gene.genomicStop}</td>
                                  <td>{gene.ref}</td>
                                  <td>{gene.alt}</td>
                                  <td>{gene.accession}</td>
                                  <td>{gene.reportedRef}</td>
                                  <td>{gene.reportedAlt}</td>
                              </tr>
                          )}
                          </tbody>
                      </table>
                  </div>
              </div>
          </div>
      );
  }
}

export default App;
