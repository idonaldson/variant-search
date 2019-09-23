import React, { Component } from 'react';
import { SERVER_URL} from './config';
import 'whatwg-fetch';
import axios from "axios";
import './css/style.css'
import ReactDataGrid from 'react-data-grid'

const urlFormatter = ({ row }) => {
    return(
        <a href={row.url} target="_blank">{row.source}</a>
    );
};

const defaultColumnProperties = {
    resizable: true
}
const columns = [
    { key: 'geneName', name: 'Gene', width: 100 },
    { key: 'nucleotideChange', name: 'Nucleotide Change', width:250},
    { key: 'proteinChange', name: 'Protein Change' },
    { key: 'alias', name: 'Alias' },
    { key: 'region', name: 'Region' },
    { key: 'reportedClassification', name: 'Reported Classification' },
    { key: 'lastEvaluated', name: 'Last Evaluated' },
    { key: 'lastUpdated', name: 'Last Updated' },
    { key: 'url', name: 'More Info',  formatter: urlFormatter},
].map(c => ({...c, ...defaultColumnProperties}));


class Results extends Component {
    constructor() {
        super();

        this.state = {
            genes: []
        }
    }

    componentDidMount() {
        const { gene } = this.props.match.params;

        console.log(gene);
        axios.post(`${SERVER_URL}gene/results?geneName=${gene}&max=25`)
            .then((data) => {
                this.setState( { genes:data.data})
            })
            .catch(console.log)

    }


    render() {
        return (
            <ReactDataGrid
                columns={columns}
                rowGetter={i => this.state.genes[i]}
                rowsCount={this.state.genes.length}
                minHeight={550} />
        );
    }
}
export default Results;
