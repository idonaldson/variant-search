# Variant Search Coding Assignment

## Assignment

Create a web application that allows a user to search for genomic variants by gene name and display the results in a tabular view.

## Features

1. Allow the user to enter a gene name to search for variants in that gene. Display the results in a table that shows various attributes associated with each genomic variant.

2. Provide an auto-suggest feature for entering the gene name.

3. Provide two RESTful endpoints supporting the functionality listed in steps 1 and 2.

## Datasource

A zipped TSV file of variants is available in /data/variants.tsv.zip. Each row in the TSV file represents a genomic variant and contains a Gene column with the gene name. A variant will belong to one and only one gene, but multiple variants may belong to the same gene.

## Implementation

If you are comfortable with Python and/or React, please use these technologies for your app. You may use any additional frameworks, languages, databases, libraries, etc. that you find appropriate.

Our expectation is you will be writing some server code, client code, and applying some basic styling to create a working web application. The application should include unit tests.

# My Solution
The application server was built using `Grails 3.3.5` and the client application was build using `ReactJS 16.2.0`. The sample TSV file is parsed with a groovy script into an H2 database to allow for faster searching and parsing of the data.


## Available Scripts
To run the project from a *Nix based system, run the following from the root directory:
### `./gradlew bootRun --parallel`

On a Windows based system, run the following command from the root directory:
### `gradlew.bat bootRun --parallel`


This will run both the server and client applications. The server will load on port 8080, while the client will be running
on port 3000. 

With the server application running, you can run the following curl command to test the suggestions API endpoint

### `curl -i localhost:8080/gene/suggestion?value=CD&max=25`

And you can run the following curl command to test the result API endpoint

### `curl -i localhost:8080/gene/results?geneName=CD274&max=25`



