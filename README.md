# Variant Search Demo App

This application is a demo to demonstrate searching a list of genes and their variants. This app provides an auto suggest feature and displays the results in a tabular mannor.

## Available Scripts

In the root of the project directory, you can run:

### `./gradlew bootRun --parallel`

This will run both the server and client applications. The server will load on port 8080, while the client will be running
on port 3000. 

With the server application running, you can run the following curl command to test the suggestions API endpoint

### `curl -i localhost:8080/gene/suggestion?value=CD&max=25`

And you can run the following curl command to test the results API endpoint

### `curl -i localhost:8080/gene/results?geneName=CD274&max=25`



