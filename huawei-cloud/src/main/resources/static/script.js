async function getPricing() {
    const url = 'https://bss.myhuaweicloud.com/v1/pricing/calculator';

    const response = await fetch(url, {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json',
            'X-Auth-Token': 'TU_TOKEN_DE_AUTENTICACIÓN'
        }
    });

    const data = await response.json();
    document.getElementById("resultado").innerText = JSON.stringify(data, null, 2);
}
