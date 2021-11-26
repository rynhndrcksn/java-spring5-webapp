/**
 * We will wait until everything is loaded before we start calling everything.
 */
window.onload = () => {

    // Make some constants for neato statistics
    const classes = "http://localhost:8080/actuator/metrics/jvm.classes.loaded";
    const cpuUsage = "http://localhost:8080/actuator/metrics/process.cpu.usage";
    const httpRequests = "http://localhost:8080/actuator/metrics/http.server.requests";
    const health = "http://localhost:8080/actuator/health";

    // Configure the config 😏
    const config = {
        method: "GET", // GET request
        mode: "cors", // Allows cross origin requests
        headers: {
            "Content-Type": "application/json" // Using json format
        }
    }

    // Load the loaded Java classes
    fetch(classes, config)
        .then((response) => { // .then takes (success, failure)
            return response.json();
        })
        .then((json) => { // This function gets called after the previous one, and uses the returned response.json()
            displayClasses(json);
        })
        .catch(err => {
            console.error("Error: ", err);
        });

    // Load the current CPU usage
    fetch(cpuUsage, config)
        .then((response) => {
            return response.json();
        })
        .then((json) => {
            displayCpuUsage(json);
        })
        .catch(err => {
            console.log("Error: ", err);
        });

    // Load the HTTP requests info
    fetch(httpRequests, config)
        .then((response) => { // .then takes (success, failure)
            return response.json();
        })
        .then((json) => { // This function gets called after the previous one, and uses the returned response.json()
            displayHttpRequests(json);
        })
        .catch(err => {
            console.error("Error: ", err);
        });

    // Load the health info
    fetch(health, config)
        .then((response) => { // .then takes (success, failure)
            return response.json();
        })
        .then((json) => { // This function gets called after the previous one, and uses the returned response.json()
            displayHealth(json);
        })
        .catch(err => {
            console.error("Error: ", err);
        });
}

/**
 * Displays the amount of classes loaded in the Spring app
 *
 * @param data JSON data to use
 */
const displayClasses = (data) => {
    let classes = document.getElementById("classes");
    let classesLoaded = document.createElement("p");

    classesLoaded.innerHTML = data["measurements"][0].value;

    classes.appendChild(classesLoaded);
}

const displayCpuUsage = (data) => {
    let cpuUsage = document.getElementById("cpuUsage");
    let usage = document.createElement("p");

    usage.innerHTML = data["measurements"][0].value;

    cpuUsage.appendChild(usage);
}

/**
 * Displays HTTP data for the admin page
 *
 * @param data JSON data to use
 */
const displayHttpRequests = (data) => {
    let httpRequests = document.getElementById("httpRequests");
    let count = document.createElement("p");
    let totalTime = document.createElement("p");
    let max = document.createElement("p");

    count.innerHTML = "Total Requests: " + data["measurements"][0].value;
    totalTime.innerHTML = "Total Time For Requests: " + data["measurements"][1].value;
    max.innerHTML = "Longest Request Time: " + data["measurements"][2].value;

    httpRequests.appendChild(count);
    httpRequests.appendChild(totalTime);
    httpRequests.appendChild(max);
}

/**
 * Displays DB health data for admin page
 * @param data JSON data to use
 */
const displayHealth = (data) => {
    let health = document.getElementById("dbHealth");
    let status = document.createElement("p")
    let db = document.createElement("p")

    status.innerHTML = "Status of DB: " + data["components"]["db"].status;
    db.innerHTML = "DB Type: " + data["components"]["db"]["details"].database;

    health.appendChild(status);
    health.appendChild(db);
}

