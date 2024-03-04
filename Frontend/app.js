var input = document.getElementById("numb");
input.addEventListener("keypress", function(event) {
    if(event.key === "Enter"){
        fetchFromRestAPI('addNewTODOTask');
    }
});

function displayTODOList(todoList) {
    const todoListContainer = document.querySelector(".TODOListPlaceholder");

    // Clear any existing content in the container
    todoListContainer.innerHTML = "";

    // Create a table element
    const table = document.createElement("table");
    table.classList.add("todo-table");

    // Create a table header row
    const headerRow = document.createElement("tr");

    // Create table headers (columns)
    const headers = ["Name", "Status", "Action"];

    headers.forEach((headerText) => {
        const th = document.createElement("th");
        th.textContent = headerText;
        headerRow.appendChild(th);
    });

    table.appendChild(headerRow);

    // Create table rows for each TODO item
    todoList.forEach((todoItem) => {
        const row = document.createElement("tr");

        // Create table cells (columns) for each item property
        const cellName = document.createElement("td");
        cellName.textContent = todoItem.name;

        const cellIsDone = document.createElement("td");
        cellIsDone.textContent = todoItem.isDone ? "✔️" : "❌"; // Display "Yes" if isDone is true, otherwise "No"
        cellIsDone.addEventListener("click", () => {
            fetchFromRestAPI('changeStatusById', todoItem.id);
        });

        //create Button to delete
        const buttonCell = document.createElement("button");
        buttonCell.textContent = "delete";
        buttonCell.addEventListener("click", () => {
            fetchFromRestAPI('deleteListElementById', todoItem.id);
        });


        // Append cells to the row
        row.appendChild(cellName);
        row.appendChild(cellIsDone);
        row.appendChild(buttonCell);

        // Append the row to the table
        table.appendChild(row);
    });

    // Append the table to the container
    todoListContainer.appendChild(table);
}

// Define the fetchTODOList function first
async function fetchTODOList() {
    try {
        const response = await fetch("http://localhost:8080/printListOfTODOs");
        if (!response.ok) {
            throw new Error("Network response not ok");
        }
        const todoList = await response.json();
        return todoList;
    } catch (error) {
        console.log("Error fetching TODO List: " + error);
        return [];
    }
}

// Modify the fetchAndDisplayTODOList function to call fetchTODOList and then display the list
async function fetchAndDisplayTODOList() {
    try {
        const todoList = await fetchTODOList();
        todoList.sort((a, b) => a.id -b.id);
        displayTODOList(todoList);
    } catch (error) {
        console.log("Error fetching and displaying TODO List: " + error);
    }
}

// Call the fetchAndDisplayTODOList function to fetch and display the list.
fetchAndDisplayTODOList();

async function fetchFromRestAPI(fetchServiceName, id){
    let response = null;
    try{
        switch(fetchServiceName){
            case "addNewTODOTask":
                response = await fetch("http://localhost:8080/addNormalTODOListItem?name="+document.getElementById("numb").value);
                document.getElementById("numb").value = "";
                break;
            case "changeStatusById":
                response = await fetch("http://localhost:8080/changeStatusById?id="+id);
                break;
            case "deleteListElementById":
                response = await fetch("http://localhost:8080/deleteListElementById?id="+id);
                break;
        }
        if (!response.ok) {
            throw new Error("Response des Servers nicht ok bei "+fetchServiceName);
        }
        //update the List
        fetchAndDisplayTODOList();
    } catch (error) {
        console.log("Error fetching TODO List: " + error);
        return [];
    }
}