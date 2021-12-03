// Wait until the window loads to do anything...
window.onload = () => {

    // Read data from the web api at http://localhost:8080/api/jokes/
    let path = window.location.pathname; // grab anything after localhost:8080/
    let api = "http://localhost:8080/api";
    let uri = api + path; //
    let config = {
        method: "GET", // GET request
        mode: "cors", // Allows cross origin requests
        headers: {
            "Content-Type": "application/json" // Using json format
        }
    }

    // Show the data on the page
    fetch(uri, config)
        .then((response) => { // .then takes (success, failure)
            console.log("Http status code: " + response.status);
            console.log("Http status text: " + response.statusText);
            return response.json();
        })
        .then((json) => { // This function gets called after the previous one, and uses the returned response.json()
            displayDataElements(json)
        })
        .catch(err => {
           console.error("Error: ", err);
        });
}

/**
 * Should be safe from Async issues. Regardless, verifies whether we're loading an array or single item, then makes the
 * appropriate amount of calls.
 *
 * @param jsonData a single (or array) of JSON data containing jokes
 */
let displayDataElements = (jsonData) => {
    if (Array.isArray(jsonData)) {
        for (let i = 0; i < jsonData.length; i++) {
            createJoke(jsonData[i]);
        }
    } else {
        createJoke(jsonData);
    }
}

/**
 * Displays a joke on the webpage
 *
 * @param data JSON data to use
 */
let createJoke = (data) => {
    let cont = document.getElementById("content");
    let left = document.getElementById("setup");
    let right = document.getElementById("joke");
    let setup = document.createElement("h4");
    let joke = document.createElement("p");


    setup.innerHTML = data.setup;
    joke.innerHTML = data.joke;

    setup.className = "border-top mt-3";
    joke.className = "border-bottom";

    cont.className = "row";
    cont.appendChild(setup);
    cont.appendChild(joke);
}
