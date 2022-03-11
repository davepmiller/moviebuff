[![Build Status](https://travis-ci.org/davepmiller/moviebuff-api.svg?branch=master)](https://travis-ci.org/davepmiller/moviebuff-api)
[![License](https://img.shields.io/badge/license-%20MIT-blue.svg)](../master/LICENSE)

# moviebuff
Spring Boot Rest API

## Run pre-built Docker image 

1. Install Docker on Mac (skip this step if you already have docker installed):
    * [Download Docker](https://download.docker.com/mac/stable/Docker.dmg)
    * Click the downloaded *.dmg file
    * Drag the Docker icon on to the Applications folder
    * Open Docker from Launchpad
    * It will ask for your password, then you should be good to go

2. Start the Application:
    ```bash
    # Sanity check
    docker version

    # Run the image, exposing it's port 8080 to your localhost:8080
    docker run -p 8080:8080 davidpmiller/moviebuff-api:0.0.1
    ```

3. View in your browser: [http://localhost:8080/api/movies](http://localhost:8080/api/movies)

## Build From Source

Install dependencies for Mac:

1. You'll need to install HomeBrew if you don't have that (OSX package manager)
    ```bash
    # Check if you have it
    brew -v
    ```
    * No? [Install HomeBrew!](https://brew.sh/)

2. Install Java
    ```bash
    # Sanity check, both java and javac should show some output
    java -version
    javac -version
    # No dice? No problem...
    brew cask install java
    ```

3. Install Git
    ```bash
    git --version
    brew install git
    ```

4. Clone Repo
    ```bash
    git clone https://github.com/DaveyLaser/moviebuff-api.git
    ```

5. Build and run
    ```bash
    cd moviebuff-api
   ./gradlew build && java -jar build/libs/moviebuff-api-0.0.1-SNAPSHOT.jar
    ```
   
7. View in your browser: [http://localhost:8080/api/movies](http://localhost:8080/api/movies)
