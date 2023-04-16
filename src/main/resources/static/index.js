async function search() {
    const text = document.getElementById("search").value;
    const response = await fetch(`/search?search=${text}`);
    const data = await response.json();

    displayResults(data);
}

function displayResults(results) {
    const container = document.getElementById("resultsContainer");
    container.textContent = "";

    for (const result of results) {
        const newPara = document.createElement("p");
        newPara.appendChild(document.createTextNode(result.title));
        container.appendChild(newPara);
    }
}
