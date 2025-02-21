document.addEventListener("DOMContentLoaded", function () {
    document.querySelector(".btn-obtener").addEventListener("click", getPricing);
});

async function getPricing() {
    try {
        const response = await fetch("/api/calculadora/pricing");
        const data = await response.json();
        renderTable(data);
    } catch (error) {
        console.error("Error obteniendo precios:", error);
    }
}

function renderTable(data) {
    const tableBody = document.getElementById("pricing-table");
    tableBody.innerHTML = "";
    
    data.forEach(item => {
        const row = document.createElement("tr");
        row.innerHTML = `
            <td>${item.region}</td>
            <td>${item.billingMode}</td>
            <td>${item.cpuArchitecture}</td>
            <td>${item.type}</td>
            <td>${item.series}</td>
            <td>${item.image}</td>
            <td>${item.specification}</td>
            <td>${item.quantity}</td>
            <td>${item.disk}</td>
            <td>${item.diskQuantity}</td>
            <td>${item.eip}</td>
            <td>${item.eipType}</td>
            <td>${item.eipQuantity}</td>
            <td>${item.bandwidthType}</td>
            <td>${item.bandwidth}</td>
            <td>${item.estimatedPrice} USD</td>
        `;
        tableBody.appendChild(row);
    });
}
