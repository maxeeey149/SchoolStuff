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
    const headers = ["Name", "Is Done"]; // Add more headers if needed

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
        cellIsDone.textContent = todoItem.isDone ? "Yes" : "No"; // Display "Yes" if isDone is true, otherwise "No"

        // Append cells to the row
        row.appendChild(cellName);
        row.appendChild(cellIsDone);

        // Append the row to the table
        table.appendChild(row);
    });

    // Append the table to the container
    todoListContainer.appendChild(table);
}

// Modify the fetchAndDisplayTODOList function to call fetchTODOList and then display the list
async function fetchAndDisplayTODOList() {
    try {
        const todoList = await fetchTODOList();
        displayTODOList(todoList);
    } catch (error) {
        console.log("Error fetching and displaying TODO List: " + error);
    }
}

// Call the fetchAndDisplayTODOList function to fetch and display the list.
fetchAndDisplayTODOList();