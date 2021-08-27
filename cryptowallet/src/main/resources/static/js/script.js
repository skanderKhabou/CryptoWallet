const wallet = document.getElementById("btc-wallet-total");
const price = document.getElementById("btc-current-price");

const button = document.getElementById("refresh");

button.onclick = () => {
fetch("wallet/BTC")
  .then(response => response.json())
  .then(data => {
    price.innerHTML=data.price;
    wallet.innerHTML=data.total*data.price;
  });
}

//"https://api.binance.com/api/v3/ticker/24hr?symbol=BTCEUR"