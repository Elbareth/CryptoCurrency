# CryptoCurrency
Application made for recruitment purpose
To get information about few currency exchange you need to write URL like this: http://localhost:8080/currencies/BTC?filter=USD&filter=ETH where BTC is currency from which we want to exchange and USD and ETH are currencies we want exchange. 
Example of result:
{
"source":"BTC",
"rates":[
"USDT":0.3321,
"ETH":0.2911
]
}
If we wanto to exchange one currency to another we need to type this URL: http://localhost:8080/currencies/exchange and as a body we need to put JSON like this:
{
"from":"BTC",
"to":["ETH","USD"],
"amount":121
}
And server will return this result:
{
"from": "BTH",
"to":[
{"name":"ETH",
"rate":100,
"amount":121,
"result":150,
"fee":0.0001
},
{
"name":"USD",
"rate":0.21,
"amount":121,
"result":0.213,
"fee":0.0001
}
]
Sometimes server will responds 429 error -it's because I have limited version of API and I haven't got opportunity to send a lot request.
