const prodDiv = document.getElementById("products");
const addProductButton = document.getElementById("addProductButton");

const addProductName = document.getElementById("addProductName");
const addProductPrice = document.getElementById("addProductPrice");

const deleteProductId = document.getElementById("deleteProductId");
const deleteProductButton = document.getElementById("deleteProductButton");

const patchProductId = document.getElementById("patchProductId");
const patchProductName = document.getElementById("patchProductName");
const patchProductPrice = document.getElementById("patchProductPrice");
const patchProductButton = document.getElementById("patchProductButton");

refreshProducts();

function refreshProducts(){
    fetch('/api/v1/products/')
        .then(response => response.json())
        .then(data => showProducts(data));
}

function showProducts(products){
    // Also, useful to see difference between imperative programming in Vanilla JS vs declarative in REACT
    prodDiv.innerHTML="";
    for(let i = 0; i < products.length; i++ ){
        let addedProd = document.createElement("div");
        addedProd.innerHTML = `${products[i].id} ${products[i].name} ${products[i].price}`
        prodDiv.appendChild(addedProd);
    }
}

addProductButton.onclick = () => {
    var product = {
        name: addProductName.value,
        price: addProductPrice.value,
    };
    fetch('/api/v1/products/', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
          // 'Content-Type': 'application/x-www-form-urlencoded',
        },
        body: JSON.stringify(product)
    }).then(refreshProducts());
    refreshProducts();
}

deleteProductButton.onclick = () => {
    fetch('/api/v1/products/' + deleteProductId.value, {
        method: 'DELETE',
        headers: {
          'Content-Type': 'application/json'
          // 'Content-Type': 'application/x-www-form-urlencoded',
        }
    }).then(refreshProducts());
    refreshProducts();
}

patchProductButton.onclick = () => {
    var product = {
        name: patchProductName.value,
        price: patchProductPrice.value,
    };
    fetch('/api/v1/products/' + patchProductId.value, {
        method: 'PATCH',
        headers: {
          'Content-Type': 'application/json'
          // 'Content-Type': 'application/x-www-form-urlencoded',
        },
        body: JSON.stringify(product)
    }).then(refreshProducts());
    refreshProducts();
}

